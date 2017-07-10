<%@ page contentType="text/html; charset=utf-8"%> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rt_登录界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUi/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUi/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUi/themes/color.css">	
	<script type="text/javascript"  src="${pageContext.request.contextPath}/easyUi/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/echarts.common.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
   <div id="loginDialog"  title="登录" style="width:300px;height:200px;padding:5px;">
	  	<form id="loginInputForm" method="post">
	  		<table>
	  			<tr>
	  				<th align="right">用户名</th>
	  				<td><input class="easyui-textbox" required="true" name="userName" data-options="prompt:'userName',iconCls:'icon-man',iconWidth:38"/></td>
	  			</tr>
	  			<tr>
	  				<th align="right">密码</th>
	  				<td><input class="easyui-textbox" required="true" type="password" name="password" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38"/></td>
	  			</tr>
	  		</table>
	  	</form>
	</div>
	
</body>
<script type="text/javascript">
 var loginDialog
 $(function(){
	 loginDialog=$('#loginDialog').dialog({
		 colsable:false,
		 modal:true,
		 buttons:[{
			 text:'登录',
			 handler:function(){	
				$.ajax({
					url:"/SSMiframe/userInfo",
					data:$("#loginInputForm").serialize(),
					cache:false,
					dataType:'json',
					success:function(r){
						if(r&&r.success){//登录成功
							window.location.href ="/SSMiframe/Allshow"
							loginDialog.dialog('close');
						}else{//登录失败，报错
							$.messager.alert('标题',r.message);
						
						}
					}
				});
			 }
		 }	 
		 ]
	 });
 });



</script>
</html>