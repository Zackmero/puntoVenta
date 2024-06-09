/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.BL;

import catalogo.advertencias.Advertencias;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import mx.edu.tecmm.chapala.sistemas.DAO.UsuarioDAO;
import mx.edu.tecmm.chapala.sistemas.modelo.Producto;
import mx.edu.tecmm.chapala.sistemas.modelo.Usuario;

/**
 *
 * @author Araceli Mercado
 */
@Stateless
public class UsuarioEJB implements UsuarioEJBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public Advertencias agregar(Usuario usuario) {
        UsuarioDAO usuarioDao = new UsuarioDAO();

        if (usuario != null) {
            usuarioDao.crear(usuario); //Enviar peticion al DAO para agregar usuario
            System.out.println("Usuario creado en el EJB");
            return Advertencias.NADA;
        } else {
            return Advertencias.ENTIDAD_VACIA;
        }
    }

    @Override
    public Advertencias editar(Usuario per) {
        UsuarioDAO perDAO = new UsuarioDAO();
        perDAO.editar(per); //Enviar peticion al DAO para modificar usuario
        System.out.println("Usuario modificado en el EJB");
        return Advertencias.NADA;
    }

    @Override
    public Advertencias eliminar(Usuario per) {
        UsuarioDAO perDAO = new UsuarioDAO();
        perDAO.elimnar(per); //Enviar peticion al DAO para eliminar usuario
        System.out.println("Usuario eliminado en el EJB");
        return Advertencias.NADA;
    }

    @Override
    public Usuario buscarUsuarioPorID(int id) {
        UsuarioDAO perDAO = new UsuarioDAO();
        return perDAO.getPorID(id);
    }

    @Override
    public List<Usuario> getTodos() {
        UsuarioDAO p = new UsuarioDAO();
        System.out.println("Se muestran todos los usuarioes en el EJB");
        return p.getTodo();
    }

  
}
