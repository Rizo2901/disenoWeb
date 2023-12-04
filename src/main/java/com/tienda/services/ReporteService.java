
package com.tienda.services;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ReporteService {
    
    //Este metodo se utiliza para generar los reportes
    //Recibe:
    //1.El nombre del archivo del reporte.
    //2.Los parametros del reporte...si se requieren
    //3.El tipo de reporte (pantalla,pdf,Excel,CSV)
    public ResponseEntity<Resource> generaReporte(
            String reporte,
            Map<String,Object> parametros,
            String tipo
    ) throws IOException;
    
    
}
