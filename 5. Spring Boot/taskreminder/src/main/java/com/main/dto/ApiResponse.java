package com.main.dto;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    // Constructors
    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Getters

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    // Setters
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
    // toString method
    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
    // Static factory methods for success and error responses
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null);
    }
    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<>(false, message, data);
    }
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Operation successful", data);
    }
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(true, "Operation successful", null);
    }
    public static <T> ApiResponse<T> error() {
        return new ApiResponse<>(false, "Operation failed", null);
    }
    public static <T> ApiResponse<T> error(String message, Throwable e) {
        return new ApiResponse<>(false, message + ": " + e.getMessage(), null);
    }
    public static <T> ApiResponse<T> error(Throwable e) {
        return new ApiResponse<>(false, "Operation failed: " + e.getMessage(), null);
    }
    public static <T> ApiResponse<T> error(Throwable e, T data) {
        return new ApiResponse<>(false, "Operation failed: " + e.getMessage(), data);
    }
    public static <T> ApiResponse<T> error(String message, Throwable e, T data) {
        return new ApiResponse<>(false, message + ": " + e.getMessage(), data);
    }

}