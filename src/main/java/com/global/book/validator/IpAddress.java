package com.global.book.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {IpAddressImpl.class}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IpAddress {

    String message() default "{validation.constraints.ip-address.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
