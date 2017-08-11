//package com.lwlsh.trex.util;
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
//import com.lwlsh.trex.controller.Atest;
//
///**
// * json生成xml文件
// * @author Administrator
// *
// */
//public class ElementUtil {
//	 public boolean createXml(JSONObject object) {
//		 //用來保存名字xml
//		 String xmlName="";
//	        //创建一个xml文档
//	        Document doc = DocumentHelper.createDocument();
//	        //向xml文件中添加注释
//	        doc.addComment("管理一个页面的元素（webelement：input,select,textare,a,li等标签），一个page包含多个locator对象Pagename:page对象名字(填写的是包名下的对应类).HomePageValue：页面对象的URL，可不填。 Desc:页面对象中文描述");
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
//						xmlName=dObject.getString("pageName").toString();
//						String pageName="com.lwlsh.trex.webdriver."+dObject.getString("pageName").toString();
//						pageEle.addAttribute("pageName", pageName);
//					}if (dObject.getString("desc")!=null) {
//						pageEle.addAttribute("desc", dObject.getString("dessc").toString());
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
//	            out = new FileWriter(System.getProperty("user.dir")+"//"+xmlName+".xml");
//	            //创建一个dom4j创建xml的对象
//	            XMLWriter writer = new XMLWriter(out, format);
//	            //调用write方法将doc文档写到指定路径
//	            writer.write(doc);
//	            writer.close();
//	            System.out.print("生成XML文件成功");
//	        } catch (IOException e) {
//	            System.out.print("生成XML文件失败");
//	            e.printStackTrace();
//	            return false;
//	        }
//			return true;
//	    }
//
//	 
//	 public static void main(String[] args) {    
//		 String abc ="{\"map\": {\"page\": {\"attribute\": {\"pageName\": \"loginPage\" }";
//		 abc=abc+"},\"locator\": [{\"attribute\": { \"desc\": \"xpath\", \"type\": \"xpath\",\"value\":\"//a[input]\"},\"value\": \"123\"},{\"attribute\": { \"desc\": \"xpath\", \"type\": \"xpath\",\"value\":\"//a[input]\"},\"value\": \"123\"}]}}";
//		 JSONObject aObject=JSONObject.parseObject(abc);
//		 
////		 String abd="{\"pageName\":\"loginPage\"}";
////		 JSONObject abObject=JSONObject.parseObject(abd);
////		 System.out.println(abObject.get("desc")!=null);
////		 
//		 ElementUtil elementUtil=new ElementUtil();
//		 elementUtil.createXml(aObject);
//		}
//}
