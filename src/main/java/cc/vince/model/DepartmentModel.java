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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @describe :
 * @param x
 *            :
 * @return :
 */
@Entity(name="department")
public class DepartmentModel {
	private int id;
	private String department;
	private String phone;
	
	private CompanyModel company;
	private Set<PositionModel> positions = new HashSet<PositionModel>();

	@Id
	@GeneratedValue
	@Column(name="dId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="dDepartment")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "dPhone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@ManyToOne
	@JoinColumn(name="dCompanyId")
	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}

	@OneToMany(mappedBy="department")
	public Set<PositionModel> getPositions() {
		return positions;
	}

	public void setPositions(Set<PositionModel> positions) {
		this.positions = positions;
	}


}
