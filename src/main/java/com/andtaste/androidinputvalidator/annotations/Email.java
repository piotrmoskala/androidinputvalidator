package com.andtaste.androidinputvalidator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * E-mail annotation
 *
 * @author Piotr Moskala
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
  public String value() default "This is not valid e-mail address";
}
