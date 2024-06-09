/*
 * To change this license header, choose License Headers in Project Proproductoties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.BL;

import catalogo.advertencias.Advertencias;
import java.util.List;
import javax.ejb.Stateless;
import mx.edu.tecmm.chapala.sistemas.DAO.PermisoDAO;
import mx.edu.tecmm.chapala.sistemas.DAO.ProductoDAO;
import mx.edu.tecmm.chapala.sistemas.modelo.Permiso;
import mx.edu.tecmm.chapala.sistemas.modelo.Producto;

/**
 *
 * @author Araceli Mercado
 */
@Stateless
public class ProductoEJB implements ProductoEJBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Advertencias agregar(Producto producto) {
        ProductoDAO productoDao = new ProductoDAO();

        if (producto != null) {
            productoDao.crear(producto); //Enviar peticion al DAO para agregar permiso
            System.out.println("Producto creado con exito!!");
            return Advertencias.NADA;
        } else {
            return Advertencias.ENTIDAD_VACIA;
        }
    }

      @Override
    public Advertencias editar(Producto producto) {
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.editar(producto); //Enviar peticion al DAO para modificar productomiso
        System.out.println("Producto modificado con exito!!");
        return Advertencias.NADA;
    }

    @Override
    public Advertencias eliminar(Producto producto) {
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.elimnar(producto); //Enviar peticion al DAO para eliminar productomiso
        return Advertencias.NADA;
    }

    @Override
    public Producto buscarProductoPorID(int id) {
        ProductoDAO productoDAO = new ProductoDAO();

        return productoDAO.getPorID(id);
    }

    @Override
    public List<Producto> getTodos() {
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.getTodo();
    }

}
