package com.andtaste.androidinputvalidator;

import android.widget.TextView;
import com.andtaste.androidinputvalidator.validators.AbstractValidator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Validator class
 * It's used to fire validators on given object.
 * <i>validate()</i> method is looking for annotations by calling
 * <i>validateField</i> method on each of validators,
 * that are provided inside Validators class
 *
 * @see Validators
 *
 *
 * Example usage:
 * Validator validator = new Validator();
 * validator.validate(MainActivity.this)
 *
 * @see com.andtaste.androidinputvalidator.validators.AbstractValidator
 */
public class Validator {
  protected List<String> errors = new ArrayList<String>();
  private int errorSize = 0;
  /**
   * Fires all validators for given fields
   * For now it's checking only TextViews.
   * @param obj
   * @return
   */
  public List<String> validate(Object obj) {
    errors = new ArrayList<String>();
    Field[] fields = obj.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      validateTextView(field, obj);
    }
    return errors;
  }

  /**
   * Validates textfields with validators
   * @param field - declared field of obj
   * @param obj
   * @return
   */
  private boolean validateTextView(Field field, Object obj){
    try {
      if (field.get(obj) instanceof TextView) {
        TextView textView = ((TextView) field.get(obj));
        String returnedError = "";
        for (AbstractValidator abstractValidator : Validators.validators) {
          returnedError = abstractValidator.validateField(field, textView.getText().toString());
          if (returnedError != "")
            errors.add(returnedError);
        }
        if (errors.size() > 0) {
          if(errorSize != errors.size())
            textView.setText(errors.get(errors.size() - 1));
          errorSize = errors.size();
        }
      }
      return true;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      return false;
    }
  }

}


