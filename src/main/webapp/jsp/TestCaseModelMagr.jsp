<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rt_用例模块管理</title>
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
	<div id="tb" style="padding: 3px">
		<form id="searchForm">
			<table>
				<tr>
					<!--这个怎么通过itf_smgid获取到smg_sysName  -->
					<th>用例集名称:</th>
					<td><input id="tcm_name"
						style="line-height: 26px; border: 1px solid #ccc" /></td>
				</tr>
				<tr>
					<td><a href="javascript:searchTestcase()"
						class="easyui-linkbutton" data-option="plain:true">查找</a></td>
					<td><a href="javascript:resetValue()"
						class="easyui-linkbutton" data-option="plain:true">清空</a></td>
				</tr>

			</table>
		</form>
	</div>
	<table id="tt">

	</table>
	<div id="toolbar">
	   		<a href="javascript:openAddTcm()" class="easyui-linkbutton"
			data-option="iconCls:'icon-add',plain:'true'">新增</a> <a
			href="javascript:editTcModel()" class="easyui-linkbutton"
			data-option="iconCls:'icon-edit',plain:'true'">修改</a> <a
			href="javascript:removeTcModel()" class="easyui-linkbutton"
			data-option="iconCls:'icon-remove',plain:'true'">删除</a>
	</div>
	 <div id="dlg" class="easyui-dialog" style="width:600px;height:350px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle"><h3>添加用例模块</h3></div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
            <table>
	  			<tr>
	  				<td align="right" style="width:100px">用例模块名称</td>
	  				<td><input class="easyui-textbox"  name="tcm_name" required="true" style="width:160px"/></td>
	  				<td align="right" style="width:100px">用例模块描述</td>
	  				<td><input name="tcm_tcmDes" data-options="multiline:true" required="true" style="width: 160px; height: 60px"></td>
	  			</tr>
	  			<tr>
	  				<td align="right" style="width:100px">所属系统</td>
	  				<td><select id="cc" class="easyui-combobox" name="tcm_sysId"
						style="width: 160px;">
					</select></td>
	  			</tr>
            </table>
            </div>
        </form>
    </div>
 	<div id="dlg-buttons">
		<a href="javascript:saveTestCaseModel()" class="easyui-linkbutton"iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">返回</a>
	</div>
</body>
<script type="text/javascript">
var url;
function detail(id,tcm_name,tcm_sysid,tcmid){
	var content = '<iframe src="/SSMiframe/tcmPageShow?tcm_tcListId='+id+'&sysid='+tcm_sysid+'&tcmid='+tcmid+'" width="100%" height="99%" frameborder="0" scrolling="no"></iframe>';
    var divContent = '<div id="' + id + '">';
    var win = $('<div/>').dialog({
        content: content,
        width: 1200,
        height: 600,
        modal: true,
        title: tcm_name,
        closed: true,  
        onClose: function () {
            $(this).dialog('destroy');
        }
    });
    win.dialog('open');
}

function runCase(id){
	$.ajax({
		url:"/SSMiframe/runTestCase?runModeId="+id,
		data:$("#loginInputForm").serialize(),
		cache:false,
		dataType:'json',
		success:function(r){
			if(r&&r.success){//登录成功
				$.messager.alert('标题',r.message);
			}else{//登录失败，报错
				$.messager.alert('标题',r.message);
			}
		}
	});
}


function editTcModel(){
	var selectedRows = $("#tt").datagrid("getSelections");
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var id=selectedRows[0].id;
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑接口信息");
    $("#fm").form("load", row);
    url = "/SSMiframe/editTcModelInfo?id="+id;
}

function removeTcModel(){
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
                $.post("removeTestcaseModel", {
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


function openAddTcm() {
    $("#dlg").dialog("open").dialog("setTitle", "新增用例模块");
    $('#fm').form('clear');
    url="/SSMiframe/saveTestCaseModeInfo";
}

function saveTestCaseModel(){
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


//datagrid加载数据
$(function (){
	$('#tt').datagrid({
		url:'/SSMiframe/showTcModelPage',
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
				 title:'id',
				 field:'id',
				 width:100,
				 hidden:true
			 },{
		    	 title:'用例模块名称',
		    	 field:'tcm_name',
		    	 width:100
		     } , {
		    	 title:'用例模块描述',
		    	 field:'tcm_tcmDes',
		    	 width:100
		     },
		     {
		    	 title:'用例集合id',
		    	 field:'tcm_tcListId',
		    	 width:100,
		    	 hidden:true
		     },{
		    	 title:'所属系统',
		    	 field:'tcm_sysId',
		    	 width:100
		     } , {
		    	 title:'操作',
		    	 field:'nothing',
			     formatter:function(value,row){
			    	 		//这里不知道为什么只能传数字的，传字符串的就会报错
			    		 return '<a href=\"#\" onclick=\"detail(\''+row.tcm_tcListId+'\',\''+row.tcm_name+'\',\''+row.tcm_sysId+'\',\''+row.id+'\');\">添加用例</a>&nbsp;&nbsp;<a href=\"#\" onclick=\"runCase(' +row.id+ ');\">执行</a>'
			    		   //return  '<a style="color:blue" href="javascript:detail(+row.id+,row.tcm_name);">详情</a>&nbsp;&nbsp;&nbsp;&nbsp<a style="color:blue" href="javascript:runExe('+row.id+','+row.tcm_name+');">运行</a>'
			    		},
		    	 width:100
		     }
		]]
	});
	
});


$('#cc').combobox({
	//textField:是下拉列表框里显的内容。
	//valueField是下拉列表框选中的值。
	url:"/SSMiframe/getAllSysName",
    valueField:'smg_id',
    textField:'smg_sysName',
    panelHeight:'auto',
    editable:false//不可输入
});
</script>
</html>