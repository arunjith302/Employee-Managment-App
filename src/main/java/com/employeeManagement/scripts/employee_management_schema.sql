
Create database  employee_management ;
 Create Department Table
CREATE TABLE department (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(255) NOT NULL UNIQUE,
    creation_date DATE,
    head_id INT 
);


CREATE TABLE employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(255),
    date_of_birth DATE,
    address VARCHAR(255),
    title VARCHAR(255),
    joining_date DATE,
    salary DOUBLE,
    yearly_bonus_percentage DOUBLE,
    department_id INT,
    manager_id INT,
    FOREIGN KEY (department_id) REFERENCES department(department_id),
    FOREIGN KEY (manager_id) REFERENCES employee(employee_id)
);


INSERT INTO department (department_name, creation_date, head_id)
VALUES 
('Engineering', '2023-01-01', NULL),
('Human Resources', '2023-01-02', NULL),
('Marketing', '2023-01-03', NULL),
('Finance', '2023-01-04', NULL),
('Operations', '2023-01-05', NULL);


INSERT INTO employee (
    employee_name, address, date_of_birth, title, joining_date,
    salary, yearly_bonus_percentage, department_id, manager_id
)
VALUES 
('Alice Johnson', 'New York', '1990-05-10', 'Software Engineer', '2022-01-15', 70000, 5.0, 1, NULL),
('Bob Smith', 'California', '1985-07-22', 'Team Lead', '2021-03-10', 85000, 6.0, 1, 1),
('Catherine Lee', 'Texas', '1992-11-30', 'QA Engineer', '2022-07-20', 60000, 4.0, 1, 2),
('David Kumar', 'Bangalore', '1988-04-12', 'HR Manager', '2020-09-01', 75000, 5.5, 2, NULL),
('Eva Green', 'Mumbai', '1991-06-18', 'Recruiter', '2023-02-25', 65000, 4.5, 2, 4),
('Frank Brown', 'Chennai', '1983-08-05', 'Finance Manager', '2019-12-12', 95000, 7.0, 4, NULL),
('Grace Adams', 'Delhi', '1995-09-09', 'Junior Accountant', '2023-04-01', 55000, 3.0, 4, 6),
('Henry Evans', 'Kerala', '1990-10-10', 'Marketing Specialist', '2022-06-01', 72000, 4.8, 3, NULL),
('Isla Thomas', 'Hyderabad', '1996-03-05', 'Marketing Intern', '2023-05-15', 48000, 3.5, 3, 8),
('Jack Wilson', 'Pune', '1987-01-01', 'Operations Lead', '2020-01-20', 98000, 6.5, 5, NULL),
('Kelly Jordan', 'Kochi', '1994-12-20', 'Ops Executive', '2022-10-10', 67000, 4.2, 5, 10),
('Leo Fernandes', 'Coimbatore', '1986-05-15', 'Backend Dev', '2021-11-11', 69000, 5.0, 1, 2),
('Mira Shah', 'Surat', '1993-08-08', 'HR Intern', '2023-03-03', 40000, 2.0, 2, 4),
('Nathan White', 'Gujarat', '1992-10-10', 'Finance Analyst', '2022-02-02', 53000, 3.8, 4, 6),
('Olivia Davis', 'Vizag', '1991-11-11', 'Marketing Manager', '2022-12-12', 82000, 5.6, 3, 8);


UPDATE department SET head_id = 2 WHERE department_id = 1; 
UPDATE department SET head_id = 4 WHERE department_id = 2; 
UPDATE department SET head_id = 8 WHERE department_id = 3; 
UPDATE department SET head_id = 6 WHERE department_id = 4;
UPDATE department SET head_id = 10 WHERE department_id = 5; 






