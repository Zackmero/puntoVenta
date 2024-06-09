/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.BL;

import catalogo.advertencias.Advertencias;
import java.util.List;
import javax.ejb.Local;
import mx.edu.tecmm.chapala.sistemas.modelo.Proveedor;

/**
 *
 * @author Araceli Mercado
 */
@Local
public interface ProveedorEJBLocal {

    Advertencias agregar(Proveedor proveedor);

    Advertencias editar(Proveedor per);

    Advertencias eliminar(Proveedor per);

    Proveedor buscarProveedorPorID(int id);

    List<Proveedor> getTodos();
}
