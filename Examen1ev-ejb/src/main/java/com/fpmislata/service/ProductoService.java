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
    
    private static ArrayList<Producto> listaTienda = new ArrayList<>();
    private static ArrayList<Producto> listaCarrito = new ArrayList<>();
    static{
        listaTienda.add(new Producto(1,"images/01figuritas-pop.jpg","Figuras Pop! Capitán América: Civil War Figuras vinilo Funko, juego de 5",70.00, 0));
        listaTienda.add(new Producto(2,"images/02pantalon.jpg","Pantalón pijama Vengadores para hombre",19.19, 0));
        listaTienda.add(new Producto(3,"images/03agenteCarter.jpg","Figura Agente Carter serie Legends de Capitán América: Civil War (16 cm)",26.90, 0));
        listaTienda.add(new Producto(4,"images/04capuchones.jpg","Juego 3 capuchones de felpa para lápiz MXYZ Marvel",7.99, 0));
        listaTienda.add(new Producto(5,"images/05llavero.jpg","Llavero peluche MXYZ Marvel",7.99, 0));
        listaTienda.add(new Producto(6,"images/06megaseFiguritas.jpg","Megaset juego figuritas Los Vengadores Marvel",40.00, 0));
        listaTienda.add(new Producto(7,"images/07zapatillas.jpg","Zapatillas infantiles Spider-Man",11.99, 0));
        listaTienda.add(new Producto(8,"images/08arco.jpg","Set arco y flechas Ojo de Halcón",26.93, 0));
    }

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
    public Producto findProductoTienda(Producto producto) {
        Iterator<Producto> it = listaTienda.iterator();
        Producto p = it.next();
        while(it.hasNext()){
            if(p.getId()==producto.getId()){
                return p;
            }
        }
        return null;
    }

    @Override
    public void addProductoCarrito(Producto producto) {
        int i = 0;
        boolean enc = false;
        while(i<listaCarrito.size() && enc==false){
            if(listaCarrito.get(i).getId() == producto.getId()){
                enc = true;
            }else{
                i++;
            }
        }
        if(enc){
            int udsProducto = producto.getUnidades();
            int udsCarrito = listaCarrito.get(i).getUnidades();
            listaCarrito.get(i).setUnidades(udsProducto+udsCarrito);
        }else{
            listaCarrito.add(producto);
        }
    }

    @Override
    public void deleteProductoCarrito(Producto producto) {
        int i=0;
        boolean enc = false;
        while(i<listaCarrito.size() && enc==false){
            if(listaCarrito.get(i).getId() == producto.getId()){
                enc = true;
            }else{
                i++;
            }
        }
        if(enc){
            listaCarrito.remove(i);
        }
    }
    
    
    
}
