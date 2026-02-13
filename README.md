# DeadDrop

DeadDrop is an economy-enabled task marketplace where users post real-world missions with attached rewards, and other users complete them by submitting verifiable proof.

## Vision
DeadDrop explores how decentralized gig-style micro-tasks can be coordinated through reputation, verification workflows, and wallet mechanics.
The goal is to design infrastructure where:
- Task creators and task executors are both anonymous
- No regulations
- admin authorization for rewards

## Core Idea
- Director funds tasks
- Agents executes the task
- Submits proof of completion
- Operator verifies completion
- Credits are transferred
- All parties anonymous

## Technologies
- Java Servlets
- JDBC
- Maven
- Apache Tomcat
- JSP
- MySQL

## Roles
- Director - funds tasks
- Executor - executes tasks
- Operator - admin who approves tasks and payments

## Features (MVP)
- User login using session
- Secure authentication with salt
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
DeadDrop is a simulation platform built for learning and experimentation.