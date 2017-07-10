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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.lwlsh.trex.pojo.InterfacePojo;
import com.lwlsh.trex.pojo.Sysmag;
import com.lwlsh.trex.service.IinterfaceService;

@Controller
public class InterfaceController {
	
	@Autowired
	public  IinterfaceService iService;
	
	
	/**
	 * 查询接口的名字根据itf_smgID
	 * @param itf_smgId
	 * @return
	 */
	@RequestMapping(value="/getAllItByName")
	public @ResponseBody JSONArray getAllInterfaceName(@RequestParam(value="itf_smgId",required=false) String  itf_smgId){
		System.out.println("++++++++++++");
		System.out.println(itf_smgId);
		System.out.println("++++++++++++");
		
		List<InterfacePojo>	value=iService.getAllIntName(itf_smgId);
		//将结果返回json值
		JSONArray aj=new JSONArray();
		for(InterfacePojo a: value){
			JSONObject jo = new JSONObject();
			jo.put("id", a.getId());
			jo.put("name", a.getItf_interfaceName());
			aj.add(jo);
		}
		System.out.println("=====================");
		System.out.println("返回的json值是:"+aj);
		System.out.println("=====================");
		return aj;
	}
	
	/**
	 * 根据id查询接口的参数值
	 * @param itf_smgId
	 * @return
	 */
	@RequestMapping(value="/getParamValue")
	public @ResponseBody JSONArray getParamById(@RequestParam(value="id",required=false) String  id){
		System.out.println("++++++++++++");
		System.out.println(id);
		System.out.println("++++++++++++");
		
		InterfacePojo	value=iService.getParamValue(id);
		//切分字符串
		String[] bStrings=value.getItf_interfaceParam().split(",");
		JSONArray aj=new JSONArray();
		for (int s = 0; s < bStrings.length; s++) {
			JSONObject jo = new JSONObject();
			jo.put("paramID", bStrings[s]);
			jo.put("tc_inputData", "");
			aj.add(jo);
		}
		System.out.println("===============");
		System.out.println(aj);
		System.out.println("===============");
		return aj;
	}
	
	
	
	
	@RequestMapping(value="/showParamInfo")
	public @ResponseBody JSONArray showParamValue(InterfacePojo interfacePojo){
		InterfacePojo iPojo=iService.showParamInfo();
		
		//切分字符串
		String[] bStrings=iPojo.getItf_interfaceParam().split(",");
		JSONArray aj=new JSONArray();
		for (int s = 0; s < bStrings.length; s++) {
			JSONObject jo = new JSONObject();
			jo.put("paramID", bStrings[s]);
			aj.add(jo);
		}
		System.out.println("===============");
		System.out.println(aj);
		System.out.println("===============");
		return aj;
	}
	
	
	
	/**
	 * 保存接口信息
	 */
	@RequestMapping(value="/saveInterface")
	public @ResponseBody JSONObject saveInterface(InterfacePojo interfacePojo,@RequestParam(value="itf_smgId",required=false) String  itf_smgId,@RequestParam(value="smg_sysName",required=false) String  smg_sysName,HttpServletResponse res) throws Exception{
		interfacePojo.setItf_smgId(Integer.parseInt(itf_smgId));
		int resultTotle=0;
		resultTotle=iService.addInterfaceInfo(interfacePojo);
		JSONObject jo = new JSONObject();
		if (resultTotle>0) {
			jo.put("success", true);
		}else{
			jo.put("success", false);
		}
        return jo;
    }
	/**
	 * 更新主机信息
	 */
	@RequestMapping(value="/editInterface")
	public @ResponseBody JSONObject editHost(InterfacePojo interfacePojo,HttpServletResponse res) throws Exception{
		
		int resultTotle=0;
		resultTotle=iService.editInterfaceInfo(interfacePojo);
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
	@RequestMapping(value ="/showInterfacePage")
	public @ResponseBody JSONObject  showdataPage(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,@Param("itf_smgid")String  itf_smgid,@Param("itf_interfaceName")String  itf_interfaceName,
			HttpServletResponse res){

	Map<String,Object> map=new HashMap<String,Object>();
		map.put("itf_smgid", itf_smgid);
		map.put("itf_interfaceName", itf_interfaceName);
		//这里转换表示从哪条数据开始
		if (page==1) {
			//是从0开始计算的
			page=0;
		}else{
			page=((page-1)* rows);
		}
        map.put("page", page);
        map.put("rows", rows);
        List<Object> iPojos=iService.selectAllInterfaceInfo(map);
        Long total=iService.getTotal(map);
        JSONObject result=new JSONObject();
        result.put("rows", iPojos);
        result.put("total", total);
        System.out.println(result);
		return result;
		
	}
	
	/**
	 * 删除主机信息
	 */
	@RequestMapping(value="/removeInterfaceInfo")
	public @ResponseBody JSONObject delete(@RequestParam(value="ids") String ids,HttpServletResponse res) throws Exception{
        String[] idStr = ids.split(",");
        JSONObject jsonObject = new JSONObject();
        for (String id : idStr) {
        	iService.delInterfaceInfo(Integer.parseInt(id));
        }
        jsonObject.put("success", true);
        System.out.println(jsonObject);
        return jsonObject;
    }
	
	/**
	 * 根据系统id查询所有的接口
	 */
	@RequestMapping(value="/getNameBySysid")
	public @ResponseBody JSONArray getNameBySysid(@RequestParam(value="sysid") String sysid) throws Exception{

		System.out.println("$$$$$$$$:进来了");
		List<InterfacePojo> value=iService.getInterfaceName(Integer.parseInt(sysid));
		//将结果返回json值
		JSONArray aj=new JSONArray();
		for(InterfacePojo a: value){
			JSONObject jo = new JSONObject();
			jo.put("id", a.getId());
			jo.put("itfName", a.getItf_interfaceName());
			aj.add(jo);
		}
		System.out.println("=====================");
		System.out.println("返回的json值是:"+aj);
		System.out.println("=====================");
        return aj;
		
    }
	
	
	
	


}
