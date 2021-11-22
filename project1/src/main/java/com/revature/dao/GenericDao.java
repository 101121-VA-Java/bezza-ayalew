package com.revature.dao;

import java.io.IOException;
import java.util.List;

public interface GenericDao<T> {
	T add(T t) throws IOException;
	int delete(int id) throws IOException; 
	T getById(int id) throws IOException;
	List<T> getAll() throws IOException;
	boolean update(T t);
}
