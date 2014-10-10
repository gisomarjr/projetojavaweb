package com.vendas.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.negocio.ICliente;
import com.vendas.negocio.IFornecedor;

public class DAOFornecedor implements IFornecedor  {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	
	EntityManager em = emf.createEntityManager();

	EntityTransaction et = em.getTransaction();

	public void cadastrar(Fornecedor fornecedor) throws Exception {
		// TODO Auto-generated method stub
		try{	
			et.begin();
			em.persist(fornecedor);
			et.commit();
			em.close(); 
			emf.close();
		}catch(Exception e){
			throw new Exception("Não foi possível Inserir os dados (Fornecedor)");
		}
	}

	public void editar(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}

	public Fornecedor consultarPorId(Integer id) {
	
		 return em.find(Fornecedor.class, id);
	}

	public ArrayList<Fornecedor> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
