package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.services.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }
    
     @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        
        return "/pruebas/listado2";
    }
    
    @PostMapping("/query1")
    public String consulta1(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var productos = productoService.consutaQuery(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precionInf", "precioInf");
        model.addAttribute("precionSup", "precioSup");

        return "/pruebas/listado2";
    }
    
    @PostMapping("/query2")
    public String consulta2(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var productos = productoService.consutaJPQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precionInf", "precioInf");
        model.addAttribute("precionSup", "precioSup");

        return "/pruebas/listado2";
    }
    
    @PostMapping("/query3")
    public String consulta3(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var productos = productoService.consutaSQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precionInf", "precioInf");
        model.addAttribute("precionSup", "precioSup");

        return "/pruebas/listado2";
    }

}
