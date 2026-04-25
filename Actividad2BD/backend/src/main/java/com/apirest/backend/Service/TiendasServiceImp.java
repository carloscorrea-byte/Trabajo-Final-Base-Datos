package com.apirest.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.TiendasModel;
import com.apirest.backend.Repository.ITiendasRepository;
@Service
public class TiendasServiceImp implements ITiendasService {
    //inyección de dependecia con el repositorio
    @Autowired ITiendasRepository tiendasRepository;
    @Override
    public String GuardarTienda(TiendasModel tienda) {
        tiendasRepository.save(tienda);
        return "La tienda "+ tienda.getNombre()+", fue creada con éxito";
    }

    @Override
    public List<TiendasModel> ListarTiendas() {
        return tiendasRepository.findAll();
    }
    
}
