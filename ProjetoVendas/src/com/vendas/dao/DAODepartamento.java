package com.vendas.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Departamento;
import com.vendas.basicas.Endereco;
import com.vendas.negocio.ICliente;
import com.vendas.negocio.IDepartamento;

public class DAODepartamento implements IDepartamento  {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	
	EntityManager em = emf.createEntityManager();

	EntityTransaction et = em.getTransaction();
	
	public void cadastrar(Departamento departamento) throws Exception {	
	try{	
		et.begin();
		em.persist(departamento);
		et.commit();
		emf.close();
		em.close(); 
		
	}catch(Exception e){
		throw new Exception("N�o foi poss�vel Inserir os dados (Cliente)");
	}
}

	public void editar(Departamento departamento) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Departamento departamento) {
		// TODO Auto-generated method stub
		
	}

	public Departamento consultarPorId(Integer id) {

		return em.find(Departamento.class, id);
	}

	public ArrayList<Departamento> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
