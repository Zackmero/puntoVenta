/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.BL;

import catalogo.advertencias.Advertencias;
import java.util.List;
import javax.ejb.Local;
import mx.edu.tecmm.chapala.sistemas.modelo.Usuario;

/**
 *
 * @author Araceli Mercado
 */
@Local
public interface UsuarioEJBLocal {
    
    Advertencias agregar(Usuario usuario);

    Advertencias editar(Usuario usuario);

    Advertencias eliminar(Usuario usuario);

    Usuario buscarUsuarioPorID(int id);

    List<Usuario> getTodos();
    
}
