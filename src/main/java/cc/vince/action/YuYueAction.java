/**
 * 
 */
package cc.vince.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


/**
 * @author vince
 * 
 */
@Controller
public class YuYueAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7026262687832787035L;	
    private String user;
    // 返回结果给客户端
    private String result;
	public String execute() {
		
			return SUCCESS;
	}

}
