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
import mx.edu.tecmm.chapala.sistemas.modelo.VentaProducto;

/**
 *
 * @author Araceli Mercado
 */
public class VentaProductoDAO {
    
    private EntityManager em;

    public VentaProductoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(VentaProducto ventaProducto) {
        
        em.getTransaction().begin();        //Iniciar transaccion con la bd
        em.persist(ventaProducto);                 //GUARDAR
        em.getTransaction().commit();       //Teminar transaccion con la bd
        System.out.println("aqui si funciona lineas del profe/////////////////////////////");
        return true;
    }

    public boolean editar(VentaProducto ventaProducto) {
        if (ventaProducto.getId() == null) {
            return false;
        } else {
            em.getTransaction().begin();        //Iniciar transaccion con la bd
            em.merge(ventaProducto);                   //modificar BD
            em.getTransaction().commit();      //Teminar transaccion con la bd

            return true;
        }

    }

    public boolean elimnar(VentaProducto ventaProducto) {
        em.getTransaction().begin();         //Iniciar transaccion con la bd
        em.remove(em.merge(ventaProducto));       //modificar BD
        em.getTransaction().commit();       //Teminar transaccion con la bd

        return true;
    }

    public VentaProducto getPorID(int id) {
        Query q = em.createNamedQuery("VentaProducto.findById");
        q.setParameter("id", id);
        if (q.getResultList() != null) {
            return (VentaProducto) q.getResultList().get(0);
        }
        return null;
    }

    public VentaProducto getPorCantidadProductos(String cantidad) {
        Query q = em.createNamedQuery("VentaProducto.findById");
        q.setParameter("cantidadProductos", cantidad);
        return null;
    }

    public List<VentaProducto> getTodo() {
        Query q = em.createNamedQuery("VentaProducto.findAll");
        return q.getResultList();
    }


}
