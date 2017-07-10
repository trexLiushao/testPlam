<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rt_用例管理</title>
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
					<th>系统名字</th>
					<td><select id="cc" class="easyui-combobox" name="tc_sysId"
						style="width: 160px;">
					</select></td>
				</tr>
				<tr>
					<th>接口名称</th>
					<td><input id="tc_interfaceId"
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
		<a href="javascript:openAddTestcase()" class="easyui-linkbutton"
			data-option="iconCls:'icon-add',plain:'true'">新增</a> <a
			href="javascript:editTestcase()" class="easyui-linkbutton"
			data-option="iconCls:'icon-edit',plain:'true'">修改</a> <a
			href="javascript:removeTestcase()" class="easyui-linkbutton"
			data-option="iconCls:'icon-remove',plain:'true'">删除</a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 640px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">
			<h3>添加用例</h3>
		</div>
		<form id="fm" method="post" novalidate>
			<div >
				<table>
					<tr>
						<td align="right">应用程序</td>
						<td><select id="dd" class="easyui-combobox" name="tc_sysId"
							required="true" style="width: 160px;" editable="false">
						</select></td>
						<td align="right">接口名称</td>
						<td><select id="ee" class="easyui-combobox"
							name="tc_interfaceId" required="true" style="width: 160px;"
							editable="false">
						</select></td>
					</tr>
					<tr>
						<td align="right">用例描述</td>
						<td><input name="tc_tcdesc" data-options="multiline:true"
							required="true" style="width: 160px; height: 40px"></input></td>
						<td align="right">用例级别</td>
						<td><select id="levelCase" class="easyui-combobox"
							name="tc_caseLevel" required="true" style="width: 160px;"
							editable="false">
								<option value="P1">P1</option>
								<option value="P2">P2</option>
								<option value="P3">P3</option>
								<option value="P4">P4</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="4" align="right">
						<table id="ntt">

							</table>
						</td>
					</tr>

					<tr>
						<td align="right">依赖接口</td>
						<td><select id="ff" class="easyui-combobox"
							name="YesOrNot" style="width: 160px;" editable="false">
						</select></td>
						<td align="right">父接口名</td>
						<td id="yincang" style="display: none;"><select id="gg"
							name="tcsuperid"  style="width: 160px;"
							editable="false">
						</select></td>
					</tr>
					<tr>
						<td align="right">期望结果</td>
						<td colspan="3"><input name="tc_exptData"
							data-options="multiline:true" required="true"
							style="width: 390px; height: 60px"></td>
					</tr>
					<tr>
						<td align="right">校验数据库</td>
						<td><select id="valDb" class="easyui-combobox"
							name="tc_valDb" style="width: 160px;" editable="false">
						</select></td>
						<td align="right">数据库语句</td>
						<td id="yincangdb" style="display: none;"><input
							name="tc_sqlyuju" data-options="multiline:true" required="true"
							style="width: 160px; height: 60px"></td>
					</tr>
					<tr id="yincangdbRs" style="display: none;">
						<td align="right">DB期望结果</td>
						<td colspan="3"><input name="tc_sqlexptData"
							data-options="multiline:true" required="true"
							style="width: 390px; height: 60px"></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:saveTestCase()" class="easyui-linkbutton"iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">返回</a>
	</div>

</body>
<script type="text/javascript">
var url;
function editTestcase(){
	var selectedRows = $("#tt").datagrid("getSelections");
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
    $("#fm").form("load", row);
 	url = "/SSMiframe/editTestCase?id="+id;
}

function openAddTestcase() {
    $("#dlg").dialog("open").dialog("setTitle", "新增用例信息");
    $('#fm').form('clear');
    url="/SSMiframe/saveTestCase";
}
function saveTestCase(){
	alert("3324");
	alert(url);
    $("#fm").form("submit", {
        url:url,
        success : function(result) {
        	alert(result);
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

function removeTestcase(){
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
                $.post("removeTestcase", {
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



//datagrid加载数据
$(function (){
	$('#tt').datagrid({
		url:'/SSMiframe/showTestcasePage',
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
		    	 title:'系统管理的id',
		    	 field:'tc_sysId',
		    	 width:100
		     } ,
		     {
		    	 title:'id',
		    	 field:'id',
		    	 width:100,
		    	 hidden:true
		     } ,{
		    	 title:'接口id',
		    	 field:'tc_interfaceId',
		    	 width:100
		     } ,
		     {
		    	 title:'父接口id',
		    	 field:'tc_supInterId',
		    	 width:100
		     } , {
		    	 title:'参数数据',
		    	 field:'tc_inputData',
		    	 width:100
		     } , {
		    	 title:'期望结果',
		    	 field:'tc_exptData',
		    	 width:100
		     }  , {
		    	 title:'用例级别',
		    	 field:'tc_caseLevel',
		    	 width:100
		     } , {
		    	 title:'检查数据库',
		    	 field:'tc_valDb',
		    	 width:100
		     } , {
		    	 title:'需要检查的数据库语句',
		    	 field:'tc_sqlyuju',
		    	 width:100
		     } , {
		    	 title:'sql语句期望结果',
		    	 field:'tc_sqlexptData',
		    	 width:100
		     } , {
		    	 title:'用例的描述',
		    	 field:'tc_tcdesc',
		    	 width:100
		     } 
		]]
	});
	
});



$(function(){  
    var sysNameId = $('#dd').combobox({  
        url:'/SSMiframe/getAllSysName',  
        editable:false,  
        valueField:'smg_id',
        textField:'smg_sysName', 
        panelHeight:'auto',
        editable:false,//不可输入
        onSelect:function(record){  
            //刷新数据，重新读取该系统下的接口列表，并清空当前输入的值  
            InterfaceId.combobox({  
                disabled:false,  
                url:'/SSMiframe/getAllItByName?itf_smgId='+record.smg_id,  
                valueField:'id',  
                textField:'name'  
            }).combobox('clear');  
            $('#gg').combobox({  
                disabled:false,  
                url:'/SSMiframe/getAllItByName?itf_smgId='+record.smg_id,  
                valueField:'id',  
                textField:'name'  
            }).combobox('clear'); 
        }  
    });  
    var InterfaceId = $('#ee').combobox({  
        disabled:true,  
        url:'/SSMiframe/getAllItByName?itf_smgId='+sysNameId.val(),  
        valueField:'id',  
        textField:'name',
        onSelect:function(record){
			    $('#ntt').datagrid({
			    	url:'/SSMiframe/getParamValue?id='+record.id,
			    	rownumbers: true,
					pagination:true,//分页
					pageSize:10,
					pageList:[10,20,30,40],
					fitColumns:true,//列表自适应填满，false时变窄时会有滚动条，当列不是很多时可以使用
					nowarp:false,//文本自动换行，true时不会看全文本
					idFeild:'id',
					loadMsg: '正在拼命加载,请稍后...',
					sortable:true,//列排序
			        columns:[[
			        {field:'paramID',title:'参数名称'},
			        { title:'参数值',
				    	 field:'tc_inputData',
				    	 width:100,
				    	 formatter:function(value){
				    		   return '<input name="tc_inputData" type="text" value="'+value+'">'
				    		}}
			        ]]		
        	});
        }
    });  
	
 var isSuperTrue = $('#ff').combobox({  
        url:'',  
        valueField:'id',
        textField:'name', 
        panelHeight:'auto',
        editable:false,//不可输入
		data:[{
			id: '是',
			name: '是'
		},{
			id: '否',
			name: '否'
		}],
        onSelect:function(record){  
            //刷新数据，重新读取该系统下的接口列表，并清空当前输入的值  
            if(record.id=='是'){
               	$('#yincang').show();
               	
            }else{
            	$('#yincang').hide();
            	  $('#gg').combobox({  
                      disabled:false,  
                      url:'',  
                      valueField:'id',  
                      textField:'name',
                      data: [{
                    	  id: 'id',
                    	  name: 0
              			}]
                 
                  }).combobox('clear'); 
            }
        }  
    }); 
	
var valDb= $('#valDb').combobox({  
     url:'',  
     valueField:'dbid',
     textField:'dbname', 
     panelHeight:'auto',
     editable:false,//不可输入
		data:[{
			dbid: '是',
			dbname: '是'
		},{
			dbid: '否',
			dbname: '否'
		}],
        onSelect:function(record){  
            //刷新数据，重新读取该系统下的接口列表，并清空当前输入的值  
            if(record.dbid=='是'){
            	//用上面的.css样式会改变
            	$('#yincangdbRs').show();
            	$('#yincangdb').show(); 
            }else{
            	//用上面的.css样式会改变
            	$('#yincangdb').hide();
            	$('#yincangdbRs').hide();
            }
            $('#gg').combobox({  
				valueField:'id',  
				textField:'name'
            }).combobox('clear'); 
		
        }  
 
 });
 
});



</script>
</html>