package org.example.repository;

// esse arquivo vai ser intermédio para o arquivo JSON

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskRepository {

    public void jsonExiste() {
        // criando JSON
        File json = new File("tasks.json");

        // se não existe, cria e escreve "[]" dentro
        if (!json.exists()) {
            try {
                json.createNewFile();
                FileWriter fl = new FileWriter(json);
                fl.write("[]");
                fl.close();
                System.out.println("Json criado com sucesso!");

            } catch (IOException e) {
                System.out.println(e);
            }
        }
        else {
            System.out.println("Arquivo já existe");
        }
    }

    
}
