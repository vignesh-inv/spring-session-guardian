# Spring Session Guardian

## 🔐 Overview

**Spring Session Guardian** is a secure Spring Boot application demonstrating:

- **Session ID Rotation**: Mitigates session fixation attacks by rotating session IDs on login and refresh.
- **Spring Security Integration**: Implements authentication and authorization with roles like `USER` and `ADMIN`.
- **Password Hashing**: Utilizes salted hashing BCrypt for secure password storage.
- **Admin Privileges**: Allows administrators to manage user roles and privileges.

## ⚙️ Technologies Used

- **Backend**: Spring Boot, Spring Security
- **Database**: MySql
- **Frontend**: Thymeleaf (for Login)
- **Security**: BCrypt, CSRF protection, Session management

## 🚀 Getting Started

### Prerequisites

- Java 17 or later
- Maven or Gradle
- Mysql

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/vignesh-inv/spring-session-guardian.git
   cd spring-session-guardian
