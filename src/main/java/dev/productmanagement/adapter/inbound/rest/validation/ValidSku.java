package dev.productmanagement.adapter.inbound.rest.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Constraint(validatedBy = {})
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@Pattern(regexp = "[A-Za-z]{2}[0-9]{5}", message = "SKU must follow the pattern AA99999")
public @interface ValidSku {

    String message() default "Invalid SKU";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
