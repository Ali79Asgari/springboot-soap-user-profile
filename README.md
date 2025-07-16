# SOAP Microservices

This project is a sample implementation of a microservice-based architecture designed to demonstrate advanced Java and Spring Boot capabilities using both REST and SOAP communication. It consists of two services:

- `user-service`: Handles user registration and retrieval.
- `profile-service`: Manages user profiles and communicates with the `user-service` via SOAP to validate users.

---

## 📌 Features

- ✅ Java 24 (OpenJDK)
- ✅ Spring Boot 3.2.5
- ✅ Spring Web + Spring Data JPA
- ✅ PostgreSQL for data persistence
- ✅ Docker + Docker Compose
- ✅ RESTful APIs
- ✅ SOAP communication between services
- ✅ Swagger UI for API documentation
- ✅ Maven build

---

## 🏗️ Project Structure

- ├── user-service/
- │ └── Handles user registration and SOAP server endpoint
- ├── profile-service/
- │ └── Handles user profiles and acts as a SOAP client
- ├── docker-compose.yml
- └── README.md


---

## 🔧 Technologies Used

| Layer           | Technology                        |
|----------------|-----------------------------------|
| Language        | Java 24 (OpenJDK)                |
| Framework       | Spring Boot 3.2.5                |
| Build Tool      | Maven                            |
| Communication   | REST + SOAP                      |
| Persistence     | PostgreSQL (via Docker)          |
| Documentation   | Swagger (SpringDoc)              |
| Containerization| Docker, Docker Compose           |

---

## 🚀 How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Ali79Asgari/springboot-soap-user-profile.git
cd springboot-soap-user-profile
```
### 2️⃣ Build the JARs
```bash
cd user-service
mvn clean package -DskipTests

cd ../profile-service
mvn clean package -DskipTests

cd ..
```
### 3️⃣ Run with Docker Compose
```bash
docker-compose up --build
```

This will start:

user-service on port 8081

profile-service on port 8082

PostgreSQL for both services

---

## 🔍 API Endpoints
### 📦 user-service
POST /users – Create a new user

{
  "name": "Ali Rezaei",
  "email": "ali@example.com"
}


GET /users – List all users


GET /users/{id} – Get a specific user by ID

#### 🧼 SOAP Endpoint (WSDL):
http://localhost:8081/ws/users.wsdl

### 📦 profile-service
POST /profiles – Create a new profile

(Automatically checks if user exists via SOAP)

{
  "userId": 1,
  "bio": "Senior Java Developer",
  "location": "Tehran",
  "age": 30
}


GET /profiles/{id} – Get a profile with associated user info (via SOAP)

---

## 📖 Swagger API Documentation

### user-service Swagger UI
```bash
http://localhost:8081/swagger-ui.html
```
### profile-service Swagger UI
```bash
http://localhost:8082/swagger-ui.html
```

---

## 📂 Database Configuration
PostgreSQL is used for both services:

usersdb for user-service (port 5432)

profilesdb for profile-service (port 5433)

Credentials for both:

username: ali

password: ali

You can connect using any PostgreSQL client or via docker exec.

---

## 📬 Example Usage (with cURL)
```bash
# Create user
curl -X POST http://localhost:8081/users \
  -H "Content-Type: application/json" \
  -d '{"name": "Ali Rezaei", "email": "ali@example.com"}'

# Create profile
curl -X POST http://localhost:8082/profiles \
  -H "Content-Type: application/json" \
  -d '{"userId": 1, "bio": "Developer", "location": "Tehran", "age": 30}'
```

---

### 🧪 Testing
After all services are up:

Test user creation at http://localhost:8081/users

Test profile creation at http://localhost:8082/profiles

Validate SOAP communication using profile creation

---

### ✅ Tips for Development
Use docker-compose down -v to reset DBs completely.

Rebuild project when Java class changes:

```bash
mvn clean package -DskipTests
docker-compose up --build
```

Watch logs with:

```bash
docker-compose logs -f user-service
```
