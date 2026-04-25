package com.apirest.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionTienda {
    private String ubicacion;
    private String numero;
    private String ciudad;
}
