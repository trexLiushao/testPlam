package com.lwlsh.trex.controller;

import java.util.HashMap;
import java.util.Map;

public class Atest {

	public static void main(String[] args) {
//		String aString="username,password";
//		String bString=",";
//		Atest atest=new Atest();
//		Map<String, String>  resultMap=atest.strToMap(aString, bString);
//		 for (Map.Entry<String , String> entry : resultMap.entrySet()) {
//			 System.out.println("key= " + entry.getKey() + " and value= "  + entry.getValue());
//		 }

		
		
		
	}
	
	public Map<String, String> strToMap(String a,String b){
		Map<String, String>  resultMap=new HashMap<String,String>();
		if (",".equals(a)) {
			return resultMap;
		}
		String[] Amap=a.split(",");
		if (",".equals(b)) {
			System.out.println("12321");
			for(int i=0;i<Amap.length;i++){
				resultMap.put(Amap[i],"");
			}
			
			return resultMap;
		}
		String[] Bmap=b.split(",");
		System.out.println(Bmap.length);
		for(int i=0;i<Amap.length;i++){
			if (i<Bmap.length) {
				System.out.println("1:"+Amap[i]+"2:"+Bmap[i]);
				resultMap.put(Amap[i],Bmap[i]);
			}else{
				System.out.println("1:"+Amap[i]+"2:"+"");
				resultMap.put(Amap[i],"");
			}
			
		}
		return resultMap;
	}
}
