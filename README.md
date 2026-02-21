# taskassignment
task assignment 

# 🚀 Product Management REST API

A production-ready Spring Boot RESTful API for managing Products and Items with JWT Authentication, Role-Based Authorization, Pagination, Refresh Token rotation, and Docker support.

---

## 📌 Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- PostgreSQL
- Spring Security
- JWT Authentication
- Refresh Token Rotation
- Swagger (OpenAPI)
- Docker & Docker Compose
- JUnit 5 & Mockito

---

## 🏗 Architecture

The project follows **Layered Clean Architecture**:

Controller → Service → Repository → Database

### Package Structure

---

## 🔐 Security Features

- JWT Access Token
- Refresh Token with rotation
- Role-Based Authorization (ROLE_ADMIN, ROLE_USER)
- Password Encryption (BCrypt)
- CORS Configuration
- Stateless Authentication

---

## 🌐 API Endpoints

### 🔑 Authentication

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/v1/auth/register | Register new user |
| POST | /api/v1/auth/login | Login user |
| POST | /api/v1/auth/refresh | Generate new access token |

---

### 📦 Product APIs

| Method | Endpoint | Role |
|--------|----------|------|
| POST | /api/v1/products | ADMIN |
| GET | /api/v1/products | ADMIN, USER |
| GET | /api/v1/products/{id} | ADMIN, USER |
| PUT | /api/v1/products/{id} | ADMIN |
| DELETE | /api/v1/products/{id} | ADMIN |
| GET | /api/v1/products/{id}/items | ADMIN, USER |

---

## 📊 Features Implemented

- Full CRUD operations
- Pagination support
- Global Exception Handling
- Standardized JSON Error Response
- Database Indexing
- Refresh Token Expiry Handling
- Dockerized Application
- Swagger Documentation

---

## 🗄 Database Schema

### Product Table
- id (Primary Key)
- product_name
- created_by
- created_on
- modified_by
- modified_on

### Item Table
- id (Primary Key)
- product_id (Foreign Key)
- quantity

### User & Role Tables
- users
- roles
- user_roles
- refresh_tokens
