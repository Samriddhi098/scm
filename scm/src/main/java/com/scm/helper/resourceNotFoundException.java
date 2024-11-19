package com.scm.helper;

public class resourceNotFoundException extends RuntimeException{
    public resourceNotFoundException(String message){
        super(message);
}
public  resourceNotFoundException(){
    super("resource not found");
}
}
