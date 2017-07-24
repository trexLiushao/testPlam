<%@ page contentType="text/html; charset=utf-8"%> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>rt_SSM iframe</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUi/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUi/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUi/themes/color.css">	
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:30px;background:#B3DFDA;padding:0px">欢迎 </div>
	<div class="easyui-panel"  data-options="region:'west',split:true,title:'West'" style="width:200px;padding:10px;">
	<ul class="easyui-tree">
			<li>
				<span>菜单管理</span>
				<ul>
					<li>
							<span>接口管理</span>
							<ul>
								<li>
								<span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('主机管理','jsonData')">主机管理</a></span><br/>
								</li>
								<li>
								<span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('接口管理','interfaceData')">接口管理</a></span>
								</li>
								<li>
								<span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('用例管理','testCaseData')">用例管理</a></span>
								</li>
								<li>
								<span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('用例模块管理','testCaseModelData')">用例模块管理</a></span>
								</li>
								<li>
								<span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('结果报告','result')">结果报告</a></span>
								</li>
							</ul>
					</li>
				</ul>
				
				
					<ul>
					<li>
							<span>UI</span>
							<ul>
								<li>
								<span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('关键字管理','userkeyword')">关键字管理</a></span><br/>
								</li>
								<li>
									<span><a href="#" class="easyui-linkbutton">元素管理</a></span>
									<ul class="easyui-tree">
										<li><span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('页面管理','pageData')">页面管理</a></span></li>
										<li><span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('用例管理','testCaseData')">页面元素管理</a></span></li>
									</ul>
								</li>
								<li>
								<span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('用例管理','testCaseData')">用例管理</a></span>
								</li>
								<li>
								<span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('用例模块管理','testCaseModelData')">用例模块管理</a></span>
								</li>
								<li>
								<span><a href="#" class="easyui-linkbutton" onclick="testAddSubPage('结果报告','result')">结果报告</a></span>
								</li>
							</ul>
					</li>
				</ul>
			</li>
			
		</ul>	
	</div>
	<div data-options="region:'south',border:false" style="height:30px;background:#A9FACD;padding:10px;">技术支持</div>
	<div id="showData" style="height: 100%;width: 100%;" class="easyui-tabs"  data-options="region:'center',title:'Center'"></div>
</body>
<script type="text/javascript">
    //title是标题，url是提交的servlet路径，name是传入的值
    function testAddSubPage(title,url){  
       if ($('#showData').tabs('exists', title)){
                $('#showData').tabs('select', title);
            } else {
                url="/SSMiframe/"+url;
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#showData').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
            }
       
    }  
</script>
</html>
