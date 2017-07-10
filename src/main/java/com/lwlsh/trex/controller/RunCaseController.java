package com.lwlsh.trex.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.pojo.InterfacePojo;
import com.lwlsh.trex.pojo.Sysmag;
import com.lwlsh.trex.pojo.TcDetailRdPojo;
import com.lwlsh.trex.pojo.TestCasePojo;
import com.lwlsh.trex.service.IinterfaceService;
import com.lwlsh.trex.service.IrunCaseService;
import com.lwlsh.trex.service.IsysmagService;
import com.lwlsh.trex.service.ItestCaseService;
import com.lwlsh.trex.util.HtmlUtil;
import com.lwlsh.trex.util.HttpUtil;

/**
 * 测试用例执行
 * @author Administrator
 *
 */
@Controller
public class RunCaseController {
	
	
	@Autowired
	public  IrunCaseService irunCaseService;
	@Autowired
	public  ItestCaseService itestCaseService;
	@Autowired
	public  IinterfaceService itfService;
	@Autowired
	public IsysmagService isysmagService;

	public HttpUtil httpUtil=new HttpUtil();
	public HtmlUtil htmlUtil=new HtmlUtil();
	
	/**
	 * 保存用例模块信息
	 */
	@RequestMapping(value="/runTestCase")
	public @ResponseBody JSONObject runTestCase(@RequestParam(value="runModeId",required=false) String  runModeId) throws Exception{
	
		//1首先根据runModelId获取tcm_tclistId的值
		
		//2分解tcm_tclistId的值list
		
		//3根据分解的每个tcm_tclistId的值去获取对应接口的值
		
		//4根据获取的接口值去调用util里的执行
		
		//4.1把每条用例的执行结果写到数据库里面
		//4.2统计多少条成功执行，多少条失败执行
		JSONObject jo = new JSONObject();
        return jo;
    }
	
	/**
	 * 通过用例模块id查询该模块下有哪些testCase
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getRunCase")
	public @ResponseBody JSONObject getTestCaseById(@RequestParam(value="tcm_tcListId",required=false) String  tcm_tcListId,@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows){
		List<Integer> aIntegers =new ArrayList<>();
		Map<String,Object> map=new HashMap<String,Object>();
		System.out.println("hello evryone:"+tcm_tcListId);
		System.out.println("hello evryone:"+aIntegers);
	 if (!"".equals(tcm_tcListId)&&!(tcm_tcListId==null)&&!"null".equals(tcm_tcListId)) {
		 String[] b=tcm_tcListId.split(",");
		 if (!("").equals(b[0])) {//判断第一个值是不是逗号
				for (int i = 0; i < b.length; i++) {
					aIntegers.add(Integer.parseInt(b[i]));
				}
				map.put("list", aIntegers);
		 	} else{
		 		for (int i = 1; i < b.length; i++) {
					aIntegers.add(Integer.parseInt(b[i]));
				}
				map.put("list", aIntegers);
		 }
		}else{
			System.out.println("123");
			map.put("flagtrue", 1);
		}
		
		//解析tcm_tcListId 1,3
		System.out.println("page:"+page);
		System.out.println("rows:"+rows);
	
		//这里转换表示从哪条数据开始
		if (page==1) {
			//是从0开始计算的
			page=0;
		}else{
			page=((page-1)* rows);
		}
        map.put("page", page);
        map.put("rows", rows);
        List<Object> iPojos=irunCaseService.getAllTestCaseInfo(map);
        System.out.println(iPojos.size()+"&&&&&&&&&&&&&");
       // Long total=irunCaseService.getTotal(map);
        JSONObject result=new JSONObject();
        result.put("rows", iPojos);
        result.put("total", iPojos.size());
        System.out.println("****************"+result);
		return result;
		
	}
	
	/**
	 * 通过系统id查询该系统下有哪些未添加的testCase(即除去tcm_tcListId的值)
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getRunCaseBySysid")
	public @ResponseBody JSONObject getRunCaseBySysid(@RequestParam(value="tcm_tcListId",required=false) String  tcm_tcListId,
			@RequestParam(value="sysid",required=false) String  sysid,
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows){
		System.out.println("==================TREX=======================");
		
		System.out.println("==================TREX=======================");
		List<Integer> aIntegers =new ArrayList<>();
		Map<String,Object> map=new HashMap<String,Object>();
		System.out.println("hello evryone:"+tcm_tcListId);
		System.out.println(tcm_tcListId==null);
		System.out.println("".equals(tcm_tcListId));
		System.out.println(tcm_tcListId.isEmpty());
		System.out.println("hello evryone:"+aIntegers);
		if (!"".equals(tcm_tcListId)&&!(tcm_tcListId==null)&&!"null".equals(tcm_tcListId)) {
			String[] b=tcm_tcListId.split(",");
			for (int i = 0; i < b.length; i++) {
				aIntegers.add(Integer.parseInt(b[i]));
			}
			map.put("list", aIntegers);
		}else{
			System.out.println("123");
			map.put("flagtrue", 1);
		}
		
		//解析tcm_tcListId 1,3
		System.out.println("page:"+page);
		System.out.println("rows:"+rows);
	
		//这里转换表示从哪条数据开始
		if (page==1) {
			//是从0开始计算的
			page=0;
		}else{
			page=((page-1)* rows);
		}
        map.put("page", page);
        map.put("rows", rows);
        List<Object> iPojos=irunCaseService.getAllTcNot(map);
        System.out.println(iPojos.size()+"&&&&&&&&&&&&&");
       // Long total=irunCaseService.getTotal(map);
        JSONObject result=new JSONObject();
        result.put("rows", iPojos);
        result.put("total", iPojos.size());
        System.out.println("****************"+result);
		return result;
		
	}
	
	
	/**
	 * 删除模块下的id
	 */
	@RequestMapping(value="/delTestcaseByrun")
	public @ResponseBody JSONObject delTestCaseById(@RequestParam(value="ids") String ids){
		
		//1删除用例，更新页面datagrid
        String[] idStr = ids.split(",");
        JSONObject jsonObject = new JSONObject();
        for (String id : idStr) {
        	irunCaseService.delTestCaseInfo(Integer.parseInt(id));
        }
        jsonObject.put("success", true);
        System.out.println(jsonObject);
		//2删除模块集合里面的值tcm_list
		return null;
		
	}
	
	/**
	 *从列表中选择添加用例的集合用例中
	 */
	@RequestMapping(value="/addTc")
	public @ResponseBody JSONObject addTcByList(@RequestParam(value="ids") String ids,@RequestParam(value="tcmid") String tcmid,
			@RequestParam(value="tcm_tcListId",required=false) String  tcm_tcListId){
//		System.out.println(tcm_tcListId);
//		System.out.println("7777777777777777777777");
//		System.out.println(tcm_tcListId==null);
//		System.out.println("".equals(tcm_tcListId));
//		System.out.println(tcm_tcListId==null||"".equals(tcm_tcListId));
//		System.out.println("7777777777777777777777");
//		System.out.println(tcmid);
		System.out.println(tcm_tcListId+"*********************");
		if (tcm_tcListId==null||"".equals(tcm_tcListId)) {
			System.out.println("进来了");
			ids=ids;
		}else {
			ids=","+ids;
		}
		System.out.println("*********:"+ids);
		int resultTotle=0;
		resultTotle=irunCaseService.udListId(Integer.parseInt(tcmid), ids);
		JSONObject jo = new JSONObject();
		if (resultTotle>0) {
			jo.put("success", true);
		}else{
			jo.put("success", false);
		}
		return jo;
		
	}
	
	/**
	 * 
	 *单条用例执行
	 * @param tc_id:用例id
	 * @return
	 */
	@RequestMapping(value="/runTcByOne")
	public @ResponseBody JSONObject runTcOne(@RequestParam(value="tc_id") String tc_id){
		TcDetailRdPojo tRdPojo=new TcDetailRdPojo();
		System.out.println("进来了，仅此而已"+tc_id);
		Response response=null;
		//1根据用例id获取用例所有信息
		TestCasePojo testCasePojo=itestCaseService.getTcById(Integer.parseInt(tc_id));
		System.out.println(testCasePojo);
		//2根据获取到的testCasePojo.去获取接口表、系统表的信息
		//2.1获取接口表的信息
		InterfacePojo itfPojo=itfService.getItfById(testCasePojo.getTc_interfaceId());
		InterfacePojo supitfPojo=null;
		//2.1.2,判断是否有父接口
		if (testCasePojo.getTc_supInterId()!=0) {
			supitfPojo=itfService.getItfById(testCasePojo.getTc_supInterId());
		}
		//2.2获取系统表的信息
		Sysmag smag=isysmagService.getSysById(testCasePojo.getTc_sysId());
		//2.1获取接口参数param
		boolean flagParam=true;
		Map<String, String> resultMap=new HashMap<String,String>();
		if (",".equals(itfPojo.getItf_interfaceParam())||itfPojo.getItf_interfaceParam()==null) {
			flagParam=false;
		}else{
			resultMap=strToMap(itfPojo.getItf_interfaceParam(), testCasePojo.getTc_inputData());
		}
		//3后续增加头文件参数设置
		
		//组装url,参数，接口
		if (supitfPojo==null) {//没有依赖的父接口
			System.out.println("没有依赖的接口");
			//接口请求类型(http)=itfPojo.getItf_interfaceProt()
			//接口请求的域名和路径=itfPojo.getItf_interfaceUrl();
			//接口请求的方式(post Or get)=itfPojo.getItf_interfaceType();
			//接口传递参数的方式(json or 普通)=itfPojo.getItf_interfaceParaType()
			//接口需要传递的参数=resultMap
			String httpUrl=itfPojo.getItf_interfaceProt()+"://"+itfPojo.getItf_interfaceUrl();
			String httpType=itfPojo.getItf_interfaceType();
			String httpReqType=itfPojo.getItf_interfaceParaType();
			response=httpUtil.httpPost(httpUrl, httpType, resultMap, httpReqType);
		}else{//有依赖的父接口，传参也传入
			System.out.println(itfPojo.getItf_interfaceProt()+"://"+itfPojo.getItf_interfaceUrl()+"");
			System.out.println(itfPojo.getItf_interfaceType()+":"+itfPojo.getItf_interfaceParaType()+":");
			String httpUrl=itfPojo.getItf_interfaceProt()+"://"+itfPojo.getItf_interfaceUrl();
			String httpType=itfPojo.getItf_interfaceType();
			String httpReqType=itfPojo.getItf_interfaceParaType();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("==============================");
			System.out.println(httpUrl+":"+httpType+":"+httpReqType);
			System.out.println("==============================");
			response=httpUtil.httpPost(httpUrl, httpType, resultMap, httpReqType);
		}
		JSONObject jo = new JSONObject();
		
		//保存用例执行详细信息到数据库
		tRdPojo.setTcd_ifId(itfPojo.getId());
		tRdPojo.setTcdr_tcId(Integer.parseInt(tc_id));
		
		
		jo.put("success", true);//这里的true应该根据Assert断言类里面的判断返回数据
		jo.put("message", response.body());
		
		return jo;
	}
	

	
	
	/**
	 * 单条执行结果展示
	 * @param tc_id
	 * @return
	 */
	@RequestMapping(value="/resultSeeOne")
	public  @ResponseBody JSONObject resultSee(@RequestParam(value="tc_id") String tc_id){
		
		System.out.println("进来了");
		System.out.println(tc_id);
		
		JSONObject jo = new JSONObject();
		//这里没有区分密码错误还是用户名不存在，如果有需要后面优化时候再去区分填写
			jo.put("success", true);
			StringBuffer sb = new StringBuffer();
			//1根据用例id获取用例所有信息
			TestCasePojo testCasePojo=itestCaseService.getTcById(Integer.parseInt(tc_id));
			//,  errorLog先暂时不用
			htmlUtil.bodyhtml(testCasePojo.getTc_exptData(), testCasePojo.getTc_sqlexptData());
			
//			sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
//			sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n");
//			sb.append("<meta http-equiv=\"Content-Type\"content=\"text/html; charset=utf-8\" />\n");
//			sb.append("<title>提示</title>");
//			sb.append("</head>");
//			sb.append("<body><fieldset style=\"width:220px;\">");
//			sb.append("<legend>结果信息</legend>");
//			sb.append("<table>");
//			sb.append("<tr><th align=\"right\">用户名</th><td>hello world</td></tr>");
//			sb.append("<tr><th align=\"right\">用户名</th><td>hello world</td></tr>");
//			sb.append("<table>");
//			sb.append("</fieldset></body>");
			
			jo.put("message", sb);
		System.out.println(jo.toString());
		return jo;		
		
		
	}
	
	
	/**
	 * 永远返回true
	 * @param tc_id
	 * @return
	 */
	@RequestMapping(value="/yesTrue")
	public  @ResponseBody JSONObject resultSee(){
		JSONObject jo = new JSONObject();
		jo.put("success", true);
		return jo;
	}
	/**
	 * 永远返回true
	 * @param tc_id
	 * @return
	 */
	@RequestMapping(value="/yesTrueTwo")
	public  @ResponseBody JSONArray resultSeeTwo(){
		JSONArray aj=new JSONArray();
		JSONObject passjo = new JSONObject();
		JSONObject failjo = new JSONObject();
		JSONObject skipjo = new JSONObject();
		passjo.put("name", 123);
		failjo.put("name", 163);
		skipjo.put("name", 173);
		aj.add(passjo);
		aj.add(failjo);
		aj.add(skipjo);
		return aj;
	}
	
	
	
	/**
	 * 通过传递两个参数返回map
	 * @param a
	 * @param b
	 * @return
	 */
	private Map<String, String> strToMap(String a,String b){
		Map<String, String>  resultMap=new HashMap<String,String>();
		if (",".equals(a)) {
			return resultMap;
		}
		String[] Amap=a.split(",");
		if (",".equals(b)) {
			for(int i=0;i<Amap.length;i++){
				resultMap.put(Amap[i],"");
			}
			return resultMap;
		}
		String[] Bmap=b.split(",");
		System.out.println(Bmap.length);
		for(int i=0;i<Amap.length;i++){
			if (i<Bmap.length) {
				resultMap.put(Amap[i],Bmap[i]);
			}else{
				resultMap.put(Amap[i],"");
			}
			
		}
		return resultMap;
	}
	
}
