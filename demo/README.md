# Task Management System with JWT Authentication

## Description
This is a task management application that allows users to manage their tasks. It includes JWT authentication and Spring Security for protecting endpoints. Users can register, log in, and perform CRUD operations on their tasks.

## Features
- User registration and login with JWT-based authentication.
- CRUD operations for tasks (create, read, update, delete).
- Secured API endpoints with Spring Security.

## Installation

### Prerequisites
- Java 17
- Maven

### Steps
1. Clone this repository:
   ```bash
   git clone https://github.com/UwaseNadege/demo-project.git


Usage
Access the application at http://localhost:8080.
Register a new user by sending a POST request to /auth/register with the user's details.
Log in to get a JWT token by sending a POST request to /auth/login.
Use the token to authenticate and access the /tasks endpoint (GET, POST, PUT, DELETE).

Technologies Used
Spring Boot
Spring Security
JWT (JSON Web Token)
Hibernate / JPA
SQLite
