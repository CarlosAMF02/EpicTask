package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.TaskRepository;
import br.com.fiap.epictaskapi.repository.UserRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        taskRepository.saveAll(List.of(
            new Task("Modelar o BD", "Modelar as tabelas do banco", 10 , 0), 
            new Task("Prototipo", "prototipar as telas", 100 , 0),
            new Task("Tela Inicial", "Fazer o codigo html e css da tela inicial", 15 , 1), 
            new Task("Mapear Endpoints", "Criar tabela com os endpoitns", 5 , 2),
            new Task("Atualizar API", "Atualizar codigos de resposta", 200 , 0), 
            new Task("Criar token", "Criar token para validação do login", 200 , 10),
            new Task("Protitpar telas", "Criar prototipos das telas", 105 , 0), 
            new Task("CP01 Bancp","Realizar checkpoint", 1000 , 0),
            new Task("Atualizar documentação", "Atualizar documentação 3", 20 , 0), 
            new Task("Estudar Android", "Estudar Android", 10 , 80)
        ));

        userRepository.save(new User("Carlos", "rm87204@fiap.com.br", "$2a$12$jkZjDv.BMVzIoR/tw7H/ZueKHvmTaCWKhvJCooVVyg08Y7T4xDVru"));
        
    }
    
}
