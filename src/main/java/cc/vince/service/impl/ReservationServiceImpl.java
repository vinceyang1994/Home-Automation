package cc.vince.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cc.vince.service.ReservationService;

import cc.vince.dao.BaseDao;
import cc.vince.dao.ReservationDao;
import cc.vince.dao.impl.ReservationDaoImpl;
import cc.vince.model.ReservationModel;

@Service
@Scope("prototype")
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDao reservationdao;

	/*
	 * @describe ： 实验预约
	 * 
	 * @return ：true，false 返回预约成功或者失败
	 */
	@Override
	public boolean yuYue(ReservationModel yuyue) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @param x: 实验台
	 * 
	 * @param y: 查询时间
	 * 
	 * @describe ： 单天查询
	 * 
	 * @return ：查询日期的预约情况
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<ReservationModel> chaXun(int table, Date yuyuedate) {
		String where = "where rTableId = ?0 and rDateTime >= ?1 and rDateTime <= ?2";

		// 构造查询当天时间上下限
		Date limitdatebegin = new Date(yuyuedate.getYear(),
				yuyuedate.getMonth(), yuyuedate.getDate(), 0, 0, 0);
		Date limitdateend = new Date(yuyuedate.getYear(), yuyuedate.getMonth(),
				yuyuedate.getDate(), 23, 59, 59);
		System.out.println("yuyuedate:" + yuyuedate + " limitdatebegin:"
				+ limitdatebegin + " limitdateend:" + limitdateend);

		List<ReservationModel> chaxun = (List<ReservationModel>) reservationdao
				.getAll(where, new Object[] { table, limitdatebegin,
						limitdateend });
		System.out.println("CoreServiceImpl:" + chaxun.size());

		return chaxun;
	}

}
