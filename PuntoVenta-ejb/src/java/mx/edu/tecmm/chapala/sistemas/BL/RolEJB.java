/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.BL;

import catalogo.advertencias.Advertencias;
import java.util.List;
import javax.ejb.Stateless;
import mx.edu.tecmm.chapala.sistemas.DAO.PermisoRolDAO;
import mx.edu.tecmm.chapala.sistemas.DAO.RolDAO;
import mx.edu.tecmm.chapala.sistemas.modelo.PermisoRol;
import mx.edu.tecmm.chapala.sistemas.modelo.Rol;

/**
 *
 * @author Araceli Mercado
 */
@Stateless
public class RolEJB implements RolEJBLocal {

    @Override
    public Advertencias agregar(Rol rol) {
        RolDAO rolDAO = new RolDAO();
        PermisoRolDAO permisoRolDAO = new PermisoRolDAO();
        rolDAO.crear(rol);  //Se crea el rol en la BD
        for(PermisoRol pr : rol.getPermisoRolList()) {
            permisoRolDAO.crear(pr);
        }
        return Advertencias.NADA;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Advertencias modificar(Rol rol) {
        RolDAO rolDAO = new RolDAO();
        rolDAO.editar(rol);
        return Advertencias.NADA;
    }
    
    

    @Override
    public Rol buscarPorID(int id) {
        RolDAO rolDAO = new RolDAO();
        
        return rolDAO.getPorID(id);
    }
    
     @Override
    public List<Rol> getTodos() {
        RolDAO perDAO = new RolDAO();
        return perDAO.getTodo();
    }
    
    
}
