package com.apirest.backend.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apirest.backend.DTO.TiendaDTO;
import com.apirest.backend.Model.TiendasModel;

public interface ITiendasRepository extends MongoRepository<TiendasModel, ObjectId> {
    //Aquí se implementarán las agregaciones
    @Aggregation(pipeline = {
        "{ $match: { 'direccion.ciudad': ?0 } }",
        "{ $project: { _id: 0, nombre: 1, " +
            "\"direccionCompleta\": { " +
                "\"$concat\": [ '$direccion.ubicacion', ' ', '$direccion.numero' ] " +
            "}" +
        "} }"
    })
    List<TiendaDTO> buscarTiendasPorCiudad(String ciudad);
}