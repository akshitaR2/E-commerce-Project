package com.project.orderService.exception;

import java.util.Objects;

public class CustomerNotFoundException extends RuntimeException{

	private final String msg;
	public CustomerNotFoundException(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
        return msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerNotFoundException)) return false;
        if (!super.equals(o)) return false;
        CustomerNotFoundException that = (CustomerNotFoundException) o;
        return Objects.equals(msg, that.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), msg);
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "msg='" + msg + '\'' +
                "} " + super.toString();
    }
}
