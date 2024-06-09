/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.vista;

import catalogo.advertencias.Advertencias;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import mx.edu.tecmm.chapala.sistemas.BL.PermisoEJBLocal;
import mx.edu.tecmm.chapala.sistemas.modelo.Permiso;

/**
 *
 * @author Araceli Mercado
 */
@Named(value = "permisoBEAN")
@SessionScoped
public class PermisoBEAN implements Serializable {

    @EJB
    private PermisoEJBLocal permisoEJBLocal;

    /**
     * Creates a new instance of PermisoBEAN1
     */
    private String titulo;

    public PermisoBEAN() {
    }

    Permiso permiso = new Permiso();

    public String activar() {
        System.out.println("Se realizo la accion correctamente!!");
        //Permiso p = new Permiso(0, "Agregar", "Permiso");

        Permiso per = new Permiso(0, "Agregar");
        Advertencias adv = permisoEJBLocal.agregar(per);
        return "index.xhtml";
    }

    public String agregar() {
//            System.out.println("entraste a agregar al permiso Bean");
//        if (permiso.getId() == null) {
//            System.out.println("El ID es null"+permiso.getId());
//            permisoEJBLocal.agregar(permiso);
//            System.out.println("Se agrego permiso ID vacio en el BEAN");
//            return "permisoLista.xhtml";
//
//        } else {
//            System.out.println("El ID no es null, si tiene id");
//            permisoEJBLocal.agregar(permiso);
//            permiso = new Permiso();
//            return "permisoLista.xhtml";
//        }
        System.out.println("El ID en el BEAN es: " + permiso.getId());
        permisoEJBLocal.agregar(permiso);
        permiso = new Permiso();
        return "permisoLista.xhtml";
    }

    public String editar() {
        permisoEJBLocal.editar(permiso);
        permiso = new Permiso();
        System.out.println("Se edito permiso en el BEAN");
        return "permisoLista.xhtml";
    }

    public String eliminar() {
        permisoEJBLocal.eliminar(permiso);
        permiso = new Permiso();
        System.out.println("Se elimino permiso en el BEAN");
        return "permisoLista.xhtml";
    }

    public void prepararEditar(Permiso p) {
        titulo = "Editando permiso";
        System.out.println("El id en preparar editar es: " + p);
        permiso = p;
    }

    public void prepararEliminar(Permiso p) {
        titulo = "Eliminando permiso";
        System.out.println("El id en preparar eliminar es: " + p);
        permiso = p;
    }

    public void prepararNuevoPermiso() {
        titulo = "Agregando un permiso";
        permiso = new Permiso();
    }

    public String listaPermisos() {
        return "permisoLista.xhtml";
    }

    public List<Permiso> getAllPermisos() {
        System.out.println("se muestran permisos del BEAN");
        return permisoEJBLocal.getTodos();
    }

    ////GETTER & SETTER
    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public String getTitulo() {
        return titulo;
    }

}
