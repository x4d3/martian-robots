package com.example;

public class InvalidSimulationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSimulationException(String message) {
		super(message);
	}

	public InvalidSimulationException(String message, Throwable cause) {
		super(message, cause);
	}

}
