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

	<table id="tt">

	</table>
	<div id="toolbar">
		<a href="javascript:openAddTestcase()" class="easyui-linkbutton"
			data-option="iconCls:'icon-add',plain:'true'">新增用例</a> <a
			href="javascript:removeTestcase()" class="easyui-linkbutton"
			data-option="iconCls:'icon-remove',plain:'true'">删除用例</a>
	</div>
	<div id="showTooltip">
	
	</div>
	
	
	<div id="dlg" class="easyui-dialog"
		style="width: 600px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">
			<h3>添加用例</h3>
		</div>
		<form id="searchForm">
			<table>
				<tr>
					<!--这个怎么通过itf_smgid获取到smg_sysName  -->
					<th>系统名字</th>
					<td><select id="cc" class="easyui-combobox" name="tc_sysId"
						style="width: 160px;" data-options="editable:false">
					</select></td>
				</tr>
				<tr>
					<th>接口名称</th>
					<td><select id="dd" class="easyui-combobox" name="tc_sysId"
						style="width: 160px;" data-options="editable:false">
					</select></td>
				</tr>
				<tr>
					<td><a href="javascript:searchTestcase()"
						class="easyui-linkbutton" data-option="plain:true">查找</a></td>
					<td><a href="javascript:resetValue()"
						class="easyui-linkbutton" data-option="plain:true">清空</a></td>
				</tr>
			</table>
		</form>
		<form id="dataFrom" method="post" novalidate>
			<table id="caseTT" >

			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:saveTestcase()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">返回</a>
	</div>

</body>
<script type="text/javascript">
var id;//用例id
var sysid;//系统id;
var tcmid;//用例模块的id
var url;



//用例单体执行
function Runone(tc_id){
	$.ajax({
		 type : "POST",
		 url : "/SSMiframe/runTcByOne?tc_id="+tc_id,
		 beforeSend: function () {
			    $.messager.progress({ 
			       title: '提示', 
			       msg: '用例执行中，请稍候……', 
			       text: '' 
			    });
			    },
		complete: function () {
			        $.messager.progress('close');
			    },
		success:function(r){
			 var r = eval('(' + r + ')');
			if(r&&r.success){//成功
				$.messager.alert('标题',r.message);
			}else{//失败，报错
				$.messager.alert('标题',r.message);
			
			}
		}
		});
	
}

function saveTestcase(){
	var selectedRows = $("#caseTT").datagrid("getSelections");
	   if (selectedRows.length == 0) {
           $.messager.alert("系统提示", "请选择要添加的用例!");
           return;
       }
	 var strIds = [];
	 for ( var i = 0; i < selectedRows.length; i++) {
	       strIds.push(selectedRows[i].id);
	     }
	 var ids = strIds.join(",");
   	 $("#dataFrom").form("submit", {
        url :'/SSMiframe/addTc?ids='+ids+'&tcmid='+tcmid+'&tcm_tcListId='+id,
        success : function(result) {
        	var result = eval('(' + result + ')');
            if (result.success) {
                $.messager.alert("系统提示", "添加成功!");
                $("#dlg").dialog("close");
                $('#tt').datagrid('reload');
            } else {
                $.messager.alert("系统提示", "添加失败！");
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
                $.post("delTestcaseByrun", {
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



function openAddTestcase() {
	 //id=GetQueryString("tcm_tcListId");
    $("#dlg").dialog("open").dialog("setTitle", "新增用例信息");
    $('#searchForm').form('clear');
	sysid=GetQueryString("sysid");
	//暂时只是显示id,后续才显示姓名
	 $('#cc').combobox('select',GetQueryString("sysid"));
	 $('#dd').combobox({
			//textField:是下拉列表框里显的内容。
			//valueField是下拉列表框选中的值。
			url:'/SSMiframe/getNameBySysid?sysid='+sysid,
		    valueField:'id',
		    textField:'itfName',
		    panelHeight:'auto',
		    editable:false//不可输入
		});
     $('#caseTT').datagrid({
    	url:'/SSMiframe/getRunCaseBySysid?sysid='+sysid+'&tcm_tcListId='+id,
    	title:'',
		iconCls:'icon-save',
		rownumbers: true,
		pagination:true,//分页
		pageSize:10,
		width: 600,
	    height: 400,
		pageList:[10,20,30,40],
		fitColumns:false,//列表自适应填满，false时变窄时会有滚动条，当列不是很多时可以使用
		nowarp:false,//文本自动换行，true时不会看全文本
		idFeild:'id',
		loadMsg: '正在拼命加载,请稍后...',
		sortable:true,//列排序
		columns:[[
		          {
				    	 title:'系统管理的id',
				    	 field:'tc_sysId',
				    	 width:100
				     } , {
				    	 title:'用例id',
				    	 field:'id',
				    	 width:100,
				 		hidden:true
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
     
     
}

//获取url里面的参数值
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
function seeCase(tc_id){
   	$.ajax({
		url:"/SSMiframe/yesTrue",
		success:function(r){
	        var result = eval('(' + r + ')');
			if(result&&result.success){//登录成功
				  $('#easyui-tooltip').tooltip({
					  position: 'left',
					  width:'300',
					  onShow: function (e) {
					 	$.ajax({
	    		    		url:"/SSMiframe/resultSeeOne?tc_id="+tc_id,
	    		    		success:function(b){
	    		    			alert(b);
	    		    	        var resultValue = eval('(' + b + ')');
	    						if(resultValue&&resultValue.success){//登录成功
	    							  $('#easyui-tooltip').tooltip({
	    								  content:"safsfl",
	    								  width:'300'
	    							  });
	    						}else{//登录失败，报错
	    							$.messager.alert('标题',r.message);
	    						
	    						}
	    					}
	    		    	});
					  }
				 
				  });
			}else{//登录失败，报错
				$.messager.alert('标题',r.message);
			
			}
		}
   	}); 

}

//datagrid加载数据
$(function (){
	tcmid=GetQueryString("tcmid");
 	id=GetQueryString("tcm_tcListId");
	$('#tt').datagrid({
		url:'/SSMiframe/getRunCase?tcm_tcListId='+id,
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
			}, {
		    	 title:'系统管理的id',
		    	 field:'tc_sysId',
		    	 width:100
		     },{
		    	 title:'接口id',
		    	 field:'tc_interfaceId',
		    	 width:100
		     },{
		    	 title:'父接口id',
		    	 field:'tc_supInterId',
		    	 width:100
		     },{
		    	 title:'参数数据',
		    	 field:'tc_inputData',
		    	 width:100
		     },{
		    	 title:'期望结果',
		    	 field:'tc_exptData',
		    	 width:100
		     },{
		    	 title:'用例级别',
		    	 field:'tc_caseLevel',
		    	 width:100
		     },{
		    	 title:'检查数据库',
		    	 field:'tc_valDb',
		    	 width:100
		     },{
		    	 title:'需要检查的数据库语句',
		    	 field:'tc_sqlyuju',
		    	 width:100
		     },{
		    	 title:'sql语句期望结果',
		    	 field:'tc_sqlexptData',
		    	 width:100
		     },{
		    	 title:'用例的描述',
		    	 field:'tc_tcdesc',
		    	 width:100
		     },{
		    	 title:'操作',
		    	 field:'nothing',
			     formatter:function(value,row){
		    		 	  return '<a href=\"#\" onclick=\"Runone(\''+row.id+'\');\">单条执行</a>&nbsp;&nbsp;<a title="后面在做" class=\"easyui-tooltip\" href=\"javascript:void()\">结果预览</a>'
		    		   	// return '<a href=\"#\" onclick=\"Runone(\''+row.id+'\');\">单条执行</a>&nbsp;&nbsp;<a title="" id=\"easyui-tooltip\" onmouseover="seeCase(\''+row.id+'\')">结果预览</a>'
			    		},
		    	 width:100
		     }
		     
		]],
/* 	   onLoadSuccess:function(data) {  
		   // alert("grid加载成功");
            var rows=$('#tt').datagrid("getRows");
            //alert(rows);
            if (rows.length != 1) {//只可以选中一行
             //   $('#tt').datagrid('selectRow',0);//grid加载完成后自动选中第一行
                var row=$('#tt').datagrid("getSelections");//获取选中的数据
                var rowData = {
                        id:row[0].id
                };
                alert("grid的第一行数据>>" + rowData.id);
          		//结果预览
        		$('.easyui-tooltip').tooltip({
        		    position: 'left',
        		    onShow: function (e) {
        		    	$.ajax({
        		    		url:"/SSMiframe/resultSeeOne?tc_id="+rowData.id,
        		    		success:function(r){
        		    	        var result = eval('(' + r + ')');
        						if(result&&result.success){//返回成功
        							  $('.easyui-tooltip').tooltip({
        								  content:result.message,
        								  width:'300'
        							  });
        						}else{//返回失败
        							$.messager.alert('标题',r.message);
        						
        						}
        					}
        		    	});
        		    },
      
        		    onHide: function (e) {
        		    }
        		    
        		    
        		});
            }
	          }  */
	});
	
});


</script>
</html>