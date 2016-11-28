/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class ProductoService implements ProductoServiceLocal {
    
    ArrayList<Producto> listaTienda = new ArrayList<>();
    ArrayList<Producto> listaCarrito = new ArrayList<>();

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList listTienda() {
        return listaTienda;
    }

    @Override
    public ArrayList listCarrito() {
        return listaCarrito;
    }

    @Override
    public Producto findProductoById(Producto producto, ArrayList lista) {
        Iterator<Producto> it = lista.iterator();
        while(it.hasNext()){
            Producto p = new Producto();
            if(p.getId() == producto.getId()){
                return p;
            }
        }
        return null;
    }

    @Override
    public void addProducto(Producto producto, ArrayList lista) {
        Producto p = new Producto();
        p = findProductoById(producto, lista);
        if(p == null){
            lista.add(producto);
        }
    }

    @Override
    public void deleteProducto(Producto producto, ArrayList lista) {
        Producto p = new Producto();
        p = findProductoById(producto, lista);
        if(p != null){
            lista.remove(producto);
        }
    }

    @Override
    public void updateProducto(Producto producto, ArrayList lista) {
    }
    
    
    
}
