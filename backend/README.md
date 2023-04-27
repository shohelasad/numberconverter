# Number Conversion

1. Convert number Decimal to Roman
2. Convert number Binary to Roman

### Strategy
1. Expose post API for with requestBody from, to and number field. It will support if the number is length long for english number
2. Implement factory method pattern to initiate conversion service for different type conversions
3. Expose the Post API "/api/v1/conversions" to 8080 port
4. Log incoming request and response into in memory database with audit trail

### TODO: Add another conversion like Roman to English, then we need to follow:
1. To convert Roman to English, first convert roman to Decimal then Decimal to English
2. Add a new conversion class RomanToEnglishConversion and implements ConversionService and implement romanToEnglish(String roman)
3. Add RomanToEnglishConversion to ConversionFactory class and ConversionFactory() constructor
4. Implement the function romanToDecimal(String roman) and decimalToEnglish(String decimal) into ConversionUtils

### Used Technologies
* Java 11
* Spring Boot 2.3.4
* Spring Boot Actuator
* Spring Validation
* Spring data jpa
* InMemory h2 database

### Run with maven

```sh
mvn spring-boot:run
```

### Run only test cases

```sh
mvn test
```

## Run with maven clean build and create jar

Package the application as a JAR file (find the jar in backend/target)

```sh
mvn clean install
```
