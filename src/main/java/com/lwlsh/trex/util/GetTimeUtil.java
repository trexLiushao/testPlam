package com.lwlsh.trex.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimeUtil {

	
	public long getTime(){
		
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return date.getTime();
		
	}
	public static void main(String[] args) throws Exception {
		long aString=new GetTimeUtil().getTime();
		System.out.println(aString);
		Thread.sleep(3000);
		long bString=new GetTimeUtil().getTime();
		System.out.println(bString);
		System.out.println((int)(bString- aString)/1000);
		
	}
}
