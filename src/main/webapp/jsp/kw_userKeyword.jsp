<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rt_主机管理</title>
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
					<th>userkey word:</th>
					<td><input id="ky_userky" style="line-height: 26px; border: 1px solid #ccc" /></td>
						<td><a href="javascript:searchKw()" class="easyui-linkbutton" data-option="plain:true">查找</a>
						<a href="javascript:resetValue()" class="easyui-linkbutton" data-option="plain:true">清空</a></td>
				</tr>
			</table>
		</form>
	</div>
	<table  id="tt" >
	</table>
</body>
<script type="text/javascript">
var url;
var smg_id;
//datagrid加载数据
$(function (){
	$('#tt').datagrid({
		url:'/SSMiframe/getAllkeyword',
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
		    	 title:'关键字',
		    	 field:'keyword_name',
		    	 width:100
		     } ,{
		    	 title:'中文值',
		    	 field:'keyword_value',
		    	 width:100
		     } ,
		     
		]]
	});
	
});
function searchKw() {
    $("#tt").datagrid('load', {
        "smg_sysName" : $("#smg_sysName").val(),
        "smg_type":$("#smg_type").val()
    });
}

function resetValue() {
    $("#ky_userky").val("");

}
</script>
</html>