package com.main.models;

/**
 * Enum representing the types of reminders
 */
public enum ReminderType {
    EMAIL("Email"),
    SMS("SMS"),
    PUSH_NOTIFICATION("Push Notification"),
    IN_APP("In-App Notification");
    
    private final String displayName;
    
    ReminderType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
} 