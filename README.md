# AkkodisTestInditex
This project gets information about the PRICES table using a microservice with one endpoint 
with parameters product id, brand id and application date.
The endpoint will return a json object with the following fields:
- priceId
- brandId
- startDate
- endDate
- priceList
- productId
- priority
- price
- currency
## Technologies
- Java 17
- Spring boot 3.1.1
## Installation
- git clone https://github.com/acogolludo/testJava
- cd ../destination/path
- mvn spring-boot:run
## FAQs
- The application runs in the port 8080
- The context-path is /pricetest
- There are two test classes:
  - AkkodisTestInditexApplicationTests: contains the succesfull tests with a product returned.
  - AkkodisTestInditexApplicationNotFoundTests: contains the tests with error responses
- There is a postman collection in ../src/main/resources