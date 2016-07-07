package com.freitas.server.ws;

import com.freitas.exception.BaseException;
import com.freitas.exception.RestError;
import com.freitas.model.RestCustomer;
import com.freitas.server.ws.service.CustomerGupService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/ws")
public class GupAPI {
	private static Logger            log = Logger.getLogger(GupAPI.class);
	private static GupValidator validator = new GupValidator();
	
	@Autowired
	private CustomerGupService customerService;
	
	@RequestMapping(value="/customer", method = RequestMethod.POST)
	public @ResponseBody
    RestCustomer saveCustomer(@RequestBody RestCustomer customer) {
		log.debug("Enter saveCustomer in TestMgmtController with " + customer.getName());
		
		validator.validateCustomer(customer);
		return customerService.saveCustomer(customer);
	}

    @RequestMapping(value="/customer", method = RequestMethod.GET)
	public @ResponseBody
    RestCustomer getCustomerByName(@RequestParam("name") String name) {
		log.debug("Enter getCustomerByName in MainController with " + name);
		
		validator.validateString(name, "Name");
		return customerService.getCustomerByName(name);
	}

	@RequestMapping(value="/customer/{name}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteCustomer(@PathVariable String name) {
		log.debug("Enter getTest in MainController");
		
		validator.validateString(name, "Name");
		return customerService.deleteCustomerByName(name);
	}

	@ExceptionHandler(BaseException.class)
	public @ResponseBody RestError handleCustomException (BaseException ex, HttpServletResponse response) {
		response.setHeader("Content-Type", "application/json");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ex.transformException(HttpServletResponse.SC_BAD_REQUEST);
	}
}
