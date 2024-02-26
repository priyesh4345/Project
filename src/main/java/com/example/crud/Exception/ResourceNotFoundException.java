package com.example.crud.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(long id){
        super("Resource Not Found for id no"+id);
    }
}
