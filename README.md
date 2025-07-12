# 🧾 Employee Management System
<hr>
<li>A Spring Boot REST API for managing Employees and Departments with full CRUD operations, validations, pagination, and query features.
<br>

#  📌 Project Scope

Build an API system to:
<br>
<li>Create, update, delete employees and departments
<br>
<li>Move employees between departments
<br>
<li>Support pagination and lookup views
<br>
<li>Fetch department with list of employees (via expand=true)
<br>
<li>Full validation and exception handling
<br>
# 🔗 REST API Endpoints
  <hr>
# 📁 Department APIs
  <br>
Method	Endpoint	Description
  <br>
<li>POST	/api/departments	Add new department
    <br>
<li>PUT	/api/departments/{id}	Update department details
    <br>
<li>DELETE	/api/departments/{id}	Delete department 
    <br>
<li>GET	/api/departments	Get list of departments
    <br>
<li>GET	/api/departments?expand=true	Get departments with employees
  <br>

# 📁 Employee APIs
<hr>
Method	Endpoint	Description
<br>
<li>POST	/api/employees	Create a new employee
   <br>
<li>PUT	/api/employees/{id}	Update existing employee
   <br>
<li>PATCH	/api/employees/{id}/department/{departmentId}	Move employee to another department
   <br>
<li>GET	/api/employees	Get all employees (paginated)
   <br>
<li>GET	/api/employees?lookup=true	Get only employee ID and names
   <br>
<li>GET	/api/employees/{id}	Get one employee
 <br>

# 📄 Sample JSON Schemas
<hr>
▶ Create Employee
 <br>
json
Copy
Edit
{
  "employeeName": "John Doe",
  "dateOfBirth": "1990-01-01",
  "address": "Bangalore",
  "jobTitle": "Software Engineer",
  "joiningDate": "2023-06-01",
  "salary": 60000,
  "yearlyBonusPercentage": 10,
  "reportingManagerId": 2,
  "departmentId": 1
}
▶ Create Department
json
Copy
Edit
{
  "departmentName": "Engineering",
  "departmentHeadId": 1
}
🗃 Database Schema
🔸 Employee Table
Column	Type	Description
employee_id	INT (PK)	Auto increment primary key
employee_name	VARCHAR	Required
date_of_birth	DATE	Optional
address	VARCHAR	Optional
title	VARCHAR	Required
joining_date	DATE	Optional
salary	DOUBLE	Required
yearly_bonus_percentage	DOUBLE	Optional
department_id	INT (FK)	Links to Department
manager_id	INT (FK)	Self-reference

🔸 Department Table
Column	Type	Description
department_id	INT (PK)	Auto increment primary key
department_name	VARCHAR	Unique name
creation_date	DATE	Auto-set on creation
head_id	INT (FK)	Links to Employee

⚙️ application.properties Example
properties
Copy
Edit
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
🚨 Error Handling Examples
🔸 Validation Error
json
Copy
Edit
{
  "employeeName": "must not be blank",
  "salary": "must be greater than 0"
}
🔸 Not Found
json
Copy
Edit
{
  "error": "Department not found"
}
🔸 Internal Error
json
Copy
Edit
{
  "error": "Internal server error",
  "details": "Exception message..."
}
