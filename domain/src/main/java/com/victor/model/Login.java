package com.victor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "logins")
public record Login(
        @Id String id,
        String username,
        String password,
        List<String> roles) {
}
