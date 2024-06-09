/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.BL;

import catalogo.advertencias.Advertencias;
import java.util.List;
import javax.ejb.Local;
import mx.edu.tecmm.chapala.sistemas.modelo.Permiso;

/**
 *
 * @author Araceli Mercado
 */
@Local
public interface PermisoEJBLocal {
    

    Advertencias agregar(Permiso p);

    Advertencias editar(Permiso p);

    Advertencias eliminar(Permiso p);

    Permiso buscarPermisoPorID(int id);

    List<Permiso> getTodos();
    
}
