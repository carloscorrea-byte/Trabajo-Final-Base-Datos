package com.apirest.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    private static final String URI = "mongodb+srv://juanmanalvarez_db_user:Admin2008@clustermodulo3.n85igzv.mongodb.net/Modulo3Ejemplo1?retryWrites=true&w=majority&appName=ClusterModulo3";
    private static final String DATABASE = "Modulo3Ejemplo1";

    @Bean
    @Primary
    public MongoClient mongoClient() {
        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(URI))
            .build();
        return MongoClients.create(settings);
    }

    @Bean
    @Primary
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), DATABASE);
    }
}