package com.andtaste.androidinputvalidator.validators;

import com.andtaste.androidinputvalidator.annotations.Regex;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * Validator for regular expressions
 *
 * @author Piotr Moskala
 */
public class RegexValidator extends AbstractValidator {

  @Override
  public String validateField(Field field, String text) {
    Regex regex = field.getAnnotation(Regex.class);
    Pattern pattern;
    if (regex != null) {
      pattern = Pattern.compile(regex.regex());
      boolean isRegex = pattern.matcher(text).matches();
      if (isRegex) {
        return regex.value();
      }
    }
    return "";
  }


}
