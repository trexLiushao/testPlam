package com.lwlsh.trex.util;

/**
 * html工具类
 * 
 * @author Administrator
 *
 */
public class HtmlUtil {

	public static String  htmlHead="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<meta http-equiv=\"Content-Type\"content=\"text/html; charset=utf-8\" />\n<title>提示</title></head><body><fieldset style=\"width:220px;\"><legend>结果信息</legend>";
			
	public static String htmlEnd="</fieldset></body>";

	public  String  bodyhtml(String expectResult,String expectDbResult){
		String bodyValue="<table>";
		bodyValue=bodyValue+"<tr><th align=\"right\">预期结果</th><td>"+expectResult+"</td></tr>";
		if (expectDbResult!=null) {
			bodyValue=bodyValue+"<tr><th align=\"right\">db预期结果</th><td>"+expectDbResult+"</td></tr>";
		}
//		if (actualResult!=null) {
//			bodyValue=bodyValue+"<tr><th align=\"right\">db实际结果</th><td>"+actualResult+"</td></tr>";
//		}
//		if (errorLog!=null) {
//			bodyValue=bodyValue+"<tr><th align=\"right\">错误结果</th><td>"+errorLog+"</td></tr>";
//		}
		return htmlHead+bodyValue+htmlEnd;
	}
}
