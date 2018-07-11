package com.practice.interfaces;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Documented
@Retention(RUNTIME)
public @interface CustomAnnotation {
	String author() default "Dheeraj";
	int rollnum() default 1;
	String name() default "Ramu";
}

