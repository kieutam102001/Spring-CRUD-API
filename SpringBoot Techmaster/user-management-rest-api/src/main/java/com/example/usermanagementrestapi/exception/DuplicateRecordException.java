package com.example.usermanagementrestapi.exception;

public class DuplicateRecordException extends RuntimeException{
    public DuplicateRecordException(String message){
        super(message);
    }
}
