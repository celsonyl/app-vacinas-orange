package com.example.zuporange.services.exceptions;

public class ObjectNotFound extends RuntimeException {

    public ObjectNotFound(String msg){
        super(msg);
    }
    public ObjectNotFound(String msg,Throwable cause){
        super(msg,cause);
    }
}
