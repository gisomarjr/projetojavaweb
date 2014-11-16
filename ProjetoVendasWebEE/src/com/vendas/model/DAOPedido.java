package com.vendas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.interfaces.ICliente;
import com.vendas.interfaces.IFornecedor;
import com.vendas.interfaces.IPedido;
import com.vendas.basicas.Pedido;

public class DAOPedido implements IPedido  {

	protected EntityManager entityManager;
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAOPedido() {
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
        	Pedido pedido = consultarPorId(id);
            excluir(pedido);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void cadastrar(Pedido pedido) throws Exception {
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(pedido);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            //ex.printStackTrace();
           // entityManager.getTransaction().rollback();
        }
		
	}

	@Override
	public void editar(Pedido pedido) {
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(pedido);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public void excluir(Pedido pedido) {
		 try {
	            entityManager.getTransaction().begin();
	            pedido = entityManager.find(Pedido.class, pedido.getId());
	            entityManager.remove(pedido);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public Pedido consultarPorId(Integer id) {
		  return entityManager.find(Pedido.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Pedido> listar() {
		return entityManager.createQuery("FROM " + Pedido.class.getName()).getResultList();
	}
}
