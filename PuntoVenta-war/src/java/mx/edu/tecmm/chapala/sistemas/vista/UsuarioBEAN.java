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
import mx.edu.tecmm.chapala.sistemas.BL.RolEJBLocal;
import mx.edu.tecmm.chapala.sistemas.BL.UsuarioEJBLocal;
import mx.edu.tecmm.chapala.sistemas.modelo.Rol;
import mx.edu.tecmm.chapala.sistemas.modelo.Usuario;

/**
 *
 * @author Araceli Mercado
 */
@Named(value = "usuarioBEAN")
@SessionScoped
public class UsuarioBEAN implements Serializable {

    @EJB
    private UsuarioEJBLocal usuarioEJBLocal;

    @EJB
    private RolEJBLocal rolEJBLocal;

    private int rolSelect;
    private String titulo;
    private Usuario usuario;
    private Rol rol;

    /**
     * Creates a new instance of UsuarioBEAN
     */
    public UsuarioBEAN() {
    }

    public String agregar() {
        System.out.println("entra a agregar");
        System.out.println("se encuentra el id seleccionado: " + rolSelect);
        usuario.setRolId(rolEJBLocal.buscarPorID(rolSelect));
        System.out.println("se encuentra el id seleccionado: " + rolSelect);

        usuarioEJBLocal.agregar(usuario);
        //rolSelect = 0;

        usuario = new Usuario();
        System.out.println("Se agrego usuario en el BEAN");
        return "usuarioLista.xhtml";
    }

    public String editar() {
        usuarioEJBLocal.editar(usuario);
        usuario = new Usuario();
        System.out.println("Se edito usuario en el BEAN");
        return "usuarioLista.xhtml";
    }

    public String eliminar() {
        usuarioEJBLocal.eliminar(usuario);
        usuario = new Usuario();
        System.out.println("Se elimino usuario en el BEAN");
        return "usuarioLista.xhtml";
    }

    public String listaUsuario() {
        return "usuarioLista.xhtml";
    }

    public void prepararNuevoUsuario() {
        titulo = "Agregando un Usuario";
        usuario = new Usuario();

    }

    public void prepararEditarUsuario(Usuario usuario) {
        titulo = "Editando un Usuario";
        usuario = new Usuario();
    }

    public void prepararEliminarUsuario(Usuario usuario) {
        titulo = "Eliminando un Usuario";
        usuario = new Usuario();
    }

    public List<Usuario> getTodos() {
        System.out.println("Se muestran todos los usuario en el BEAN");
        return usuarioEJBLocal.getTodos();
    }

    public List<Rol> getTodosRoles() {
        System.out.println("Se muestran todos los roles de usuario en el BEAN");
        return rolEJBLocal.getTodos();
    }

    // GETTERS & SETTERS
    public Usuario getUsuario() {
        return usuario;
    }

    public int getRolSelect() {
        return rolSelect;
    }

    public void setRolSelect(int rolSelect) {
        this.rolSelect = rolSelect;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

}
