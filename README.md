##Spring rest exception handling 404 пример

* `advanced-error-handling-rest-based-web-service`:  [lopakalogic.com/articles/web-services-articles/advanced-error-handling-rest-based-web-service](http://www.lopakalogic.com/articles/web-services-articles/advanced-error-handling-rest-based-web-service/) **[github.com](https://github.com/bobfreitas/rest-err-handler)**
* `mvn clean package -Dmaven.test.skip=true`

> GET [/api/oauth?name=bob](http://localhost:8080/api/oauth?name=bob)
> GET [/api/oauth](http://localhost:8080/api/oauth)
> POST [/api/oauth?name=bobeeeeeee](http://localhost:8080/api/oauth) {"name":"bob"}
> GET [/api/oauth?name=bobeeeeeee](http://localhost:8080/api/oauth?name=bobeeeeeee)
> GET [/api/oauth?nameeeee=bob](http://localhost:8080/api/oauth?nameeeee=bob)
> GET [/api/oauth?name=](http://localhost:8080/api/oauth?name=)

> { "name":"bob", "id":1 }
> { "name":"bob" ,"id":null }
> { "serviceId":1, "errorCode":3, "messageArgs":{}, "httpStatus":500, "debugMessage":"Customer not found with name: bobeeeeeee" }
> { "serviceId":1, "errorCode":3, "messageArgs":{}, "httpStatus":400, "debugMessage":"Customer not found with name: bobeeeeeee" }
> { "serviceId":1, "errorCode":2, "messageArgs":{}, "httpStatus":400, "debugMessage":"Name is required" }

