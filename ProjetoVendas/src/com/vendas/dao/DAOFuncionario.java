package com.vendas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.basicas.Funcionario;
import com.vendas.negocio.IFuncionario;

public class DAOFuncionario implements IFuncionario {

	protected EntityManager entityManager;
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAOFuncionario() {
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
            Funcionario funcionario = consultarPorId(id);
            excluir(funcionario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

		
	@Override
	public void cadastrar(Funcionario funcionario) throws Exception {
		
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	throw new Exception(ex.getMessage());
        }
	}

	@Override
	public void editar(Funcionario funcionario) {
		
		 try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(funcionario);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	          
	        }
	}

	@Override
	public void excluir(Funcionario funcionario) {

		 try {
	            entityManager.getTransaction().begin();
	            funcionario = entityManager.find(Funcionario.class, funcionario.getId());
	            entityManager.remove(funcionario);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
		
	}

	@Override
	public Funcionario consultarPorId(Integer id) {

		return entityManager.find(Funcionario.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
		
		return (ArrayList<Funcionario>) entityManager.createQuery("FROM " + Funcionario.class.getName()).getResultList();
	}
	
	/**
	 * Realizar Login - Funcion�rio
	 * @param usuario
	 * @param senha
	 * @return
	 */
	public List<Funcionario> realizarLogin(String usuario,String senha) {
		return entityManager.createQuery("select f from Funcionario as f where f.usuario = ?1 and f.senha = ?2").
		setParameter(1, usuario).
		setParameter(2, senha).
		getResultList();
	
	}

	public List<Funcionario> consultarPorCPF(String cpf) {
		
		return entityManager.createQuery("select f from Funcionario as f where f.cpf = ?1").
				setParameter(1, cpf).
				getResultList();
	}

}
