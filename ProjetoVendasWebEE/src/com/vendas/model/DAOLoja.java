package com.vendas.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Loja;
import com.vendas.interfaces.ILoja;

public class DAOLoja implements ILoja  {

	protected EntityManager entityManager;
	 
	/**
	 * Construtor para pegar o EntityManager
	 */
    public DAOLoja() {
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
            Loja loja = consultarPorId(id);
            excluir(loja);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void cadastrar(Loja loja) throws Exception {
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(loja);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
		
	}

	@Override
	public void editar(Loja loja) {
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(loja);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            //ex.printStackTrace();
	            //entityManager.getTransaction().rollback();
	           
	        }
		
	}

	@Override
	public void excluir(Loja loja) {
		 try {
	            entityManager.getTransaction().begin();
	            loja = entityManager.find(Loja.class, loja.getId());
	            entityManager.remove(loja);
	            entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
		
	}

	@Override
	public Loja consultarPorId(Integer id) {
		  return entityManager.find(Loja.class, id);
	}
	
	
	/*public List<Loja> listarDepartamentos(Loja loja) {
		return entityManager.createQuery("select f from Loja as f where f.cnpj = ?1").
		setParameter(1, "").getResultList();
	
	}*/

	@Override
	@SuppressWarnings("unchecked")
	public List<Loja> listar() {
		
		return entityManager.createQuery("FROM " + Loja.class.getName()).getResultList();
	}


	public List<Loja> realizarLogin(String cnpj,String senha) {
		return entityManager.createQuery("select l from Loja as l where l.cnpj = ?1 and l.senha = ?2").
		setParameter(1, cnpj).
		setParameter(2, senha).
		getResultList();
	
	}
}
