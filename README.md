[![Build Status](https://travis-ci.org/graemeo/epocha.svg?branch=master)](https://travis-ci.org/graemeo/epocha)

# Epocha

## Description

This is a simple application built to satisfy a technical assessment to calculate two dates with its differences in a number of days. 

The primary requirements for this application is to:

* Read in two dates in the format of DD MM YYYY, DD MM YYYY where the first is the earlier date and the second is the earlier date
* The dates can be supplied either from file input or System input - file input is chosen
* The dates are to be validated
* The year must not be earlier than 1900 and not later than 2010
* The output will be in the form of "DD MM YYYY, DD MM YYYY, difference"
* The above feature will be exposed as a REST API

## Assumption

Given the above high level descriptions, a few assumptions need to be made to limit the scope of this deliverable:

* Date input is in numerical format
* Output will be in system out
* Feature is exposed as a GET endpoint

## Pre-requisite(s)

* Java 7 and above
* Gradle - optional as Gradle wrapper is already included
* Access to Maven Central - to ensure you do not have proxy configured which may affect downloading dependencies

## Usage(s)

*To run automated tests*

```bash

./gradlew test --info

```

*To build*

```bash

./gradlew clean build

```

*To run application*

```bash

./gradlew bootrun

```

Endpoint is accessible via http://localhost:9090/epocha/dates


