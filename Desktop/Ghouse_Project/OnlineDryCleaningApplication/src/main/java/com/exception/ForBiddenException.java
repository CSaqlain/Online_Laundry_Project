package com.exception;



public class ForBiddenException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForBiddenException() {
		super("Invalid Login/Not Logged In");
	}

}
