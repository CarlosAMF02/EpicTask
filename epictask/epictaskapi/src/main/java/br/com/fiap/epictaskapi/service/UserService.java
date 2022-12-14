package br.com.fiap.epictaskapi.service;

import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Page<User> listAll(Pageable paginacao){
        return repository.findAll(paginacao);
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
