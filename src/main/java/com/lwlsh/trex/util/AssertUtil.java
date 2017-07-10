package com.lwlsh.trex.util;

import org.testng.Assert;

/**
 * d断言类
 * @author Administrator
 *
 */
public class AssertUtil {
	
	public boolean expToact(String expectValue,String actualValue){
		
		boolean flag=true;
		Assert.assertEquals(expectValue, actualValue);
		return false;
	}

}
