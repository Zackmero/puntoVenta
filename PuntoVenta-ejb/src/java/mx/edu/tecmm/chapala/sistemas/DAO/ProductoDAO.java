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
import mx.edu.tecmm.chapala.sistemas.modelo.Permiso;
import mx.edu.tecmm.chapala.sistemas.modelo.Producto;

/**
 *
 * @author Araceli Mercado
 */
public class ProductoDAO {
        private EntityManager em;

    public ProductoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Producto producto) {
        //System.out.println("Dis que siiiiiiiiiiiii/////////////////////////////");
        em.getTransaction().begin();        //Iniciar transaccion con la bd
        em.persist(producto);                 //GUARDAR
        em.getTransaction().commit();       //Teminar transaccion con la bd
        System.out.println("aqui si funciona lineas del profe/////////////////////////////");
        return true;
    }

    public boolean editar(Producto producto) {
        if (producto.getId() == null) {
            return false;
        } else {
            em.getTransaction().begin();        //Iniciar transaccion con la bd
            em.merge(producto);                   //modificar BD
            em.getTransaction().commit();      //Teminar transaccion con la bd

            return true;
        }

    }

    public boolean elimnar(Producto producto) {
        em.getTransaction().begin();         //Iniciar transaccion con la bd
        em.remove(em.merge(producto));       //modificar BD
        em.getTransaction().commit();       //Teminar transaccion con la bd

        return true;
    }

    public Producto getPorID(int id) {
        Query q = em.createNamedQuery("Producto.findById");
        q.setParameter("id", id);
        if (q.getResultList() != null) {
            return (Producto) q.getResultList().get(0);
        }
        return null;
    }

    public Producto getPorNombre(String nombre) {
         Query q = em.createNamedQuery("Producto.findByNombreProducto");
        q.setParameter("nombreProducto", nombre);
       
        return null;
    }
    
    

    public List<Producto> getTodo() {
        Query q = em.createNamedQuery("Permiso.findAll");
        return q.getResultList();
    }

}
