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


# 📁 Department APIs
  <hr>
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
<li>
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
   <br>
   <br> 
▶ Create Department
 <br>
<li>{
  "departmentName": "Engineering",
  "departmentHeadId": 1
}
# 🗃 Database Schema
  <hr>
🔸 Employee Table
   <br>
<hr> <table border="1" cellspacing="0" cellpadding="5"> <thead> <tr> <th>Column</th> <th>Type</th> <th>Description</th> </tr> </thead> <tbody> <tr> <td>employee_id</td> <td>INT (PK)</td> <td>Auto increment primary key</td> </tr> <tr> <td>employee_name</td> <td>VARCHAR</td> <td>Required</td> </tr> <tr> <td>date_of_birth</td> <td>DATE</td> <td>Optional</td> </tr> <tr> <td>address</td> <td>VARCHAR</td> <td>Optional</td> </tr> <tr> <td>title</td> <td>VARCHAR</td> <td>Required</td> </tr> <tr> <td>joining_date</td> <td>DATE</td> <td>Optional</td> </tr> <tr> <td>salary</td> <td>DOUBLE</td> <td>Required</td> </tr> <tr> <td>yearly_bonus_percentage</td> <td>DOUBLE</td> <td>Optional</td> </tr> <tr> <td>department_id</td> <td>INT (FK)</td> <td>Links to Department</td> </tr> <tr> <td>manager_id</td> <td>INT (FK)</td> <td>Self-reference</td> </tr> </tbody> </table>
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
