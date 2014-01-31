package com.andtaste.androidinputvalidator.validators;

import java.lang.*;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * Validator that checks if given string is number or not
 *
 * @author Piotr Moskala
 */
public class NumberValidator extends AbstractValidator {

  private static final String NUMBERS_REGEX = ".*[^0-9].*";

  @Override
  public String validateField(Field field, String text) {
    com.andtaste.androidinputvalidator.annotations.Number number = field.getAnnotation(
            com.andtaste.androidinputvalidator.annotations.Number.class);
    Pattern pattern = Pattern.compile(NUMBERS_REGEX);
    boolean isNumber = pattern.matcher(text).matches();
    if (isNumber)
      return number != null ? number.value() : "";
    return "";
  }
}
