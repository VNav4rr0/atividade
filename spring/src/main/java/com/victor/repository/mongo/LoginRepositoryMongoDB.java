package com.victor.repository.mongo;

import com.victor.model.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepositoryMongoDB extends MongoRepository<Login, String> {
}
