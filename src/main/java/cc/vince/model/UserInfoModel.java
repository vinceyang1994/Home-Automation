/**
 * @package : com.vince.model
 * @date : 2015年1月14日
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
@Entity(name = "userinfo")
public class UserInfoModel {
	private int id;
	private int creditworthiness;
	private String email;
	private String employeeNumber;
	private String name;
	private String password;
	private String phone;
	private String salt;
	private String telephone;

	private PermissionModel permission;
	private PositionModel position;
	private Set<ReservationModel> reservations = new HashSet<ReservationModel>();

	@Id
	@GeneratedValue
	@Column(name = "uId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "uCreditworthiness")
	public int getCreditworthiness() {
		return creditworthiness;
	}

	public void setCreditworthiness(int creditworthiness) {
		this.creditworthiness = creditworthiness;
	}

	@Column(name = "uEmail")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "uEmployeeNumber")
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Column(name = "uName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "uPassword")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "uPhone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "uSalt")
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "uTelephone")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@ManyToOne
	@JoinColumn(name = "uPermissionId")
	public PermissionModel getPermission() {
		return permission;
	}

	public void setPermission(PermissionModel permission) {
		this.permission = permission;
	}

	@ManyToOne
	@JoinColumn(name = "uPositionId")
	public PositionModel getPosition() {
		return position;
	}

	public void setPosition(PositionModel position) {
		this.position = position;
	}

	@OneToMany(mappedBy="user")
	public Set<ReservationModel> getReservations() {
		return reservations;
	}

	public void setReservations(Set<ReservationModel> reservations) {
		this.reservations = reservations;
	}

}
