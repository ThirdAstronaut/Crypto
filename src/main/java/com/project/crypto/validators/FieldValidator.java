package com.project.crypto.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rafał on 2017-09-06.
 */
public class FieldValidator implements ConstraintValidator<Validate, String> {

    private int min;
    private int max;
    private String regexp;

    @Override
    public void initialize(Validate validate) {
        min = validate.min();
        max = validate.max();
        regexp = validate.regexp();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.length() < min || s.length() > max) {
            return false;
        }
        if (regexp.length() > 1) {
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }
        return true;
    }
}
