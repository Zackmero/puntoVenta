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
import mx.edu.tecmm.chapala.sistemas.modelo.Proveedor;

/**
 *
 * @author Araceli Mercado
 */
public class ProveedorDAO implements Serializable {

    private EntityManager em;

    public ProveedorDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Proveedor proveedor) {
        System.out.println("El ID proveedor en DAO: "+proveedor.getId());
        em.getTransaction().begin();        //Iniciar transaccion con la bd
        em.persist(proveedor);                 //GUARDAR
        em.getTransaction().commit();       //Teminar transaccion con la bd
        System.out.println("ya se creo tu!!!!!");
        return true;
    }

    public boolean editar(Proveedor proveedor) {
        System.out.println("El id que tratas de editar es: "); 
        if (proveedor.getId() == null) {
            System.out.println("El id: " + proveedor.getId() + " no se pudo editar");
            return false;
        } else {
            System.out.println("ID del provedor que se editara: " + proveedor.getId());
            em.getTransaction().begin();        //Iniciar transaccion con la bd
            em.merge(proveedor);                   //modificar BD
            em.getTransaction().commit();      //Teminar transaccion con la bd

            return true;
        }

    }

    public boolean elimnar(Proveedor proveedor) {
        em.getTransaction().begin();         //Iniciar transaccion con la bd
        em.remove(em.merge(proveedor));       //modificar BD
        em.getTransaction().commit();       //Teminar transaccion con la bd

        return true;
    }

    //buscar por id
    public Proveedor getPorID(int id) {
        Query q = em.createNamedQuery("Proveedor.findById");
        q.setParameter("id", id);
        if (q.getResultList() != null) {
            return (Proveedor) q.getResultList().get(0);
        }
        return null;
    }

    //buscar por nombre
    public Proveedor getPorNombre(String nombre) {
        Query q = em.createNamedQuery("Proveedor.findByNombre");
        q.setParameter("nombre", nombre);
        return null;
    }

    //buscar por marca
    public Proveedor getPorMarca(String marca) {
        Query q = em.createNamedQuery("Proveedor.findByMarca");
        q.setParameter("marca", marca);
        return null;
    }


    //buscar por telefono
    public Proveedor getPorTelefono(String telefono) {
        Query q = em.createNamedQuery("Proveedor.findByCargoContacto");
        q.setParameter("telefono", telefono);
        return null;
    }

    public List<Proveedor> getTodo() {
        Query q = em.createNamedQuery("Proveedor.findAll");
        return q.getResultList();
    }

}
