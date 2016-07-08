package com.gup.server.api.service;

import com.gup.exception.CustomerGupException;
import com.gup.model.RestCustomer;

public interface CustomerGupService {

    /**
     *
     * @param customer
     * @return
     */
	RestCustomer saveCustomer(RestCustomer customer);

    /**
     *
     * @param name
     * @return
     * @throws CustomerGupException
     */
	RestCustomer getCustomerByName(String name) throws CustomerGupException;

    /**
     *
     * @param name
     * @return
     * @throws CustomerGupException
     */
	boolean deleteCustomerByName(String name) throws CustomerGupException;

}
