package cc.vince.service;

import java.util.Date;
import java.util.List;

import cc.vince.model.ReservationModel;

public interface ReservationService{

	/*
	 * describe ： 实验预约
	 * return ：true，false 返回预约成功或者失败
	 */
	public boolean yuYue(ReservationModel yuyue);
	
	/*
	 * describe ： 单天查询
	 * return ：查询日期的预约情况
	 */
	public List<ReservationModel> chaXun(int table,Date yuyuedate);
}
