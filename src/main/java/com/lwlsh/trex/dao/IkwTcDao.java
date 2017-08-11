package com.lwlsh.trex.dao;

import java.util.List;
import java.util.Map;

import com.lwlsh.trex.pojo.KwPagePojo;
import com.lwlsh.trex.pojo.KwTcModePojo;
import com.lwlsh.trex.pojo.KwTcasePojo;

public interface IkwTcDao {
	
	

	public List<KwTcasePojo> getAllTc(Map<String,Object> map);
	
	
	/**++
	 * 根据testcaseId获取所有的步骤
	 * @param testcaseId
	 * @return
	 */
	public List<KwTcasePojo> getAllTcbyId(int testcaseId);
	/**
	 * 更新KwTcasePojo页面
	 * @return
	 */
	public int updateTcase(KwTcasePojo kwTcasePojo);
	
	
	
	/**
	 * 根据tcid获取kwtcasePojo
	 * @param map
	 * @return
	 */
	public  KwTcasePojo getTcById(int  tcid);
	
	/**
	 * 新增KwTcasePojo页面
	 * @return
	 */
	public int addTcase(KwTcasePojo kwTcasePojo);
	
	/**
	 * 删除KwTcasePojo
	 * @return
	 */
	public int delTcase(int tcid);
	
	/**
	 * 根据testcaseId获取testDesc
	 * @param testcaseId
	 * @return
	 */
	public String getNameById(int testcaseId);
	
	public String getDescById(int testcaseId);

}
