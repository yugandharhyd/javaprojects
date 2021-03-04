# Backend Dev Interview Test

This Repo is based on Spring boot project with h2 database, Gradle and java 8. 
It includes Schema and test data (schema.sql and data.sql) and auto creates schema and data.
Please run Gradle bootRun to start both tomcat and h2 console on localhost 8080.

### Database H2 console
http://localhost:8080/h2-console (jdbc url = jdbc:h2:mem:testdb, user = sa, blank password)

### Application endpoints to implement:
http://localhost:8080/activeCustomersNotOrderedYet
http://localhost:8080/totalValueOfCompletedOrdersFromActiveCustomers

### implementation strategy
Used only repository CRUD methods and service layer to implement the business logic.

