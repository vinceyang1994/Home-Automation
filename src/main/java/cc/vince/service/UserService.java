package cc.vince.service;

import cc.vince.model.UserInfoModel;

public interface UserService {
	public void register(UserInfoModel user);// 员工注册

	public String getSalt(String username);// 取得员工盐值
	
	public boolean logIn(UserInfoModel user);// 员工登录

	//public boolean Verification(UserInfoModel user);// 登录校验

}
