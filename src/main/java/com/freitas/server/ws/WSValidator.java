package com.freitas.server.ws;

import com.freitas.exception.CustomerGupErrorCode;
import com.freitas.exception.CustomerGupException;
import com.freitas.model.RestCustomer;

public class WSValidator {
	public void validateString(String param, String paramName) {
		if (param == null || param.isEmpty()) {
			throw new CustomerGupException(CustomerGupErrorCode.INVALID_PARAMS, paramName + " is required");
		}
	}

	public void validateLong(Long param, String paramName) {
		if (param == null || param.equals(0L)) {
			throw new CustomerGupException(CustomerGupErrorCode.INVALID_PARAMS, paramName + " is required");
		}
	}
	
	public void validateCustomer(RestCustomer customer) {
		if (customer == null) {
			throw new CustomerGupException(CustomerGupErrorCode.INVALID_PARAMS, "RestCustomer is empty");
		}
		if (customer.getName() == null || customer.getName().isEmpty()) {
			throw new CustomerGupException(CustomerGupErrorCode.INVALID_PARAMS, "RestCustomer name is required");
		}
	}
}
