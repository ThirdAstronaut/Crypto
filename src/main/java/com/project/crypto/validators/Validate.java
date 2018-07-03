package com.project.crypto.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Rafał on 2017-09-06.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = com.project.crypto.validators.FieldValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface Validate {

    int min();
    int max();
    String regexp();
    String message();
  /*  Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
*/
}
