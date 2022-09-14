package br.com.fiap.epictaskapi.controller;

import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.model.UserVM;
import br.com.fiap.epictaskapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping()
    public Page<User> index(@PageableDefault(size = 5) Pageable pageable){
        return service.listAll(pageable);
    }
    @PostMapping()
    public ResponseEntity<User> create(@RequestBody @Valid User user){
        service.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> show(@PathVariable Long id){
        return ResponseEntity.of(service.getById(id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        Optional<User> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
    @PutMapping("{id}")
    public ResponseEntity<User> update (@PathVariable Long id, @RequestBody @Valid UserVM newUser){
        Optional<User> optional = service.getById(id);
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        User user = optional.get();
        user.setId(id);
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());

        service.save(user);

        return ResponseEntity.ok(user);
    }
}
