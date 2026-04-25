package com.apirest.backend.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apirest.backend.Model.TiendasModel;

public interface ITiendasRepository extends MongoRepository<TiendasModel, ObjectId> {
    //Aquí se implementarán las agregaciones
}
