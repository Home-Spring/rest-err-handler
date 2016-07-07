package com.freitas.server.ws.service;

import com.freitas.exception.CustomerGupErrorCode;
import com.freitas.exception.CustomerGupException;
import com.freitas.model.RestCustomer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	private static Logger log = Logger.getLogger(CustomerServiceImpl.class);
	
	private Map<String,RestCustomer> customerMap = new HashMap<String,RestCustomer>();
	private long                      lastId = 3;
	
	public CustomerServiceImpl() {
		customerMap.put("bob", new RestCustomer(1L, "bob"));
		customerMap.put("fred", new RestCustomer(2L, "fred"));
		customerMap.put("sarah", new RestCustomer(3L, "sarah"));
	}

	public RestCustomer saveCustomer(RestCustomer customer) {
		log.debug("Enter saveCustomer in CustomerServiceImpl with customer " + customer.getName());
		
		lastId++;
		
		log.debug("Created new entry with id " + lastId);
		
		customerMap.put(customer.getName(), customer);
		return customer;
	}

	public RestCustomer getCustomerByName(String name) throws CustomerGupException {
		log.debug("Enter getCustomerByName in CustomerServiceImpl with customer " + name);

		RestCustomer customer = customerMap.get(name);
		if (customer == null) {
			String msg = "RestCustomer not found with name: " + name;
			log.error(CustomerGupErrorCode.NOT_FOUND.getName() + msg);
			throw new CustomerGupException(CustomerGupErrorCode.NOT_FOUND, msg);
		}

		return customer;
	}

	public boolean deleteCustomerByName(String name) throws CustomerGupException {
		log.debug("Enter deleteCustomer in TestMgmtServiceImpl with name " + name);
		
		RestCustomer customer = getCustomerByName(name);
		if (customer == null) {
			log.error("On delete by id " + CustomerGupErrorCode.NOT_FOUND.getName());
			throw new CustomerGupException(CustomerGupErrorCode.NOT_FOUND, "Exception: Unable to find customer in database");
		} else {
			customerMap.remove(customer);
		}
		return true;
	}
}
