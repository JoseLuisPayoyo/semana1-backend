package com.jose.sistema_productos.controlador;

import com.jose.sistema_productos.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaProductoControlador {

    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productoServicio.listarProductos());
        return "productos"; // Busca productos.html 
    }
}
