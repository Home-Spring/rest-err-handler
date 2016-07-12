package ua.com.itproekt.gup.client.customer;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.com.itproekt.gup.client.BaseTestCase;
import ua.com.itproekt.gup.model.RestCustomer;

public class CustomerTest extends BaseTestCase {

    private CustomerGupClient restClient;
    private String                  name = "bob";

    @Autowired
    public void setClientService(CustomerGupClient wsClient) {
        this.restClient = wsClient;
    }

    @Test
    public void testGetCustomerGupByName() {
        RestCustomer customer = restClient.getCustomerByName(name);

        assertNotNull("Is not NULL", customer);
//        System.err.println("#1....." + customer.toString());

        assertEquals("Is found a name", name, customer.getName());
//        System.err.println("#2....." + customer.getName());
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
