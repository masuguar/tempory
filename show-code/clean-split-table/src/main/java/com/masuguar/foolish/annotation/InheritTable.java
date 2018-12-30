package com.masuguar.foolish.annotation;

import com.masuguar.foolish.dialect.InheritQueryDialect;
import com.masuguar.foolish.format.Formatter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritTable {

    Class< ? extends Formatter> formatter() ;

    InheritQueryDialect dialect() default InheritQueryDialect.POSTGRESSQL;

    String spliter() default "_";
}
