package com.lwlsh.trex.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * http请求的util
 * @author Administrator
 *
 */
public class HttpUtil {
	public Jsoup  tjsoup; 
	
	/**
	 * 
	 * @param hoStUrl=地址
	 * @param methodType=请求的方法类型
	 * @param Param=请求的参数值
	 * @param ParamType=发送请求的参数类型(如：json/application-xml..)
	 * @return
	 */
	public Response httpPost(String hoStUrl,String methodType,Map<String, String> Param,String ParamType){
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("==============================");
		System.out.println(hoStUrl+":"+methodType+":"+ParamType);
		System.out.println("==============================");
		
		Connection connection=Jsoup.connect(hoStUrl);
	
		connection.timeout(3000);
		if (methodType.equals("get")) {
			connection.method(Method.GET);
		} else {
			connection.method(Method.POST);
			for (Map.Entry<String , String> entry : Param.entrySet()) {
				System.out.println(entry.getKey()+":"+entry.getValue());
				connection.data(entry.getKey(),entry.getValue());
			 }
		}
		//忽略传输的类型--暂时写死
		connection.ignoreContentType(true);
		Response response=null;
		try {
			response=connection.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
	
	
	
	public static void main(String[] args) {
		HttpUtil httpUtil=new HttpUtil();
		Map<String, String>  resultMap=new HashMap<String,String>();
		resultMap.put("name", "15818675502");
		resultMap.put("pwd","czq090312");
		Response response=httpUtil.httpPost("https://www.struck.cn/struck2/signReg/login.action", "post", resultMap, "json");
		System.out.println("==============================");
		System.out.println(response.statusCode());
		System.out.println("==============================");
		System.out.println(response.body());
		System.out.println("==============================");

		
	}

}
