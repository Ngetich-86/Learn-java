# Task Reminder API Documentation

## Base URL
```
http://localhost:8082/api/tasks
```

## Authentication
Currently, the API doesn't require authentication. All endpoints are publicly accessible.

## Endpoints

### 1. Task Management

#### Create a new task
- **POST** `/api/tasks`
- **Description**: Create a new task
- **Request Body**:
```json
{
  "title": "Complete project documentation",
  "description": "Write comprehensive documentation for the Spring Boot project",
  "dueDate": "2024-01-15T14:30:00",
  "priority": "HIGH",
  "userId": 1,
  "categoryId": 2
}
```
- **Response**: `201 Created` with task details

#### Get all tasks
- **GET** `/api/tasks`
- **Description**: Retrieve all tasks
- **Response**: `200 OK` with list of tasks

#### Get task by ID
- **GET** `/api/tasks/{id}`
- **Description**: Retrieve a specific task by ID
- **Response**: `200 OK` with task details or `404 Not Found`

#### Update task
- **PUT** `/api/tasks/{id}`
- **Description**: Update an existing task
- **Request Body**: Same as create task
- **Response**: `200 OK` with updated task or `404 Not Found`

#### Delete task
- **DELETE** `/api/tasks/{id}`
- **Description**: Delete a task
- **Response**: `204 No Content` or `404 Not Found`

### 2. Task Status Management

#### Mark task as completed
- **PATCH** `/api/tasks/{id}/complete`
- **Description**: Mark a task as completed
- **Response**: `200 OK` with updated task or `404 Not Found`

#### Mark task as incomplete
- **PATCH** `/api/tasks/{id}/incomplete`
- **Description**: Mark a task as incomplete
- **Response**: `200 OK` with updated task or `404 Not Found`

### 3. Task Filtering and Search

#### Get tasks by user
- **GET** `/api/tasks/user/{userId}`
- **Description**: Get all tasks for a specific user
- **Response**: `200 OK` with list of tasks

#### Get tasks by user and completion status
- **GET** `/api/tasks/user/{userId}/status/{completed}`
- **Description**: Get tasks for a user filtered by completion status
- **Parameters**: `completed` (true/false)
- **Response**: `200 OK` with list of tasks

#### Get tasks by priority
- **GET** `/api/tasks/priority/{priority}`
- **Description**: Get all tasks with a specific priority
- **Parameters**: `priority` (LOW, MEDIUM, HIGH, URGENT)
- **Response**: `200 OK` with list of tasks

#### Get tasks by user and priority
- **GET** `/api/tasks/user/{userId}/priority/{priority}`
- **Description**: Get tasks for a user with a specific priority
- **Response**: `200 OK` with list of tasks

#### Search tasks by title
- **GET** `/api/tasks/search?title={searchTerm}`
- **Description**: Search tasks by title (case-insensitive)
- **Parameters**: `title` (search term)
- **Response**: `200 OK` with list of matching tasks

#### Search tasks by title and user
- **GET** `/api/tasks/search/user/{userId}?title={searchTerm}`
- **Description**: Search tasks by title for a specific user
- **Response**: `200 OK` with list of matching tasks

### 4. Task Monitoring

#### Get overdue tasks
- **GET** `/api/tasks/overdue`
- **Description**: Get all overdue tasks (past due date and not completed)
- **Response**: `200 OK` with list of overdue tasks

#### Get overdue tasks by user
- **GET** `/api/tasks/overdue/user/{userId}`
- **Description**: Get overdue tasks for a specific user
- **Response**: `200 OK` with list of overdue tasks

#### Get tasks due soon
- **GET** `/api/tasks/due-soon`
- **Description**: Get tasks due within the next 24 hours
- **Response**: `200 OK` with list of tasks due soon

#### Get tasks due soon by user
- **GET** `/api/tasks/due-soon/user/{userId}`
- **Description**: Get tasks due soon for a specific user
- **Response**: `200 OK` with list of tasks due soon

### 5. Statistics

#### Get task statistics for a user
- **GET** `/api/tasks/statistics/user/{userId}`
- **Description**: Get task statistics for a specific user
- **Response**: `200 OK` with statistics object
```json
{
  "totalTasks": 15,
  "completedTasks": 8,
  "pendingTasks": 7
}
```

#### Get task statistics summary
- **GET** `/api/tasks/statistics/summary`
- **Description**: Get information about available statistics endpoints
- **Response**: `200 OK` with summary information

### 6. Health Check

#### Health check
- **GET** `/api/tasks/health`
- **Description**: Check if the task controller is running
- **Response**: `200 OK` with status message

## Data Models

### TaskRequest
```json
{
  "title": "string (required, 1-255 characters)",
  "description": "string (optional)",
  "dueDate": "datetime (optional)",
  "priority": "enum (LOW, MEDIUM, HIGH, URGENT, default: MEDIUM)",
  "userId": "long (optional)",
  "categoryId": "long (optional)"
}
```

### TaskResponse
```json
{
  "id": "long",
  "title": "string",
  "description": "string",
  "dueDate": "datetime",
  "completed": "boolean",
  "priority": "enum",
  "userId": "long",
  "username": "string",
  "categoryId": "long",
  "categoryName": "string",
  "createdAt": "datetime",
  "updatedAt": "datetime",
  "overdue": "boolean",
  "dueSoon": "boolean"
}
```

### Priority Enum
- `LOW` - Low priority
- `MEDIUM` - Medium priority (default)
- `HIGH` - High priority
- `URGENT` - Urgent priority

## Error Responses

### 400 Bad Request
- Invalid request body
- Missing required fields
- Validation errors

### 404 Not Found
- Task not found
- User not found
- Category not found

### 500 Internal Server Error
- Database connection issues
- Unexpected server errors

## Example Usage

### Create a task
```bash
curl -X POST http://localhost:8082/api/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Learn Spring Boot",
    "description": "Complete the Spring Boot tutorial",
    "dueDate": "2024-01-20T18:00:00",
    "priority": "HIGH",
    "userId": 1
  }'
```

### Get tasks for a user
```bash
curl -X GET http://localhost:8082/api/tasks/user/1
```

### Mark a task as completed
```bash
curl -X PATCH http://localhost:8082/api/tasks/1/complete
```

### Search for tasks
```bash
curl -X GET "http://localhost:8082/api/tasks/search?title=Spring"
```

## Notes

1. All datetime fields use ISO 8601 format (e.g., "2024-01-15T14:30:00")
2. The API supports CORS for cross-origin requests
3. All endpoints return JSON responses
4. Task IDs are automatically generated
5. Created and updated timestamps are automatically managed
6. The `overdue` and `dueSoon` fields are calculated automatically based on the current time 