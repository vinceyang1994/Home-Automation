/**
 * @package : com.vince.utils
 * @date : 2015年3月4日
 * @author : vince
 * @version : 0.9
 */
package cc.vince.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @describe :
 * @param x
 *            :
 * @return :
 */
public class GetDateTime {
	public static Date getSysTimeNow() {
		Date date = new Date();
		return date;
	}

	// 得到当前时间
		public static Calendar getNowTimeCalendar() {
			Calendar curr = Calendar.getInstance();			
			curr.set(Calendar.HOUR,0);
			curr.set(Calendar.MINUTE,0);
			curr.set(Calendar.SECOND,0);

			return curr;
		}
	public static String getSysFormatTimeNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		return sdf.format(date);
	}

	public static Date String2Date(String datetime) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = null;
		try {
			date = format.parse(datetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

	// 将当前时间推迟一天
	public static Calendar getTomorrowTimeCalendar() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.DATE, curr.get(Calendar.DATE) + 1);//日期设为明日零时
		curr.set(Calendar.HOUR,0);
		curr.set(Calendar.MINUTE,0);
		curr.set(Calendar.SECOND,0);


		return curr;
	}
	// 将当前时间推迟一天
	public static Date getTomorrowTimeDate() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.DATE, curr.get(Calendar.DATE) + 1);//日期设为明日零时
		curr.set(Calendar.HOUR,0);
		curr.set(Calendar.MINUTE,0);
		curr.set(Calendar.SECOND,0);
		
		Date date = curr.getTime();

		return date;
	}
	//仅得到日期
/*	public static Date getDateOnly(Date datetime) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date dateonly = null;
		try {
			dateonly = format.parse(DateFormat.getDateInstance().format(datetime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateonly;
	}*/
	
	//仅得到日期
		public static String getDateOnlyString(Date datetime) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
			return sdf.format(datetime);
		}
	
}
