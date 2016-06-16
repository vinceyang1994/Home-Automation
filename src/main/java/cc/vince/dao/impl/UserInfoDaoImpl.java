package cc.vince.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import cc.vince.dao.UserInfoDao;
import cc.vince.model.UserInfoModel;
@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfoModel> implements UserInfoDao {
/*	private SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	private Session session = sf.getCurrentSession();*/
	

	@Override
	public void addUser(UserInfoModel user) {
		getCurrentSession().save(user);
	}

	/*@Override
	public boolean verification(String username) {
		Query query = getCurrentSession()
				.createQuery("from UserModel u where u.name = :userName");
		query.setString(username, "userName");
		boolean exist = !(query.list().isEmpty());
		System.out.println(exist);
		return exist;
	}
*/
	@Override
	public void login(UserInfoModel user) {
		
		
	}
	
	@Override
	//取盐
	public String getSalt(String username) {
		System.out.println("UserInfoDaoImpl.getSalt() has been called! emplyeeid is "+ username);
		
		String hql ="select salt from userinfo as u where employeeNumber="+username;
		System.out.println("hql :" + hql);
		Query query = getCurrentSession()
				.createQuery(hql);
		//System.out.println("test query success!");

		//System.out.println("取得盐值？"+!(query.list().isEmpty()));
		String saltString = query.list().toString().substring(1, 17); //取出来带有[],去掉[]

		System.out.println(saltString);
		
		return saltString;
	}

}