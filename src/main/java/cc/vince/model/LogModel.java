/**
 * @package : com.vince.model
 * @date : 2015年1月20日
 * @author : vince
 * @version : 0.9
 */
package cc.vince.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @describe :
 * @param x
 *            :
 * @return :
 */
@Entity(name="log")
public class LogModel {
	private int id;
	private Date datetime;
	private String ip;

	private UserInfoModel user;

	@Id
	@GeneratedValue
	@Column(name = "lId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "lDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	@Column(name = "lIp")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@ManyToOne
	@JoinColumn(name = "lUId")
	public UserInfoModel getUser() {
		return user;
	}

	public void setUser(UserInfoModel user) {
		this.user = user;
	}

}
