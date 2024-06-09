/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.edu.tecmm.chapala.sistemas.modelo.Rol;

/**
 *
 * @author Araceli Mercado
 */
public class RolDAO {

    private EntityManager em;

    //Contructor de la clase
    public RolDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Rol r) {
        em.getTransaction().begin(); //Inicia la transaccion con la BF
        em.persist(r);  //Se crea el rol en la BD
        em.getTransaction().commit();  //Se termina la transaccion en la BD
        return true;  //Valida que se creo el Rol  
    }

    public boolean editar(Rol r) {
        if (r.getId() != null) {
            em.getTransaction().begin(); //Inicia la transaccion con la BD
            em.merge(r); //Modifica en la BD
            em.getTransaction().commit();  //Termina la transaccion con la BD

            return true;    //Valida que se modifico el Rol  
        } else {
            return false;   //Si no se identifico ningun rol, no se puede modificar
        }

    }

    public boolean eliminar(Rol r) {

        em.getTransaction().begin(); //Inicia transaccion con la BD
        em.remove(em.merge(r));   //Remueve el rol de la BD
        em.getTransaction().commit(); //Termina la transaccion con la BD

        return true; //Valida que se elimino el Rol
    }

    public Rol getPorID(int id) {
        Query q = em.createNamedQuery("Rol.findById");
        q.setParameter("id", id);
        if (q.getResultList() != null) {
            return (Rol) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public Rol getPorRol() {
        return null;
    }
    
    public Rol buscarPorID(int id){
        RolDAO rd = new RolDAO();
        return rd.getPorID(id);
    }

    public List<Rol> getTodo() {
        Query q = em.createNamedQuery("Rol.findAll");
        return q.getResultList();
    }

}
