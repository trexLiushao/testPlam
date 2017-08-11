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
  <div id="#inrtoolbar" class="easyui-layout">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#simpleDgId').edatagrid('addRow')">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#simpleDgId').edatagrid('destroyRow')">删除</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#simpleDgId').edatagrid('saveRow')">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#simpleDgId').edatagrid('cancelRow')">取消</a>
    </div>    
    <table id="simpleDgId" title="用户列表"  class="easyui-datagrid" style="width:300px;height:350px;padding:10px 20px" toolbar="#inrtoolbar" idField="id" rownumbers="true" fitColumns="true" singleSelect="true">   
        <thead>
            <tr>
          	 <th field="id" width="100">ID</th>
 			 <th field="testId" width="100" editor="{type:'validatebox',options:{required:true}}">用例ID</th>
             <th field="teststep" width="100" editor="{type:'validatebox',options:{required:true}}">操作步骤</th>
             <th field="tcdesc" width="100" editor="{type:'validatebox'}">用例描述</th>
              <th data-options="field:'pageName',width:50,
						formatter:function(value,row){
							return row.pageName;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'pageName',
								textField:'pageName',
								method:'get',
								url:'getAllPage?page=1&rows=500',
								required:true,
								onSelect:function(data){ 
								   var row = $('#simpleDgId').datagrid('getSelected');  
								   var rowIndex = $('#simpleDgId').datagrid('getRowIndex',row);//获取行号 
								   var thisTarget = $('#simpleDgId').datagrid('getEditor', {'index':rowIndex,'field':'pageName'}).target; 
								    console.info(thisTarget);
								    console.info(data);
								    
								   var value = thisTarget.combobox('getText');
								   
								   var target = $('#simpleDgId').datagrid('getEditor', {'index':rowIndex,'field':'elementXpath'}).target; 
								   target.combobox('clear'); //清除原来的数据  
								   var url = 'getElementById?pageId='+data.pageID;  
                                   target.combobox('reload', url);//联动下拉列表重载  
								 }
							}
						}">页面选择</th>
						<th field="elementType" editor="{  
    type:'combobox',   
    options:{ 
        data:[   
            {'value':'xpath','text':'xpath'}, 
            {'value':'Id','text':'Id'} ,
             {'value':'name','text':'name'} ,
              {'value':'Id','text':'CLASSNAME'} ,
             {'value':'CSS','text':'CSS'} ,
             {'value':'LINK','text':'LINK'} ,
             {'value':'PARTIALLINK','text':'PARTIALLINK'}
        ], 
    valueField:'text',   
    textField:'text'}}">元素定位类型</th>
						   <th data-options="field:'elementXpath',width:50,
						editor:{
							type:'combobox',
							options:{
								valueField:'elementXpath',
								textField:'elementDesc'
							}
						}">页面元素</th>
            
                    <th data-options="field:'keywordValue',width:50,
						formatter:function(value,row){
							return row.keywordValue;
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
						}">关键字选择</th>
             <th field="inputData" width="100" editor="{type:'validatebox'}">输入值</th>
            </tr>
        </thead>
    </table>
    
</body>
<script type="text/javascript">
var sortFlag = false;
$(function (){
	//隐藏id列，第二个参数时作用的域
	$("#simpleDgId").datagrid('hideColumn', 'id');
	  $('#simpleDgId').edatagrid({
	    	fitColumns:true,
	    	fit: false,
	    	pagination:true,//分页
	    	nowarp:false,//文本自动换行，true时不会看全文本
			url: '/SSMiframe/getAllTcase',
			saveUrl: '/SSMiframe/saveTcase',
			updateUrl: '/SSMiframe/udTcase',
			//destroyUrl里面已经自带id
			destroyUrl: '/SSMiframe/dTcase',
			onLoadSuccess: function(data){
			    	//调用方法，传参(datagrid的ID,要合并的commname列名);
			    	 $(this).datagrid("autoMergeCells", ['simpleDgId', 'testId']);
			    }
		
		});


});


//引用插件
$.extend($.fn.datagrid.methods, {
	autoMergeCells : function (jq, fields) {
		return jq.each(function () {
			var target = $(this);
			if (!fields) {
				fields = target.datagrid("getColumnFields");
			}
			var rows = target.datagrid("getRows");
			var i = 0,
			j = 0,
			temp = {};
			for (i; i < rows.length; i++) {
				var row = rows[i];
				j = 0;
				for (j; j < fields.length; j++) {
					var field = fields[j];
					var tf = temp[field];
					if (!tf) {
						tf = temp[field] = {};
						tf[row[field]] = [i];
					} else {
						var tfv = tf[row[field]];
						if (tfv) {
							tfv.push(i);
						} else {
							tfv = tf[row[field]] = [i];
						}
					}
				}
			}
			$.each(temp, function (field, colunm) {
				$.each(colunm, function () {
					var group = this;
					
					if (group.length > 1) {
						var before,
						after,
						megerIndex = group[0];
						for (var i = 0; i < group.length; i++) {
							before = group[i];
							after = group[i + 1];
							if (after && (after - before) == 1) {
								continue;
							}
							var rowspan = before - megerIndex + 1;
							if (rowspan > 1) {
								target.datagrid('mergeCells', {
									index : megerIndex,
									field : field,
									rowspan : rowspan
								});
							}
							if (after && (after - before) != 1) {
								megerIndex = after;
							}
						}
					}
				});
			});
		});
	}
});
</script>

</html>