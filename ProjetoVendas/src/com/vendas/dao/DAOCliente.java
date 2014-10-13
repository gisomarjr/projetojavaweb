package com.vendas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.negocio.ICliente;



public class DAOCliente implements ICliente{

	protected EntityManager entityManager;
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAOCliente() {
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
     * Removendo pelo ID
     * @param id
     */
    
    public void removeById(final Integer id) {
        try {
            Cliente Cliente = consultarPorId(id);
            excluir(Cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void cadastrar(Cliente cliente) throws Exception {
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
		
	}

	@Override
	public void editar(Cliente cliente) {
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(cliente);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public void excluir(Cliente cliente) {
		 try {
	            entityManager.getTransaction().begin();
	            cliente = entityManager.find(Cliente.class, cliente.getId());
	            entityManager.remove(cliente);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public Cliente consultarPorId(Integer id) {
		  return entityManager.find(Cliente.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
	}
}
