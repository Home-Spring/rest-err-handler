package ua.com.itproekt.gup.client.customer;

import ua.com.itproekt.gup.client.BaseWebServiceClient;
import ua.com.itproekt.gup.model.RestCustomer;

public interface CustomerClient extends BaseWebServiceClient {

    RestCustomer saveCustomer(RestCustomer customer);
    RestCustomer getCustomerByName(String name);

}
