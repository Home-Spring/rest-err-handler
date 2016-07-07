
http :// localhost:8080 /rest-err-handler/ws/customer ? name=bob
---------------------
{"name":"bob","id":1}

http :// localhost:8080 /rest-err-handler/ws/customer ? name=bobeeeeeee
-----------------------------------------------------------------------
{"errorCode":3,"debugMessage":" Customer not found with name: bobeeeeeee","messageArgs":{},"httpStatus":500,"serviceId":1}

http :// localhost:8080/rest-err-handler/ws/customer
------------------------
{"name":"bob"}
 - - - - - - - - - - - -
{"name":"bob","id":null}

http :// localhost:8080/rest-err-handler/ws/customer ? name=bobeeeeeee
----------------------------------------------------------------------
{"serviceId":1,"errorCode":3,"messageArgs":{},"httpStatus":400,"debugMessage":" Customer not found with name: bobeeeeeee"}

http :// localhost:8080 /rest-err-handler/ws/customer ? name=
-------------------------------------------------------------
{"serviceId":1,"errorCode":2,"messageArgs":{},"httpStatus":400,"debugMessage":"Name is required"}





{ "name":"bob", "id":1 }
{ "name":"bob" ,"id":null }

{ "serviceId":1, "errorCode":3, "messageArgs":{}, "httpStatus":500, "debugMessage":"Customer not found with name: bobeeeeeee" }
{ "serviceId":1, "errorCode":3, "messageArgs":{}, "httpStatus":400, "debugMessage":"Customer not found with name: bobeeeeeee" }
{ "serviceId":1, "errorCode":2, "messageArgs":{}, "httpStatus":400, "debugMessage":"Name is required" }

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Модель, возвращает результаты данных в ворматах: успешного запроса и в случае ошибки
-------------------------------
com.freitas.model     Customer
com.freitas.exception RestError

'Customer' - это модель которая возвращает результаты в успешном формате.
---------------
интерфейс 'CustomerClient' - это сервис, он содержит методы для работы с объектом 'Customer' (сохранить, вернуть, обновить, удалить)
- - - - - - - -
- является наследником интерфейса 'BaseWebServiceClient'
- 'BaseWebServiceClientImpl' реализация интерфейса 'BaseWebServiceClient'
- - - - - - - -
'CustomerClientImpl' - является наследником класса 'BaseWebServiceClientImpl' и интерфейса 'CustomerClient'

'Response' - это модель которая хранит полную информацию в ответ о все-возможных результатах запроса.

+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
- 'MainController' - это реальный класс-API для REST-сервиса (применяется для боевых клиентских-запросов)

- 'CustomerClientImpl' - это класс-заглушка для REST-сервиса (применяется в JUnit для тестирования Spring-м)
  -- (вместо класс-заглушка для REST-сервиса можно применить 'SOAP' для написания тестов...)















