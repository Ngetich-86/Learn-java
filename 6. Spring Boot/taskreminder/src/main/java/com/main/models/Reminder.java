package com.main.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Reminder entity for scheduling task notifications
 */
@Entity
@Table(name = "reminders")
public class Reminder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Reminder time is required")
    @Column(name = "reminder_time", nullable = false)
    private LocalDateTime reminderTime;
    
    @Column(name = "message")
    private String message;
    
    @Column(name = "sent", nullable = false)
    private Boolean sent = false;
    
    @Column(name = "reminder_type")
    @Enumerated(EnumType.STRING)
    private ReminderType reminderType = ReminderType.EMAIL;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    // Constructors
    public Reminder() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public Reminder(LocalDateTime reminderTime, Task task) {
        this();
        this.reminderTime = reminderTime;
        this.task = task;
    }
    
    public Reminder(LocalDateTime reminderTime, String message, Task task) {
        this(reminderTime, task);
        this.message = message;
    }
    
    // Pre-persist and pre-update methods
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDateTime getReminderTime() {
        return reminderTime;
    }
    
    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Boolean getSent() {
        return sent;
    }
    
    public void setSent(Boolean sent) {
        this.sent = sent;
    }
    
    public ReminderType getReminderType() {
        return reminderType;
    }
    
    public void setReminderType(ReminderType reminderType) {
        this.reminderType = reminderType;
    }
    
    public Task getTask() {
        return task;
    }
    
    public void setTask(Task task) {
        this.task = task;
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
    
    // Business methods
    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(reminderTime) && !sent;
    }
    
    public boolean isDueSoon() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHourFromNow = now.plusHours(1);
        return reminderTime.isAfter(now) && reminderTime.isBefore(oneHourFromNow) && !sent;
    }
    
    public String getDefaultMessage() {
        if (message != null && !message.trim().isEmpty()) {
            return message;
        }
        return "Reminder: " + task.getTitle() + " is due soon!";
    }
    
    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", reminderTime=" + reminderTime +
                ", message='" + message + '\'' +
                ", sent=" + sent +
                ", reminderType=" + reminderType +
                ", task=" + (task != null ? task.getTitle() : "null") +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Reminder reminder = (Reminder) o;
        
        return id != null ? id.equals(reminder.id) : reminder.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
} 