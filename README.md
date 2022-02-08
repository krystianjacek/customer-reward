## Requirements:
* install java 15 or higher
* install maven 3 or use bundled in IntelliJ
* install CURL or Postman to execute rest requests
* download project
* go to folder containing project and execute following commans: 
  * build application in maven ```mvn clean install```
  * run application by IntelliJ or by command ```mvn spring-boot:run```

## REST endpoints:
Basic test data is loaded along with application start.

Use postman or CURL to execute following scenarios:
1. to add customer
```
curl -X POST -H "Content-Type: application/json" -d  "{ \"id\": null, \"firstName\": \"James\", \"lastName\": \"Smith\" }"  localhost:8080/api/internal/customer
```

2. to get customer
```
curl -X GET localhost:8080/api/internal/customer/customerId/{customerId}
```
3. to get all customers
```
curl -X GET localhost:8080/api/internal/customer
```
4. to add customer transaction
```
curl -X POST -H "Content-Type: application/json" -d  "{ \"id\": null, \"price\": 353.40, \"date\": \"2022-01-05T11:55:16Z\" }"  localhost:8080/api/internal/transaction/customerId/{customerId}
```
5. to get reward points for one month for customer
```
curl -X GET localhost:8080/api/internal/reward/customerId/{customerId}/month
```
6. to get all reward points for customer
```
curl -X GET localhost:8080/api/internal/reward/customerId/{customerId}/total
```

## Api doc - swagger
http://localhost:8080/swagger-ui/
