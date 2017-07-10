package com.lwlsh.trex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.pojo.Sysmag;
import com.lwlsh.trex.pojo.TestCasePojo;
import com.lwlsh.trex.service.ItestCaseService;

/**
 * 测试用例管理
 * @author Administrator
 *
 */
@Controller
public class TestCaseController {
	
	
	@Autowired
	public  ItestCaseService itestCaseService;
	
	/**
	 * 保存用例信息信息
	 */
	@RequestMapping(value="/saveTestCase")
	public @ResponseBody JSONObject saveTestcaseInfo(TestCasePojo testCasePojo,@RequestParam(value="tcsuperid",required=false) String  tcsuperid,@RequestParam(value="tc_inputData",required=false) String  tc_inputData) throws Exception{
		System.out.println("**********");
		System.out.println("进来了：testcasePojo的值是:"+tcsuperid);
		System.out.println("paramVale:"+tc_inputData);
		if ("".equals(tcsuperid)||tcsuperid==null) {
			testCasePojo.setTc_supInterId(0);
		}else{
			testCasePojo.setTc_supInterId(Integer.parseInt(tcsuperid));
		}
		System.out.println("**********");
		int resultTotle=0;
		resultTotle=itestCaseService.addTestcaseInfo(testCasePojo);
		JSONObject jo = new JSONObject();
		if (resultTotle>0) {
			jo.put("success", true);
		}else{
			jo.put("success", false);
		}
        return jo;
    }
	
	/**
	 * 查询所有的主机信息返回到页面分页
	 * @return
	 */
	@RequestMapping(value ="/showTestcasePage")
	public @ResponseBody JSONObject  showTestCasePage(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,@Param("tc_sysId")String  tc_sysId){

	Map<String,Object> map=new HashMap<String,Object>();
		map.put("tc_sysId", tc_sysId);
		//这里转换表示从哪条数据开始
		if (page==1) {
			//是从0开始计算的
			page=0;
		}else{
			page=((page-1)* rows);
		}
        map.put("page", page);
        map.put("rows", rows);
        List<Object> iPojos=itestCaseService.selectAllTestCaseInfo(map);
        Long total=itestCaseService.getTotal(map);
        JSONObject result=new JSONObject();
        result.put("rows", iPojos);
        result.put("total", total);
        System.out.println(result);
		return result;
		
	}
	
	
	/**
	 * 删除用例
	 */
	@RequestMapping(value="/removeTestcase")
	public @ResponseBody JSONObject deleteTcModel(@RequestParam(value="ids") String ids) throws Exception{
        String[] idStr = ids.split(",");
        JSONObject jsonObject = new JSONObject();
        for (String id : idStr) {
        	itestCaseService.delTcModelInfo(Integer.parseInt(id));
        }
        jsonObject.put("success", true);
        System.out.println(jsonObject);
        return jsonObject;
    }

	/**
	 * 更新用例信息
	 */
	@RequestMapping(value="/editTestCase")
	public @ResponseBody JSONObject editHost(TestCasePojo testCasePojo) throws Exception{
		System.out.println("$$$$$$$$:进来了"+testCasePojo);
		int resultTotle=0;
		resultTotle=itestCaseService.editSysmag(testCasePojo);
		JSONObject jo = new JSONObject();
		if (resultTotle>0) {
			jo.put("success", true);
		}else{
			jo.put("success", false);
		}
        return jo;
    }

}
