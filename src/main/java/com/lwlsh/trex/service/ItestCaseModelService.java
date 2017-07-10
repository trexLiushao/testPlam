package com.lwlsh.trex.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lwlsh.trex.pojo.TestCaseModelPojo;

@Resource
public interface ItestCaseModelService {

	
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
