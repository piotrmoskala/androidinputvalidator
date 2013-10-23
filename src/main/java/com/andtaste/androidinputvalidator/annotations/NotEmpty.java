package com.andtaste.androidinputvalidator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Not empty annotation
 *
 * @author Piotr Moskala
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmpty {
   public String value() default "This field can't be empty";
}
