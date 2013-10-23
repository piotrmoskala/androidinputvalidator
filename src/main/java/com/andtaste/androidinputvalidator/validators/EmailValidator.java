package com.andtaste.androidinputvalidator.validators;

import com.andtaste.androidinputvalidator.annotations.Email;

import java.lang.reflect.Field;

/**
 * Validator, that checks if email address is valid (contains @)
 *
 * @author Piotr Moskala
 */
public class EmailValidator extends AbstractValidator {

  @Override
  public String validateField(Field field, String text) {
    Email email = field.getAnnotation(Email.class);

    if (!text.contains("@"))
      return email != null ? email.value() : "";
    return "";
  }
}
