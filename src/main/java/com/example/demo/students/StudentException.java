package com.example.demo.students;

public class StudentException extends  RuntimeException{
    String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    StudentException(String message){
        this.message = message;
    }
}
