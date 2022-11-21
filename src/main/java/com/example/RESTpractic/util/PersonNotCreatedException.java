package com.example.RESTpractic.util;

public class PersonNotCreatedException extends RuntimeException{
    public PersonNotCreatedException(String msg){
        super(msg);
    }
}
