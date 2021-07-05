# SpringBoot2RestMySQLCRUDExample
Mini Project (Backend ) - 2 <br>- Creating using Rest API, Spring Data JPA, to connect My SQL server and using Postman for testing REST API

# How to Run
<p>Clone the project and launch your command line interface in the project root folder. Execute the following commands based on your environment </br>
  <b> mvn spring-boot:run </b>
  
# How to Test using Postman

============TEST OPERATIONS=============================================

1. To create data:
POST 	localhost:8080/api/employees/save	  SEND
	Body
		(*) raw   [JSON]
{
    "empName": "Sham sunder",
    "empSalary": 10000.0,
    "empDept": "Test"

}

-------------------------------------------------------------------------------------
2. To get all data:
GET  	localhost:8080/api/employees/all  		SEND

-------------------------------------------------------------------------------------
3. To only 1 employee's data:
GET  	localhost:8080/api/employees/one/3  	SEND

-------------------------------------------------------------------------------------
4. To update existing one employee's data:
PUT		localhost:8080/api/employees/update		SEND

{
    "empId": 2,
    "empName": "Ram",
    "empSalary": 25000.0,
    "empDept": "Managment"

}

-------------------------------------------------------------------------------------
5. To delete one employee data by id
DELETE		localhost:8080/api/employees/remove/3	SEND
