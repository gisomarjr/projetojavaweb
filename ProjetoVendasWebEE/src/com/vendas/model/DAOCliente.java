package com.vendas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Cliente;
import com.vendas.basicas.Funcionario;
import com.vendas.interfaces.ICliente;



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
	public void editar(Cliente Cliente) {
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(Cliente);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public void excluir(Cliente Cliente) {
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

	@Override
	public Cliente consultarPorId(Integer id) {
		  return entityManager.find(Cliente.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
	}
	
	
	public List<Cliente> realizarLogin(String cpf,String senha) {
		return entityManager.createQuery("select c from Cliente as c where c.cpf = ?1 and c.senha = ?2").
		setParameter(1, cpf).
		setParameter(2, senha).
		getResultList();
	
	}
	
}
