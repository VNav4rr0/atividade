package com.victor.repository.adapter;

import com.victor.model.Login;
import com.victor.repository.LoginRepository;
import com.victor.repository.mongo.LoginRepositoryMongoDB;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginRepositoryImpl implements LoginRepository {

    private final LoginRepositoryMongoDB repository;

    public LoginRepositoryImpl(LoginRepositoryMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public Login salvar(Login login) {
        return repository.save(login);
    }

    @Override
    public Optional<Login> buscarPorId(String id) {
        return repository.findById(id);
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }
}
