package com.vendas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vendas.basicas.Entrega;
import com.vendas.basicas.Entrega;
import com.vendas.basicas.Funcionario;
import com.vendas.interfaces.IEntrega;



public class DAOEntrega implements IEntrega{
	
	protected EntityManager entityManager;
	
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAOEntrega() {
        entityManager = getEntityManager();
    }
    /**
     * Verificando se já existe a conexão com o banco
     * @return
     */
    
    private EntityManager getEntityManager() {
    
        	try {
    			Class.forName("com.mysql.jdbc.Driver");
    			
    			 EntityManagerFactory factory = Persistence
    		                .createEntityManagerFactory("mysql");
    		        if (entityManager == null) {
    		            entityManager = factory.createEntityManager();
    		        }
    			
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	
        return entityManager;
    }
 
 
    /**
     * Removendo pelo ID
     * @param id
     */
    
    public void removeById(final Integer id) {
        try {
            Entrega entrega = consultarPorId(id);
            excluir(entrega);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void cadastrar(Entrega entrega) throws Exception {
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(entrega);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
		
	}

	@Override
	public void editar(Entrega entrega) {
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(entrega);
	            entityManager.getTransaction().commit();
	            entityManager.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public void excluir(Entrega entrega) {
		 try {
	            entityManager.getTransaction().begin();
	            entrega = entityManager.find(Entrega.class, entrega.getId());
	            entityManager.remove(entrega);
	            entityManager.getTransaction().commit();
	            entityManager.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public Entrega consultarPorId(Integer id) {
		  return entityManager.find(Entrega.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Entrega> listar() {
		return entityManager.createQuery("FROM " + Entrega.class.getName()).getResultList();
	}
	
	
	
}
