/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import mx.edu.tecmm.chapala.sistemas.BL.PermisoEJBLocal;
import mx.edu.tecmm.chapala.sistemas.BL.RolEJBLocal;
import mx.edu.tecmm.chapala.sistemas.modelo.Permiso;
import mx.edu.tecmm.chapala.sistemas.modelo.PermisoRol;
import mx.edu.tecmm.chapala.sistemas.modelo.Rol;


/**
 *
 * @author Araceli Mercado
 */
@Named(value = "rolBEAN")
@SessionScoped
public class RolBEAN implements Serializable {

    @EJB
    private PermisoEJBLocal permisoEJB;

    @EJB
    private RolEJBLocal rolEJB;

    Rol rol = new Rol();

    private int rolID;

    private Permiso permiso;
    private String titulo;
    private List<PermisoRol> listaPermisoRol;

    /**
     * Creates a new instance of RolBEAN
     */
    public RolBEAN() {
    }

    public String activar() {
        Rol r = new Rol(0, "RolPrueba");

        listaPermisoRol = new ArrayList<>();

        PermisoRol pr = new PermisoRol();

        pr.setRolId(r); //Este no se encuentra en la BD
        pr.setPermisoId(permisoEJB.buscarPermisoPorID(2));  //Permiso existente en la BD
        listaPermisoRol.add(pr);

        PermisoRol pr2 = new PermisoRol();

        pr2.setRolId(r); //Este no se encuentra en la BD
        pr2.setPermisoId(permisoEJB.buscarPermisoPorID(1));  //Permiso existente en la BD
        listaPermisoRol.add(pr2);

        r.setPermisoRolList(listaPermisoRol);

        rolEJB.agregar(r);

        return "index.xhtml";
    }

    public String agregar() {
        PermisoRol pr = new PermisoRol();
        listaPermisoRol = new ArrayList<>();
        pr.setRolId(rolEJB.buscarPorID(rolID));

        return "rolLista.xhtml";
    }

    public void prepararEditarRol(Rol r){
        titulo="Editando un Rol";
        rol = r;
    }
    
    public String editar() {
        Rol r = rolEJB.buscarPorID(1);
        r.setRol("Rol modificado");

//      Producto p = ProductoEJB.buscarPorID(Advertencia);
//if (p!=null) {
//            DetalleVenta dv=new DetalleVenta();
//              dv.setAdvertencia(p.getAdvertencia());
//                dv.setNombre(p.getNombre());
//        }
        rolEJB.modificar(r);
        return "index.xhtml";
    }

    public void prepararEliminarRol(Rol r){
        titulo="Eliminando un Rol";
        rol=r;
    }
    public String eliminarRol(){
        
        return "rolLista.xhtml";
    }
    
    public void prepararNuevoRol() {
        titulo = "Creando nuevo Rol";
        rol = new Rol();
    }

    public String rolLista() {
        return "rolLista.xhtml";
    }
    
    
    
    

//    GETTER & SETTER
    public List<Rol> getTodosRoles() {
        return rolEJB.getTodos();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getRolID() {
        return rolID;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<PermisoRol> getListaPermisoRol() {
        return listaPermisoRol;
    }

}
