package com.victor.config;

import com.victor.repository.LoginRepository;
import com.victor.repository.adapter.LoginRepositoryImpl;
import com.victor.repository.mongo.LoginRepositoryMongoDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public LoginRepository loginRepository(LoginRepositoryMongoDB repository) {
        return new LoginRepositoryImpl(repository);
    }
}
