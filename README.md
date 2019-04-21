# selenium-drivers

Project that implements services that execute drivers used in Selenium.

## About selenium-drivers

* Currently, we have the implementation of two drivers: [Chrome](http://chromedriver.chromium.org/downloads) and [Firefox](https://github.com/mozilla/geckodriver/releases).
* The drivers are located in the `src/main/resource/drivers`.
* To run the application, you can change the paths of the drivers to another location. You must also populate the `downloadPath` parameter.

## Dependencies

- [Java 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/index.html)
- [Selenium (3.141.59)](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59)
- [JUnit 5 (5.4.0)](https://junit.org/junit5/docs/current/user-guide/)
- [Jackson Databind (2.9.5)](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.9.5)
- [Apache Poi (3.8)](https://mvnrepository.com/artifact/org.apache.poi/poi/3.8)
- [log4j (1.2.17)](https://mvnrepository.com/artifact/log4j/log4j/1.2.17)

## Contributing

