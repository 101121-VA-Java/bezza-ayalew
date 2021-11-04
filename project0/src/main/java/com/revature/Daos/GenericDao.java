package com.revature.Daos;

import java.io.IOException;
import java.util.List;

import com.revature.models.Employee;

// An interface for other Daos to extend
public interface GenericDao<T> {

	T add(T t) throws IOException;
	T delete(T t);
	T getById(int id);
	List<T> getAll();
	boolean update(T t);

}
