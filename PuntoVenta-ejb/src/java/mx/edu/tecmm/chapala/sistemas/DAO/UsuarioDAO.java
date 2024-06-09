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
import mx.edu.tecmm.chapala.sistemas.modelo.Usuario;

/**
 *
 * @author Araceli Mercado
 */
public class UsuarioDAO {
    private EntityManager em;

    public UsuarioDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntoVenta-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Usuario usuario) {
        em.getTransaction().begin();        //Iniciar transaccion con la bd
        em.persist(usuario);                 //GUARDAR
        em.getTransaction().commit();       //Teminar transaccion con la bd
        System.out.println("Se creo usuario en el DAO");
        return true;
    }

    public boolean editar(Usuario usuario) {
        if (usuario.getId() == null) {
            return false;
        } else {
            em.getTransaction().begin();        //Iniciar transaccion con la bd
            em.merge(usuario);                   //modificar BD
            em.getTransaction().commit();      //Teminar transaccion con la bd
            System.out.println("Se edito usuario en el DAO");
            return true;
        }

    }

    public boolean elimnar(Usuario usuario) {
        em.getTransaction().begin();         //Iniciar transaccion con la bd
        em.remove(em.merge(usuario));       //modificar BD
        em.getTransaction().commit();       //Teminar transaccion con la bd
        System.out.println("Se elimino usuario en el DAO");
        return true;
    }

    public Usuario getPorID(int id) {
        Query q = em.createNamedQuery("Usuario.findById");
        q.setParameter("id", id);
        if (q.getResultList() != null) {
            return (Usuario) q.getResultList().get(0);
        }
        return null;
    }

    
     public Usuario getPorEdad(String edad) {
        Query q = em.createNamedQuery("Usuario.findByEdad");
        q.setParameter("edad", edad);
        System.out.println("Se busca usuario por el edad en el DAO");
        return null;
    }

     public Usuario getPorDireccion(String direccion) {
        Query q = em.createNamedQuery("Usuario.findByDireccion");
        q.setParameter("direccionn", direccion);
        System.out.println("Se busca usuario por el direccion en el DAO");
        return null;
    }
        
     public Usuario getPorCodigoPostal(String cp) {
        Query q = em.createNamedQuery("Usuario.findByCodigoPostal");
        q.setParameter("codigoPostal", cp);
        System.out.println("Se busca usuario por el CP en el DAO");
        return null;
    }
    
     public Usuario getPorTelefono(String tel) {
        Query q = em.createNamedQuery("Usuario.findByTelefono");
        q.setParameter("telefono", tel);
        System.out.println("Se busca usuario por el Telefono en el DAO");
        return null;
    }
      
    public List<Usuario> getTodo() {
        Query q = em.createNamedQuery("Usuario.findAll");
        System.out.println("Se muestran todos los usuarios en el DAO");
        return q.getResultList();
    }

}
