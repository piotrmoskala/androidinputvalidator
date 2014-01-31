package com.andtaste.androidinputvalidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotrmoskala on 13.12.2013.
 */
public class ErrorContext {
  private Object object;
  private ArrayList<ValidatorError> errors;

  public ErrorContext(Object object) {
    this.object = object;
    errors = new ArrayList<ValidatorError>();
  }

  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }

  public ArrayList<ValidatorError> getErrors() {
    return errors;
  }

  public void setErrors(ArrayList<ValidatorError> errors) {
    this.errors = errors;
  }
}
