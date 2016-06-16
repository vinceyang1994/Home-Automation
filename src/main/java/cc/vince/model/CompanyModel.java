/**
 * @package : com.vince.model
 * @date : 2015年1月20日
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
import javax.persistence.OneToMany;

/**
 * @describe :
 * @param x
 *            :
 * @return :
 */
@Entity(name="company")
public class CompanyModel {
	private int id;
	private String fax;
	private String location;
	private String name;
	private String phone;

	private Set<DepartmentModel> departments = new HashSet<DepartmentModel>();

	@Id
	@GeneratedValue
	@Column(name = "cId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "cFax")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name="cLocation")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name="cName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="cPhone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToMany(mappedBy="company")
	public Set<DepartmentModel> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<DepartmentModel> departments) {
		this.departments = departments;
	}

}
