package com.andtaste.androidinputvalidator;

import com.andtaste.androidinputvalidator.validators.*;

/**
 * All validators in one array
 *
 * @author Piotr Moskala
 */
public class Validators {
  public static final AbstractValidator[] validators = {new EmailValidator(),
          new NumberValidator(),
          new RegexValidator(),
          new ValueGreaterValidator(),
          new ValueLessValidator(),
          new NotEmptyValidator()};
}
