# SpringBoot2RestMySQLCRUDExample
Mini Project (Backend ) - 2 <br>- Creating using Rest API, Spring Data JPA, to connect My SQL server and using Postman for testing REST API

# How to Run
<p>Clone the project and launch your command line interface in the project root folder. Execute the following commands based on your environment </br>
  <b> mvn spring-boot:run </b>
  
# How to Test using Postman

============TEST OPERATIONS=============================================

1. To create data:<br>
POST 	<b>localhost:8080/api/employees/save </b>	  SEND <br>
	Body<br>
		(*) raw   [JSON] <br>
{<br>
    "empName": "Sham sunder",<br>
    "empSalary": 10000.0,<br>
    "empDept": "Test"<br>
}

-------------------------------------------------------------------------------------
2. To get all data: <br>
GET  	<b>localhost:8080/api/employees/all  </b> 		SEND

-------------------------------------------------------------------------------------
3. To only 1 employee's data: <br>
GET  	<b>localhost:8080/api/employees/one/3  </b>	SEND

-------------------------------------------------------------------------------------
4. To update existing one employee's data: <br>
PUT	<b>localhost:8080/api/employees/update	</b>	SEND

{
    "empId": 2,
    "empName": "Ram",
    "empSalary": 25000.0,
    "empDept": "Managment"
}

-------------------------------------------------------------------------------------
5. To delete one employee data by id: <br>
DELETE	<b> ocalhost:8080/api/employees/remove/3 </b>	SEND
