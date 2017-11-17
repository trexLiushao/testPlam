package com.lwlsh.trex.service;

import java.util.List;

import javax.annotation.Resource;

import com.lwlsh.trex.pojo.KwRunResultPojo;
import com.lwlsh.trex.pojo.KwTcasePojo;

@Resource
public interface IkwResultService {
	/**
	 * 新增用例执行结果-详情结果
	 * @return
	 */
	public int addTcrusultDetail(KwRunResultPojo kwRunResultPojo);
	
	/**
	 * 获取所有的用例执行-详情结果by模块名
	 * @param map
	 * @return
	 */
	public List<KwTcasePojo> getRsByName(String tcmodelName);
	

}
