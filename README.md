# DataVista (A DataBase Visualizer)

## A Web App for users to execute and visulaize their database queries.

### Features
* Login
* SignUp
* See all tables present in the DB
* Admin can set permissions related to each table for each user.
* Users can run "Select" queries on tables accessible to them.

### Built With
* [Spring Boot](https://en.wikipedia.org/wiki/Spring_Framework)
* [MySQL](https://en.wikipedia.org/wiki/MySQL)
* [MongoDB](https://en.wikipedia.org/wiki/MongoDB)

### Dependencies
* [JUnit]() for testing.
* [Spring boot starter web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) for web.
* [Spring boot starter jetty](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jetty) for server.
* [JSTL](https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/jstl-api) and [taglibs](https://mvnrepository.com/artifact/org.apache.taglibs/taglibs-standard-impl) for [JSP](https://en.wikipedia.org/wiki/Jakarta_Server_Pages)
* [JWT](https://en.wikipedia.org/wiki/JSON_Web_Token) for authentication (oatuh0)
* [tomcat-jdbc](https://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html) for database connection pool.
* [MySQL connnector](https://dev.mysql.com/downloads/connector/j/) and [Spring boot starter jdbc](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jdbc) for jdbc connection and queries.

### Getting started
* Set up a datasource for jdbc to connect with in jdbcConfig class.
* Set up a cookie name in the login controller and a session timeout time.
* Set the table names and database names in SQLHandler and QueryHandler classes.
### Table structures
1. <img width="290" alt="Screenshot 2021-03-29 at 6 35 37 PM" src="https://user-images.githubusercontent.com/69719655/112841189-d3b4eb00-90bd-11eb-9769-32d842295f96.png">

* Permissions Table
  * Columns
    * "Email" - varchar(255)
    * "TableName" - varchar(255)
    * "Insert" - boolean
    * "Read" - boolean
    * "Update" - boolean
    * "Delete" - boolean
2. <img width="160" alt="Screenshot 2021-03-29 at 6 44 44 PM" src="https://user-images.githubusercontent.com/69719655/112842142-e11ea500-90be-11eb-9392-00d7c636e2e2.png">

* Users Table
  * Columns
    * "Email" - varchar(255)
    * "Password" - vachar(255)
    * "isAdmin" - boolean


### Implementation
* SignUp Controller
  - Inserts a user in the user table keeping the isAdmin value false by default.
* Login Controller
  - Gets a user object from the servlet and sets a cookie for a session and authenticates the user.
* Home Controller
  - Gets all the table names from the database and sends it to the jsp.
* Table Controller
  - Gets the control when a table name is clicked upon and extracts the table name and finds if the table is accessible to the current user.
  - Gives the control back to user to execute a query is table is accessible or return unatuthorised if not.
  - Executes the query given by the user and returns the data received in the form of a table object and is displayed on the screen in a ***table*** tag.
* QueryBuilder
  - Takes variables like select, from, where, limit etc and builds a query in sql syntax.
* SQL Handler
  - Executes queries and creates objects like user, table, row etc.

### In Development Phase
* Mongo Query Builder
* Assigning Permissions for tables to users by admin.
* UI
