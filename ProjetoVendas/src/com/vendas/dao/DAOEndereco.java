package com.vendas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.negocio.ICliente;
import com.vendas.negocio.IEndereco;
import com.vendas.negocio.IFornecedor;

public class DAOEndereco implements IEndereco  {

	protected EntityManager entityManager;
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAOEndereco() {
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
            Endereco endereco = consultarPorId(id);
            excluir(endereco);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
	public void cadastrar(Endereco endereco) throws Exception {
		
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
           
        }
	}

	public void editar(Endereco endereco) {
		 try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(endereco);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	public void excluir(Endereco endereco) {

		 try {
	            entityManager.getTransaction().begin();
	            endereco = entityManager.find(Endereco.class, endereco.getId());
	            entityManager.remove(endereco);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	public Endereco consultarPorId(Integer id) {
		
		return entityManager.find(Endereco.class, id);
		
	}

	@SuppressWarnings("unchecked")
	public List<Endereco> listar() {
		return (ArrayList<Endereco>) entityManager.createQuery("FROM " + Endereco.class.getName()).getResultList();

	}

	
	
	

	
}
