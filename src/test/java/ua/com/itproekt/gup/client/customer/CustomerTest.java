package ua.com.itproekt.gup.client.customer;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.com.itproekt.gup.client.BaseTestCase;
import ua.com.itproekt.gup.exception.BaseException;
import ua.com.itproekt.gup.exception.CustomerGupErrorCode;
import ua.com.itproekt.gup.model.RestCustomer;

public class CustomerTest extends BaseTestCase {

    private CustomerClient wsClient;
    private String         custName = "bob";

    @Autowired
    public void setClientService(CustomerClient wsClient) {
        this.wsClient = wsClient;
    }

    @Test
    public void testGetCustomerByName() {
        RestCustomer customer = wsClient.getCustomerByName(custName);

        assertNotNull("#1.....", customer);
        System.err.println("#1....." + customer.toString());

        assertEquals("#2.....", custName, customer.getName());
        System.err.println("#2....." + customer.getName());
//        try {
//            customer = wsClient.getCustomerByName(custName);
//            fail("Expected an exception here");
//        } catch(BaseException be) {
//            assertEquals("#3.....", CustomerGupErrorCode.NOT_FOUND.getErrorCode(), be.getErrorCode().getErrorCode());
//        } finally {
//            System.err.println("#3....." + CustomerGupErrorCode.NOT_FOUND.getErrorCode());
//        }
    }
}
