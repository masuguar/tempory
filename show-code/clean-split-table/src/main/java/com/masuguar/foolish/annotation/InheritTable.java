package com.masuguar.foolish.annotation;

import com.masuguar.foolish.dialect.InheritDialect;
import com.masuguar.foolish.format.Formatter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.Date;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritTable {

    Class< ? extends Formatter> formatter() ;

    InheritDialect dialect() default InheritDialect.POSTGRESSQL;

    String key() ;

    String spliter() default "_";
}
