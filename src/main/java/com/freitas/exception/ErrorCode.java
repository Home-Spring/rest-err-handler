package com.freitas.exception;

public interface ErrorCode {

	int getErrorCode();
	String getName();
	int getServiceId();
	String getMessageKey();
	String getDefaultMessage();

}
