<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rt_接口管理</title>
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
	<div id="tb" style="padding: 3px" >
		<form id="searchForm">
			<table>
				<tr>
					<!--这个怎么通过itf_smgid获取到smg_sysName  -->
					<th>系统名字</th>
					<td>
					    <select id="cc" class="easyui-combobox" name="itf_smgid"  style="width:160px;">
		    			</select>
					</td>
				</tr>
				<tr>
					<th>接口名称</th>
					<td><input id="itf_interfaceName" style="line-height: 26px; border: 1px solid #ccc" /></td>
				</tr>
				<tr>
					<td><a href="javascript:searchInterface()" class="easyui-linkbutton" data-option="plain:true">查找</a></td>
					<td><a href="javascript:resetValue()" class="easyui-linkbutton" data-option="plain:true">清空</a></td>
				</tr>
				
			</table>
		</form>
	</div>
	<table id="tt" >
 	
	</table>
	<div id="toolbar">
		<a href="javascript:openAddInterface()" class="easyui-linkbutton" data-option="iconCls:'icon-add',plain:'true'" >新增</a>
        <a href="javascript:editInterface()" class="easyui-linkbutton" data-option="iconCls:'icon-edit',plain:'true'" >修改</a>
        <a href="javascript:removeInterface()" class="easyui-linkbutton" data-option="iconCls:'icon-remove',plain:'true'" >删除</a>
	</div>
	 <div id="dlg" class="easyui-dialog" style="width:600px;height:400px;padding:10px 20px" 
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle"><h3>添加接口</h3></div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
            <table>
            	<tr>
	  				<td align="right">应用程序</td>
	  				<td><select id="dd" class="easyui-combobox" name="itf_smgId"  style="width:160px;">
		    			</select></td>
	  				<td align="right">接口名称</td>
	  				<td><input class="easyui-textbox" name="itf_interfaceName" required="true"/></td>
	  			</tr>
	  			<tr>
	  				<td align="right">请求协议</td>
	  				<td>
	  					<select  class="easyui-combobox" name="itf_interfaceProt" style="width:160px;" editable="false">
						<option value="Http" selected>Http</option>
						<option value="Https">Https</option>
						</select>
	  				</td>
	  				<td align="right">请求方式</td>
	  				<td><select  class="easyui-combobox" name="itf_interfaceType" style="width:160px;"  editable="false">
						<option value="post" selected>post</option>
						<option value="get">get</option>
					</select></td>
	  			</tr>
	  			 <tr>
	  				 <td align="right">接口路径</td>
	  				<td><input class="easyui-textbox" name="itf_interfaceUrl" required="true"/></td>
	  				<td align="right">接口参数</td>
	  				<td><input class="easyui-textbox" name="itf_interfaceParam"  data-options="prompt:'多个参数间用,分开'"/></span></td>
	  				
	  			</tr>
	  			 <tr>
	  				<td align="right">参数类型</td>
	  				<td><select  class="easyui-combobox" name="itf_interfaceParaType" style="width:160px;" editable="false">
						<option value="普通" selected>普通</option>
						<option value="json">json</option>
						</select></td>
	  				<td align="right">接口描述</td>
	  				<td><input name="itf_interfaceDesc"  data-options="multiline:true"  style="width:160px;height:40px"></input></td>
	  			</tr>
            </table>
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:saveInterface()" class="easyui-linkbutton" iconCls="icon-ok" >保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">返回</a>
    </div>

</body>
<script type="text/javascript">
var id;
var url;
function editInterface(){
	var selectedRows = $("#tt").datagrid("getSelections");
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var id=selectedRows[0].id;
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑接口信息");
    $("#fm").form("load", row);
    url = "/SSMiframe/editInterface?id="+id;
}

function openAddInterface() {
    $("#dlg").dialog("open").dialog("setTitle", "新增接口信息");
    $('#fm').form('clear');
    url="/SSMiframe/saveInterface";
}
function saveInterface(){
	
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


function removeInterface(){
    var selectedRows = $("#tt").datagrid("getSelections");
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].id);
        }
        var ids = strIds.join(",");
        $.messager.confirm("系统提示", "您确定要删除这<font color=red>"
                + selectedRows.length + "</font>条数据吗？", function(r) {
            if (r) {
                $.post("removeInterfaceInfo", {
                    ids : ids
                }, function(result) {
                    if (result.success) {
                        $.messager.alert("系统提示", "数据已成功删除！");
                        $("#tt").datagrid("reload");
                    } else {
                        $.messager.alert("系统提示", "数据删除失败，请联系系统管理员！");
                    }
                }, "json");
            }
        });
    }

function searchInterface() {
    $("#tt").datagrid('load', {
        "itf_smgid" : $("#itf_smgid").val()
    });
}

$('#cc').combobox({
	//textField:是下拉列表框里显的内容。
	//valueField是下拉列表框选中的值。
	url:"/SSMiframe/getAllSysName",
    valueField:'smg_id',
    textField:'smg_sysName',
    panelHeight:'auto',
    editable:false//不可输入
});
/* */
$('#dd').combobox({
	//textField:是下拉列表框里显的内容。
	//valueField是下拉列表框选中的值。
	url:"/SSMiframe/getAllSysName",
    valueField:'smg_id',
    textField:'smg_sysName',
    panelHeight:'auto',
    editable:false//不可输入
});
 
 
 
//datagrid加载数据
$(function (){
	$('#tt').datagrid({
		url:'/SSMiframe/showInterfacePage',
		title:'',
		iconCls:'icon-save',
		rownumbers: true,
		pagination:true,//分页
		pageSize:10,
		pageList:[10,20,30,40],
		fitColumns:true,//列表自适应填满，false时变窄时会有滚动条，当列不是很多时可以使用
		nowarp:false,//文本自动换行，true时不会看全文本
		idFeild:'id',
		loadMsg: '正在拼命加载,请稍后...',
		sortable:true,//列排序
		toolbar:'#toolbar',
		columns:[[
		     {
		    	 title:'应用程序名称',
		    	 field:'smg_sysName',
		    	 width:100
		     } , {
		    	 title:'id',
		    	 field:'id',
		    	 width:100,
		     } ,
		     {
		    	 title:'接口名称',
		    	 field:'itf_interfaceName',
		    	 width:100
		     } , {
		    	 title:'接口协议',
		    	 field:'itf_interfaceProt',
		    	 width:100
		     } , {
		    	 title:'接口路径',
		    	 field:'itf_interfaceUrl',
		    	 width:100
		     }  , {
		    	 title:'参数值字段',
		    	 field:'itf_interfaceParam',
		    	 width:100
		     } , {
		    	 title:'接口方法',
		    	 field:'itf_interfaceMethod',
		    	 width:100
		     } , {
		    	 title:'参数类型',
		    	 field:'itf_interfaceParaType',
		    	 width:100
		     } , {
		    	 title:'请求方式',
		    	 field:'itf_interfaceType',
		    	 width:100
		     } , {
		    	 title:'接口描述',
		    	 field:'itf_interfaceDesc',
		    	 width:100
		     } 
		]]
	});
	
});


</script>
</html>