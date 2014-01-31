package com.andtaste.androidinputvalidator;

import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;
import com.andtaste.androidinputvalidator.validators.AbstractValidator;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Validator class
 * It's used to fire validators on given object.
 * <i>validate()</i> method is looking for annotations by calling
 * <i>validateField</i> method on each of validators,
 * that are provided inside Validators class
 *
 * @see Validators
 * <p/>
 * <p/>
 * Example usage:
 * Validator validator = new Validator();
 * validator.validate(MainActivity.this)
 * @see com.andtaste.androidinputvalidator.validators.AbstractValidator
 */
public class Validator {
  protected ArrayList<ErrorContext> errors = new ArrayList<ErrorContext>();
  private int errorSize = 0;
  private boolean setHintsAutomatically;
  private int hintsColor = Color.parseColor("#AAAAAA");

  /**
   * Fires all validators for given fields
   * For now it's checking only TextViews.
   *
   * @param obj
   * @return
   */
  public ArrayList<ErrorContext> validate(Object obj) {
    errors = new ArrayList<ErrorContext>();
    errors.clear();
    Field[] fields = obj.getClass().getDeclaredFields();
    for (Field field : fields) {
      Log.d("AGENT", "checking..");
      field.setAccessible(true);
      validateTextView(field, obj);
      validateValidatables(field, obj);
    }
    fields = obj.getClass().getSuperclass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      validateTextView(field, obj);
      validateValidatables(field, obj);
    }
    return errors;
  }

  /**
   * Validates textfields with validators
   *
   * @param field - declared field of obj
   * @param obj
   * @return
   */
  private boolean validateTextView(Field field, Object obj) {
    try {
      if (field.get(obj) instanceof TextView) {
        TextView textView = ((TextView) field.get(obj));
        ErrorContext errorContext = new ErrorContext(textView);
        errorContext = validateField(errorContext, field, textView.getText().toString());
        if (errorContext.getErrors().size() > 0) {
          if (setHintsAutomatically) {
            textView.setText("");
            textView.setHint(errorContext.getErrors().get(errorContext.getErrors().size() - 1).getError());
            textView.setHintTextColor(hintsColor);
          }
        }
        errors.add(errorContext);
      }
      return true;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Validates classes that implement Validatable interface
   *
   * @param field
   * @param obj
   * @return
   * @see com.andtaste.androidinputvalidator.Validatable
   */
  private boolean validateValidatables(Field field, Object obj) {
    try {
      if (field.get(obj) instanceof Validatable) {
        Validatable validatable = ((Validatable) field.get(obj));
        ErrorContext errorContext = new ErrorContext(validatable);
        errorContext = validateField(errorContext, field, validatable.getText());
        if (errorContext.getErrors().size() > 0) {
          if (setHintsAutomatically) {
            validatable.setText("");
            validatable.setHint(errorContext.getErrors().get(errorContext.getErrors().size() - 1).getError());
          }
        }
        errors.add(errorContext);
      }
      return true;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   *
   * @param errorContext
   * @param field
   * @param value
   * @return
   */
  private ErrorContext validateField(ErrorContext errorContext, Field field, String value) {
    String returnedError = "";
    for (AbstractValidator abstractValidator : Validators.validators) {
      returnedError = abstractValidator.validateField(field, value);
      if (returnedError != "") {
        errorContext.getErrors().add(new ValidatorError(returnedError, abstractValidator.getClass()));
        Log.d("AGENT", "found:" + returnedError + "  " + abstractValidator.getClass());
      }
    }
    return errorContext;
  }

  public void setHintsAutomatically(boolean setHintsAutomatically) {
    this.setHintsAutomatically = setHintsAutomatically;
  }

  public void setHintsColor(int color) {
    this.hintsColor = color;
  }


}


