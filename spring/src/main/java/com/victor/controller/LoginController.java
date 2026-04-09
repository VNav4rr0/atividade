package com.victor.controller;

import com.victor.controller.adapter.LoginControllerAdapter;
import com.victor.controller.dto.request.LoginRequest;
import com.victor.controller.dto.response.LoginResponse;
import com.victor.model.Login;
import com.victor.repository.LoginRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/logins")
public class LoginController {

    private final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @PostMapping
    public LoginResponse salvar(@RequestBody LoginRequest request) {
        Login login = LoginControllerAdapter.paraEntidade(request);
        Login loginSalvo = loginRepository.salvar(login);
        return LoginControllerAdapter.paraResposta(loginSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoginResponse> atualizar(@PathVariable String id, @RequestBody LoginRequest request) {
        Optional<Login> loginExistente = loginRepository.buscarPorId(id);
        
        if (loginExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Login loginParaAtualizar = LoginControllerAdapter.paraEntidadeComId(id, request);
        Login loginAtualizado = loginRepository.salvar(loginParaAtualizar);

        return ResponseEntity.ok(LoginControllerAdapter.paraResposta(loginAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        Optional<Login> loginExistente = loginRepository.buscarPorId(id);

        if (loginExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        loginRepository.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public String login() {
        return "Realizar Login - API do Victor";
    }
}
