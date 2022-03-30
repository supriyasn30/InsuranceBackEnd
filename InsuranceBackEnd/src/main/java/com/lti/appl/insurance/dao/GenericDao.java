package com.lti.appl.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public Object store(Object obj) {
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
	}
	
	public void delete(Object obj) {
		try{ 
			entityManager.remove(obj);
			}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}

	public <E> E Fetch(Class<E> cname, Object pk) {
		E e = entityManager.find(cname, pk);
		return e;
	}

	public <A> List<A> fetchAll(Class<A> cname) {
		String jpql = "select obj from " + cname.getName() + " as obj";
		Query q = entityManager.createQuery(jpql);
		List<A> list = q.getResultList();

		return list;
	}
}