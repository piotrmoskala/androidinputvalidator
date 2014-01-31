package com.andtaste.androidinputvalidator;

import com.andtaste.androidinputvalidator.validators.AbstractValidator;

/**
 * Created by piotrmoskala on 13.12.2013.
 */
public class ValidatorError {

  private String error;
  private Class validatorClass;

  public ValidatorError(String error, Class validatorClass) {
    this.error = error;
    this.validatorClass = validatorClass;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Class getValidatorClass() {
    return validatorClass;
  }

  public void setValidatorClass(Class validatorClass) {
    this.validatorClass = validatorClass;
  }
}
