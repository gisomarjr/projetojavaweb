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
import com.vendas.negocio.IEndereco;
import com.vendas.negocio.IFornecedor;

public class DAOEndereco implements IEndereco  {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	
	EntityManager em = emf.createEntityManager();

	EntityTransaction et = em.getTransaction();

	public void cadastrar(Endereco endereco) throws Exception {
		try{	
			et.begin();
			em.persist(endereco);
			et.commit();
			emf.close();
			em.close(); 
			
		}catch(Exception e){
			throw new Exception("N�o foi poss�vel Inserir os dados (Endereco)");
		}
	}

	public void editar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	public Endereco consultarPorId(Integer id) {
		
		return em.find(Endereco.class, id);
	}

	public ArrayList<Endereco> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

	
}
