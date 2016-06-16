/**
 * @package : com.vince.action
 * @date : 2015年1月14日
 * @author : vince
 * @version : 0.9
 */
package cc.vince.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import cc.vince.service.ReservationService;

import cc.vince.model.ExperimentTableModel;
import cc.vince.model.ReservationModel;
import cc.vince.utils.GetDateTime;

/**
 * @describe : 查找所有实验台预约情况
 * @param x
 *            :
 * @return :
 */
@Controller
@Scope("prototype")
// @InterceptorRef(value="json")
public class ChaXunAction extends ActionSupport {
	private static final long serialVersionUID = -7202740366103980536L;
	@Autowired
	private ReservationService reservationservice;
	

	private List<ReservationModel> yuyuelist = new ArrayList<ReservationModel>();

	private ReservationModel rm=new ReservationModel();

	private Boolean[] vacant = new Boolean[] { true, true, true, true, true,
			true, true, true, true, true, true, true, };
	// 查询日期起一周内的预约情况
	private String[] chaxundate = new String[7];

	// 接收JSON数据
	private int table;
	private Date datetime;

	// 第一次查询之后使用，只返回数据，不返回视图
	public String loadJson() {
		// 传往下一层查询
		yuyuelist = reservationservice.chaXun(table, datetime);

		for (ReservationModel reservation : yuyuelist) {
			Date rdatetime = reservation.getDatetime();// 得到所有已经预约的时间 //
			System.out.println(rdatetime);
			vacant[rdatetime.getHours() / 2] = false;// 相应位置不可选

		}
		System.out.println("loadJson() has been called.");
		System.out.println("table :" + table + " datetime:" + datetime);
		return SUCCESS;
	}

	// 第一次查询时使用，返回视图

	public String execute() {
		// 未来7天
		Calendar curr = GetDateTime.getNowTimeCalendar();
		Date date = null;
		for (int i = 0; i < 7; i++) {

			curr.set(Calendar.DATE, curr.get(Calendar.DATE) + 1);
			date = curr.getTime();
			chaxundate[i] = GetDateTime.getDateOnlyString(date);// 只得到日期
			System.out.println("chaxundate[" + i + "]=" + chaxundate[i]);
		}
		/*---------------------参数错误处理------------------------*/		
		if (rm.getTable()==null) {
			ExperimentTableModel table  = new ExperimentTableModel();
			table.setId(1);
			rm.setTable(table);
			
		}
		// System.out.println(rm.getRtable());
		if (rm.getDatetime() == null
				|| rm.getDatetime().before(GetDateTime.getSysTimeNow())) {// 设定预约时间默认值
			rm.setDatetime(GetDateTime.getTomorrowTimeDate());
		}
		 System.out.println("ChaXunAction execute() ok!");
		// addActionMessage("ChaXunAction execute() ok!");
		// System.out.println(rm.getRdatetime());

		// 传往下一层查询
		yuyuelist = reservationservice.chaXun(rm.getTable().getId(), rm.getDatetime());

		 System.out.println("yuyuelist.size()"+yuyuelist.size());
		for (ReservationModel reservation : yuyuelist) {
			Date rdatetime = reservation.getDatetime();// 得到所有已经预约的时间
			// System.out.println(rdatetime);
			vacant[rdatetime.getHours() / 2] = false;// 相应位置不可选

		}
		for (int i = 0; i < 12; i++) {

			System.out.println("ChaXunAction() result " + i + ": " + vacant[i]);
		}
		return SUCCESS;
	}

	public List<ReservationModel> getYuyuelist() {
		return yuyuelist;
	}

	public void setYuyuelist(List<ReservationModel> yuyuelist) {
		this.yuyuelist = yuyuelist;
	}

	public Boolean[] getVacant() {
		return vacant;
	}

	public void setVacant(Boolean[] vacant) {
		this.vacant = vacant;
	}

	public String[] getChaxundate() {
		return chaxundate;
	}

	public void setChaxundate(String[] chaxundate) {
		this.chaxundate = chaxundate;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int rtable) {
		this.table = rtable;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date rdatetime) {
		this.datetime = rdatetime;
	}

}
