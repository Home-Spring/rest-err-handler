package com.freitas.server.ws;

import com.freitas.exception.BaseException;
import com.freitas.exception.RestError;
import com.freitas.model.Customer;
import com.freitas.server.ws.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/ws")
public class APIController {
	private static Logger            log = Logger.getLogger(APIController.class);
	private static WSValidator validator = new WSValidator();
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer", method = RequestMethod.POST)
	public @ResponseBody Customer saveCustomer(@RequestBody Customer customer) {
		log.debug("Enter saveCustomer in TestMgmtController with " + customer.getName());
		
		validator.validateCustomer(customer);
		return customerService.saveCustomer(customer);
	}

    @RequestMapping(value="/customer", method = RequestMethod.GET)
	public @ResponseBody Customer getCustomerByName(@RequestParam("name") String name) {
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
