# Employee Management REST API

## Overview
A REST API for managing employee records, built using Java 21, Spring Boot, Spring Data JPA, and MySQL.

## Technologies Used
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Bean Validation

## Features
- Create, retrieve, update, and delete employees
- Validate employee input
- Handle exceptions
- Use DTOs and a layered architecture

## Project Structure
- `entity` – Employee entity
- `dto` – Employee data transfer object and validation
- `repository` – Database operations
- `service` – Business logic
- `controller` – REST API endpoints
- `mapper` – Entity and DTO conversion
- `exception` – Global exception handling

## Prerequisites
- Java JDK 21
- MySQL Server
- Spring Tool Suite (STS) or another compatible Java IDE

## Database Setup
1. Start MySQL.
2. Create the database:

   ```sql
   CREATE DATABASE employee_db;
   ```

3. Open `src/main/resources/application.properties`.
4. Configure your database connection:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
   spring.datasource.username=root
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

5. Replace `YOUR_MYSQL_PASSWORD` with your own MySQL password locally. Never publish your actual password on GitHub.

## How to Run
1. Clone or download this repository.
2. Open the project in STS.
3. Configure the MySQL connection.
4. Allow Maven to download dependencies.
5. Run the Spring Boot application.

The application runs at `http://localhost:8080` by default.

## API Endpoints

Base URL: `http://localhost:8080/api/employees`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Create an employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get an employee by ID |
| PUT | `/api/employees/{id}` | Update an employee |
| DELETE | `/api/employees/{id}` | Delete an employee |

## Sample Request

**POST** `/api/employees`

```json
{
  "firstName": "Anu",
  "lastName": "Thomas",
  "email": "anu.thomas@example.com",
  "department": "IT",
  "salary": 35000
}
```

## Validation and Error Handling
- Required fields are validated.
- Email must be in a valid format.
- Salary must be zero or greater.
- Invalid input returns HTTP 400 Bad Request.
- An employee that cannot be found returns HTTP 404 Not Found.

## Testing
Use Postman to test the API endpoints.

## Author
Sithara K
