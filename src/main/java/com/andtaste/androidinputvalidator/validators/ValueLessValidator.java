package com.andtaste.androidinputvalidator.validators;

import com.andtaste.androidinputvalidator.annotations.ValueGreaterThan;
import com.andtaste.androidinputvalidator.annotations.ValueLessThan;

import java.lang.reflect.Field;

/**
 * Created by piotrmoskala on 13.12.2013.
 */
public class ValueLessValidator extends AbstractValidator{

  @Override
  public String validateField(Field field, String text) {
    ValueLessThan valueLessThan = field.getAnnotation(ValueLessThan.class);
    if(valueLessThan == null)
      return "";
    if((text == "" ? 0 : Integer.valueOf(text))<valueLessThan.number()){
      return "";
    } else {
      return valueLessThan.value();
    }
  }
}
