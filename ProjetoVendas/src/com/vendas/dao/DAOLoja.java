package com.vendas.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vendas.basicas.Fornecedor;
import com.vendas.basicas.Loja;
import com.vendas.negocio.ILoja;

public class DAOLoja implements ILoja{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	
	EntityManager em = emf.createEntityManager();

	EntityTransaction et = em.getTransaction();
	
	public void cadastrar(Loja loja) throws Exception {

		try{	
			et.begin();
			em.persist(loja);
			et.commit();
			em.close(); 
			emf.close();
		}catch(Exception e){
			throw new Exception("Não foi possível Inserir os dados (Loja)");
		}
	}

	public void editar(Loja loja) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Loja loja) {
		// TODO Auto-generated method stub
		
	}

	public Loja consultarPorId(Integer id) {

		 return em.find(Loja.class, id);
	}

	public ArrayList<Loja> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
