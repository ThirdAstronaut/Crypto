package com.project.crypto.utils;

public class ConstantUtils {
    public static final String CHAR_PATTERN = "[a-zA-Z\\s]+";
    public static final String ID_PATTERN = "[a-zA-Z0-9]+";
    public static final String CODE_PATTERN = "[0-9]{2}-[0-9]{3}";  //48-303
    public static final String MOBILE_PATTERN = "[0-9]{9}"; //111222333
    public static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String AGE_PATTERN = "[0,9]{1,3}";
}
