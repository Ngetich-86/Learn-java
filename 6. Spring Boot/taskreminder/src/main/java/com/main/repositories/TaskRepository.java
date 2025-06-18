package com.main.repositories;

import com.main.models.Priority;
import com.main.models.Task;
import com.main.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Find tasks by user
    List<Task> findByUserOrderByCreatedAtDesc(User user);
    
    // Find tasks by user and completion status
    List<Task> findByUserAndCompletedOrderByCreatedAtDesc(User user, Boolean completed);
    
    // Find tasks by category
    List<Task> findByCategoryOrderByCreatedAtDesc(Task category);
    
    // Find tasks by priority
    List<Task> findByPriorityOrderByCreatedAtDesc(Priority priority);
    
    // Find tasks by user and priority
    List<Task> findByUserAndPriorityOrderByCreatedAtDesc(User user, Priority priority);
    
    // Find overdue tasks
    @Query("SELECT t FROM Task t WHERE t.dueDate < :now AND t.completed = false")
    List<Task> findOverdueTasks(@Param("now") LocalDateTime now);
    
    // Find overdue tasks for a specific user
    @Query("SELECT t FROM Task t WHERE t.user = :user AND t.dueDate < :now AND t.completed = false")
    List<Task> findOverdueTasksByUser(@Param("user") User user, @Param("now") LocalDateTime now);
    
    // Find tasks due soon (within next 24 hours)
    @Query("SELECT t FROM Task t WHERE t.dueDate BETWEEN :now AND :tomorrow AND t.completed = false")
    List<Task> findTasksDueSoon(@Param("now") LocalDateTime now, @Param("tomorrow") LocalDateTime tomorrow);
    
    // Find tasks due soon for a specific user
    @Query("SELECT t FROM Task t WHERE t.user = :user AND t.dueDate BETWEEN :now AND :tomorrow AND t.completed = false")
    List<Task> findTasksDueSoonByUser(@Param("user") User user, @Param("now") LocalDateTime now, @Param("tomorrow") LocalDateTime tomorrow);
    
    // Find tasks by title containing (case-insensitive search)
    List<Task> findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(String title);
    
    // Find tasks by user and title containing
    List<Task> findByUserAndTitleContainingIgnoreCaseOrderByCreatedAtDesc(User user, String title);
    
    // Count tasks by user and completion status
    long countByUserAndCompleted(User user, Boolean completed);
    
    // Count tasks by user
    long countByUser(User user);
    
    // Find tasks by due date range
    @Query("SELECT t FROM Task t WHERE t.dueDate BETWEEN :startDate AND :endDate ORDER BY t.dueDate ASC")
    List<Task> findByDueDateBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    
    // Find tasks by user and due date range
    @Query("SELECT t FROM Task t WHERE t.user = :user AND t.dueDate BETWEEN :startDate AND :endDate ORDER BY t.dueDate ASC")
    List<Task> findByUserAndDueDateBetween(@Param("user") User user, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
} 