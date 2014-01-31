package com.andtaste.androidinputvalidator.validators;

import com.andtaste.androidinputvalidator.annotations.ValueGreaterThan;

import java.lang.reflect.Field;

/**
 * Created by piotrmoskala on 13.12.2013.
 */
public class ValueGreaterValidator extends AbstractValidator {
  @Override
  public String validateField(Field field, String text) {
    ValueGreaterThan valueGreaterThan = field.getAnnotation(ValueGreaterThan.class);
    if(valueGreaterThan == null)
      return "";
    if((text.equals("") ? 0 : Integer.valueOf(text))>valueGreaterThan.number()){
      return "";
    } else {
      return valueGreaterThan.value();
    }
  }
}
