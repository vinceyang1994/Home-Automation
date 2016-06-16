package cc.vince.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cc.vince.service.UserService;

import cc.vince.dao.UserInfoDao;
import cc.vince.model.UserInfoModel;
import cc.vince.utils.SHA1;
import cc.vince.utils.Salt;
@Service
@Scope("prototype")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserInfoDao userdao;
	
	//private UserDao userDao = new UserDaoImpl();
	@Override
	public void register(UserInfoModel user) {
		this.userdao.addUser(user);
	}

	@Override
	public boolean logIn(UserInfoModel user) {
		String employeeNumber = user.getEmployeeNumber();
		SHA1.Sha1(user.getPassword());
		// user=userService.logIn(user);
		return true;

	}

	@Override
	public String getSalt(String username) {
		System.out.println("UseServiceImpl.getSalt() has been called! emplyeeid is "+ username);
		String salt = userdao.getSalt(username);
		//用户不存在，随机产生一个盐值。再次请求盐值最好不变。
		if(salt=="null"){
			Salt usersalt = new Salt();
			salt = usersalt.createSalt();
		}
		return salt;
	}

}