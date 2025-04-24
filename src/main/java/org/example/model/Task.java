package org.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private static int proximoId = 1;
    private int id;
    private String description;
    private TaskStatus status;
    private String createdAt;
    private String updatedAt;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Task() {
    }

    public Task(String description) {
        this.id = proximoId++;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now().format(formatter);
        this.updatedAt = createdAt;
    }

    public LocalDateTime getCreatedAtDateTime() {
        return LocalDateTime.parse(createdAt, formatter);
    }

    public LocalDateTime getUpdatedAtDateTime() {
        return LocalDateTime.parse(updatedAt, formatter);
    }

    // lida com o ID
    public static void setProximoId(int novoValor) {
        proximoId = novoValor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
