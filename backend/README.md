# Number Conversion

1. Convert number Decimal to Roman
2. Convert number Binary to Roman

## TODO: Add another conversion like Roman to English, then we need to follow:
1. To convert Roman to English, first convert roman to Decimal then Decimal to English
2. Add a new conversion class RomanToEnglishConversion and implements ConversionService and
3. Add to ConversionFactory class ConversionFactory() constructor
4. Implement functionality decimalToEnglish(int decimal) into ConversionUtils 

## Used Technologies
* Java 11
* Spring Boot 2.3.4
* Spring Boot Actuator
* Spring Validation
* Lombok

### Run with maven
Set profile dev in application.properties
spring.profiles.active=dev

```sh
mvn spring-boot:run
```

### Run only test cases

```sh
mvn test
```

## Run with Docker Compose

Package the application as a JAR file

```sh
mvn clean install
```
