package com.lwlsh.trex.dao;

import java.util.List;
import java.util.Map;

import com.lwlsh.trex.pojo.KwPagePojo;
import com.lwlsh.trex.pojo.KwTcModePojo;

public interface IkwTcModelDao {
	
	
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
	 * 根据testcaseId获取testDesc
	 * @param testcaseId
	 * @return
	 */
	public String getNameById(int testcaseId);
	
	/**
	 * 根据模块名获取tecaseID
	 * @param testcaseId
	 * @return
	 */
	public List<KwTcModePojo> getTcCaseById(String tcmdName);
	


}
