package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.TiendasModel;

public interface ITiendasService { 
    //lógica del negocio que se realizará con la clase TiendasModel
    public String GuardarTienda (TiendasModel tienda);
    public List<TiendasModel> ListarTiendas();
    //Otros métodos CRUD, funcionalidades y agregaciones
}