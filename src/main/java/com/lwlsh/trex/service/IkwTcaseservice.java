package com.lwlsh.trex.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lwlsh.trex.pojo.KwTcasePojo;

@Resource
public interface IkwTcaseservice {
	

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
