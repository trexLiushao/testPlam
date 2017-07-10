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
					<th>系统名字</th>
					<td><input id="smg_sysName" style="line-height: 26px; border: 1px solid #ccc" /></td>
				</tr>
				<tr>
					<th>系统类型</th>
					<td><input id="smg_type" style="line-height: 26px; border: 1px solid #ccc" /></td>
					<td>	<a href="javascript:searchHost()" class="easyui-linkbutton" data-option="plain:true">查找</a>
						<a href="javascript:resetValue()" class="easyui-linkbutton" data-option="plain:true">清空</a></td>
				</tr>
			
				
			</table>
		</form>
	</div>
	<table  id="tt" >
	</table>
	<div id="toolbar" class="easyui-layout">
	    <a href="javascript:openAddHost()" class="easyui-linkbutton" data-option="iconCls:'icon-add',plain:'true'" >新增</a>
        <a href="javascript:editHost()" class="easyui-linkbutton" data-option="iconCls:'icon-edit',plain:'true'" >修改</a>
        <a href="javascript:removeHost()" class="easyui-linkbutton" data-option="iconCls:'icon-remove',plain:'true'" >删除</a>
	</div>
	 <div id="dlg" class="easyui-dialog" style="width:600px;height:350px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle"><h3>添加主机</h3></div>
        <form id="fm" method="post" novalidate>
            <div>
	            <table>
	            	<tr>
		  				<td align="right">主机IP</td>
		  				<td><input class="easyui-textbox" name="smg_hostIP" required="true"/></td>
		  				<td align="right">端口号</td>
		  				<td><input class="easyui-textbox" name="smg_hostPort" required="true"/></td>
		  			</tr>
		  			<tr>
		  				<td align="right">状态</td>
		  				<td>
		  					<select  class="easyui-combobox" name="smg_status" style="width:160px">
							<option value="可用" selected>可用</option>
							<option value="不可用">不可用</option>
							</select>
		  				</td>
		  				<td align="right">类型</td>
		  				<td><select  class="easyui-combobox" name="smg_type" style="width:160px">
							<option value="应用程序" selected>应用程序</option>
							<option value="数据">数据库</option>
							<option value="App">App</option>
						</select></td>
		  			</tr>
		  			 <tr>
		  				<td align="right">系统名字</td>
		  				<td><input class="easyui-textbox" name="smg_sysName" required="true"/></td>
		  				<td align="right">db名</td>
		  				<td><input class="easyui-textbox" name="smg_dbName" required="true" /></td>
		  			</tr>
		  			 <tr>
		  				<td align="right">账号</td>
		  				<td><input class="easyui-textbox" name="smg_dbAnt" required="true"/></td>
		  				<td align="right">密码</td>
		  				<td><input class="easyui-textbox"  name="smg_dbPwd" required="true"/></td>
		  			</tr>
		  			<tr>
		  				<td align="right">描述</td>
		  				<td colspan="3"><input name="smg_desc"  data-options="multiline:true"  style="width:300px;height:100px"></input>
		  			</tr>
	            
	            </table>
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" onclick="saveHost()" >保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">返回</a>
    </div>

</body>
<script type="text/javascript">
var url;
var smg_id;
//datagrid加载数据
$(function (){
	$('#tt').datagrid({
		url:'/SSMiframe/showDataPage',
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
		    	 title:'系统id',
		    	 field:'smg_id',
		    	 width:100
		     } ,
		     {
		    	 title:'主机地址',
		    	 field:'smg_hostIP',
		    	 width:100
		     } , {
		    	 title:'主机端口',
		    	 field:'smg_hostPort',
		    	 width:100
		     } , {
		    	 title:'db账号',
		    	 field:'smg_dbName',
		    	 width:100
		     }  , {
		    	 title:'数据库名',
		    	 field:'smg_dbAnt',
		    	 width:100
		     } , {
		    	 title:'系统描述',
		    	 field:'smg_desc',
		    	 width:100
		     } , {
		    	 title:'状态',
		    	 field:'smg_status',
		    	 width:100
		     } , {
		    	 title:'系统类型',
		    	 field:'smg_type',
		    	 width:100
		     } , {
		    	 title:'系统名字',
		    	 field:'smg_sysName',
		    	 width:100
		     },{
		    	 title:'数据库密码',
		    	 field:'smg_dbPwd',
		    	 width:100,
		    	 hidden:true
		     }
		]]
	});
	
});
function searchHost() {
    $("#tt").datagrid('load', {
        "smg_sysName" : $("#smg_sysName").val(),
        "smg_type":$("#smg_type").val()
    });
}

function resetValue() {
    $("#smg_sysName").val("");
    $("#smg_type").val("");
}

function editHost(){
	var selectedRows = $("#tt").datagrid("getSelections");
	smg_id=selectedRows[0].smg_id;
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
    $("#fm").form("load", row);
    url = "/SSMiframe/editHost?smg_id="+smg_id;
}

function openAddHost() {
    $("#dlg").dialog("open").dialog("setTitle", "新增主机信息");
    $('#fm').form('clear');
    url="/SSMiframe/saveHost";
}
function saveHost(){
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


function removeHost(){
    var selectedRows = $("#tt").datagrid("getSelections");
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].smg_id);
        }
        var ids = strIds.join(",");
        $.messager.confirm("系统提示", "您确定要删除这<font color=red>"
                + selectedRows.length + "</font>条数据吗？", function(r) {
            if (r) {
                $.post("removeHost", {
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
</script>
</html>