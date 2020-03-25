package com.javaeetest.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.javaeetest.common.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	// HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;
	private Class<T> entityClass;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public BaseDaoImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/*
	 * public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	 * this.hibernateTemplate = hibernateTemplate; }
	 */

	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClass, Serializable id) {
		Session session = sessionFactory.openSession();
		T t = (T) session.get(entityClass, id); // 关闭session
		session.close();
		return t;
	}

	@Override
	public int save(T entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int status = 0;
		try {
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
			status = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return status;
	}

	@Override
	public int update(T entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int status = 0;
		try {
			tx = session.beginTransaction();
			session.update(entity);
			status = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
		session.close();
		return status;
	}

	@Override
	public int delete(Class<T> entityClass) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int status = 0;
		try {
			tx = session.beginTransaction();
			session.delete(entityClass);
			status = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return status;
	}

	@Override
	public List<T> findAll(Class<T> entityClass) {
		return find("select en from" + entityClass.getSimpleName() + "en");
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		Session session = sessionFactory.openSession();
		List<T> list = session.createSQLQuery(hql).list();
		session.close(); // 关闭session
		return list;
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByHql(String hql) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<T> list = query.list();
		session.close(); // 关闭session
		return list;
	}

	@SuppressWarnings("unchecked")
	protected List<Integer> find1(String hql) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);

		List<Integer> list = query.list();
		session.close(); // 关闭session
		return list;
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... parms) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery(hql).addEntity(entityClass);
		for (int i = 0; i < parms.length; i++) {
			query.setParameter(i + "", parms[i]);
		}
		List<T> list = query.list();
		session.close(); // 关闭session
		return list;
	}
}
