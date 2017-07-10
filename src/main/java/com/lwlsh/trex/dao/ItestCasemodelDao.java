package com.lwlsh.trex.dao;
import java.util.List;
import java.util.Map;

import com.lwlsh.trex.pojo.InterfacePojo;
import com.lwlsh.trex.pojo.TestCaseModelPojo;

public interface ItestCasemodelDao {
	
	/**
	 * 	新增用例模块信息
	 * @param testCaseModelPojo
	 * @return
	 */
	public  int addTestcaseModeInfo(TestCaseModelPojo testCaseModelPojo);
	
	/**
	 * 查找系统主机
	 * @return
	 */
	public List<Object> selectAllTestCaseModel(Map<String,Object> map);
	  /**
     * 获取总记录数
     * @param map
     * @return获取的total数
     */
    public Long getTotal(Map<String, Object> map);
	
    
    /**
	 * 更新用例模块
	 * @return
	 */
	public int updateTcModelInfo(TestCaseModelPojo testCaseModelPojo);
	
	/**
	 * 根据接口id删除用例模块
	 * @param id
	 * @return
	 */
	public int delTcModelInfo(int id);

}
