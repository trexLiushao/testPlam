//package com.lwlsh.trex.controller;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.XMLWriter;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//public class Atest {
//	
//	 public boolean testCreateXml(JSONObject object) {
//	        //创建一个xml文档
//	        Document doc = DocumentHelper.createDocument();
//	        //向xml文件中添加注释
//	        doc.addComment("管理一个页面的元素（webelement：input,select,textare,a,li等标签），一个page包含多个locator对象Pagename:page对象名字，格式：net.hk515.PageObject.xxxPage;最后面那位才是真正的页面名字，前面的是java对象库路径； 另外注意，页面名字是头个单词大写；例如主页：名字定义为 ****.HomePageValue：页面对象的URL，可不填。 Desc:页面对象中文描述");
//	        //创建一个名为map的节点，因为是第一个创建，所以是根节点,再通过doc创建一个则会报错。
//	        Element root = doc.addElement("map");
//	        //在root节点下创建一个名为page的节点
//	        Element pageEle =null; 
//	        JSONObject bObject=JSONObject.parseObject(object.get("map").toString());
//	        //这个是处理locator
//	        JSONArray ltObject=JSONObject.parseArray(bObject.get("locator").toString());
//			 //处理page
//	        if (bObject.get("page")!=null) {//page不为空
//				pageEle=root.addElement("page");
//				//获取属性值
//				JSONObject cObject=JSONObject.parseObject(bObject.get("page").toString());
//				if (cObject.get("value")!=null){
//					String pageValue=cObject.get("value").toString();
//					pageEle.setText(pageValue);
//				}
//				if (cObject.get("attribute")!=null) {
//					//获取属性值
//					JSONObject dObject=JSONObject.parseObject(cObject.get("attribute").toString());
//					System.out.println("======"+cObject.get("attribute").toString());
//					if (dObject.getString("pageName")!=null) {
//						pageEle.addAttribute("pageName", dObject.getString("pageName").toString());
//					}if (dObject.getString("desc")!=null) {
//						pageEle.addAttribute("desc", dObject.getString("desc").toString());
//					}
//				
//				}	
//		        //处理page下的子节点locator
//				if (ltObject.size()>0) {
//					//给student节点添加一个子节点
//					for (int i = 0; i < ltObject.size(); i++) {
//						 	Element locatorEle = pageEle.addElement("locator");
//							//获取属性值
//							JSONObject dObject=JSONObject.parseObject(ltObject.get(i).toString());
//							//获取属性值
//							JSONObject eObject=JSONObject.parseObject(dObject.get("attribute").toString());
//							if (eObject.getString("type")!=null) {
//								locatorEle.addAttribute("type", eObject.getString("type").toString());
//							}if (eObject.getString("desc")!=null) {
//								locatorEle.addAttribute("desc", eObject.getString("desc").toString());
//							}if (eObject.getString("value")!=null) {
//								locatorEle.addAttribute("value", eObject.getString("value").toString());
//							}
//							if (dObject.getString("value")!=null) {
//								locatorEle.setText(dObject.getString("value").toString());
//							}
//					}
//				}
//				
//			}else{
//				System.out.println("page不能为空");
//				return false;
//			}
//	
//	        //用于格式化xml内容和设置头部标签
//	        OutputFormat format = OutputFormat.createPrettyPrint();
//	        //设置xml文档的编码为utf-8
//	        format.setEncoding("utf-8");
//	        Writer out;
//	        try {
//	            //创建一个输出流对象
//	            out = new FileWriter(System.getProperty("user.dir")+"//new.xml");
//	            //创建一个dom4j创建xml的对象
//	            XMLWriter writer = new XMLWriter(out, format);
//	            //调用write方法将doc文档写到指定路径
//	            writer.write(doc);
//	            writer.close();
//	            System.out.print("生成XML文件成功");
//	        } catch (IOException e) {
//	            System.out.print("生成XML文件失败");
//	            e.printStackTrace();
//	        }
//			return false;
//	    }
//	 public static void main(String[] args) {    
//		 String abc ="{\"map\": {\"page\": {\"attribute\": {\"pageName\": \"loginPage\" }";
//		 abc=abc+"},\"locator\": [{\"attribute\": { \"desc\": \"xpath\", \"type\": \"xpath\",\"value\":\"//a[input]\"},\"value\": \"123\"},{\"attribute\": { \"desc\": \"xpath\", \"type\": \"xpath\",\"value\":\"//a[input]\"},\"value\": \"123\"}]}}";
//		 JSONObject aObject=JSONObject.parseObject(abc);
//		 
////		 String abd="{\"pageName\":\"loginPage\"}";
////		 JSONObject abObject=JSONObject.parseObject(abd);
////		 System.out.println(abObject.get("desc")!=null);
////		 
//		 Atest atest=new Atest();
//
//System.out.println(System.getProperty("user.dir"));
//		atest.testCreateXml(aObject);
//		 
//		// System.out.println( aObject.entrySet());
////		 		JSONObject bObject=JSONObject.parseObject(aObject.get("map").toString());
////		 		System.out.println(bObject);
////		 		JSONArray cObject=JSONObject.parseArray(bObject.get("locator").toString());
////				 System.out.println(cObject);
////				 System.out.println(cObject.size());
////				 System.out.println(cObject.get(0).toString());
////		
//			 
//	
//		
//		 
////		 System.out.println(aObject.get("map"));
//////		 for (JSONObject entry : aObject.entrySet()) {  
//////			    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
//////			  
//////			}  
////		 JSONObject bObject=JSONObject.parseObject(aObject.get("map").toString());
////		 System.out.println(bObject.get("page"));
////		 JSONObject cObject=JSONObject.parseObject(bObject.get("page").toString());
////		 System.out.println(cObject.get("attribute"));
////		 System.out.println(cObject.get("value"));
//		 
// 	 }
//	 
//	 
//	 
//}
