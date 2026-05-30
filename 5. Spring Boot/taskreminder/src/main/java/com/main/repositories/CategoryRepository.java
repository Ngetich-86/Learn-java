package com.main.repositories;

import com.main.models.Category;
import com.main.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    // Find categories by user
    List<Category> findByUserOrderByNameAsc(User user);
    
    // Find categories by user ID
    List<Category> findByUserIdOrderByNameAsc(Long userId);
    
    // Find category by name and user
    List<Category> findByNameAndUser(String name, User user);
    
    // Find category by name (case-insensitive)
    List<Category> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    
    // Find categories by name and user (case-insensitive)
    List<Category> findByNameContainingIgnoreCaseAndUserOrderByNameAsc(String name, User user);
    
    // Count categories by user
    long countByUser(User user);
} 