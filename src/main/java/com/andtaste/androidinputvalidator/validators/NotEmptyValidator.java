package com.andtaste.androidinputvalidator.validators;

import com.andtaste.androidinputvalidator.annotations.NotEmpty;

import java.lang.reflect.Field;

/**
 * Checks if string is empty
 *
 * @author Piotr Moskala
 */
public class NotEmptyValidator extends AbstractValidator {

  @Override
  public String validateField(Field field, String text) {
    NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
    if (text.length() == 0)
      return notEmpty != null ? notEmpty.value() : "";
    return "";
  }
}
