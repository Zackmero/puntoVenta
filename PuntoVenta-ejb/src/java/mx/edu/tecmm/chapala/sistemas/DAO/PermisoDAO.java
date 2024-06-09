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
import mx.edu.tecmm.chapala.sistemas.modelo.Permiso;

/**
 *
 * @author Araceli Mercado
 */
public class PermisoDAO implements Serializable {

    private final EntityManager em;

    public PermisoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Permiso permiso) {
        
        System.out.println("Entraste a permisoDAO "+permiso.getId());
        em.getTransaction().begin();        //Iniciar transaccion con la bd
        em.persist(permiso);                 //GUARDAR
        em.getTransaction().commit();       //Teminar transaccion con la bd
        System.out.println("Se creo en el DAO");
        return true;
    }

    public boolean editar(Permiso permiso) {
        
        if (permiso.getId() == null) {
            System.out.println("neeel funciona ");
            return false;
        } else {
            System.out.println("Se edito en el DAO");
            em.getTransaction().begin();        //Iniciar transaccion con la bd
            em.merge(permiso);                   //modificar BD
            em.getTransaction().commit();      //Teminar transaccion con la bd

            return true;
        }

    }

    public boolean elimnar(Permiso permiso) {
        em.getTransaction().begin();         //Iniciar transaccion con la bd
        em.remove(em.merge(permiso));       //modificar BD
        em.getTransaction().commit();       //Teminar transaccion con la bd
        System.out.println("Se elimino en el DAO");
        return true;
    }

    public Permiso getPorID(int id) {
        Query q = em.createNamedQuery("Permiso.findById");
        q.setParameter("id", id);
        if (q.getResultList() != null) {
            return (Permiso) q.getResultList().get(0);
        }
        return null;
    }

    public Permiso getPorTipoPermiso(String tipoPermiso) {
        return null;
    }

    public List<Permiso> getTodo() {
        Query q = em.createNamedQuery("Permiso.findAll");
        System.out.println("Se muestran todos los permisos en el DAO");
        return q.getResultList();
    }

}
