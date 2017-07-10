package com.lwlsh.trex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.pojo.Sysmag;
import com.lwlsh.trex.service.IsysmagService;

@Controller
public class SysmagController {

	@Autowired
	public IsysmagService isysmagService;
	
	public int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@RequestMapping(value="/getAllSysName")
	public @ResponseBody JSONArray selectSysName() throws Exception{
		System.out.println("$$$$$$$$:进来了");
		List<Sysmag>	value=isysmagService.getAllsmgName();
		//将结果返回json值
		JSONArray aj=new JSONArray();
		for(Sysmag a: value){
			JSONObject jo = new JSONObject();
			jo.put("smg_id", a.getSmg_id());
			jo.put("smg_sysName", a.getSmg_sysName());
			aj.add(jo);
		}
		System.out.println("=====================");
		System.out.println("返回的json值是:"+aj);
		System.out.println("=====================");
        return aj;
    }

	/**
	 * 保存主机信息到数据库
	 * @param sysmag
	 * @return
	 */
	@RequestMapping(value ="/saveSysmag")
	public String saveSysmag(Sysmag sysmag,HttpSession session,HttpServletRequest request){
		System.out.println("进来了");
		System.out.println(sysmag.getSmg_hostIP()+"#"+sysmag.getSmg_dbAnt());
		System.out.println(sysmag);
		try {
			isysmagService.addSysmag(sysmag);
			return "HostMag";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	/**
	 * 删除主机信息
	 */
	@RequestMapping(value="/removeHost")
	public @ResponseBody JSONObject delete(@RequestParam(value="ids") String ids,HttpServletResponse res) throws Exception{
        String[] idStr = ids.split(",");
        JSONObject jsonObject = new JSONObject();
        for (String id : idStr) {
        	isysmagService.delSysmag(Integer.parseInt(id));
        }
        jsonObject.put("success", true);
        System.out.println(jsonObject);
      //  ResponseUtil.write(res, jsonObject);
        return jsonObject;
    }
	
	/**
	 * 保存主机信息
	 */
	@RequestMapping(value="/saveHost")
	public @ResponseBody JSONObject saveHost(Sysmag sysmag,HttpServletResponse res) throws Exception{
		System.out.println("$$$$$$$$:进来了"+sysmag);
		int resultTotle=0;
		resultTotle=isysmagService.addSysmag(sysmag);
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
	@RequestMapping(value="/editHost")
	public @ResponseBody JSONObject editHost(Sysmag sysmag,HttpServletResponse res) throws Exception{
		System.out.println("$$$$$$$$:进来了"+sysmag);
		int resultTotle=0;
		resultTotle=isysmagService.editSysmag(sysmag);
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
	@RequestMapping(value ="/showDataPage")
	public @ResponseBody JSONObject  showdataPage(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,@Param("smg_sysName")String  smg_sysName,@Param("smg_type")String  smg_type,
			HttpServletResponse res){
		System.out.println("=================================");
		System.out.println("smg_sysName:"+smg_sysName);
		System.out.println("smg_type:"+smg_type);
		System.out.println("page:"+page);
		System.out.println("rows:"+rows);
		System.out.println("=================================");
		Sysmag sysmag=new Sysmag();
		sysmag.setSmg_sysName(smg_sysName);
		sysmag.setSmg_type(smg_type);

	Map<String,Object> map=new HashMap<String,Object>();
		map.put("smg_sysName", smg_sysName);
		map.put("smg_type", smg_type);
		//这里转换表示从哪条数据开始
		if (page==1) {
			//是从0开始计算的
			page=0;
		}else{
			page=((page-1)* rows);
		}
        map.put("page", page);
        map.put("rows", rows);
        List<Sysmag> sysmags=isysmagService.selectAllSysmagr(map);
        Long total=isysmagService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=formatRsToJsonArray(sysmags);
        result.put("rows", jsonArray);
        result.put("total", total);
        System.out.println(result);
		return result;
		
	}
	
	
	/**
	 * 查询所有的主机信息返回到页面
	 * @return
	 */
	@RequestMapping(value ="/showData")
	public @ResponseBody JSONObject  showdata(){
		List<Sysmag> sysmag=isysmagService.selectAllSysmag();
		JSONArray json=	formatRsToJsonArray(sysmag);
		JSONObject jo = new JSONObject();
		jo.put("rows", json);
		jo.put("total", json.size());
		System.out.println(jo);
		return jo;		//返回到添加接口界面
	}
    /** 
     * 将result的结果集转化成json数组格式 
     * @param rs 
     * @return 
     * @throws Exception 
     */  
	private JSONArray formatRsToJsonArray(List<Sysmag> modelMap) {
		   JSONArray json = new JSONArray();
           for(Sysmag a : modelMap){
               JSONObject jo = new JSONObject();
               jo.put("smg_id", a.getSmg_id());
               jo.put("smg_hostIP", a.getSmg_hostIP());
               jo.put("smg_hostPort", a.getSmg_hostPort());
               jo.put("smg_dbName", a.getSmg_dbName());
               jo.put("smg_dbAnt", a.getSmg_dbAnt());
               jo.put("smg_hostPort", a.getSmg_hostPort());
               jo.put("smg_desc", a.getSmg_desc());
               jo.put("smg_status", a.getSmg_status());
               jo.put("smg_type", a.getSmg_type());
               jo.put("smg_sysName", a.getSmg_sysName());
               jo.put("smg_dbPwd", a.getSmg_dbPwd());
               json.add(jo);
           }
		return json;
	}


	
}
