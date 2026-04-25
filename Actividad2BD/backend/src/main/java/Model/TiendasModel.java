package com.apirest.backend.Model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Tiendas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TiendasModel {
    @Id
    private ObjectId id;
    private String nombre;
    private DireccionTienda direccion; // este atributo representa el documento embebido
    private List<Integer> telefonos = new ArrayList<>();
}