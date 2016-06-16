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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @describe :
 * @param x
 *            :
 * @return :
 */
@Entity(name = "experimenttable")
public class ExperimentTableModel {
	private int id;
	private String tablename;// 实验台名称

	private UserInfoModel admin;// 实验台管理员

	@Id
	@GeneratedValue
	@Column(name = "tId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "tTableName")
	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	@ManyToOne
	@JoinColumn(name = "tAdminId")
	public UserInfoModel getAdmin() {
		return admin;
	}

	public void setAdmin(UserInfoModel admin) {
		this.admin = admin;
	}

}
