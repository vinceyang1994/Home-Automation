/**
 * @package : com.vince.utils
 * @date : 2015年1月25日
 * @author : vince
 * @version : 0.9
 */
package cc.vince.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @describe : 根据日期取得星期几
 * @param x : 
 * @return : 
 */
public class GetWeek {
		public static String getWeek(Date date){ 
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
			String week = sdf.format(date);
			return week;
		}
}
