package com.myproject.userservice.annotation.validator;

import jakarta.validation.Payload;

/**
 * @author nguyenle
 */
public @interface DobConstraint {

    String message() default "INVALID_DATE_OF_BIRTH";

    int min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payloads() default {};

}
