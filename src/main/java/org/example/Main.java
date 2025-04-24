package org.example;

import java.util.Scanner;

import org.example.model.Task;
import org.example.repository.TaskRepository;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o comando (exemplo: 'todo add <descricao>'):");
            String input = sc.nextLine();  

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Saindo...");
                break;
            }

            String[] comandoParts = input.split(" ", 3);  
            if (comandoParts.length < 3) {
                System.out.println("Uso incorreto! O uso correto é: 'todo add <descricao>'");
                continue;  
            }

            String comando = comandoParts[0]; 
            String acao = comandoParts[1];    
            String descricao = comandoParts[2]; 

            if (!comando.equalsIgnoreCase("todo") || !acao.equalsIgnoreCase("add")) {
                System.out.println("Comando inválido! Use 'todo add <descricao>'");
                continue;  
            }

            Task novaTarefa = new Task(descricao);
            
            TaskRepository taskRepository = new TaskRepository();
            taskRepository.adicionarTarefas(novaTarefa);
            System.out.println("Tarefa adicionada com sucesso!");
        }

        sc.close(); 
    }
}
