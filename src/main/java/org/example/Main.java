package org.example;

import org.example.repository.TaskRepository;

public class Main {
    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();
        taskRepository.jsonExiste();
        
    }
}