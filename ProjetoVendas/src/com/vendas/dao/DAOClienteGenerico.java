package com.vendas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;



public class DAOClienteGenerico {

	protected EntityManager entityManager;
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAOClienteGenerico() {
        entityManager = getEntityManager();
    }
    
 
    /**
     * Verificando se já existe a conexão com o banco
     * @return
     */
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("mysql");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
 
        return entityManager;
    }
 
    /**
     * Recebendo informação do Cliente pelo ID
     * @param id
     * @return
     */
    public Cliente getById(final Long id) {
        return entityManager.find(Cliente.class, id);
    }
    
    /**
     * Listando os Clientes
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Cliente> findAll() {
        return entityManager.createQuery("FROM " + Cliente.class.getName())
                .getResultList();
    }
 
    /**
     * Adicionando um novo Cliente no banco
     * @param Cliente
     */
    public void persist(Cliente Cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(Cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    /**
     * Atualizando o Cliente
     * @param Cliente
     */
    public void merge(Cliente Cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(Cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    /**
     * Removendo o Cliente
     * @param Cliente
     */
    public void remove(Cliente Cliente) {
        try {
            entityManager.getTransaction().begin();
            Cliente = entityManager.find(Cliente.class, Cliente.getId());
            entityManager.remove(Cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    /**
     * Removendo pelo ID
     * @param id
     */
    public void removeById(final Long id) {
        try {
            Cliente Cliente = getById(id);
            remove(Cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
