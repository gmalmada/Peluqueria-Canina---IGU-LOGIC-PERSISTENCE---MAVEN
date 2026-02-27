package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import logica.Duenio; // Asegúrate de que este import coincida con tu paquete

public class DuenioJpaController implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf = null;

    // Este constructor conecta tu programa con el archivo persistence.xml
    public DuenioJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluqueriaPU");
    }

    public DuenioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para CREAR un Duenio en la Base de Datos
    public void create(Duenio duenio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para LEER (traer) todos los Duenios
    public List<Duenio> findDuenioEntities() {
        return findDuenioEntities(true, -1, -1);
    }

    public List<Duenio> findDuenioEntities(int maxResults, int firstResult) {
        return findDuenioEntities(false, maxResults, firstResult);
    }

    private List<Duenio> findDuenioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Duenio.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para LEER un Duenio en específico por su ID
    public Duenio findDuenio(int id) { 
        EntityManager em = getEntityManager();
        try {
            return em.find(Duenio.class, id);
        } finally {
            em.close();
        }
    }

    // Método para EDITAR un Duenio
    public void edit(Duenio duenio) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            duenio = em.merge(duenio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para ELIMINAR un Duenio
    public void destroy(int id) throws Exception { 
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Duenio duenio;
            try {
                duenio = em.getReference(Duenio.class, id);
                // Si tu getter de id en la clase Duenio no se llama getId(), ajusta esta línea
                duenio.getIdDuenio(); 
            } catch (Exception enfe) {
                throw new Exception("El duenio con id " + id + " no existe.", enfe);
            }
            em.remove(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
