# Student Monitoring System

A desktop-based **Student Monitoring System** developed using **Java Swing, JDBC, and MySQL**.

The application provides a graphical interface for managing student information, attendance, academic marks, and student performance.

This project was developed as an academic/learning project to practice Java programming, Object-Oriented Programming, GUI development, JDBC, SQL, and MySQL database connectivity.

---

## Features

- User Login
- Dashboard
- Student Details Management
- Add Student Details
- View Student Details
- Update Student Information
- Attendance Management
- Marks Management
- Student Performance Tracking
- Pass/Fail Information
- MySQL Database Connectivity
- Java Swing GUI

---

## Technologies Used
|----------------|---------------------------------------|
| Technology     | Purpose                               |
|----------------|---------------------------------------|
| Java           | Application development               |
| Java Swing     | Graphical User Interface              |
| JDBC           | Database connectivity                 |
| MySQL          | Database                              |
| SQL            | Database queries                      |
| JCalendar      | Date selection                        |
| rs2xml/DbUtils | Displaying database results in tables |
|----------------|---------------------------------------|
---

## Project Modules

### 1. Login

The application starts with a login screen where the user can enter their username and password.

Successful authentication provides access to the main dashboard.

### 2. Dashboard

The dashboard provides navigation to the different modules of the Student Monitoring System.

### 3. Student Details

The student details module allows users to manage student information.

The application supports operations such as:

- Adding student details
- Viewing student details
- Updating student information

Student information includes fields such as:

- GR Number
- Name
- Address
- Aadhar Number
- Phone Number
- Gender
- Blood Group
- Date of Birth

### 4. Attendance

The attendance module allows users to record and view student attendance information.

### 5. Marks

The marks module allows users to add and view academic marks for students.

The system also calculates total marks and provides student performance information.

### 6. Student Performance

The application provides functionality for viewing student performance and identifying students based on their academic results.

---

## Project Structure

```text
Student-Monitoring-System/
│
├── src/
│   ├── Main.java
│   │
│   ├── images/
│   │   └── Application images
│   │
│   └── sms/
│       ├── addAttendance.java
│       ├── addDetails.java
│       ├── addMarks.java
│       ├── attendance.java
│       ├── chooseTheField.java
│       ├── conn.java
│       ├── dashboard.java
│       ├── login.java
│       ├── marks.java
│       ├── selectStd.java
│       ├── starter.java
│       ├── updateProfile.java
│       └── viewDetails.java
│
├── .gitignore
└── README.md
```

---

## Database

The application uses **MySQL** as its database.

The Java application connects to MySQL using JDBC.

Before running the application, create a MySQL database and configure the connection details in:

```text
src/sms/conn.java
```

Example:

```java
String username = "root";
String password = "YOUR_MYSQL_PASSWORD";
String url = "jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME";
```

Replace the placeholder values with your local MySQL credentials.
---

## Required Libraries

The project requires the following libraries:

- MySQL Connector/J
- JCalendar
- rs2xml / DbUtils

These libraries need to be added to the project classpath before running the application.

---

## How to Run

### Step 1: Clone the Repository

```bash
git clone https://github.com/mahendra-samant/student-monitoring-system.git
```

### Step 2: Open the Project

Open the project in IntelliJ IDEA or another Java IDE.

### Step 3: Set Up MySQL

Install MySQL Server and create the required database.

Example:

```sql
CREATE DATABASE student_monitoring_system;
```

Create the required tables according to the SQL queries used by the application.

### Step 4: Configure Database Connection

Open:

```text
src/sms/conn.java
```

and update:

```java
String username = "root";
String password = "YOUR_MYSQL_PASSWORD";
String url = "jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME";
```

### Step 5: Add Required JAR Files

Add the required external libraries to the project.

### Step 6: Run the Application

Run:

```text
src/Main.java
```

or the appropriate application entry point configured in the project.

---

## Learning Outcomes

This project helped me practice:

- Core Java
- Object-Oriented Programming
- Java Swing
- Event Handling
- JDBC
- MySQL
- SQL Queries
- CRUD Operations
- Database Connectivity
- GUI-based application development
- Working with multiple Java classes
- Connecting a desktop application with a relational database

---

## Future Improvements

Possible improvements for a future version include:

- Implement password hashing
- Use `PreparedStatement` instead of dynamically constructed SQL queries
- Add stronger input validation
- Add role-based authentication
- Improve the user interface and user experience
- Add student search and filtering
- Add attendance reports
- Add graphical performance analytics
- Add export functionality for reports
- Improve project architecture using layered design
- Migrate the application to a web-based architecture
- Develop REST APIs for the backend

---

## Project Status

**Completed — Academic/Learning Project**

This project represents an earlier stage of my development journey and demonstrates practical experience with Java Swing, JDBC, SQL, and MySQL.

---

## Author

**Mahendra**

GitHub:  
`https://github.com/mahendra-samant

---

## License

This project is intended for educational and learning purposes.