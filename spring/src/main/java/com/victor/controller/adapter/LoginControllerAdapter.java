package com.victor.controller.adapter;

import com.victor.controller.dto.request.LoginRequest;
import com.victor.controller.dto.response.LoginResponse;
import com.victor.model.Login;

import java.util.UUID;

public class LoginControllerAdapter {

    public static Login paraEntidade(LoginRequest request) {
        String novoId = UUID.randomUUID().toString();
        
        return new Login(
                novoId,
                request.username(),
                request.password(),
                request.roles()
        );
    }

    public static Login paraEntidadeComId(String id, LoginRequest request) {
        return new Login(
                id,
                request.username(),
                request.password(),
                request.roles()
        );
    }

    public static LoginResponse paraResposta(Login login) {
        return new LoginResponse(
                login.id(),
                login.username(),
                login.password(),
                login.roles()
        );
    }
}
