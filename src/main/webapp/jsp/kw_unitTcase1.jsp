<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rt_page manager</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyUi/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyUi/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyUi/themes/color.css">
<%--可能是版本问题，用这些加载会出现错误，加载不出,用来加载edatagrid.js

 	<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyUi/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyUi/jquery.edatagrid.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyUi/locale/easyui-lang-zh_CN.js"></script> --%>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.edatagrid.js"></script>
</head>
<body>
<!-- <div id="dlg" class="easyui-dialog" style="width:600px;height:350px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
                 </div>  -->  
    <div id="#inrtoolbar" class="easyui-layout">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">取消</a>
    </div>    
       
 	<table id="dg" title="用户列表" data-options="onLoadSuccess:mergeCells"  class="easyui-datagrid" style="width:300px;height:350px;padding:10px 20px" toolbar="#inrtoolbar" idField="id" rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
            
                <th data-options="field:'testId',width:50,
						formatter:function(value,row){
							return row.testmodel;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'testId',
								textField:'testmodel',
								method:'get',
								url:'getAllTc?page=1&rows=500',
								required:true
							}
						}">用例模块</th>
                <th data-options="field:'pageID',width:50,
						formatter:function(value,row){
							return row.pageName;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'pageID',
								textField:'pageName',
								method:'get',
								url:'getAllPage?page=1&rows=500',
								required:true
							}
						}">页面选择</th>
						<!-- 这里元素要根据页面选择的值去获取，这里需要重新写个方法 -->
						   <th data-options="field:'pageID',width:50,
						formatter:function(value,row){
							return row.testmodel;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'testId',
								textField:'testmodel',
								method:'get',
								url:'getAllElement?page=1&rows=500',
								required:true
							}
						}">元素选择</th>
       <!--         extField:是下拉列表框里显的内容。
    			valueField是下拉列表框选中的值。 -->
              	<th data-options="field:'pageID',width:50,
						formatter:function(value,row){
							return row.keyword_name;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'keyword_name',
								textField:'keyword_value',
								method:'get',
								url:'getAllkeyword?page=1&rows=500',
								required:true
							}
						}">关键字</th> 
                <th field="pageqw" width="100" editor="{type:'validatebox',options:{required:true}}">输入值</th>
            </tr>
        </thead>
    </table>
 
</body>
 <script type="text/javascript">
 $(function (){
        	  $('#dg').edatagrid({
        	    	fitColumns:true,
        	    	fit: false,
        	    	nowarp:false,//文本自动换行，true时不会看全文本
        			url: '/SSMiframe/getAllTcase?page=1&rows=10',
        			saveUrl: '/SSMiframe/saveTcase',
        			updateUrl: '/SSMiframe/saveTcase',
        			destroyUrl: '/SSMiframe/getAllPage?page=4&rows=10',
        		
        		});

       
});
 
    </script>
</html>