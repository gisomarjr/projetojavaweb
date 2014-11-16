package com.vendas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Clientes;
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
    	
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("mysql");
        if (entityManager == null) {
        	/*try {
    			Class.forName("com.mysql.jdbc.Driver");
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}*/
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
            Clientes Clientes = consultarPorId(id);
            excluir(Clientes);
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
	public void editar(Clientes clientes) {
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(clientes);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public void excluir(Clientes clientes) {
		 try {
	            entityManager.getTransaction().begin();
	            clientes = entityManager.find(Clientes.class, clientes.getId());
	            entityManager.remove(clientes);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public Clientes consultarPorId(Integer id) {
		  return entityManager.find(Clientes.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Clientes> listar() {
		return entityManager.createQuery("FROM " + Clientes.class.getName()).getResultList();
	}
	
	
	public List<Clientes> realizarLogin(String cpf,String senha) {
		return entityManager.createQuery("select c from Clientes as c where c.cpf = ?1 and c.senha = ?2").
		setParameter(1, cpf).
		setParameter(2, senha).
		getResultList();
	
	}
	
}
