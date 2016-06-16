/**
 * @package : com.vince.utils
 * @date : 2015年3月26日
 * @author : vince
 * @version : 0.9
 */
package cc.vince.utils;

import java.util.Random;

/**
 * @describe : 对每个用户产生一个盐值，每次用户登录之后调用重新生成
 * @param x
 *            :
 * @return :
 */
public class Salt {

	public String createSalt() {

		// 设定可用于盐的字符，ASCII码的48～122
		char[] saltchar = new char[75];
		for (int i = 0; i < 75; i++) {
			saltchar[i] = (char) (i + 48);
			//System.out.print(saltchar[i]);
		}
		// 生成16位的盐
		StringBuffer usersalt = new StringBuffer();
		int bound = saltchar.length;
		// System.out.println("bound is :"+bound);
		Random random = new Random();

		for (int i = 0; i < 16; i++) {
			usersalt.append(saltchar[random.nextInt(bound)]);
		}
		return usersalt.toString();
	}
}
