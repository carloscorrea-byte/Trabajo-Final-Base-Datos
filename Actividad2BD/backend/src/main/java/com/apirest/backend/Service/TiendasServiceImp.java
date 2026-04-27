package com.apirest.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.TiendasModel;
import com.apirest.backend.Repository.ITiendasRepository;

import org.bson.types.ObjectId;

import com.apirest.backend.DTO.TiendaDTO;
import com.apirest.backend.Exception.RecursoNoEncontradoException;

@Service
public class TiendasServiceImp implements ITiendasService {
    //inyección de dependencia con el repositorio
    @Autowired ITiendasRepository tiendasRepository;

    @Override
    public String GuardarTienda(TiendasModel tienda) {
        tiendasRepository.save(tienda);
        return "La tienda " + tienda.getNombre() + ", fue creada con éxito";
    }

    @Override
    public List<TiendasModel> ListarTiendas() {
        return tiendasRepository.findAll();
    }

@Override
    public TiendasModel buscarTiendaPorId(ObjectId id) {
        // Este método utiliza una función lambda para buscar una tienda por su ID en el repositorio.
        // Si la tienda existe, retorna el objeto correspondiente. De lo contrario, lanza una excepción
        // personalizada RecursoNoEncontradoException con un mensaje descriptivo.
        return tiendasRepository.findById(id)
        .orElseThrow(() -> new RecursoNoEncontradoException("Error!. No existe una tienda con ID: " + id + " o está mal escrito"));
    }

    @Override
    public TiendasModel actualizarTienda(ObjectId id, TiendasModel tienda) {
        // Usamos el método buscarTiendaPorId para garantizar que la tienda exista en la base de datos
        TiendasModel tiendaExistente = buscarTiendaPorId(id);
        // Actualizar los valores de la tienda si y solo si existente
        tiendaExistente.setNombre(tienda.getNombre());
        tiendaExistente.setDireccion(tienda.getDireccion());
        tiendaExistente.setTelefonos(tienda.getTelefonos());

        // Guardar la tienda actualizada
        return tiendasRepository.save(tiendaExistente);
    }

    @Override
    public String eliminarTienda(ObjectId id) {
        // Usamos el método buscarTiendaPorId para garantizar que la tienda exista en la base de datos
        TiendasModel tiendaExistente = buscarTiendaPorId(id);

        // Eliminar la tienda
        tiendasRepository.delete(tiendaExistente);
        // Retornamos un mensaje de confirmación de la acción realizada
        return "La tienda con ID " + id + " fue eliminada correctamente.";
    }

    @Override
    public List<TiendaDTO> buscarTiendasPorCiudad(String ciudad) {
        return tiendasRepository.buscarTiendasPorCiudad(ciudad);
    }

}