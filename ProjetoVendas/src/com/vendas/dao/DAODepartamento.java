package com.vendas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.vendas.basicas.Departamento;
import com.vendas.negocio.IDepartamento;

public class DAODepartamento implements IDepartamento  {

	protected EntityManager entityManager;
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAODepartamento() {
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
            Departamento departamento = consultarPorId(id);
            excluir(departamento);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void cadastrar(Departamento departamento) throws Exception {
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(departamento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
		
	}

	@Override
	public void editar(Departamento departamento) {
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(departamento);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            //ex.printStackTrace();
	            //entityManager.getTransaction().rollback();
	           
	        }
		
	}

	@Override
	public void excluir(Departamento departamento) {
		 try {
	            entityManager.getTransaction().begin();
	            departamento = entityManager.find(Departamento.class, departamento.getId());
	            entityManager.remove(departamento);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public Departamento consultarPorId(Integer id) {
		  return entityManager.find(Departamento.class, id);
	}
	
	
	/*public List<Departamento> consultarPorCNPJ(String cnpj) {
		return entityManager.createQuery("select f from Departamento as f where f.cnpj = ?1").
		setParameter(1, cnpj).getResultList();
	
	}*/

	@Override
	@SuppressWarnings("unchecked")
	public List<Departamento> listar() {
		return entityManager.createQuery("FROM " + Departamento.class.getName()).getResultList();
	}
}
