/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.BL;

import catalogo.advertencias.Advertencias;
import java.util.List;
import javax.ejb.Stateless;
import mx.edu.tecmm.chapala.sistemas.modelo.Permiso;
import mx.edu.tecmm.chapala.sistemas.DAO.PermisoDAO;

/**
 *
 * @author Araceli Mercado
 */
@Stateless
public class PermisoEJB implements PermisoEJBLocal {

    PermisoDAO permisoDao = new PermisoDAO();
    
    @Override
    public Advertencias agregar(Permiso per) {
        
        
        
        
            System.out.println("Entraste a permiso EJB"+per.getId());
            permisoDao.crear(per); //Enviar peticion al DAO para agregar permiso
            System.out.println("Se agrego en el EJB");
            return Advertencias.NADA;
//
//        if (per != null) {
//            PermisoDAO permisoDao = new PermisoDAO();
//            System.out.println("Entraste a permiso EJB");
//            permisoDao.crear(per); //Enviar peticion al DAO para agregar permiso
//            System.out.println("Se agrego en el EJB");
//            return Advertencias.NADA;
//        } else {
//            return Advertencias.ENTIDAD_VACIA;
//        }
    }

    @Override
    public Advertencias editar(Permiso per) {
        
        permisoDao.editar(per); //Enviar peticion al DAO para modificar permiso
        System.out.println("Se edito en el EJB");
        return Advertencias.NADA;
    }

    @Override
    public Advertencias eliminar(Permiso per) {
        
        permisoDao.elimnar(per); //Enviar peticion al DAO para eliminar permiso
        System.out.println("Se elimino en el EJB");
        return Advertencias.NADA;
    }

    @Override
    public Permiso buscarPermisoPorID(int id) {
        

        return permisoDao.getPorID(id);
    }

    @Override
    public List<Permiso> getTodos() {
        
        System.out.println("se muestran permisos del EJB");
        return permisoDao.getTodo();
    }

    
    
}
