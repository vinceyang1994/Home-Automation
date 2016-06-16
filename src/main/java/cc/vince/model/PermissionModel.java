/**
 * @package : com.vince.model
 * @date : 2015年1月20日
 * @author : vince
 * @version : 0.9
 */
package cc.vince.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @describe :
 * @param x
 *            :
 * @return :
 */
@Entity(name="permission")
public class PermissionModel {
	private int id;// 主键
	private int permission;// 权限等级
	private String title;// 权限名称

	@Id
	@GeneratedValue
	@Column(name = "pId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "pPermission")
	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	@Column(name = "pTitle")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
