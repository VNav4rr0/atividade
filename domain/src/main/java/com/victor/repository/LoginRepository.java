package com.victor.repository;

import com.victor.model.Login;
import java.util.Optional;

public interface LoginRepository {
    Login salvar(Login login);
    Optional<Login> buscarPorId(String id);
    void deletar(String id);
}
