# Setting Up Redis for Spring Boot (Docker CLI & Docker Compose)

This guide will walk you through two ways to set up Redis for your Spring Boot application:
1. Using Docker CLI (manual, quick start)
2. Using Docker Compose (recommended for projects)

---

## Part 1: Quick Start with Docker CLI

### Step 1: Pull the Redis Image
Download the official Redis image from Docker Hub:

```sh
docker pull redis
```

### Step 2: Run Redis in a Container
Start a Redis container with port mapping:

```sh
docker run --name my-redis -p 6379:6379 -d redis
```
- `--name my-redis`: Names your container for easy management
- `-p 6379:6379`: Maps host port 6379 to Redis's default port
- `-d`: Runs in detached (background) mode

To persist data between restarts, add a volume:
```sh
docker run --name my-redis -p 6379:6379 -v redis_data:/data -d redis
```

### Step 3: Verify Redis is Running
Check the container status:
```sh
docker ps
```
Test Redis:
```sh
docker exec -it my-redis redis-cli ping
```
You should see:
```
PONG
```

---

## Part 2: Using Docker Compose (Recommended)

### Step 1: Create a Docker Compose File
Create a file named `docker-compose.yml` in your project root:

```yaml
services:
  redis:
    image: redis:latest
    container_name: my-redis
    ports:
      - "6379:6379"
    volumes:
      - redis_data:/data
    restart: unless-stopped

volumes:
  redis_data:
```

### Step 2: Start Redis with Docker Compose
In your project directory, run:
```sh
docker-compose up -d
```

### Step 3: Verify Redis is Running
Check:
```sh
docker ps
```
Test:
```sh
docker exec -it my-redis redis-cli ping
```
You should see:
```
PONG
```

---

## Step 3: Configure Spring Boot to Use Redis

In your `src/main/resources/application.properties` file, add:
```properties
# Redis Configuration
spring.data.redis.host=localhost
spring.data.redis.port=6379
spring.cache.type=redis
```
If your Spring Boot app is also running in Docker, use:
```properties
spring.data.redis.host=host.docker.internal
```

---

## Common Docker Commands
- **Stop Redis:**
  ```sh
  docker-compose stop
  ```
- **Start Redis:**
  ```sh
  docker-compose start
  ```
- **Remove Redis container and volume:**
  ```sh
  docker-compose down -v
  ```

---

## Troubleshooting
- **Port Conflict:**
  If port 6379 is in use, change the port mapping in `docker-compose.yml` (e.g., `6380:6379`).
- **Connection Refused:**
  Ensure the container is running (`docker ps`) and check logs:
  ```sh
  docker logs my-redis
  ```

---

Your Redis cache is now ready for use with Spring Boot! 🎯