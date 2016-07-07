This project provides an example of how to use advanced error handling with a REST based web service.  
A problem with REST based web services is that over time the only error message that get back is 
the dreaded HTTP 500 error.  However, by itself the 500 error really provides no significant 
information.  

The approach shown in this project will allow for the server to return a 500 error with some 
additional information to allow the error to clearly be understood on the client side.  The 
project was developed with Maven, Spring 3 and in Eclipse.  

You can also test the application from a web browser after building it with a query something 
like: 

    http://localhost:8080/rest-err-handler/ws/customer?name=bob

Note: The first time you attempt build the artifact with Maven, you will want to skip the tests with something like:

    mvn package -Dmaven.test.skip=true
    
There is a sample test case that will fail, unless you start the server.  

I hava a web page that explains the project in much greater detail at

http://www.lopakalogic.com/articles/web-services-articles/advanced-error-handling-rest-based-web-service/

////////////////////////////////////////////////////////////////////////////////////////////////

com.freitas.client.ws.customer.CustomerClientImpl
com.freitas.server.ws.MainController
com.freitas.server.ws.service.CustomerServiceImpl
com.freitas.server.ws.WSValidator
com.freitas.client.ws.MyResponseExtractor
com.freitas.client.ws.MyRequestCallback

/resources/rest-servlet.xml
/resources/rest-applicationContext.xml
/resources/ws-application.properties

GET >> http://localhost:8080/rest-err-handler/ws/customer?name=bob
       {"name":"bob","id":1}
       
GET >> http://localhost:8080/rest-err-handler/ws/customer?name=bobe
       {"serviceId":1,"debugMessage":" Customer not found with name: bobe","messageArgs":{},"httpStatus":500,"errorCode":3}
       
POST >> http://localhost:8080/rest-err-handler/ws/customer?name=bobe
        HTTP Status 500 - No content to map to Object due to end of input............
        
(spring rest exception handling 404 пример) >> http://www.lopakalogic.com/articles/web-services-articles/advanced-error-handling-rest-based-web-service/ >> https://github.com/bobfreitas/rest-err-handler
>> http://www.codingpedia.org/ama/error-handling-in-rest-api-with-jersey/
>> https://dzone.com/articles/proxying-with-api-manager-1
>> http://www.mkyong.com/spring-mvc/spring-mvc-exception-handling-example/
>> https://stormpath.com/blog/spring-mvc-rest-exception-handling-best-practices-part-2
>> https://github.com/stormpath/spring-mvc-rest-exhandler
>> http://www.seostella.com/ru/article/2012/05/07/obrabotka-http-oshibok-404-500-503-v-spring-mvc.html
>> https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
>> https://stormpath.com/blog/spring-mvc-rest-exception-handling-best-practices-part-1
>> https://stormpath.com/blog/spring-mvc-rest-exception-handling-best-practices-part-2
>> http://www.tutorialspoint.com/spring/spring_exception_handling_example.htm
>> https://www.javacodegeeks.com/2013/02/exception-handling-for-rest-with-spring-3-2.html
