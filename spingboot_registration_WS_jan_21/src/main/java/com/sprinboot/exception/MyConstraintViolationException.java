package com.sprinboot.exception;

public class MyConstraintViolationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public MyConstraintViolationException(String msg){
		super(msg);
	}
}
