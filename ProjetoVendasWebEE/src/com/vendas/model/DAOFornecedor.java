package com.vendas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;

import com.vendas.basicas.Clientes;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.interfaces.ICliente;
import com.vendas.interfaces.IFornecedor;

public class DAOFornecedor implements IFornecedor  {

	protected EntityManager entityManager;
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAOFornecedor() {
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
            Fornecedor fornecedor = consultarPorId(id);
            excluir(fornecedor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void cadastrar(Fornecedor fornecedor) throws Exception {
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(fornecedor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
		
	}

	@Override
	public void editar(Fornecedor fornecedor) {
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(fornecedor);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            //ex.printStackTrace();
	            //entityManager.getTransaction().rollback();
	           
	        }
		
	}

	@Override
	public void excluir(Fornecedor fornecedor) {
		 try {
	            entityManager.getTransaction().begin();
	            fornecedor = entityManager.find(Fornecedor.class, fornecedor.getId());
	            entityManager.remove(fornecedor);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public Fornecedor consultarPorId(Integer id) {
		  return entityManager.find(Fornecedor.class, id);
	}
	
	
	public List<Fornecedor> consultarPorCNPJ(String cnpj) {
		return entityManager.createQuery("select f from Fornecedor as f where f.cnpj = ?1").
		setParameter(1, cnpj).getResultList();
	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listar() {
		return entityManager.createQuery("FROM " + Fornecedor.class.getName()).getResultList();
	}
}
