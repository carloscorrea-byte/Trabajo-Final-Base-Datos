package com.apirest.backend.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.apirest.backend.DTO.TiendaDTO;
import com.apirest.backend.Model.TiendasModel;

public interface ITiendasService {
    //lógica del negocio que se realizará con la clase TiendasModel
    public String GuardarTienda (TiendasModel tienda);
    public List<TiendasModel> ListarTiendas();
    //Otros metodos CRUD, funcionalidades
    public TiendasModel buscarTiendaPorId(ObjectId id);
    public TiendasModel actualizarTienda(ObjectId id, TiendasModel tienda);
    public String eliminarTienda(ObjectId id);
    //agregaciones
    List<TiendaDTO> buscarTiendasPorCiudad(String ciudad);
}