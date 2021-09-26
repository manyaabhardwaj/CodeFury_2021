package com.onlineauction.exception;

public class ActualGreaterThanMinimum extends Exception {
	public ActualGreaterThanMinimum(){
		super();
	}
	
	public ActualGreaterThanMinimum(String message) {
		super(message);
	}
}
