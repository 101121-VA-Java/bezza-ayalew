package com.revature.daos;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeHibernate implements EmployeeDao{

	/**
	 * Adds an employee to the database
	 * @return the employee with the new id or null if no record is created
	 */
	@Override
	public Employee add(Employee e) {
		// In hibernate, the session represents the connection to the database
		Session s = HibernateUtil.getSessionFactory().openSession();
		// starts the transaction
		Transaction tx = s.beginTransaction();
		/*
		 * saves object to database The id of the object saved has been updated to the
		 * generated value from database
		 */
		// id is generated id
		// takes transient department and makes persisted
		int id = (int) s.save(e);
		// commits the transaction
		tx.commit();
		// close the session
		// d is now detached because the session has been closed
		s.close();

		return e;
	}

	/**
	 * Retrieves an employee by its id from the database
	 * @return the employee if found or null otherwise
	 */
	@Override
	public Employee getById(int id) {
		Employee e = null;
		/*
		// using Hibernate defined methods to retrieve a record
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			d = s.get(Department.class, id);
		}
		*/
		
		/*
		// Native query
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "select * from hbn.employees where e_id = :employee_id ;";
			NativeQuery<Employees> nq = s.createNativeQuery(sql, Employees.class);
			nq.setParameter("employee_id", id);
			d = nq.getSingleResult();
		}
		*/
		
		//HQL
		try (Session s = HibernateUtil.getSessionFactory().openSession() ) {
			// instead of working with table name/column name, work with class and fields
			String hql = "from Employee where id = :id";
			TypedQuery<Employee> tq = s.createQuery(hql, Employee.class);
			tq.setParameter("id", id);
			e = tq.getSingleResult();
		}
		catch(NoResultException nr){
			return e;
		}
		return e;
	}

	/**
	 * Retrieves an employee by its name from the database
	 * @return the employee if found or null otherwise
	 */
	@Override
	public Employee getByName(String name) {
		Employee e = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			// define entity to be searched
			Root<Employee> root = cq.from(Employee.class);
			
			// defining "where name = ... && condition"
			Predicate predicateForName = cb.equal(root.get("name"), name);
//			Predicate predicateForSomethingElse = cb.equal(root.get("id"), passedInId);
//			Predicate predicateForNameAndSomethingElse = cb.and(predicateForName, predicateForSomethingElse);
			
			// cq.select(root).where(predicateForNameAndSomethingElse);
			cq.select(root).where(predicateForName);
			
			// retrieving the result
			e = (Employee) s.createQuery(cq).getSingleResult();
		}
		return e;
	}

	/**
	 * Retrieves all employees from the database
	 * @return a List of Employee objects
	 */
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = null;

		// using query
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			employees = s.createQuery("from Employee", Employee.class).list();
		}

		return employees;
		
	}

	/**
	 * Retrieves employees by department id from the database
	 * @return a List of Employee objects
	 */
	@Override
	public List<Employee> getEmployeesByDepartmentId(int deptId) {
		List<Employee> e = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			// define entity to be searched
			Root<Employee> root = cq.from(Employee.class);
			
			// defining "where name = ... && condition"
			Predicate predicateForId = cb.equal(root.get("id"), deptId);
//			Predicate predicateForSomethingElse = cb.equal(root.get("id"), passedInId);
//			Predicate predicateForNameAndSomethingElse = cb.and(predicateForName, predicateForSomethingElse);
			
			// cq.select(root).where(predicateForNameAndSomethingElse);
			cq.select(root).where(predicateForId);
			
			// retrieving the result
			e = s.createQuery(cq).getResultList();
		}
		return e;
	}

	/**
	 * Updates an employee
	 */
	@Override
	public void update(Employee e) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.update(e);
			tx.commit();
		}		
	}
	
	/**
	 * Deletes an employee
	 */
	@Override
	public void delete(Employee e) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(e);
			tx.commit();
		}
		
	}
}
