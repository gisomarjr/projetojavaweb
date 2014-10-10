package com.vendas.dao;

import java.io.Serializable;
import java.util.List;

public interface IDAOGenerico<T,Type extends Serializable> {

	/**
	 * http://blog.camilolopes.com.br/genericdao/
	 */
	
		void beginTransaction();
		
		void commitTransaction();
		
		void save(T entity);
		
		void delete (T entity);
		
		List<T> listAll();
		
}