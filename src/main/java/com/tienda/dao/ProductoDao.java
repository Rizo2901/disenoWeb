package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDao extends JpaRepository<Producto, Long> {
    
    //Ejemplo de #1 un metodo utilizando metodos Query
    public List<Producto> findByPrecioBetweenOrderByDescripcion 
        (double precioInf, 
         double precioSup
        );
    
        //Ejemplo de #2 un metodo utilizando metodos Query
        @Query(value="SELECT a FROM Producto a where a.precio between :precioInf AND :precioSup ORDER BY a.descripcion ASC")
        public List<Producto> consultaJPQL
        (double precioInf, 
         double precioSup
        );
        
        //Ejemplo de #2 un metodo utilizando metodos Query
        @Query(nativeQuery=true, 
                value="SELECT * FROM producto where producto.precio between :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
        public List<Producto> consultaSQL
        (double precioInf, 
         double precioSup
        );
}
