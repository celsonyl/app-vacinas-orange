package com.example.zuporange.resource.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private final List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(String message,String path){
        super(message,path);
    }

    public void addError(String fieldname,String message){
        erros.add(new FieldMessage(fieldname,message));
    }

    public List<FieldMessage> getErros() {
        return erros;
    }
}
