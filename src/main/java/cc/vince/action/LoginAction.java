package cc.vince.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.vince.service.UserService;

import cc.vince.model.UserInfoModel;
import cc.vince.utils.SHA1;
import cc.vince.utils.Salt;
import cc.vince.utils.Struts2Constants;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction {
	/**
	 * 登陆模块
	 */
	private static final long serialVersionUID = -2552226101747177280L;

	private String usersalt;

	private UserInfoModel user = new UserInfoModel();

	@Autowired
	private UserService userService;

	// 接收JSON数据
	private String employeeNumber;
	private String password;

	/* 返回用户盐数据，不返回视图 */
	public String getSalt() {
		System.out.println("LoginAction.getSalt() has been called! emplyeeid is "+ employeeNumber);		
		// 传往下一层查询
		usersalt = userService.getSalt(employeeNumber);
		return SUCCESS;
	}

	/* 用户登录时请求 */
	public String execute() {	
			UserInfoModel loginUser = new UserInfoModel();//将用户登录信息打包到UserInfoModel对象中
			loginUser.setEmployeeNumber(employeeNumber);
			loginUser.setPassword(password);
			if(!(userService.logIn(loginUser))){//登录不成功
				return INPUT;
			}
			
			session.put(Struts2Constants.USER, user.getEmployeeNumber());// 将user对象的工号放入session中。
		
		return SUCCESS;
	}

	public String getUsersalt() {
		return usersalt;
	}

	public void setUsersalt(String usersalt) {
		this.usersalt = usersalt;
	}


	public String getEmployeeNumber( ) {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
