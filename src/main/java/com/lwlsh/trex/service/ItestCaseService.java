package com.lwlsh.trex.service;

import java.util.List;
import java.util.Map;

import com.lwlsh.trex.pojo.TestCasePojo;

public interface ItestCaseService {

	/**
	 * 新增用例信息
	 * @param interfacePojo
	 * @return
	 */
	public  int addTestcaseInfo(TestCasePojo testCasePojo);
	
	/**
	 * 查找所有的用例信息
	 * @return
	 */
	public List<Object> selectAllTestCaseInfo(Map<String,Object> map);
	  /**
     * 获取总记录数
     * @param map
     * @return获取的total数
     */
    public Long getTotal(Map<String, Object> map);
    
	/**
	 * 根据接口id删除用例模块
	 * @param id
	 * @return
	 */
	public int delTcModelInfo(int id);
	
	/**
	 * 根据用例id查询该用例的所有信息
	 * @param id
	 * @return
	 */
	public TestCasePojo getTcById(int id);
	
	/**
	 * 编辑用例
	 * @return
	 */
	public int  editSysmag(TestCasePojo testCasePojo);
    
}

