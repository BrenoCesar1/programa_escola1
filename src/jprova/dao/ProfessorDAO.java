/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jprova.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jprova.dao.exceptions.NonexistentEntityException;
import jprova.dao.exceptions.PreexistingEntityException;
import jprova.model.Professor;

/**
 *
 * @author Administrador
 */
public class ProfessorDAO implements Serializable {
    public EntityManager getEntityManager() {
        return ConexaoJPA.getEntityManager();
    }

    public void create(Professor professor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(professor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProfessor(professor.getId()) != null) {
                throw new PreexistingEntityException("Professor " + professor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Professor professor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            professor = em.merge(professor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = professor.getId();
                if (findProfessor(id) == null) {
                    throw new NonexistentEntityException("The professor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Professor professor;
            try {
                professor = em.getReference(Professor.class, id);
                professor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The professor with id " + id + " no longer exists.", enfe);
            }
            em.remove(professor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Professor> findProfessorEntities() {
        return findProfessorEntities(true, -1, -1);
    }

    public List<Professor> findProfessorEntities(int maxResults, int firstResult) {
        return findProfessorEntities(false, maxResults, firstResult);
    }

    private List<Professor> findProfessorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Professor.class));
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

    public Professor findProfessor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Professor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfessorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Professor> rt = cq.from(Professor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
 public List<Professor> getlistaDeProfessores(String nome,
         String telefone) throws Exception{
       EntityManager em = getEntityManager();
       try {
           String hql = "";
           if (nome != null && !nome.equals("")){
               hql += "WHERE a.nome like upper (:nome)";
           }
           if (telefone != null && !telefone.equals("")){
               if(!hql.equals("")){
                   hql += " AND a.telefone like lower(:telefone)";
               } else{
                   hql += " WHERE a.telefone like lower(:telefone)";
               }
           }
        hql = "SELECT a FROM Professor a " + hql;
        Query q = em.createQuery(hql);
        if(nome != null && !nome.equals("")){
           q.setParameter("nome", "%" +
               nome.toLowerCase() + "%");
        }
        if (telefone != null && !telefone.equals("")){
           q.setParameter("telefone", "%"+
               telefone.toLowerCase() + "%");       
   }
        return q.getResultList();
       } finally {
           em.close();
       }
 }
}

