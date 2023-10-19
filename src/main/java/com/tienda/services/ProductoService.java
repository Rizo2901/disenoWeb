package com.tienda.services;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    //Se propone la firma de un metodo para recuperar los regstros de la tabla producto 
    public List<Producto> getProductos(boolean activo);
    
    //Se programa el codigo para obtener una Producto
    public Producto getProducto(Producto producto);
    
    //Se actualiza o se crea un registro que tenga el mismo idProducto
    //Si el objeto tiene un valor en idProducto , lo busca....si lo encuentra 
    //lo actualiza si no....lo crea
    public void save(Producto producto);
    
    //Se elimina el registro que tenga el idProducto pasado por parametro
    public void delete(Producto producto);
    
    
    
}
