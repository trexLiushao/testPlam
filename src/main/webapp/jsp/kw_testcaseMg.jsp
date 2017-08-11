<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rt_testcase manager</title>
<style>
            pre {outline: 1px solid #ccc; padding: 5px; margin: 5px; }
           
            .number { color: darkorange; }
            .boolean { color: blue; }
            .null { color: magenta; }
            .key { color: red; }
            
           .jsonview {
    font-family: monospace;
    font-size: 1.1em;
    white-space: pre-wrap;
}
.prop {
    font-weight: bold;
    color: red;
}
.q {
    display: inline-block;
    width: 0px;
    color: transparent;
}
.string {
    color: green;
    white-space: pre-wrap;
}
        </style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyUi/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyUi/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyUi/themes/color.css">	
	    	<!-- 加载详细信息用的-->

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
<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/datagrid-detailview.js"></script>
</head>
<body>
	<div id="tb"  style="padding: 3px">
		<form id="searchForm">
			<table>
				<tr>
					<th>TcModel name:</th>
					<td><input id="kw_pageName" style="line-height: 26px; border: 1px solid #ccc" /></td>
						<td><a href="javascript:searchKw()" class="easyui-linkbutton" data-option="plain:true">查找</a>
						<a href="javascript:resetValue()" class="easyui-linkbutton" data-option="plain:true">清空</a></td>
				</tr>
			</table>
		</form>
	</div>
	<table  id="tt" style="width:auto;  height: 600px; padding: 5px" >
	</table>
 	<div id="toolbar" class="easyui-layout">
	    <a href="javascript:openAddElement()" class="easyui-linkbutton" data-option="iconCls:'icon-add',plain:'true'" >新增</a>
    <!--     <a href="javascript:editPage()" class="easyui-linkbutton" data-option="iconCls:'icon-edit',plain:'true'" >修改</a>
        <a href="javascript:removePage()" class="easyui-linkbutton" data-option="iconCls:'icon-remove',plain:'true'" >删除</a> -->
	</div> 
	
<!-- 弹出新增单元用例信息 -->
	
	<div id="addDlg" class="easyui-dialog" style="width:600px;height:350px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle"><h3>添加模块</h3></div>
        <form id="fm" method="post" novalidate>
            <div>
	            <table>
	            	<tr>
		  				<td align="right">用例模块名:</td>
		  				<td><input class="easyui-textbox" name="testName" required="true"/></td>
		  			</tr>
		  			<tr>
		  				<td align="right">用例添加:</td>
		  				<td><select id="cc" class="easyui-combobox" name="testcaseId"  style="width:160px;">
		    			</select></td>
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
function openAddElement() {
	    $("#addDlg").dialog("open").dialog("setTitle", "新增用例模块");
	    $('#fm').form('clear');
	    $('#cc').combobox({
	    	//textField:是下拉列表框里显的内容。
	    	//valueField是下拉列表框选中的值。
	    	url:"/SSMiframe/getAllTcase?page=1&rows=500",
	        valueField:'testId',
	        textField:'tcdesc',
	        panelHeight:'auto',
	        editable:false//不可输入
	    });
	 

}
function saveElement(){
    $("#fm").form("submit", {
        url : '/SSMiframe/saveTc',
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
		url:'/SSMiframe/getAllTc',
		title:'',
		iconCls:'icon-save',
		rownumbers: true,
		pagination:true,//分页
		pageSize:10,
		pageList:[10,20,30,40],
		fitColumns:true,//列表自适应填满，false时变窄时会有滚动条，当列不是很多时可以使用
		fit:true,//fit: true,是让表格高度适应屏幕高度，为FALSE是适应内容。
		nowarp:false,//文本自动换行，true时不会看全文本
		idFeild:'id',
		sortable:true,//列排序
		toolbar:'#toolbar',
		fit: false,
		columns:[[
		     {
		    	 title:'模块名',
		    	 field:'testName',
		    	 width:100
		     },
		     {
		    	 title:'用例id',
		    	 field:'testcaseId',
		    	 width:100,
		    	 hidden:true
		     },
		     {
		    	 title:'用例描述',
		    	 field:'tcDesc',
		    	 width:100
		     },
		     {
		    	 title:'用例模块',
		    	 field:'id',
		    	 width:100,
		    	 hidden:true
		     }, {
		    	 title:'operat',
		    	 field:'nothing',
			     formatter:function(value,row){
			    	 		//这里不知道为什么只能传数字的，传字符串的就会报错
			    	 		return '<a href=\"#\" onclick=\"alert(\'还没做呢\')\">delete</a>'
			    		// return '<a href=\"#\" onclick=\"delTcCase(\''+row.id+'\');\">delete</a>'
			    		   //return  '<a style="color:blue" href="javascript:detail(+row.id+,row.tcm_name);">详情</a>&nbsp;&nbsp;&nbsp;&nbsp<a style="color:blue" href="javascript:runExe('+row.id+','+row.tcm_name+');">运行</a>'
			    		},
		    	 width:100
		     }
		]],
		view: detailview,
		detailFormatter: function(rowIndex, rowData){
			console.info(rowIndex);
			console.info(rowData);
			return '<div id="#inrtoolbar" class="easyui-layout"><a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$(\'#simpleDgId\').edatagrid(\'addRow\')">添加</a>'
					+' <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$(\'#simpleDgId\').edatagrid(\'destroyRow\')">删除</a>' 
					+' <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$(\'#simpleDgId\').edatagrid(\'saveRow\')">保存</a>'       
					+' <a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$(\'#simpleDgId\').edatagrid(\'cancelRow\')">取消</a>'       
					+'  </div> ' 
					+'<table id=\"simpleDgId-'+rowIndex+'\" title=\"用户列表\"  class=\"easyui-datagrid\" style=\"width:1000px;padding:10px 20px\" toolbar=\"#inrtoolbar\" idField=\"id\" rownumbers=\"true\" fitColumns=\"true\" singleSelect=\"true\">'
					+'<thead><tr><th field=\"id\" width=\"200\">ID</th><th field=\"testId\" width=\"200\" editor=\"{type:\'validatebox\',options:{required:true}}\">用例ID</th>'
            		+'<th field=\"teststep\" width=\"200\" editor=\"{type:\'validatebox\',options:{required:true}}\">操作步骤</th><th field=\"tcdesc\" width=\"100\" editor=\"{type:\'validatebox\'}\">用例描述</th>'
          	 		+'<th data-options=\"field:\'pageName\',width:100,formatter:function(value,row){return row.pageName;},editor:{type:\'combobox\',options:{valueField:\'pageName\',textField:\'pageName\',method:\'get\',url:\'getAllPage?page=1&rows=500\',required:true}}\">页面选择</th>'
 			 		+' <th field=\"elementXpath\" width=\"200\" editor=\"{type:\'validatebox\',options:{required:true}}\">页面元素</th>'
             		+'<th field=\"keywordValue\" width=\"200\" editor=\"{type:\'validatebox\',options:{required:true}}\">关键字操作</th>'
             		+'<th field=\"inputData\" width=\"200\" editor=\"{type:\'validatebox\'}\">输入值</th></tr> </thead></table>';
		},
		onExpandRow:function(index,row){//注意3  
			console.info("row:"+row);
			  $('#simpleDgId-'+index).edatagrid({
			    	fitColumns:true,
			    	fit: false,
			    	pagination:true,//分页
			    	nowarp:false,//文本自动换行，true时不会看全文本
					url: '/SSMiframe/getTcById?id='+row.testcaseId,
					saveUrl: '/SSMiframe/saveTcase',
					updateUrl: '/SSMiframe/udTcase',
					//destroyUrl里面已经自带id
					destroyUrl: '/SSMiframe/dTcase',
					/* onLoadSuccess: function(data){
					    	//调用方法，传参(datagrid的ID,要合并的commname列名);
					    	 $(this).datagrid("autoMergeCells", ['simpleDgId', 'testId']);
					    } */
				
				});
		
		
           /*  $('#ddv-'+index).datagrid({  
               // url:'../statisticJson/getStatisticTaskByAcqu.action?idapStatisticTask.taskGroupId='+(row.id), 
            	url:'/SSMiframe/getAllElement?page=1&rows=10',	   
                fitColumns:true,  
                singleSelect:true,  
                height:'auto',  
                columns:[[  
                    {field:'elementDesc',title:'统计任务ID'},  
                    {field:'pageName',title:'任务名称',width:50},  
               {field:'pageid',title:'任务状态',formatter:function(value, row, index){  
                        if (value) {  
                            switch (value) {  
                                case '0':  
                                    return '任务创建';  
                                    break;  
                                case '1':  
                                    return '待执行';  
                                    break;  
                                case '2':  
                                    return '执行中';  
                                    break;  
                                case '3':  
                                    return '执行成功';  
                                    break;  
                                case '4':  
                                    return '执行失败';  
                                    break;  
                                case '-1':  
                                    return '任务取消';  
                                    break;  
                                default :  
                                    return '已删除';  
                                    break;  
                            }  
                        }  
                    }},  
                    {field:'elementName',title:'任务说明',width:100},  
                    {field:'pageName',title:'任务操作',width:50,align:'center',  
                        formatter:function(value, row, index){  
                            if(row.taskStatue != '-2'){  
                                var tdContext = '<a href="#this" onclick="removeStatistic('+(row.taskId)+')">删除</a>  ';  
                            }  
                            return tdContext;  
                    }}  
                ]]
           
            });   */
            
        }  
	});

	
});



</script>
</html>