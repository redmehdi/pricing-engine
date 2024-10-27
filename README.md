Pricing Engine Service
======================

This project is a Spring Boot application that serves as a RESTful pricing engine service, following Hexagonal Architecture principles. The application provides an endpoint to query applicable pricing for products based on brand and time criteria. It uses an in-memory H2 database to store sample data and is implemented with Java and JPA.

Table of Contents
-----------------

-   [Getting Started](#getting-started)
-   [Features](#features)
-   [Architecture](#architecture)
-   [Technologies Used](#technologies-used)
-   [Endpoints](#endpoints)
-   [Database Schema](#database-schema)
-   [Configuration](#configuration)
-   [Testing](#testing)
-   [Error Handling](#error-handling)
-   [Development Guidelines](#development-guidelines)
-   [Troubleshooting](#troubleshooting)
-   [License](#license)

* * * * *

Getting Started
---------------

### Prerequisites

-   Java 17 or later
-   Maven 3.6 or later

### Installation

1.  Clone the repository:

    ```bash
    git clone https://github.com/yourusername/pricing-engine.git
    ```

### Build the Application

 ```bash
 mvn clean install
```

### Run the Application

 ```bash 
 mvn spring-boot:run
```

The application will run on `http://localhost:8080`. You can test the endpoints via tools like Postman or using curl commands (see the [Endpoints](#endpoints) section).

* * * * *

Features
--------

-   RESTful endpoint to retrieve applicable product pricing based on brand and date.
-   In-memory H2 database initialized with sample data.
-   Follows Hexagonal Architecture principles for clear separation between domain, application, and infrastructure layers.

* * * * *

Architecture
------------

This project follows Hexagonal Architecture (also known as Ports and Adapters), aiming to keep core business logic independent of external systems. It organizes code into three main components:

-   **Domain**: Contains core business logic and entities (`Price`, `Brand`, `Product`). This is the heart of the application, where the main business rules are defined.

-   **Application (Ports)**: Interfaces that define operations required by the domain but are implemented outside the core domain. These interfaces are essential for isolating the domain from specific implementations, enabling testability and flexibility.

-   **Adapters**: Concrete implementations of ports, including the REST controller (for HTTP interactions) and the Spring Data JPA repository (for database access). These adapters allow the application to interact with the outside world, such as web requests and database storage.

* * * * *

Technologies Used
-----------------

-   **Spring Boot**: Application framework for REST API development.
-   **Spring Data JPA**: Data access abstraction for database interactions.
-   **H2 Database**: In-memory database used for testing and development.
-   **Java 17**: Programming language version.
-   **Maven**: Build and dependency management tool.
-   **JUnit & Mockito**: Testing frameworks for unit and integration tests.

* * * * *

Endpoints
---------

### Retrieve Price

Retrieve pricing information based on brand ID, product ID, and application date.

-   **Endpoint**: `/api/price`
-   **Method**: `GET`
-   **Content-Type**: `application/json`
-   **Request Parameters**:
    -   `applicationDate` (LocalDateTime) - The date for price applicability.
    -   `productId` (Integer) - Product identifier.
    -   `brandId` (Long) - Brand identifier.

**Example Request**:

 ```bash
curl -X GET "http://localhost:8080/api/price"\
-H "Content-Type: application/json"\
-d '{
"applicationDate": "2020-06-14T10:00:00",
"productId": 35455,
"brandId": 1
}'
```

**Example Response**:

json

 ```bash
{
"startDate": "2020-06-14T00:00:00",
"endDate": "2020-12-31T23:59:59",
"priceList": 1,
"priority": 1,
"price": 35.50,
"currency": "EUR",
"brandId": 1,
"productId": 35455
}
```

* * * * *

Database Schema
---------------

The in-memory H2 database schema includes three main tables:

-   **BRANDS**: Stores brand information.
-   **PRODUCTS**: Contains product details.
-   **PRICES**: Reflects product prices, applicable between specific dates and by brand.

* * * * *

Configuration
-------------

Configure application properties in `application.properties` to customize settings such as the database and logging levels.

* * * * *

Testing
-------

The application includes both JUnit and Mockito tests to ensure functionality:

-   **Unit Tests**: Test individual components.
-   **Integration Tests**: Validate the application as a whole.

Run tests using:

 ```bash
 mvn test
```

* * * * *

Error Handling
--------------

The application provides comprehensive error handling, returning appropriate HTTP status codes and messages for invalid requests or data errors.

* * * * *

Development Guidelines
----------------------

-   Follow Hexagonal Architecture principles.
-   Use DTOs for data transfer between layers.
-   Implement logging for tracing and debugging.

* * * * *

Troubleshooting
---------------

### Common Issues

-   **H2 Database not loading**:
    -   Ensure H2 is configured in `application.properties`.
-   **Tests failing**:
    -   Ensure dependencies are correctly injected and mocks are properly set.

* * * * *

License
-------

This project is licensed under the MIT License. See the `LICENSE` file for details.
