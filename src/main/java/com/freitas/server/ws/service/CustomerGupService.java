package com.freitas.server.ws.service;

import com.freitas.exception.CustomerGupException;
import com.freitas.model.RestCustomer;

public interface CustomerGupService {
	
	RestCustomer saveCustomer(RestCustomer customer);
	RestCustomer getCustomerByName(String name) throws CustomerGupException;
	boolean deleteCustomerByName(String name) throws CustomerGupException;

}
