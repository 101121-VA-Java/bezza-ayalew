package com.revature.Daos;

import java.io.IOException;
import java.util.List;

public interface GenericDao<T> {

	int add(T t) throws IOException;
	int delete(T t) throws IOException; 
	T getById(int id) throws IOException;
	List<T> getAll() throws IOException;
	int update(T t);

}
