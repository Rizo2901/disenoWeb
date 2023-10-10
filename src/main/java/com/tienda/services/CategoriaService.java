package com.tienda.services;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //Se propone a firma de un metodo para recuperar los registros de la tabla categoria
    public List<Categoria> getCategorias (boolean activo);
    
}
