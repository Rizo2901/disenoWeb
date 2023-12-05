
package com.tienda.controller;

import com.tienda.domain.Item;
import com.tienda.domain.Producto;
import com.tienda.service.ItemService;
import com.tienda.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CarritoController {
    
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/")
    private String inicio(Model model) {
        var productos = productoService.getProductos(true);
        model.addAttribute("productos", productos);
        
        return "/index";
    }
    
    @GetMapping("/carrito/agregar/{idProducto}")
    public ModelAndView agreagrItem(Model model, Item item){
        System.out.println("Item" + item);
        Item buscado = itemService.get(item);
        if (buscado == null ) {
            Producto producto = productoService.getProducto(item);
            buscado = new Item(producto);
        }
        itemService.save(buscado);
        var lista = itemService.gets();
        var totalCarrito = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarrito += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarrito);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
        
    }
    
    
}
