# Task Reminder Application Documentation

## Overview
This is a Spring Boot application for managing tasks and reminders, built with:
- **Spring Boot 3.5.0**
- **PostgreSQL 16.9** (hosted on Neon)
- **Flyway** for database migrations
- **Spring Data JPA** for data access
- **Java 21**

## Database Setup with PostgreSQL Neon

### 1. Neon Database Configuration

#### Prerequisites
- Neon account (free tier available at https://neon.tech)
- PostgreSQL database created in Neon

#### Connection Details
The application is configured to connect to a Neon PostgreSQL database with the following settings:

```properties
# Neon DB (PostgreSQL) Configuration
spring.datasource.url=jdbc:postgresql://ep-patient-surf-a5s6mzcf-pooler.us-east-2.aws.neon.tech/SpringTaskReminder?sslmode=require
spring.datasource.username=Learn_owner
spring.datasource.password=MPifv3d8ImXW
```

**Important Security Note:** In production, never commit database credentials to version control. Use environment variables or secure configuration management.

### 2. Dependencies Setup

The project includes the following database-related dependencies in `pom.xml`:

```xml
<!-- PostgreSQL Driver -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Spring Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Flyway Core -->
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>

<!-- Flyway PostgreSQL Support (Required for PostgreSQL 16.9) -->
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-database-postgresql</artifactId>
</dependency>
```

**Note:** The `flyway-database-postgresql` dependency is crucial for PostgreSQL 16.9 support. Without it, you'll get "Unsupported Database: PostgreSQL 16.9" errors.

## Database Migrations with Flyway

### 1. Migration Directory Structure

Flyway migrations are stored in:
```
src/main/resources/db/migration/
```

### 2. Migration File Naming Convention

Flyway uses a specific naming convention:
- **Versioned migrations**: `V<version>__<description>.sql`
- **Repeatable migrations**: `R__<description>.sql`
- **Undo migrations**: `U<version>__<description>.sql`

Examples:
- `V1__Create_tasks_table.sql`
- `V2__Add_user_table.sql`
- `R__Update_views.sql`

### 3. Creating Your First Migration

#### Step 1: Create Migration Directory
```bash
mkdir -p src/main/resources/db/migration
```

#### Step 2: Create Migration File
Create `V1__Create_tasks_table.sql`:

```sql
-- Create tasks table
CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    due_date TIMESTAMP,
    completed BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create index on due_date for better performance
CREATE INDEX IF NOT EXISTS idx_tasks_due_date ON tasks(due_date);

-- Create index on completed status
CREATE INDEX IF NOT EXISTS idx_tasks_completed ON tasks(completed);
```

### 4. Migration Configuration

Add these settings to `application.properties`:

```properties
# Flyway (migrations)
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true

# Hibernate (JPA) settings
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

**Important Settings Explained:**
- `spring.flyway.locations`: Where to find migration files
- `spring.flyway.baseline-on-migrate=true`: Allows Flyway to work with existing databases
- `spring.jpa.hibernate.ddl-auto=validate`: Hibernate validates schema but doesn't create tables (Flyway handles this)

## Running the Application

### 1. Starting the Application

```bash
./mvnw spring-boot:run
```

### 2. What Happens During Startup

1. **Database Connection**: Spring Boot connects to Neon PostgreSQL
2. **Flyway Migration**: 
   - Validates existing migrations
   - Creates `flyway_schema_history` table (if not exists)
   - Runs pending migrations in order
   - Updates schema version
3. **Hibernate Validation**: Validates that database schema matches JPA entities
4. **Application Startup**: Spring Boot application starts successfully

### 3. Expected Logs

Successful startup logs should show:
```
INFO  --- Database: jdbc:postgresql://... (PostgreSQL 16.9)
INFO  --- Successfully validated 1 migration
INFO  --- Current version of schema "public": 1
INFO  --- Schema "public" is up to date. No migration necessary.
INFO  --- Initialized JPA EntityManagerFactory
INFO  --- Tomcat started on port 8080 (http)
INFO  --- Started TaskreminderApplication
```

### 4. Port Configuration

If port 8080 is in use, change the port in `application.properties`:

```properties
server.port=8081
```

## Troubleshooting

### Common Issues and Solutions

#### 1. "Unsupported Database: PostgreSQL 16.9"
**Problem**: Flyway doesn't support PostgreSQL 16.9
**Solution**: Add `flyway-database-postgresql` dependency to `pom.xml`

#### 2. "Port already in use"
**Problem**: Another application is using the same port
**Solution**: 
- Change `server.port` in `application.properties`
- Or kill the process using the port:
  ```bash
  netstat -ano | findstr :8080
  taskkill /PID <PID> /F
  ```

#### 3. "Unrecognized hibernate.hbm2ddl.auto setting"
**Problem**: Inline comments in properties file
**Solution**: Remove comments from property values:
  ```properties
  # Correct
  spring.jpa.hibernate.ddl-auto=validate
  
  # Incorrect
  spring.jpa.hibernate.ddl-auto=validate # Don't auto-create tables
  ```

#### 4. Database Connection Issues
**Problem**: Cannot connect to Neon database
**Solution**:
- Verify connection string format
- Check credentials
- Ensure SSL mode is set to `require`
- Verify network connectivity

## Authentication and Authorization

### Overview
The application uses JSON Web Tokens (JWT) for securing endpoints. The authentication flow includes user registration, login, and password reset functionality.

### Endpoints

#### User Registration
- **Endpoint**: `POST /api/auth/register`
- **Description**: Registers a new user.
- **Request Body**:
  ```json
  {
    "username": "testuser",
    "email": "test@example.com",
    "password": "password123",
    "firstName": "Test",
    "lastName": "User"
  }
  ```
- **Response**: `User registered!`

#### User Login
- **Endpoint**: `POST /api/auth/login`
- **Description**: Authenticates a user and returns a JWT.
- **Request Body**:
  ```json
  {
    "email": "test@example.com",
    "password": "password123"
  }
  ```
- **Response**:
  ```json
  {
    "token": "ey..."
  }
  ```

#### Forgot Password
- **Endpoint**: `POST /api/auth/forgot-password`
- **Description**: Initiates the password reset process and returns a reset token. In a real-world scenario, this token would be sent to the user's email.
- **Request Body**:
  ```json
  {
    "email": "test@example.com"
  }
  ```
- **Response**: `Password reset token: <token>`

#### Reset Password
- **Endpoint**: `POST /api/auth/reset-password`
- **Description**: Resets the user's password using a valid token.
- **Request Body**:
  ```json
  {
    "token": "<reset_token>",
    "newPassword": "newPassword456"
  }
  ```
- **Response**: `Password reset successfully!`

### Security Configuration
Spring Security is configured in `SecurityConfig.java` to protect endpoints. The `/api/auth/**` endpoints are publicly accessible, while all other endpoints require authentication.

### JWT Token Handling
- **`JwtService`**: Handles JWT generation and validation.
- **`JwtAuthFilter`**: A filter that intercepts incoming requests, validates the JWT from the `Authorization` header, and sets the user's authentication context.

## Best Practices

### 1. Migration Best Practices
- Always use versioned migrations for schema changes
- Keep migrations small and focused
- Test migrations on a copy of production data
- Never modify existing migration files (create new ones instead)

### 2. Security Best Practices
- Use environment variables for database credentials
- Enable SSL for database connections
- Regularly rotate database passwords
- Use connection pooling (HikariCP is included by default)

### 3. Development Workflow
1. Create migration file
2. Test locally
3. Commit migration to version control
4. Deploy to staging
5. Deploy to production

## Next Steps

With the database setup complete, you can now:
1. Create JPA entities for your domain models
2. Implement repositories for data access
3. Create REST controllers for API endpoints
4. Add business logic services
5. Implement frontend components

## Useful Commands

```bash
# Run application
./mvnw spring-boot:run

# Clean and compile
./mvnw clean compile

# Run tests
./mvnw test

# Package application
./mvnw package

# Check Flyway status (if Flyway CLI is installed)
flyway info
```
