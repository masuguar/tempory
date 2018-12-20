package com.masuguar.foolish.format;

public interface Formatter<T> {

    public String preffix( T t );

    public String suffix( T t );
}
