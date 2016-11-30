/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class UsuarioService implements UsuarioServiceLocal {
    
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static int lastId = 1;
    static{
        listaUsuarios.add(new Usuario(1, "ramon","1234",false));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean login(Usuario usuario) {
        return false;
    }

    @Override
    public void addUsuario(Usuario usuario) {
        Iterator<Usuario> it = listaUsuarios.iterator();
        boolean noenc = true;
        while(it.hasNext() && noenc == true){
            if(it.next().getId() == usuario.getId()){
                noenc = false;
            }
        }
        boolean nouser = true;
        while(it.hasNext() && nouser == true){
            if(it.next().getUser().equals(usuario)){
                nouser = false;
            }
        }
        if(noenc && nouser){
            listaUsuarios.add(usuario);
            lastId++;
        }
    }

    @Override
    public void uppdateUsuario(Usuario usuario) {
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        Iterator<Usuario> it = listaUsuarios.iterator();
        Usuario u = it.next();
        while(it.hasNext()){
            if(u.getId() == usuario.getId()){
                return u;
            }
        }
        return null;
    }
    
}
