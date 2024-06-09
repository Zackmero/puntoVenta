/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.DAO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.edu.tecmm.chapala.sistemas.modelo.PermisoRol;

public class PermisoRolDAO implements Serializable {

    private EntityManager em;

    public PermisoRolDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta-ejbPU");
        em = emf.createEntityManager();
    }
    
    public boolean crear(PermisoRol permisoRol) {
        em.getTransaction().begin();    //Inicio de transaccion con la base de datos
        em.persist(permisoRol); //Crea permisoRol
        em.getTransaction().commit(); //Termino de transaccion con la base de datos
        return true;
    }

    public boolean editar(PermisoRol permisoRol) {
        if (permisoRol.getId() == null) {
            return false;
        } else {
            em.getTransaction().begin();
            em.merge(permisoRol);//
            em.getTransaction().commit();
            return true;
        }

    }

    public boolean elimnar(PermisoRol permiso) {
        em.getTransaction().begin();
        em.remove(em.merge(permiso));
        em.getTransaction().commit();
        return true;
    }

    public PermisoRol getPorID(int id) {
        Query q = em.createNamedQuery("PermisoRol.findById");
        q.setParameter("id", id);
        if (q.getResultList() != null) {
            return (PermisoRol) q.getResultList().get(0);
        } else {
            return null;
        }

    }


    public List<PermisoRol> getTodo() {
        Query q = em.createNamedQuery("PermisoRol.findAll");
        return q.getResultList();
    }
    

}
