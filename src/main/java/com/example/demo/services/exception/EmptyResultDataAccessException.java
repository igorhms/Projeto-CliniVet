package com.example.demo.services.exception;

public class EmptyResultDataAccessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EmptyResultDataAccessException(String msg) {
		super(msg);
	}

}
