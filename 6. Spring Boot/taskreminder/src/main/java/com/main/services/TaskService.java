package com.main.services;

import com.main.dto.TaskRequest;
import com.main.dto.TaskResponse;
import com.main.models.Category;
import com.main.models.Priority;
import com.main.models.Task;
import com.main.models.User;
import com.main.repositories.CategoryRepository;
import com.main.repositories.TaskRepository;
import com.main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    // Create a new task
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setPriority(taskRequest.getPriority());
        
        // Set user if provided
        if (taskRequest.getUserId() != null) {
            Optional<User> user = userRepository.findById(taskRequest.getUserId());
            if (user.isPresent()) {
                task.setUser(user.get());
            }
        }
        
        // Set category if provided
        if (taskRequest.getCategoryId() != null) {
            Optional<Category> category = categoryRepository.findById(taskRequest.getCategoryId());
            if (category.isPresent()) {
                task.setCategory(category.get());
            }
        }
        
        Task savedTask = taskRepository.save(task);
        return new TaskResponse(savedTask);
    }
    
    // Get task by ID
    @Cacheable(value = "tasks", key = "#id")
    public Optional<TaskResponse> getTaskById(Long id) {
        System.out.println("Fetching from DB for id: " + id);
        Optional<Task> task = taskRepository.findById(id);
        return task.map(TaskResponse::new);
    }
    
    // Get all tasks
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }
    
    // Get tasks by user
    public List<TaskResponse> getTasksByUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return taskRepository.findByUserOrderByCreatedAtDesc(user.get()).stream()
                    .map(TaskResponse::new)
                    .collect(Collectors.toList());
        }
        return List.of();
    }
    
    // Get tasks by user and completion status
    public List<TaskResponse> getTasksByUserAndStatus(Long userId, Boolean completed) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return taskRepository.findByUserAndCompletedOrderByCreatedAtDesc(user.get(), completed).stream()
                    .map(TaskResponse::new)
                    .collect(Collectors.toList());
        }
        return List.of();
    }
    
    // Get tasks by priority
    public List<TaskResponse> getTasksByPriority(Priority priority) {
        return taskRepository.findByPriorityOrderByCreatedAtDesc(priority).stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }
    
    // Get tasks by user and priority
    public List<TaskResponse> getTasksByUserAndPriority(Long userId, Priority priority) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return taskRepository.findByUserAndPriorityOrderByCreatedAtDesc(user.get(), priority).stream()
                    .map(TaskResponse::new)
                    .collect(Collectors.toList());
        }
        return List.of();
    }
    
    // Get overdue tasks
    public List<TaskResponse> getOverdueTasks() {
        return taskRepository.findOverdueTasks(LocalDateTime.now()).stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }
    
    // Get overdue tasks by user
    public List<TaskResponse> getOverdueTasksByUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return taskRepository.findOverdueTasksByUser(user.get(), LocalDateTime.now()).stream()
                    .map(TaskResponse::new)
                    .collect(Collectors.toList());
        }
        return List.of();
    }
    
    // Get tasks due soon (within next 24 hours)
    public List<TaskResponse> getTasksDueSoon() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
        return taskRepository.findTasksDueSoon(now, tomorrow).stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }
    
    // Get tasks due soon by user
    public List<TaskResponse> getTasksDueSoonByUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime tomorrow = now.plusDays(1);
            return taskRepository.findTasksDueSoonByUser(user.get(), now, tomorrow).stream()
                    .map(TaskResponse::new)
                    .collect(Collectors.toList());
        }
        return List.of();
    }
    
    // Search tasks by title
    public List<TaskResponse> searchTasksByTitle(String title) {
        return taskRepository.findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(title).stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }
    
    // Search tasks by title and user
    public List<TaskResponse> searchTasksByTitleAndUser(String title, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return taskRepository.findByUserAndTitleContainingIgnoreCaseOrderByCreatedAtDesc(user.get(), title).stream()
                    .map(TaskResponse::new)
                    .collect(Collectors.toList());
        }
        return List.of();
    }
    
    // Update task
    public Optional<TaskResponse> updateTask(Long id, TaskRequest taskRequest) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(taskRequest.getTitle());
            task.setDescription(taskRequest.getDescription());
            task.setDueDate(taskRequest.getDueDate());
            task.setPriority(taskRequest.getPriority());
            
            // Update user if provided
            if (taskRequest.getUserId() != null) {
                Optional<User> user = userRepository.findById(taskRequest.getUserId());
                if (user.isPresent()) {
                    task.setUser(user.get());
                }
            }
            
            // Update category if provided
            if (taskRequest.getCategoryId() != null) {
                Optional<Category> category = categoryRepository.findById(taskRequest.getCategoryId());
                if (category.isPresent()) {
                    task.setCategory(category.get());
                }
            }
            
            Task updatedTask = taskRepository.save(task);
            return Optional.of(new TaskResponse(updatedTask));
        }
        return Optional.empty();
    }
    
    // Mark task as completed
    public Optional<TaskResponse> markTaskAsCompleted(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setCompleted(true);
            Task updatedTask = taskRepository.save(existingTask);
            return Optional.of(new TaskResponse(updatedTask));
        }
        return Optional.empty();
    }
    
    // Mark task as incomplete
    public Optional<TaskResponse> markTaskAsIncomplete(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setCompleted(false);
            Task updatedTask = taskRepository.save(existingTask);
            return Optional.of(new TaskResponse(updatedTask));
        }
        return Optional.empty();
    }
    
    // Delete task
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Get task statistics for a user
    public TaskStatistics getTaskStatistics(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            long totalTasks = taskRepository.countByUser(user.get());
            long completedTasks = taskRepository.countByUserAndCompleted(user.get(), true);
            long pendingTasks = taskRepository.countByUserAndCompleted(user.get(), false);
            
            return new TaskStatistics(totalTasks, completedTasks, pendingTasks);
        }
        return new TaskStatistics(0, 0, 0);
    }
    
    // Inner class for task statistics
    public static class TaskStatistics {
        private final long totalTasks;
        private final long completedTasks;
        private final long pendingTasks;
        
        public TaskStatistics(long totalTasks, long completedTasks, long pendingTasks) {
            this.totalTasks = totalTasks;
            this.completedTasks = completedTasks;
            this.pendingTasks = pendingTasks;
        }
        
        public long getTotalTasks() {
            return totalTasks;
        }
        
        public long getCompletedTasks() {
            return completedTasks;
        }
        
        public long getPendingTasks() {
            return pendingTasks;
        }
    }
} 