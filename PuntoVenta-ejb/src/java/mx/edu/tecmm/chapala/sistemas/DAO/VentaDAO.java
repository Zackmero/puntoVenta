/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.chapala.sistemas.DAO;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.edu.tecmm.chapala.sistemas.modelo.Venta;

/**
 *
 * @author Araceli Mercado
 */
public class VentaDAO {
    private EntityManager em;

    public VentaDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Venta venta) {
       
        em.getTransaction().begin();        //Iniciar transaccion con la bd
        em.persist(venta);                 //GUARDAR
        em.getTransaction().commit();       //Teminar transaccion con la bd
        System.out.println("aqui si funciona lineas del profe/////////////////////////////");
        return true;
    }

    public boolean editar(Venta venta) {
        if (venta.getId() == null) {
            return false;
        } else {
            em.getTransaction().begin();        //Iniciar transaccion con la bd
            em.merge(venta);                   //modificar BD
            em.getTransaction().commit();      //Teminar transaccion con la bd

            return true;
        }

    }

    public boolean elimnar(Venta venta) {
        em.getTransaction().begin();         //Iniciar transaccion con la bd
        em.remove(em.merge(venta));       //modificar BD
        em.getTransaction().commit();       //Teminar transaccion con la bd

        return true;
    }

    public Venta getPorID(int id) {
        Query q = em.createNamedQuery("Venta.findById");
        q.setParameter("id", id);
        if (q.getResultList() != null) {
            return (Venta) q.getResultList().get(0);
        }
        return null;
    }

    public Venta getPorFecha(Date fecha) {
        Query q = em.createNamedQuery("Venta.findByFecha");
        q.setParameter("fecha", fecha);
        return null;
    }

    public List<Venta> getTodo() {
        Query q = em.createNamedQuery("Venta.findAll");
        return q.getResultList();
    }

}
