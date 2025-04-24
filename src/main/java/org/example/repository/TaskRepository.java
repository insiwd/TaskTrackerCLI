package org.example.repository;

// esse arquivo vai ser intermédio para o arquivo JSON

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.example.model.Task;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskRepository {

    public boolean jsonExiste() {
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
        } else {
            System.out.println("Arquivo já existe");
            return true;
        }
        return true;
    }

    // listando as tasks
    public List<Task> listarTarefas() throws FileNotFoundException, IOException {
        // criando um ObjetcMapper
        ObjectMapper mapper = new ObjectMapper();

        // usando o mapper para ler o conteúdo e transformar em List<Task>
        List<Task> lista = mapper.readValue(new File("tasks.json"),
                mapper.getTypeFactory().constructCollectionLikeType(List.class, Task.class));

        // achando o maior ID existente na lista
        int maiorId = -1;
        for (Task tarefa : lista) {
            if (tarefa.getId() > maiorId) {
                maiorId = tarefa.getId();
            }
        }

        // atualizando o próximo ID
        Task.setProximoId(maiorId + 1);
        return lista;
    }
}
