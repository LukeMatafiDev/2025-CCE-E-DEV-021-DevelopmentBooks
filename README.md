# 📘 KATA for MATAFI Luke

This repository contains a **Java Spring Boot 3.5.7** project developed as part of the KATA for **MATAFI Luke**.  
The project is a **Maven-based** web application packaged as a `.war` file.

---

## 🧰 Project Overview

This project demonstrates a Spring Boot API that calculates the total cost of items in a cart.  
It leverages Java 23 features and follows standard Maven project conventions.

---

## ⚙️ Requirements

Before running the project, ensure you have the following installed:

| Requirement | Minimum Version | Description |
|--------------|-----------------|--------------|
| **Java** | 11              | Required to build and run the Spring Boot app |
| **Maven** | 3.9.x           | Required to manage dependencies and build the project |
| **Git** | Latest          | Required to clone the repository |

---

## 🚀 Setup and Execution

Follow the steps below to clone, build, and run the project locally.

### 1) Clone the Repository

If you don’t already have Git installed, please install it first.  
Then, open your terminal and run:


git clone https://github.com/LukeMatafiDev/2025-CCE-E-DEV-021-DevelopmentBooks.git

### 2) Once clone is complete, navigate to the project folder ..\developmentbooks
cd developmentbooks
### 3) You will need to execute it in main branch using below command
   git checkout main
### 4) You may now run below command to get project dependencies
   mvn clean install
### 5) To verify if the unit test cases are passing run
   mvn clean test
### 6) To run the web api use
   mvn spring-boot:run
   #### This will run the web server on port 8080
### 7) To test the application perform a post request using below url and request body

   REQUEST URL:           http://localhost:8080/cart/list
   #### REQUEST TYPE:          POST

   #### 
```json

REQUEST BODY
{
"cart":[
"Clean Code",
"Clean Code",
"The Clean Coder",
"The Clean Coder"
    ]
}

RESPONSE BODY

{
"cartTotal": 320.0
}








