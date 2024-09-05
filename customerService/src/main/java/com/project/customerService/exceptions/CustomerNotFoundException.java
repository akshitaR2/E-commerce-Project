package com.project.customerService.exceptions;

import java.util.Objects;

public class CustomerNotFoundException extends RuntimeException {
    private final String message;

   
    public CustomerNotFoundException(String message) {
        this.message = message;
    }

   
    public String getMessage() {
        return message;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerNotFoundException)) return false;
        if (!super.equals(o)) return false;
        CustomerNotFoundException that = (CustomerNotFoundException) o;
        return Objects.equals(message, that.message);
    }

   
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }

   
    @Override
    public String toString() {
        return "CustomerNotFoundException{" +
                "message='" + message + '\'' +
                '}';
    }
}

