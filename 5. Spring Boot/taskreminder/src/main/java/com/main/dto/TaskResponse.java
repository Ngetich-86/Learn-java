package com.main.dto;

import com.main.models.Priority;
import com.main.models.Task;
import java.time.LocalDateTime;

public class TaskResponse {
    
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Boolean completed;
    private Priority priority;
    private Long userId;
    private String username;
    private Long categoryId;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean overdue;
    private Boolean dueSoon;
    
    // Constructors
    public TaskResponse() {}
    
    public TaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
        this.completed = task.getCompleted();
        this.priority = task.getPriority();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
        this.overdue = task.isOverdue();
        this.dueSoon = task.isDueSoon();
        
        if (task.getUser() != null) {
            this.userId = task.getUser().getId();
            this.username = task.getUser().getUsername();
        }
        
        if (task.getCategory() != null) {
            this.categoryId = task.getCategory().getId();
            this.categoryName = task.getCategory().getName();
        }
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    
    public Boolean getCompleted() {
        return completed;
    }
    
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    
    public Priority getPriority() {
        return priority;
    }
    
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public Long getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Boolean getOverdue() {
        return overdue;
    }
    
    public void setOverdue(Boolean overdue) {
        this.overdue = overdue;
    }
    
    public Boolean getDueSoon() {
        return dueSoon;
    }
    
    public void setDueSoon(Boolean dueSoon) {
        this.dueSoon = dueSoon;
    }
    
    @Override
    public String toString() {
        return "TaskResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", completed=" + completed +
                ", priority=" + priority +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", overdue=" + overdue +
                ", dueSoon=" + dueSoon +
                '}';
    }
} 