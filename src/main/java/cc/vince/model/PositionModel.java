/**
 * @package : com.vince.model
 * @date : 2015年4月10日
 * @author : vince
 * @version : 0.9
 */
package cc.vince.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @describe :
 * @param x
 *            :
 * @return :
 */
@Entity(name="position")
public class PositionModel {
	private int id;// 主键
	private String name;// 职位名称
	
	private DepartmentModel department;// 职位所属部门
	private Set<UserInfoModel> users = new HashSet<UserInfoModel>();
	@Id
	@GeneratedValue
	@Column(name="pId")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="pName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name="pDepartmentId")
	public DepartmentModel getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentModel department) {
		this.department = department;
	}
	
	@OneToMany(mappedBy="position")
	public Set<UserInfoModel> getUsers() {
		return users;
	}
	public void setUsers(Set<UserInfoModel> users) {
		this.users = users;
	}

	
}
