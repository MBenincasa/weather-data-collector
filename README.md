# Weather Data Collector

Weather Data Collector is a Spring Boot application that collects weather data. The application utilizes Spring Batch to retrieve data from OpenWeatherMap, and it provides services to query the data history.

## Features

- Data Retrieval: The application uses a Spring Batch process to retrieve weather data from OpenWeatherMap at regular intervals.
- Data Storage: The collected weather data is stored in a database to enable querying of the data history.
- Query Services: The application offers services to query the historical weather data.

## Technologies Used

- Java: The primary programming language used to develop the application.
- Spring Boot: Framework for developing Java-based applications with Spring.
- Spring Batch: Framework for managing batch processes in Java applications.
- OpenWeatherMap API: API for accessing weather data provided by OpenWeatherMap.
- Database: A database is used to store the collected weather data.
