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
import mx.edu.tecmm.chapala.sistemas.modelo.Producto;

/**
 *
 * @author Araceli Mercado
 */
@Local
public interface ProductoEJBLocal {
    Advertencias agregar(Producto producto);

    Advertencias editar(Producto producto);

    Advertencias eliminar(Producto producto);

    Producto buscarProductoPorID(int id);

    List<Producto> getTodos();
    
}
