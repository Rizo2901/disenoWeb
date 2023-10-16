package com.tienda.services;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //Se propone la firma de un metodo para recuperar los regstros de la tabla categoria 
    public List<Categoria> getCategorias(boolean activo);
}
