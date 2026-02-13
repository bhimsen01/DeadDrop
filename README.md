# DeadDrop

DeadDrop is a web application where users can post real-world tasks
with a reward/money, and volunteers can complete those tasks and earn rewards by
submitting proof.

## Technologies
- Java Servlets
- JDBC
- Maven
- Apache Tomcat
- JSP
- MySQL

## Roles
- Director - who gives tasks
- Executor - who does tasks
- Operator - admin who approves tasks and payments

## Features (MVP)
- User login using session
- Create tasks with reward
- Claim and complete tasks
- Submit proof (image + text)
- Admin verification
- Simulated wallet payment
- Added feature for increasing credits of any task

## Architecture
- MVC pattern
- Filters for authentication and authorization
- JSP views inside WEB-INF

## Notes
Payments and users are simulated.