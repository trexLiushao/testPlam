<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rt_element manager</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyUi/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyUi/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyUi/themes/color.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyUi/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyUi/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
	<div id="tb"  style="padding: 3px">
		<form id="searchForm">
			<table>
				<tr>
					<th>page name:</th>
					<td><input id="kw_pageName" style="line-height: 26px; border: 1px solid #ccc" /></td>
						<td><a href="javascript:searchKw()" class="easyui-linkbutton" data-option="plain:true">查找</a>
						<a href="javascript:resetValue()" class="easyui-linkbutton" data-option="plain:true">清空</a></td>
				</tr>
			</table>
		</form>
	</div>
	<table  id="tt" >
	</table>
		<div id="toolbar" class="easyui-layout">
	    <a href="javascript:openAddElement()" class="easyui-linkbutton" data-option="iconCls:'icon-add',plain:'true'" >新增</a>
        <a href="javascript:editPage()" class="easyui-linkbutton" data-option="iconCls:'icon-edit',plain:'true'" >修改</a>
        <a href="javascript:removePage()" class="easyui-linkbutton" data-option="iconCls:'icon-remove',plain:'true'" >删除</a>
	</div>
	
	<!-- 新增element页面 -->
	 <div id="dlg" class="easyui-dialog" style="width:600px;height:350px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle"><h3>添加Element元素</h3></div>
        <form id="fm" method="post" novalidate>
            <div>
	            <table>
	            
	            	<tr>
	            		<td align="right">所属页面:</td>
		  				<td><select id="cc" class="easyui-combobox" name="pageId"  style="width:160px;">
		    			</select></td>
		  				<td align="right">元素名称:</td>
		  				<td><input class="easyui-textbox" name="elementName" required="true"/></td>
	            	</tr>
	            	<tr>
		  				<td align="right">元素值:</td>
		  				<td><input class="easyui-textbox" name="elementXpath" required="true"/></td>
		  				<td align="right">元素描述:</td>
		  				<td><input class="easyui-textbox" name="elementDesc" required="true"/></td>
		  			</tr>
		  			
		  			
		  			
	            </table>
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" onclick="saveElement()" >保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">返回</a>
    </div>
	
	
	
</body>
<script type="text/javascript">
var url;
var smg_id;
//datagrid加载数据
$(function (){
	$('#tt').datagrid({
		url:'/SSMiframe/getAllElement',
		title:'',
		iconCls:'icon-save',
		rownumbers: true,
		pagination:true,//分页
		pageSize:10,
		pageList:[10,20,30,40],
		fitColumns:true,//列表自适应填满，false时变窄时会有滚动条，当列不是很多时可以使用
		nowarp:false,//文本自动换行，true时不会看全文本
		idFeild:'id',
		sortable:true,//列排序
		toolbar:'#toolbar',
		columns:[[
		     {
		    	 title:'元素名称',
		    	 field:'elementName',
		    	 width:100
		     },
		     {
		    	 title:'元素值',
		    	 field:'elementXpath',
		    	 width:100
		     },
		     {
		    	 title:'元素描述',
		    	 field:'elementDesc',
		    	 width:100
		     },
		     {
		    	 title:'所属页面',
		    	 field:'pageName',
		    	 width:100
		     },
		     {
		    	 title:'页面ID',
		    	 field:'id',
		    	 width:100,
		    	 hidden:true
		     }
		]]

	});
});
function searchKw() {
    $("#tt").datagrid('load', {
        "pagename" : $("#pagename").val(),
    });
}
function resetValue() {
    $("#kw_pageName").val("");

}

function openAddElement() {
    $("#dlg").dialog("open").dialog("setTitle", "新增页面元素");
    $('#fm').form('clear');
    url="/SSMiframe/saveElement";
    $('#cc').combobox({
    	//textField:是下拉列表框里显的内容。
    	//valueField是下拉列表框选中的值。
    	url:"/SSMiframe/getAllPage?page=1&rows=10",
        valueField:'pageID',
        textField:'pageName',
        panelHeight:'auto',
        editable:false//不可输入
    });
}
function saveElement(){
    $("#fm").form("submit", {
        url : url,
        success : function(result) {
        	 var result = eval('(' + result + ')');
            if (result.success) {
                $.messager.alert("系统提示", "保存成功！");
                $("#dlg").dialog("close");
                $("#tt").datagrid("reload");
            } else {
                $.messager.alert("系统提示", "保存失败！");
                return;
            }
        }
    });
}

</script>
</html>