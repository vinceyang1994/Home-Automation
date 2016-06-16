/**
 * @package : com.vince.security
 * @date : 2015年5月11日
 * @author : vince
 * @version : 0.9
 */
package cc.vince.aop.security;

import org.springframework.stereotype.Component;

/**
 * @describe : 登录校验切面
 * @param x : 
 * @return : 
 */
@Component
public class LoginSecurity {
	public boolean isNull(String employeeNumber){
		if(employeeNumber==null){
			return true;
		}	
		return false;
	}
}
