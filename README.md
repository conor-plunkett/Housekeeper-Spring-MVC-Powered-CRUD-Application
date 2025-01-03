# Spring MVC Powered CRUD Application (Java, JavaScript, HTML, CSS, MySQL based)

This project provides a functional web service to facilitae core CRUD applications involved in the ongoing management of a housekeeping management system.
Local ports are used to host the website and the MySQL database. Live scalability integratable through cloud hosting and domain purchase.
Web based functionality facilitates the operation of the program to provide real, live benefit to the end users business.
Powered by customised Spring Boot and Boot Strap technology.

## Spring Dependencies Used
- Spring Web - Builds web services using Spring MVC
- Spring Data - JPA	Persists data into SQL stores for communication purposes
- MySQL Driver- JDBC Driver for MySQL connectivity
- Lombok - Annotation library reducing boilerplate Java code
- Thymeleaf - Frontend templating and data presentation tool

##  Model Structres
Various models are utilised in the methods and altered or returned dependent on the methods employed.
They contain the following parameters:

### Employee
- EmpID *PK
- FirstName
- LastName
- Email
- Role
- Selected

### Housekeeping
- Floor
- RoomNo *PK
- Purpose 
- Active
- EmpID
- FirstName
- LastName
- Status
- EmpSelection
  
### Room
- Floor
- RoomNo *PK
- Purpose
- Active

### Stats
- CurrTime *PK
- Cleaned
- Dirty
- Inactive
- Total

##  Controllers
Controllers aid in the HTML mapping of the aforementioned models, allowing alteration and presentation of data powered through the employed Spring Dependencies.

- DashboardController
- EmployeeController
- HomeController
- HousekeepingController
- Room Controller
  
## Services
Three services cover the core functionality of the application
1. Service 1 - Employee Management
2. Service 2 - Room Management
3. Service 3 - Housekeeping Management

Each service interface outlines the methods employed in the associated service implementation file.
The HTML mapping intuitively provides clear ease of access to these services. The employed CRUD alter the datatables, presented back to the user in the relevant HTML page and on the home dashboard.

## HTML & CSS
All access to the service is intuitively presented throughout the HTML pages. This promotes ease of use and a low barrier to entry for onboarding customers. Spring Boots technologies lay the groundwork in communication infrastructure that ultimately facilitates the integrated success of the systems actions.

## Core Functioanlity
1. Create, update and delete employees from the system
2. Create, update and delete rooms from the system
3. Create, update and delete housekeeping entites from the system (mapped to room CRUD operation
4. Batch generation of room for initialisation of a new hotel on the software
5. Mark rooms as active or inactive, dependening on whether they should be included in the rota
6. Select employees for duties assignment
7. Assign housekeeping duties for active rooms to selected employees
8. Mark rooms as clean
9. Present live overview of overall cleaning status via graphs
10. List information on all rooms, employees, and housekeeping assignments
11. Store related data in an associated database

## Gallery
The following images showcase some of the key functionalities of the service. 

### Dashboard
![image](https://github.com/user-attachments/assets/7d38ccef-1cf9-4003-88fb-2c48c38b6ab3)

### Dynamic JavaScript Graphing
![image](https://github.com/user-attachments/assets/7c1cdb8e-6ba0-4995-87b3-0cfb5da0c1d3)

### JsDelivr Table Evolution
![image](https://github.com/user-attachments/assets/be5c1a35-91a5-40c3-b410-e58a45d6cef0)

### Responsive Screen Design
![image](https://github.com/user-attachments/assets/8a9c1fe3-8403-4717-ba6b-53764b262ee6)

### Batch Addition of Rooms
![image](https://github.com/user-attachments/assets/851f40f1-1a93-4bd5-aecc-2c3bffcd05e9)

### Employee Generation
![image](https://github.com/user-attachments/assets/05d0c77b-3ed3-4e76-b65a-7093a0bd4218)


Copyright 2024, Conor Plunkett
