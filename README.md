# Student Management System

# Overview

The Student Management System is a web-based application designed to manage student-related tasks, including registration, updating student information, and maintaining a student list. The system consists of a frontend developed using Angular and a backend built with Java Spring Boot.<br>

# Technologies Used

The Student Management System utilizes the following technologies:<br>

- BackEnd - Java Springboot: Spring's convention-over-configuration solution intended to aid in creating production-grade Spring applications with minimal amounts of configuration.<br>
- FrontEnd - Angular: TypeScript-based, free and open-source single-page web application framework.<br>
- DataBase - MySQL Workbench: Serving as the relational database management system for storing employee data.<br>

# Project Structure

## Frontend Part (Angular) - 

The Frontend is organized into several components:

- **Header**: Contains the application header, basically heading & navbar icon.<br>
- **Footer**: Displays the footer section of the application.<br>
- **Menu**: Provides a navigation menu for easy access to different sections like login, register etc.<br>
- **Login**: Handles user authentication and login functionality with database.<br>
- **Sort**: Enables sorting functionality within percentage, subjects and all.<br>
- **StudentList**: Displays a list of students with all details.<br>
- **Delete**: Manages student deletion from student list.<br>
- **Update**: Allows updating student information.<br>
- **Register**: Handles student registration, basically for enrolling new student.<br>
- **Contact Me**: Provides a contact form for communication.<br>
- **About Me**: Presents information about the application or the developer.<br>

## Backend Part (Java SpringBoot) - 

The Backend is structured into the following layers:

- **DAO Layer**: Data Access Object layer responsible for handling data access and storage.<br>
- **Repository Classes**: Interfaces defining methods for database operations.<br>
- **Service Layer**: Business logic layer, contains the main application logic.<br>
- **Controller**: Handles incoming requests and communicates with the service layer.<br>
- **Model Classes**: Define the data entities used within the application.<br>

# Configuration

- Frontend runs on port 4200.<br>
- Backend runs on port 8080 using Tomcat.<br>
- Both frontend and backend are configured to communicate with each other seamlessly.<br>

# Getting Started

## For the FrontEnd - 

1. Clone the repository: `git clone https://github.com/your-username/student-management-system.git`<br>
2. Navigate to the frontend directory: `cd frontend`<br>
3. Install dependencies: `npm install`<br>
4. Run the frontend: `ng serve`<br>

## For the BackEnd - 

1. Navigate to the backend directory: `cd backend`<br>
2. Build the project: `mvn clean install`<br>
3. Run the backend: `java -jar target/student-management-system.jar`<br>

Visit `http://localhost:4200` to access the application.<br>

# Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.<br>
