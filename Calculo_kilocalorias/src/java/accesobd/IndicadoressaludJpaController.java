/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesobd;

import accesobd.exceptions.NonexistentEntityException;
import accesobd.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.transaction.UserTransaction;
import modelo.Indicadoressalud;
import modelo.Tipoactividad;
import modelo.Usuario;

/**
 *
 * @author ELI
 */
public class IndicadoressaludJpaController implements Serializable {

    public IndicadoressaludJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Indicadoressalud indicadoressalud) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Tipoactividad tipoactividad = indicadoressalud.getTipoactividad();
            if (tipoactividad != null) {
                tipoactividad = em.getReference(tipoactividad.getClass(), tipoactividad.getIdtac());
                indicadoressalud.setTipoactividad(tipoactividad);
            }
            Usuario usuario = indicadoressalud.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getIdusuario());
                indicadoressalud.setUsuario(usuario);
            }
            em.persist(indicadoressalud);
            if (tipoactividad != null) {
                tipoactividad.getIndicadoressaludList().add(indicadoressalud);
                tipoactividad = em.merge(tipoactividad);
            }
            if (usuario != null) {
                usuario.getIndicadoressaludList().add(indicadoressalud);
                usuario = em.merge(usuario);
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

    public void edit(Indicadoressalud indicadoressalud) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Indicadoressalud persistentIndicadoressalud = em.find(Indicadoressalud.class, indicadoressalud.getIdindsalud());
            Tipoactividad tipoactividadOld = persistentIndicadoressalud.getTipoactividad();
            Tipoactividad tipoactividadNew = indicadoressalud.getTipoactividad();
            Usuario usuarioOld = persistentIndicadoressalud.getUsuario();
            Usuario usuarioNew = indicadoressalud.getUsuario();
            if (tipoactividadNew != null) {
                tipoactividadNew = em.getReference(tipoactividadNew.getClass(), tipoactividadNew.getIdtac());
                indicadoressalud.setTipoactividad(tipoactividadNew);
            }
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getIdusuario());
                indicadoressalud.setUsuario(usuarioNew);
            }
            indicadoressalud = em.merge(indicadoressalud);
            if (tipoactividadOld != null && !tipoactividadOld.equals(tipoactividadNew)) {
                tipoactividadOld.getIndicadoressaludList().remove(indicadoressalud);
                tipoactividadOld = em.merge(tipoactividadOld);
            }
            if (tipoactividadNew != null && !tipoactividadNew.equals(tipoactividadOld)) {
                tipoactividadNew.getIndicadoressaludList().add(indicadoressalud);
                tipoactividadNew = em.merge(tipoactividadNew);
            }
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getIndicadoressaludList().remove(indicadoressalud);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getIndicadoressaludList().add(indicadoressalud);
                usuarioNew = em.merge(usuarioNew);
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
                Integer id = indicadoressalud.getIdindsalud();
                if (findIndicadoressalud(id) == null) {
                    throw new NonexistentEntityException("The indicadoressalud with id " + id + " no longer exists.");
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
            Indicadoressalud indicadoressalud;
            try {
                indicadoressalud = em.getReference(Indicadoressalud.class, id);
                indicadoressalud.getIdindsalud();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The indicadoressalud with id " + id + " no longer exists.", enfe);
            }
            Tipoactividad tipoactividad = indicadoressalud.getTipoactividad();
            if (tipoactividad != null) {
                tipoactividad.getIndicadoressaludList().remove(indicadoressalud);
                tipoactividad = em.merge(tipoactividad);
            }
            Usuario usuario = indicadoressalud.getUsuario();
            if (usuario != null) {
                usuario.getIndicadoressaludList().remove(indicadoressalud);
                usuario = em.merge(usuario);
            }
            em.remove(indicadoressalud);
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

    public List<Indicadoressalud> findIndicadoressaludEntities() {
        return findIndicadoressaludEntities(true, -1, -1);
    }

    public List<Indicadoressalud> findIndicadoressaludEntities(int maxResults, int firstResult) {
        return findIndicadoressaludEntities(false, maxResults, firstResult);
    }

    private List<Indicadoressalud> findIndicadoressaludEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Indicadoressalud as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Indicadoressalud findIndicadoressalud(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Indicadoressalud.class, id);
        } finally {
            em.close();
        }
    }

    public int getIndicadoressaludCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Indicadoressalud as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
