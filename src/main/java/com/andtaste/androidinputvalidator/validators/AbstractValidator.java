package com.andtaste.androidinputvalidator.validators;

import java.lang.reflect.Field;

/**
 * Created by piotrmoskala on 23.10.2013.
 */
public abstract class AbstractValidator {
  public abstract String validateField(Field field, String text);
}
