package com.scm.SmartContactManager.helper;

public class ResourceNotFoundException extends RuntimeException   {

    public ResourceNotFoundException(String message)
    {
       super(message);
    }
    public ResourceNotFoundException()
    {
        super("Reourse not found");
    }
}
