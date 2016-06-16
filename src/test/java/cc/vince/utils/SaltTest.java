/** 
* Copyright  2016 紫彤科技Co.Ltd. All rights reserved.
*
* @Title: CreateSaltTest.java 
* @Package: cc.vince.utils
* @Description: TODO
* @author: Vince Yang 
* @version: V0.9 2016年6月16日 
* 
*/ 
package cc.vince.utils;

import org.junit.Test;

public class SaltTest {

	/**
	 * Test method for {@link cc.vince.utils.Salt#Salt()}.
	 */
	@Test
	public void testCreateSalt() {
		//fail("Not yet implemented");
		Salt salt = new Salt();
		System.out.println(salt.createSalt());
	}

}
