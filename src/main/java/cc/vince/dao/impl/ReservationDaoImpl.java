package cc.vince.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cc.vince.dao.ReservationDao;
import cc.vince.model.ReservationModel;

@Repository
public class ReservationDaoImpl  extends BaseDaoImpl<ReservationModel> implements ReservationDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationModel> getAll(String where, Object[] queryParams) {
		// TODO Auto-generated method stub
		//getCurrentSession().beginTransaction();
		String hql = new StringBuffer().append("from reservation")

		.append(" ").append(where == null ? "" : where).toString();
		System.out.println("hql :" + hql);
		
		Query query = getCurrentSession().createQuery(hql);
		System.out.println("query created!");
		setQueryParams(query, queryParams);
		List<ReservationModel> result = query.list();
		
		//getCurrentSession().getTransaction().commit();
		System.out.println("查询到"+result.size()+"条。");
		return result;
	}

	protected void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(Integer.toString(i), queryParams[i]);
			}
		}
	}

}
