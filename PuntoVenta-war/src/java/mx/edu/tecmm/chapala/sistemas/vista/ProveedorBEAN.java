/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import mx.edu.tecmm.chapala.sistemas.BL.ProveedorEJBLocal;
import mx.edu.tecmm.chapala.sistemas.modelo.Proveedor;

/**
 *
 * @author Araceli Mercado
 */
@Named(value = "proveedorBEAN")
@SessionScoped
public class ProveedorBEAN implements Serializable {


    /**
     * Creates a new instance of ProveedorBEAN
     */
    public ProveedorBEAN() {
    }

    @EJB
    private ProveedorEJBLocal proveedorEJBLocal;
    private String titulo;
    Proveedor proveedor = new Proveedor();
    
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
        System.out.println("El ID en el BEAN es: " + proveedor.getId());
        proveedorEJBLocal.agregar(proveedor);
        proveedor = new Proveedor();
        return "proveedorLista.xhtml";
    }

    public String editar() {
        proveedorEJBLocal.editar(proveedor);
        proveedor = new Proveedor();
        System.out.println("Se edito proveedor en el BEAN");
        return "proveedorLista.xhtml";
    }

    public String eliminar() {
        proveedorEJBLocal.eliminar(proveedor);
        proveedor = new Proveedor();
        System.out.println("Se elimino proveedor en el BEAN");
        return "proveedorLista.xhtml";
    }

    public void prepararEditar(Proveedor p) {
        titulo = "Editando Proveedor";
        System.out.println("El id en preparar editar es: " + p);
        proveedor = p;
    }

    public void prepararEliminar(Proveedor p) {
        titulo = "Eliminando Proveedor";
        System.out.println("El id en preparar eliminar es: " + p);
        proveedor = p;
    }

    public void prepararNuevoProveedor() {
        titulo = "Agregando un Proveedor";
        proveedor = new Proveedor();
    }

    public String listaProveedores() {
       
        return "proveedorLista.xhtml";
    }

    public List<Proveedor> allProveedores() {
        System.out.println("se muestran Proveedores del BEAN");
        return proveedorEJBLocal.getTodos();
    }

//    GETTERS & SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}
