package com.lwlsh.trex.dao;

import com.lwlsh.trex.pojo.ResultPojo;

public interface IresultDao {
	
	
	/**
	 * 新增执行结果到数据库
	 * @param resultPojo
	 * @return
	 */
	public int addResultInfo(ResultPojo resultPojo);
	
	
	/**
	 * 更新测试结果
	 * @param resultPojo
	 * @return
	 */
	public int updResultInfo(ResultPojo resultPojo);

}
