# Cars4Us - Backend API

This project is the backend component of the Cars4Us application, a web-based solution to manage car showrooms and associated cars. The backend is developed with **Java 21** and **Spring Boot**, leveraging **Spring Data JPA** for data management, **PostgreSQL** as the database, and **Liquibase** for database migrations.

## Project Overview

The backend exposes a RESTful API for managing car showrooms and cars, including CRUD operations, pagination, filtering, and validations. It is configured with Spring Boot, and the main dependencies are included in the `pom.xml` file.

## Key Technologies and Dependencies

- **Java 21**: Latest Java version with enabled preview features.
- **Spring Boot 3.3.5**: Used as the primary framework.
- **Spring Data JPA**: Manages database interactions.
- **PostgreSQL**: Database management system.
- **Hibernate**: ORM framework for database management.
- **Liquibase**: Handles database versioning.
- **MapStruct**: For mapping DTOs to entities.
- **Lombok**: Reduces boilerplate code (optional).
- **OpenAPI**: Provides API documentation through Swagger UI.

## Prerequisites

- Java 21+
- Maven 3+
- PostgreSQL 13+ (or Docker to set up PostgreSQL container)
- Liquibase (for database versioning)

## Project Structure

- `src/main/java`: Application source code and REST controllers.
- `src/main/resources`: Configuration files
- `application.yaml`: Main configuration file for database connection and application properties.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Milfy1/cars-4-us.git
   cd cars-4-us
   ```

2. **Configure PostgreSQL**:
   Ensure PostgreSQL is running, and update `src/main/resources/application.yaml` with your database credentials:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/postgres
       username: postgres
       password: postgres
     jpa:
       properties:
         hibernate:
           dialect: org.hibernate.dialect.PostgreSQLDialect
           format_sql: true
       show-sql: true
       hibernate:
         ddl-auto: update
   ```

3. **Run the Application**:
   Use Maven to build and start the backend server:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access API Documentation**:
   Swagger UI is available at:
   ```
   http://localhost:8080/swagger-apis
   ```

## API Endpoints

### Car Showroom Management

- **Create Showroom**: `POST /api/v1/car-showrooms`
    - Parameters: `name`, `commercial_registration_number`, `manager_name`, `contact_number`, `address`
    - Validations: Ensures required fields, unique registration number, and other constraints.

- **List Showrooms**: `GET /api/v1/car-showrooms`
    - Pagination and sorting enabled.
    - Response: List of showrooms with `name`, `commercial_registration_number`, and `contact_number`.

- **Get Showroom Details**: `GET /api/v1/car-showrooms/{id}`
    - Retrieves full details of a specific showroom.

- **Update Showroom**: `PUT /api/v1/car-showrooms/{id}`
    - Updatable fields: `contact_number`, `manager_name`, `address`.

- **Delete Showroom**: `DELETE /api/v1/car-showrooms/{id}`
    - Soft delete; the showroom is no longer listed but remains in the database.

### Car Management

- **Add New Car**: `POST /api/v1/cars`
    - Parameters: `vin`, `maker`, `model`, `model_year`, `price`, `car_showroom_id`
    - Validations: Ensures required fields and formats.

- **List Cars with Showroom Details**: `GET /api/v1/cars`
    - Supports pagination and dynamic filtering (e.g., by maker, showroom name).
    - Response: List of cars with fields such as `vin`, `maker`, `model`, `model_year`, `price`, `car_showroom_name`, `contact_number`.

## Key Dependencies in `pom.xml`

- **Spring Boot Starter Data JPA**: For ORM and database interactions.
- **Spring Boot Starter Validation**: For input validation constraints.
- **Spring Boot Starter Web**: For building REST APIs.
- **PostgreSQL Driver**: PostgreSQL database connector.
- **MapStruct**: For entity-DTO mapping.
- **Lombok**: Simplifies code by generating boilerplate code like getters, setters, etc.
- **OpenAPI (Springdoc)**: Automatically generates Swagger UI for API documentation.


## Error Handling

- **Validation Errors**: Managed by `spring-boot-starter-validation` with appropriate HTTP status codes.
- **Exception Handling**: Proper exception handling for common errors, including custom error responses.

## Development

- **Git**: Version control with meaningful commit messages.



