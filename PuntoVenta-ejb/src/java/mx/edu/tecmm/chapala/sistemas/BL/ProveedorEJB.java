/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.BL;

import catalogo.advertencias.Advertencias;
import java.util.List;
import javax.ejb.Stateless;
import mx.edu.tecmm.chapala.sistemas.DAO.ProveedorDAO;
import mx.edu.tecmm.chapala.sistemas.modelo.Proveedor;

/**
 *
 * @author Araceli Mercado
 */
@Stateless
public class ProveedorEJB implements ProveedorEJBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public Advertencias agregar(Proveedor proveedor) {
        ProveedorDAO proveedorDao = new ProveedorDAO();

        if (proveedor != null) {
            System.out.println("El ID proveedor en EJB: " + proveedor.getId());
            proveedorDao.crear(proveedor); //Enviar peticion al DAO para agregar proveedor
            System.out.println("Proveedor creado con exito!!");
            return Advertencias.NADA;
        } else {
            System.out.println("no se creo, ta vacio");
            return Advertencias.ENTIDAD_VACIA;
        }
    }

    @Override
    public Advertencias editar(Proveedor per) {
        ProveedorDAO perDAO = new ProveedorDAO();
        perDAO.editar(per); //Enviar peticion al DAO para modificar proveedor
        System.out.println("Proveedor modificado con exito en DAO!!");
        return Advertencias.NADA;
    }

    @Override
    public Advertencias eliminar(Proveedor per) {
        ProveedorDAO perDAO = new ProveedorDAO();
        perDAO.elimnar(per); //Enviar peticion al DAO para eliminar proveedor
        return Advertencias.NADA;
    }

    @Override
    public Proveedor buscarProveedorPorID(int id) {
        ProveedorDAO perDAO = new ProveedorDAO();
        return perDAO.getPorID(id);
    }

    @Override
    public List<Proveedor> getTodos() {
        ProveedorDAO p = new ProveedorDAO();
        return p.getTodo();
    }

}
