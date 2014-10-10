package com.vendas.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.negocio.ICliente;

public class DAOCliente implements ICliente  {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	
	EntityManager em = emf.createEntityManager();

	EntityTransaction et = em.getTransaction();
	
	public void cadastrar(Cliente cliente) throws Exception {	
	try{	
		et.begin();
		em.persist(cliente);
		et.commit();
		emf.close();
		em.close(); 
		
	}catch(Exception e){
		throw new Exception("N�o foi poss�vel Inserir os dados (Cliente)");
	}
}

	public void editar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	public Cliente consultarPorId(Integer id) {

		return em.find(Cliente.class, id);
	}

	public ArrayList<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
