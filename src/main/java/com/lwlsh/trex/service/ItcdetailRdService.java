package com.lwlsh.trex.service;

import com.lwlsh.trex.pojo.TcDetailRdPojo;

public interface ItcdetailRdService {
	/**
	 * 新增执行结果到数据库
	 * @param resultPojo
	 * @return
	 */
	public int addTcdetailRdInfo(TcDetailRdPojo resultPojo);
	
	
	/**
	 * 更新测试结果
	 * @param resultPojo
	 * @return
	 */
	public int updTcdetailRdInfo(TcDetailRdPojo resultPojo);



}
