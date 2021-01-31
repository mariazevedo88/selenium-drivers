# selenium-drivers

[![Build Status](https://travis-ci.org/mariazevedo88/selenium-drivers.svg?branch=master)](https://travis-ci.org/mariazevedo88/selenium-drivers?branch=master) [![Coverage Status](https://coveralls.io/repos/github/mariazevedo88/selenium-drivers/badge.svg?branch=master)](https://coveralls.io/github/mariazevedo88/selenium-drivers?branch=master) ![GitHub tag (latest SemVer)](https://img.shields.io/github/tag/mariazevedo88/selenium-drivers.svg) ![Sonatype Nexus (Releases)](https://img.shields.io/nexus/r/https/oss.sonatype.org/io.github.mariazevedo88/selenium-drivers.svg) ![GitHub repo size](https://img.shields.io/github/repo-size/mariazevedo88/selenium-drivers.svg) ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/mariazevedo88/selenium-drivers.svg) ![GitHub language count](https://img.shields.io/github/languages/count/mariazevedo88/selenium-drivers.svg) ![GitHub top language](https://img.shields.io/github/languages/top/mariazevedo88/selenium-drivers.svg) ![GitHub](https://img.shields.io/github/license/mariazevedo88/selenium-drivers.svg) ![GitHub All Releases](https://img.shields.io/github/downloads/mariazevedo88/selenium-drivers/total.svg) ![GitHub last commit](https://img.shields.io/github/last-commit/mariazevedo88/selenium-drivers.svg)

## About selenium-drivers

Project that implements services that execute drivers used in Selenium.

* Currently, we have the implementation of two drivers: [Chrome](http://chromedriver.chromium.org/downloads) and [Firefox](https://github.com/mozilla/geckodriver/releases).
* The drivers are located in the `src/main/resource/drivers` (Windows and Linux versions).
* To run the application, you can change the paths of the drivers to another location. You must also populate the `downloadPath` parameter.

## Dependencies

- [Java 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/index.html)
- [Selenium (3.141.59)](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59)
- [JUnit 5 (5.4.0)](https://junit.org/junit5/docs/current/user-guide/)
- [Jackson Databind (2.12.0)](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.12.0)
- [Apache Poi (4.1.2)](https://mvnrepository.com/artifact/org.apache.poi/poi/4.1.2)
- [log4j (1.2.17)](https://mvnrepository.com/artifact/log4j/log4j/1.2.17)

## How to use

You must import .jar into the classpath of your project. If your project is a maven project, just set it as dependency in `pom.xml`, as follows:

```
<dependency>
    <groupId>io.github.mariazevedo88</groupId>
    <artifactId>selenium-drivers</artifactId>
    <version>1.0.4</version>
</dependency>

```
