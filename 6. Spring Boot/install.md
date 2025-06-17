# Creating a Spring Boot Project in VS Code
To create a Spring Boot project in Visual Studio Code (VS Code), you need to install the necessary extensions and follow a few steps. Here’s how to get started:
## Prerequisites
- **Java Development Kit (JDK)**: Ensure you have JDK 17 or later installed.
- **Visual Studio Code**: Download and install the latest version of VS Code.
- **Maven or Gradle**: Make sure you have Maven or Gradle installed if you prefer to use them for project management.
## Install Required Extensions
1. **Open VS Code**.
2. **Go to Extensions**: Click on the Extensions icon in the Activity Bar on the side of the window or press `Ctrl+Shift+X`.
3. **Search for Extensions**: Install the following extensions:
- **Spring Boot Extension Pack**: This includes essential tools for Spring Boot development.
- **Java Extension Pack**: Provides Java language support.
- **Lombok Annotations Support for VS Code**: For using Lombok annotations in your project.
4. **Install Extensions**: Click on the Install button for each extension.
## Create a New Spring Boot Project
Once the extensions are installed, you can create a new Spring Boot project using the Spring Initializr
integration in VS Code. Follow these steps:
1. **Open Command Palette**: Press `Ctrl+Shift+P` (Windows/Linux
or `Cmd+Shift+P` on Mac).
2. **Type "Spring Initializr"**: In the Command Palette, type `Spring Initializr` and select `Spring Initializr: Create a Maven Project` (or `Create a Gradle Project` if you prefer Gradle).
3. **Configure Project Settings**:
   - **Spring Boot Version**: Select the latest stable version (e.g., 3.2.x).
   - **Project Language**: Choose Java (or Kotlin/Groovy if needed).
   - **Group ID**: Enter your project’s base package (e.g., `com.example`).
   - **Artifact ID**: Enter your project name (e.g., `demo`).
   - **Packaging Type**: Choose JAR (default for microservices) or WAR (for traditional deployments).
   - **Java Version**: Select your JDK version (e.g., 17 or 21 for Spring Boot 3.x).
4. **Add Dependencies**: Search and select the dependencies you need, such as:
   - **Spring Web** (for REST APIs)
    - **Spring Data JPA** (for database access)
    - **Lombok** (for reducing boilerplate code)
    - **DevTools** (for hot-reload during development)
5. **Generate Project**: Select a folder to save the project. VS Code will generate the project structure and prompt you to trust the authors of the files.
6. **Open the Project**: Click "Yes" to trust the authors and "Open
Project" to load the newly created Spring Boot project in VS Code.
## Run Your Spring Boot Application
1. **Open the Main Class**: Navigate to the main class (e.g., `DemoApplication.java`) in the `src/main/java/com/example/demo` directory.
2. **Run the Application**: Look for the `@SpringBootApplication` annotation and click the Run button above it (or press `F5` to debug). You should see logs indicating that the application has started successfully, such as:
   ```
   Tomcat started on port 8080
   ```  
## Test Your Application
You can create a simple REST controller to test your application. Here’s an example:
```java
import org.springframework.web.bind.annotation.*;   
@RestController
public class DemoController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
```
## Troubleshooting
- **No Run Buttons?**: Ensure the Java extensions are active (check the `@` icon in the sidebar).
- **Dependencies Not Resolving?**: Right-click `pom.xml` → Update Project (Maven) or run `./gradlew build` (Gradle) to refresh dependencies.
## Next Steps
- **Add a Database**: Configure `application.properties` for H2/PostgreSQL.
- **Build APIs**: Use `@RestController` and `@GetMapping` to create RESTful endpoints.
- **Hot Reload**: Enable DevTools (add to `pom.xml` or `build.gradle`) to auto-refresh changes during development.
## Summary
You have successfully created a Spring Boot project in Visual Studio Code. You can now start building your application by adding more controllers, services, and repositories as needed. Happy coding!