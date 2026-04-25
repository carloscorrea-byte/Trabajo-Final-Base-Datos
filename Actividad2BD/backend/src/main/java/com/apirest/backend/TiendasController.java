package com.apirest.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.Model.TiendasModel;
import com.apirest.backend.Service.ITiendasService;

@RestController
@RequestMapping("/UAO/apirest/Tiendas")
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
}