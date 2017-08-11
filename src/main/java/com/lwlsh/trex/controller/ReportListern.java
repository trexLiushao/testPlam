package com.lwlsh.trex.controller;

import com.lwlsh.trex.util.Log;

public class ReportListern {
	Log log=new Log(this.getClass());
	//记录html结果
	StringBuffer sb = new StringBuffer();
	String reportTitle="";
	
	
	/*
	 * 
	 * 标题头设置
	 */
	public void headHtml(String reportTitle){
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n");
		sb.append("<meta http-equiv=\"Content-Type\"content=\"text/html; charset=utf-8\" />\n");
		sb.append("<title>" +reportTitle +"</title>\n");
		sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"${pageContext.request.contextPath}/easyUi/themes/default/easyui.css\">\n");
		sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"${pageContext.request.contextPath}/easyUi/themes/icon.css\">\n");	
	    sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"${pageContext.request.contextPath}/easyUi/themes/color.css\">\n");		
	    sb.append("<script type=\"text/javascript\"  src=\"${pageContext.request.contextPath}/easyUi/jquery-1.7.2.min.js\"></script>\n");			
	    sb.append("<script type=\"text/javascript\" src=\"${pageContext.request.contextPath}/easyUi/jquery.easyui.min.js\"></script>\n");		
	    sb.append("<script type=\"text/javascript\" src=\"${pageContext.request.contextPath}/easyUi/echarts.common.min.js\"></script>\n");		
	    sb.append("<script type=\"text/javascript\" src=\"${pageContext.request.contextPath}/easyUi/locale/easyui-lang-zh_CN.js\"></script>\n");		
		sb.append("</head>\n");
		sb.append("<body>\n");
		sb.append("<h1>" +reportTitle +"</hl>");
		sb.append("	<table  id=\"tt\" style=\"width:auto;  height: auto; padding: 5px\" ></table>\n");
		sb.append("</body>\n");
		this.jscriptHtml();
	}
	
	
	public void jscriptHtml(){
		
		
	}

	
	
	
	

}
