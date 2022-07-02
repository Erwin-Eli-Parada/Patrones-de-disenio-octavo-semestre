/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesobd;

import accesobd.exceptions.NonexistentEntityException;
import accesobd.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import modelo.Indicadoressalud;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import modelo.Tipoactividad;

/**
 *
 * @author ELI
 */
public class TipoactividadJpaController implements Serializable {

    public TipoactividadJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoactividad tipoactividad) throws RollbackFailureException, Exception {
        if (tipoactividad.getIndicadoressaludList() == null) {
            tipoactividad.setIndicadoressaludList(new ArrayList<Indicadoressalud>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Indicadoressalud> attachedIndicadoressaludList = new ArrayList<Indicadoressalud>();
            for (Indicadoressalud indicadoressaludListIndicadoressaludToAttach : tipoactividad.getIndicadoressaludList()) {
                indicadoressaludListIndicadoressaludToAttach = em.getReference(indicadoressaludListIndicadoressaludToAttach.getClass(), indicadoressaludListIndicadoressaludToAttach.getIdindsalud());
                attachedIndicadoressaludList.add(indicadoressaludListIndicadoressaludToAttach);
            }
            tipoactividad.setIndicadoressaludList(attachedIndicadoressaludList);
            em.persist(tipoactividad);
            for (Indicadoressalud indicadoressaludListIndicadoressalud : tipoactividad.getIndicadoressaludList()) {
                Tipoactividad oldTipoactividadOfIndicadoressaludListIndicadoressalud = indicadoressaludListIndicadoressalud.getTipoactividad();
                indicadoressaludListIndicadoressalud.setTipoactividad(tipoactividad);
                indicadoressaludListIndicadoressalud = em.merge(indicadoressaludListIndicadoressalud);
                if (oldTipoactividadOfIndicadoressaludListIndicadoressalud != null) {
                    oldTipoactividadOfIndicadoressaludListIndicadoressalud.getIndicadoressaludList().remove(indicadoressaludListIndicadoressalud);
                    oldTipoactividadOfIndicadoressaludListIndicadoressalud = em.merge(oldTipoactividadOfIndicadoressaludListIndicadoressalud);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoactividad tipoactividad) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Tipoactividad persistentTipoactividad = em.find(Tipoactividad.class, tipoactividad.getIdtac());
            List<Indicadoressalud> indicadoressaludListOld = persistentTipoactividad.getIndicadoressaludList();
            List<Indicadoressalud> indicadoressaludListNew = tipoactividad.getIndicadoressaludList();
            List<Indicadoressalud> attachedIndicadoressaludListNew = new ArrayList<Indicadoressalud>();
            for (Indicadoressalud indicadoressaludListNewIndicadoressaludToAttach : indicadoressaludListNew) {
                indicadoressaludListNewIndicadoressaludToAttach = em.getReference(indicadoressaludListNewIndicadoressaludToAttach.getClass(), indicadoressaludListNewIndicadoressaludToAttach.getIdindsalud());
                attachedIndicadoressaludListNew.add(indicadoressaludListNewIndicadoressaludToAttach);
            }
            indicadoressaludListNew = attachedIndicadoressaludListNew;
            tipoactividad.setIndicadoressaludList(indicadoressaludListNew);
            tipoactividad = em.merge(tipoactividad);
            for (Indicadoressalud indicadoressaludListOldIndicadoressalud : indicadoressaludListOld) {
                if (!indicadoressaludListNew.contains(indicadoressaludListOldIndicadoressalud)) {
                    indicadoressaludListOldIndicadoressalud.setTipoactividad(null);
                    indicadoressaludListOldIndicadoressalud = em.merge(indicadoressaludListOldIndicadoressalud);
                }
            }
            for (Indicadoressalud indicadoressaludListNewIndicadoressalud : indicadoressaludListNew) {
                if (!indicadoressaludListOld.contains(indicadoressaludListNewIndicadoressalud)) {
                    Tipoactividad oldTipoactividadOfIndicadoressaludListNewIndicadoressalud = indicadoressaludListNewIndicadoressalud.getTipoactividad();
                    indicadoressaludListNewIndicadoressalud.setTipoactividad(tipoactividad);
                    indicadoressaludListNewIndicadoressalud = em.merge(indicadoressaludListNewIndicadoressalud);
                    if (oldTipoactividadOfIndicadoressaludListNewIndicadoressalud != null && !oldTipoactividadOfIndicadoressaludListNewIndicadoressalud.equals(tipoactividad)) {
                        oldTipoactividadOfIndicadoressaludListNewIndicadoressalud.getIndicadoressaludList().remove(indicadoressaludListNewIndicadoressalud);
                        oldTipoactividadOfIndicadoressaludListNewIndicadoressalud = em.merge(oldTipoactividadOfIndicadoressaludListNewIndicadoressalud);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoactividad.getIdtac();
                if (findTipoactividad(id) == null) {
                    throw new NonexistentEntityException("The tipoactividad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Tipoactividad tipoactividad;
            try {
                tipoactividad = em.getReference(Tipoactividad.class, id);
                tipoactividad.getIdtac();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoactividad with id " + id + " no longer exists.", enfe);
            }
            List<Indicadoressalud> indicadoressaludList = tipoactividad.getIndicadoressaludList();
            for (Indicadoressalud indicadoressaludListIndicadoressalud : indicadoressaludList) {
                indicadoressaludListIndicadoressalud.setTipoactividad(null);
                indicadoressaludListIndicadoressalud = em.merge(indicadoressaludListIndicadoressalud);
            }
            em.remove(tipoactividad);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoactividad> findTipoactividadEntities() {
        return findTipoactividadEntities(true, -1, -1);
    }

    public List<Tipoactividad> findTipoactividadEntities(int maxResults, int firstResult) {
        return findTipoactividadEntities(false, maxResults, firstResult);
    }

    private List<Tipoactividad> findTipoactividadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Tipoactividad as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tipoactividad findTipoactividad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoactividad.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoactividadCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Tipoactividad as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
