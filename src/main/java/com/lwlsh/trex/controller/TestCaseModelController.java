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
import com.lwlsh.trex.pojo.TestCaseModelPojo;
import com.lwlsh.trex.service.ItestCaseModelService;

/**
 * 测试用例模块管理
 * @author Administrator
 *
 */
@Controller
public class TestCaseModelController {
	
	
	@Autowired
	public  ItestCaseModelService itcmService;
	
	/**
	 * 保存用例模块信息
	 */
	@RequestMapping(value="/saveTestCaseModeInfo")
	public @ResponseBody JSONObject saveTestcaseCaseInfo(TestCaseModelPojo testCaseModelPojo,@RequestParam(value="tcm_sysId",required=false) String  tcm_sysId) throws Exception{
		System.out.println("**********");
		System.out.println("进来了：testCaseModelPojo的值是:"+testCaseModelPojo);
		System.out.println("tcm_sysId:"+tcm_sysId);
		testCaseModelPojo.setTcm_sysId(Integer.parseInt(tcm_sysId));
		testCaseModelPojo.setTcm_status("1");
		System.out.println("**********");
		int resultTotle=0;
		resultTotle=itcmService.addTestcaseModeInfo(testCaseModelPojo);
		JSONObject jo = new JSONObject();
		if (resultTotle>0) {
			jo.put("success", true);
		}else{
			jo.put("success", false);
		}
        return jo;
    }
	
	/**
	 * 查询所有的用例模块返回到页面分页
	 * @return
	 */
	@RequestMapping(value ="/showTcModelPage")
	public @ResponseBody JSONObject  shoTcModelPage(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,@Param("tcm_name")String  tcm_name){
		System.out.println(tcm_name+"tcm的值");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tcm_name", tcm_name);
		//这里转换表示从哪条数据开始
		if (page==1) {
			//是从0开始计算的
			page=0;
		}else{
			page=((page-1)* rows);
		}
        map.put("page", page);
        map.put("rows", rows);
        List<Object> iPojos=itcmService.selectAllTestCaseModel(map);
        Long total=itcmService.getTotal(map);
        JSONObject result=new JSONObject();
        result.put("rows", iPojos);
        result.put("total", total);
        System.out.println(result);
		return result;
		
	}

	
	/**
	 * 更新用例模块
	 */
	@RequestMapping(value="/editTcModelInfo")
	public @ResponseBody JSONObject editTcModelInfo(TestCaseModelPojo testCaseModelPojo) throws Exception{
		int resultTotle=0;
		resultTotle=itcmService.updateTcModelInfo(testCaseModelPojo);
		JSONObject jo = new JSONObject();
		if (resultTotle>0) {
			jo.put("success", true);
		}else{
			jo.put("success", false);
		}
        return jo;
    }

	/**
	 * 删除用例模块
	 */
	@RequestMapping(value="/removeTestcaseModel")
	public @ResponseBody JSONObject deleteTcModel(@RequestParam(value="ids") String ids) throws Exception{
        String[] idStr = ids.split(",");
        JSONObject jsonObject = new JSONObject();
        for (String id : idStr) {
        	itcmService.delTcModelInfo(Integer.parseInt(id));
        }
        jsonObject.put("success", true);
        System.out.println(jsonObject);
        return jsonObject;
    }
}
