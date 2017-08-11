package com.lwlsh.trex.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lwlsh.trex.pojo.KwPagePojo;
import com.lwlsh.trex.pojo.KwTcModePojo;

@Resource
public interface IkwTcModelservice {
	
/**
 /**
 * 获取所有的用例模块页面
 * @param map
 * @return
 */
	public List<KwTcModePojo> getAllTc(Map<String,Object> map);
	
	
	
	/**
	 *查找
	 */
	public  KwTcModePojo getTcById(int  tcid);
	
	/**
	 * 新增KwTcModePojo页面
	 * @return
	 */
	public int addTcModel(KwTcModePojo kwTcModePojo);
	
	/**
	 * 删除KwTcModePojo
	 * @return
	 */
	public int delTcModel(int tcid);
	
	/**
	 * 根据id获取tecaseID
	 * @param testcaseId
	 * @return
	 */
	public List<KwTcModePojo> getTcCaseById(String tcmdName);


}
