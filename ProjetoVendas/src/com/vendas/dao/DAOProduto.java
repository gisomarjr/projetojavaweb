package com.vendas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.negocio.ICliente;
import com.vendas.negocio.IProduto;
import com.vendas.basicas.Produto;



public class DAOProduto implements IProduto{

	protected EntityManager entityManager;
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAOProduto() {
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
        	Produto produto = consultarPorId(id);
            excluir(produto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void cadastrar(Produto produto) throws Exception {
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            //ex.printStackTrace();
           // entityManager.getTransaction().rollback();
        }
		
	}

	@Override
	public void editar(Produto produto) {
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(produto);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public void excluir(Produto produto) {
		 try {
	            entityManager.getTransaction().begin();
	            produto = entityManager.find(Produto.class, produto.getId());
	            entityManager.remove(produto);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public Produto consultarPorId(Integer id) {
		  return entityManager.find(Produto.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
	}
}
