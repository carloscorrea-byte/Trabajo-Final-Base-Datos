package com.apirest.backend.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.DTO.TiendaDTO;
import com.apirest.backend.Model.TiendasModel;
import com.apirest.backend.Service.ITiendasService;

@RestController
@RequestMapping ("/UAO/apirest/Tiendas")
public class TiendasController {
    @Autowired ITiendasService tiendasService;

    @PostMapping("/insertar")
    public ResponseEntity<String> crearTienda(@RequestBody TiendasModel tienda){
        return new ResponseEntity<String>(tiendasService.GuardarTienda(tienda), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TiendasModel>> listarTiendas(){
        return new ResponseEntity<List<TiendasModel>>(tiendasService.ListarTiendas(), HttpStatus.OK);
    }

    @GetMapping("/TiendaPorId/{id}")
    public ResponseEntity<TiendasModel> buscarTiendaPorId(@PathVariable ObjectId id){
        return new ResponseEntity<TiendasModel>(tiendasService.buscarTiendaPorId(id), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TiendasModel> actualizarTienda(@PathVariable ObjectId id, @RequestBody TiendasModel tienda) {
        return new ResponseEntity<TiendasModel>(tiendasService.actualizarTienda(id, tienda), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTienda(@PathVariable ObjectId id) {
        return new ResponseEntity<String>(tiendasService.eliminarTienda(id), HttpStatus.OK);
    }

    @GetMapping("/tiendas/ciudad/{ciudad}")
    public ResponseEntity<List<TiendaDTO>> ListarTiendasPorCiudad(@PathVariable String ciudad){
        return new ResponseEntity<List<TiendaDTO>>(tiendasService.buscarTiendasPorCiudad(ciudad), HttpStatus.OK);
    }
}