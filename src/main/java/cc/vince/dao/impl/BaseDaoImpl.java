package cc.vince.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import cc.vince.dao.BaseDao;
import cc.vince.model.PageModel;
import cc.vince.utils.GenericsUtils;
import cc.vince.utils.SessionFactoryUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {

	// 反射机制得到实体类

	private Class<T> entityClass = (Class<T>) GenericsUtils.getGenricType(this
			.getClass());

	/*
	 * private SessionFactory sessionFactory = SessionFactoryUtil
	 * .getSessionFactory(); Session session =
	 * sessionFactory.getCurrentSession();
	 */

	@Autowired
	protected SessionFactory sessionFactory;

	/*protected SessionFactory sessionFactory = SessionFactoryUtil
			.getSessionFactory();*/

	protected Session getCurrentSession() {
		assertNotNull(sessionFactory);
		System.out.println("getCurrentSession() has been called!");
		//System.out.println("sessionFactory is" + sessionFactory.getClass());
		return sessionFactory.openSession();
	}

	@Override
	public void save(Object obj) {
		getCurrentSession().save(obj);
		//session.save(obj);
	}

	@Override
	public void saveOrUpdate(Object obj) {
		getCurrentSession().saveOrUpdate(obj);
	}

	@Override
	public void update(Object obj) {
		getCurrentSession().update(obj);
	}

	@Override
	public void delete(Serializable... ids) {
		for (Serializable id : ids) {
			// 反射得到实体类
			T t = (T) getCurrentSession().get(entityClass, id);
			getCurrentSession().delete(t);
		}
	}

	@Override
	public T get(Serializable entityId) {
		return (T) getCurrentSession().get(entityClass, entityId);
	}

	@Override
	public T load(Serializable entityId) {
		return (T) getCurrentSession().load(entityClass, entityId);
	}

	@Override
	public Object uniqueResult(String hql, Object[] queryParams) {

		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, queryParams);
		return query.uniqueResult();
	}

	@Override
	public boolean isExist(String where, Object[] queryParams) {

		String hql = new StringBuffer().append("from ")
				.append(GenericsUtils.getGenricName(this.entityClass))
				.append(" ").append(where == null ? "" : where).toString();
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, queryParams);
		if (query.list().size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<T> getAll(String where, Object[] queryParams) {

		String hql = new StringBuffer().append("from ")
				.append(GenericsUtils.getGenricName(this.entityClass))
				.append(" ").append(where == null ? "" : where).toString();
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, queryParams);
		return query.list();
	}

	@Override
	public long getCount() {

		String hql = "select count(*) from "
				+ GenericsUtils.getGenricName(this.entityClass);
		return (Long) uniqueResult(hql, null);
	}

	@Override
	public PageModel<T> find(int pageNo, int maxResult) {

		return find(null, null, null, pageNo, maxResult);
	}

	@Override
	public PageModel<T> find(int pageNo, int maxResult, String where,
			Object[] queryParams) {

		return find(where, queryParams, null, pageNo, maxResult);
	}

	@Override
	public PageModel<T> find(int pageNo, int maxResult,
			Map<String, String> orderby) {

		return find(null, null, orderby, pageNo, maxResult);
	}

	@Override
	public PageModel<T> find(String where, Object[] queryParams,
			Map<String, String> orderby, int pageNo, int maxResult) {

		final PageModel<T> pageModel = new PageModel<T>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(maxResult);
		String hql = new StringBuffer().append("from ")
				.append(GenericsUtils.getGenricName(this.entityClass))
				.append(" ").append(where == null ? "" : where)
				.append(createOrderBy(orderby)).toString();
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, queryParams);
		List<T> list = null;

		if (maxResult < 0 && pageNo < 0) {
			list = query.list();
		} else {
			list = query.setFirstResult(getFirstResult(pageNo, maxResult))
					.setMaxResults(maxResult).list();
			hql = new StringBuffer().append("select count(*) from ")
					.append(GenericsUtils.getGenricName(this.entityClass))
					.append(" ").append(where == null ? "" : where).toString();
			query = getCurrentSession().createQuery(hql);
			setQueryParams(query, queryParams);
			int totalRecords = ((Number) query.uniqueResult()).intValue();
			pageModel.setTotalRecords(totalRecords);
		}
		pageModel.setList(list);
		return pageModel;
	}

	protected int getFirstResult(int pageNo, int maxResult) {
		int firstResult = (pageNo - 1) * maxResult;
		return firstResult < 0 ? 0 : firstResult;
	}

	protected void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(Integer.toString(i), queryParams[i]);
			}
		}
	}

	protected String createOrderBy(Map<String, String> orderby) {
		StringBuffer sb = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			sb.append(" order by ");
			for (String key : orderby.keySet()) {
				sb.append(key).append(" ").append(orderby.get(key)).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
