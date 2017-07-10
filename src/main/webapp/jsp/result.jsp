<%@ page contentType="text/html; charset=utf-8"%> 
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rt_結果报表</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUi/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUi/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUi/themes/color.css">	
	<script type="text/javascript"  src="${pageContext.request.contextPath}/easyUi/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/echarts.common.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyUi/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	  <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" align="center" style="width: 400px;height:200px;"></div>
    <!-- 这个存放表格 -->
    <div id="tableShow" align="center">
	<table id="tt">

	</table>
	</div>
</body>
<script type="text/javascript">
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
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));
// 指定图表的配置项和数据
myChart.setOption ( {
	    title : {
	        text: '测试结果',
	        subtext: 'XX项目',
	        x:'center'
	    },
	    tooltip : {
	    },
	    legend: {
	        orient: 'vertical',
	        left: 'right',
	        data: ['用例通过数','用例失败数','用例未执行']
	    },
	    series : [
	        {
	            name: '测试结果',
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:[
	                /*{value:335, name:'用例通过数'},
	                {value:310, name:'用例失败数'},
	                {value:234, name:'用例未执行'}*/
	            ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	});
myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
		var names=[];    //类别数组（实际用来盛放X轴坐标值，好比上面的用例通过数/失败数/未执行数）
        var nums=[];    //数值数组（实际用来盛放Y坐标值，好比上面的335/310/234的值）-----备注后台返回的值查看图片
		 $.ajax({
         type : "post",
         async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
         url : "yesTrueTwo",    //请求发送到TestServlet处
         data : {},
         dataType : "json",        //返回数据形式为json
         success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
             if (result!=null) {
            	for(var key in result){
            		  nums.push(result[key].name);//name是存储中保存的数值
            	}
                    myChart.hideLoading();    //隐藏加载动画
                    myChart.setOption({        //加载数据图表
                        series: [{
                            // 根据名字对应到相应的系列
                        	 data:[
               	                {value:nums[0], name:"用例通过数"},
               	                {value:nums[1], name:"用例失败数"},
               	                {value:nums[2], name:"用例跳过数"}
               	            ],
               	         itemStyle: {
         	                emphasis: {
         	                    shadowBlur: 10,
         	                    shadowOffsetX: 0,
         	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
         	                }
         	            }
                        }]
                    });
                    
             }
         
        },
         error : function(errorMsg) {
             //请求失败时执行该函数
         alert("图表请求数据失败!");
         myChart.hideLoading();
         }
    })

</script>
</html>