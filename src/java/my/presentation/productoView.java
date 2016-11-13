/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProductoFacade;
import entities.Producto;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author felo
 */
@Named(value = "productoView")
@RequestScoped
public class productoView {
    
    @EJB
    private ProductoFacade productoFacade;
    
    private Producto producto;

    /**
     * Creates a new instance of productoView
     */
    public productoView() {
        producto = new Producto();
    }
    
    public Producto getProducto(){
        return producto;
    }
    
    public int getNumeroProductos(){
        return productoFacade.findAll().size();
    }
    
    public String postProducto(){
        productoFacade.create(producto);
        return "productoagregado";
    }
    
    public List<Producto> list(){
        List<Producto> resultado = productoFacade.findAll();
        Collections.reverse(resultado);
        return resultado;
    }
    
}
