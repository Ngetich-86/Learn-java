package com.main.controllers;

import com.main.dto.TaskRequest;
import com.main.dto.TaskResponse;
import com.main.models.Priority;
import com.main.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    // Create a new task
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest taskRequest) {
        try {
            TaskResponse createdTask = taskService.createTask(taskRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get all tasks
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        try {
            List<TaskResponse> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get task by ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        try {
            return taskService.getTaskById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get tasks by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskResponse>> getTasksByUser(@PathVariable Long userId) {
        try {
            List<TaskResponse> tasks = taskService.getTasksByUser(userId);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get tasks by user and completion status
    @GetMapping("/user/{userId}/status/{completed}")
    public ResponseEntity<List<TaskResponse>> getTasksByUserAndStatus(
            @PathVariable Long userId, 
            @PathVariable Boolean completed) {
        try {
            List<TaskResponse> tasks = taskService.getTasksByUserAndStatus(userId, completed);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get tasks by priority
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<TaskResponse>> getTasksByPriority(@PathVariable Priority priority) {
        try {
            List<TaskResponse> tasks = taskService.getTasksByPriority(priority);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get tasks by user and priority
    @GetMapping("/user/{userId}/priority/{priority}")
    public ResponseEntity<List<TaskResponse>> getTasksByUserAndPriority(
            @PathVariable Long userId, 
            @PathVariable Priority priority) {
        try {
            List<TaskResponse> tasks = taskService.getTasksByUserAndPriority(userId, priority);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get overdue tasks
    @GetMapping("/overdue")
    public ResponseEntity<List<TaskResponse>> getOverdueTasks() {
        try {
            List<TaskResponse> tasks = taskService.getOverdueTasks();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get overdue tasks by user
    @GetMapping("/overdue/user/{userId}")
    public ResponseEntity<List<TaskResponse>> getOverdueTasksByUser(@PathVariable Long userId) {
        try {
            List<TaskResponse> tasks = taskService.getOverdueTasksByUser(userId);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get tasks due soon (within next 24 hours)
    @GetMapping("/due-soon")
    public ResponseEntity<List<TaskResponse>> getTasksDueSoon() {
        try {
            List<TaskResponse> tasks = taskService.getTasksDueSoon();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get tasks due soon by user
    @GetMapping("/due-soon/user/{userId}")
    public ResponseEntity<List<TaskResponse>> getTasksDueSoonByUser(@PathVariable Long userId) {
        try {
            List<TaskResponse> tasks = taskService.getTasksDueSoonByUser(userId);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Search tasks by title
    @GetMapping("/search")
    public ResponseEntity<List<TaskResponse>> searchTasksByTitle(@RequestParam String title) {
        try {
            List<TaskResponse> tasks = taskService.searchTasksByTitle(title);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Search tasks by title and user
    @GetMapping("/search/user/{userId}")
    public ResponseEntity<List<TaskResponse>> searchTasksByTitleAndUser(
            @PathVariable Long userId, 
            @RequestParam String title) {
        try {
            List<TaskResponse> tasks = taskService.searchTasksByTitleAndUser(title, userId);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Update task
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id, 
            @Valid @RequestBody TaskRequest taskRequest) {
        try {
            return taskService.updateTask(id, taskRequest)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Mark task as completed
    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskResponse> markTaskAsCompleted(@PathVariable Long id) {
        try {
            return taskService.markTaskAsCompleted(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Mark task as incomplete
    @PatchMapping("/{id}/incomplete")
    public ResponseEntity<TaskResponse> markTaskAsIncomplete(@PathVariable Long id) {
        try {
            return taskService.markTaskAsIncomplete(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        try {
            boolean deleted = taskService.deleteTask(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get task statistics for a user
    @GetMapping("/statistics/user/{userId}")
    public ResponseEntity<TaskService.TaskStatistics> getTaskStatistics(@PathVariable Long userId) {
        try {
            TaskService.TaskStatistics statistics = taskService.getTaskStatistics(userId);
            return ResponseEntity.ok(statistics);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get task statistics summary
    @GetMapping("/statistics/summary")
    public ResponseEntity<Map<String, Object>> getTaskStatisticsSummary() {
        try {
            // This could be expanded to include global statistics
            Map<String, Object> summary = Map.of(
                "message", "Task statistics summary endpoint",
                "availableEndpoints", List.of(
                    "/api/tasks/statistics/user/{userId} - Get statistics for specific user"
                )
            );
            return ResponseEntity.ok(summary);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        return ResponseEntity.ok(Map.of("status", "Task Controller is running"));
    }
}
