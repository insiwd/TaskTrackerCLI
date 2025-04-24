package org.example.repository;

// esse arquivo vai ser intermédio para o arquivo JSON
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Task;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TaskRepository {

    public boolean jsonExiste() {
        File json = new File("tasks.json");

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
            return true;
        }
        return false;
    }

    public List<Task> listarTarefas() {
        Gson gson = new Gson();
        List<Task> lista = new ArrayList<>();

        try {
            String json = new String(Files.readAllBytes(Paths.get("tasks.json")));
            Type tarefaListType = new TypeToken<List<Task>>() {
            }.getType();
            lista = gson.fromJson(json, tarefaListType);
            if (lista == null)
                lista = new ArrayList<>();

            // atualiza o próximo ID
            int maiorId = 0;
            for (Task tarefa : lista) {
                if (tarefa.getId() > maiorId) {
                    maiorId = tarefa.getId();
                }
            }
            Task.setProximoId(maiorId + 1);
        } catch (IOException e) {
            System.out.println("Json corrompido! Recriando...");
            try {
                new FileWriter("tasks.json").write("[]");
                lista = new ArrayList<>();
            } catch (IOException ex) {
                System.out.println("Erro ao recriar JSON: " + ex);
            }
        }

        return lista;
    }

    public void adicionarTarefas(Task novaTarefa) {
        Gson gson = new Gson();
        jsonExiste();
        List<Task> lista = listarTarefas();
        lista.add(novaTarefa);

        try (FileWriter writer = new FileWriter("tasks.json")) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefa: " + e);
        }
    }
}