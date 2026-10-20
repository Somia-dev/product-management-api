# Product Management API

A small REST API to manage products, built with Spring Boot and a hexagonal architecture.

## Tech stack

- Java 21
- Spring Boot 4.1.1 (Web MVC, Data JPA, Validation)
- H2 database (file mode)
- Maven

## Getting started

```bash
./mvnw spring-boot:run
```

The API is available at `http://localhost:8080/api/products`.
The H2 console is available at `http://localhost:8080/h2-console`
(JDBC URL: `jdbc:h2:file:./database/database;AUTO_SERVER=TRUE`, user: `sa`, password: `password`).

## Endpoints

| Method | Path                                  | Description                      |
|--------|---------------------------------------|----------------------------------|
| GET    | `/api/products`                       | List all products                |
| GET    | `/api/products/{sku}`                 | Get a product by SKU             |
| PUT    | `/api/products/{sku}`                 | Create or update a product       |
| PATCH  | `/api/products/{sku}/description`     | Update a product description     |
| DELETE | `/api/products/{sku}`                 | Delete a product                 |

The SKU must match `^[A-Za-z0-9-]{3,32}$`.

Example:

```bash
curl -X PUT http://localhost:8080/api/products/ABC-123 \
  -H "Content-Type: application/json" \
  -d '{"name":"Pen","description":"Blue","price":2.5}'
```

## Project structure

```
dev.productmanagement
├── domain                     Product (business object)
├── usecase                    Ports: command and query use case interfaces
└── adapter
    ├── inbound.rest           Controller, API interface, DTOs, validation
    └── outbound.database      JPA entity, repository, use case implementations
```
