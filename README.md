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

<table border="1" cellspacing="0" cellpadding="5"> <thead> <tr> <th>Method</th> <th>Endpoint</th> <th>Description</th> </tr> </thead> <tbody> <tr> <td>POST</td> <td>/api/departments</td> <td>Add new department</td> </tr> <tr> <td>PUT</td> <td>/api/departments/{id}</td> <td>Update department details</td> </tr> <tr> <td>DELETE</td> <td>/api/departments/{id}</td> <td>Delete department (only if no employees)</td> </tr> <tr> <td>GET</td> <td>/api/departments</td> <td>Get list of departments</td> </tr> <tr> <td>GET</td> <td>/api/departments?expand=true</td> <td>Get departments with employees</td> </tr> </tbody> </table>
 <br>

# 📁 Employee APIs
<hr>

 <table border="1" cellspacing="0" cellpadding="5"> <thead> <tr> <th>Method</th> <th>Endpoint</th> <th>Description</th> </tr> </thead> <tbody> <tr> <td>POST</td> <td>/api/employees</td> <td>Create a new employee</td> </tr> <tr> <td>PUT</td> <td>/api/employees/{id}</td> <td>Update existing employee</td> </tr> <tr> <td>PATCH</td> <td>/api/employees/{id}/department/{departmentId}</td> <td>Move employee to another department</td> </tr> <tr> <td>GET</td> <td>/api/employees</td> <td>Get all employees (paginated)</td> </tr> <tr> <td>GET</td> <td>/api/employees?lookup=true</td> <td>Get only employee ID and names</td> </tr> <tr> <td>GET</td> <td>/api/employees/{id}</td> <td>Get one employee</td> </tr> </tbody> </table>
 <br>
 

# 📄 Sample JSON Schemas
<hr>

<h3>▶ Create Employee</h3>
<pre><code>{
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
</code></pre>

<h3>▶ Create Department</h3>
<pre><code>{
  "departmentName": "Engineering",
  "departmentHeadId": 1
}
</code></pre>
   <br>
# 🗃 Database Schema
  <hr>
🔸 Employee Table
   <br>
<hr> <table border="1" cellspacing="0" cellpadding="5"> <thead> <tr> <th>Column</th> <th>Type</th> <th>Description</th> </tr> </thead> <tbody> <tr> <td>employee_id</td> <td>INT (PK)</td> <td>Auto increment primary key</td> </tr> <tr> <td>employee_name</td> <td>VARCHAR</td> <td>Required</td> </tr> <tr> <td>date_of_birth</td> <td>DATE</td> <td>Optional</td> </tr> <tr> <td>address</td> <td>VARCHAR</td> <td>Optional</td> </tr> <tr> <td>title</td> <td>VARCHAR</td> <td>Required</td> </tr> <tr> <td>joining_date</td> <td>DATE</td> <td>Optional</td> </tr> <tr> <td>salary</td> <td>DOUBLE</td> <td>Required</td> </tr> <tr> <td>yearly_bonus_percentage</td> <td>DOUBLE</td> <td>Optional</td> </tr> <tr> <td>department_id</td> <td>INT (FK)</td> <td>Links to Department</td> </tr> <tr> <td>manager_id</td> <td>INT (FK)</td> <td>Self-reference</td> </tr> </tbody> </table>
  <br>
   <br>
<h3>🔸 Department Table</h3>
<table border="1" cellspacing="0" cellpadding="5">
  <thead>
    <tr>
      <th>Column</th>
      <th>Type</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>department_id</td>
      <td>INT (PK)</td>
      <td>Auto increment primary key</td>
    </tr>
    <tr>
      <td>department_name</td>
      <td>VARCHAR</td>
      <td>Unique name</td>
    </tr>
    <tr>
      <td>creation_date</td>
      <td>DATE</td>
      <td>Auto-set on creation</td>
    </tr>
    <tr>
      <td>head_id</td>
      <td>INT (FK)</td>
      <td>Links to Employee</td>
    </tr>
  </tbody>
</table>


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
