package cc.vince.dao;

import cc.vince.model.UserInfoModel;

public interface UserInfoDao extends BaseDao<UserInfoModel> {
	// 添加用户（管理员操作）
	public void addUser(UserInfoModel user);

/*	// 校验用户是否已经存在（管理员操作）
	public boolean verification(String username);*/
	
	//用户登录
	public void login(UserInfoModel user);

	//得到指定用户盐值
	public String getSalt(String username);
}