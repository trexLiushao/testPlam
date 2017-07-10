package com.lwlsh.trex.dao;

import java.util.List;
import java.util.Map;

import com.lwlsh.trex.pojo.TcDetailRdPojo;
import com.lwlsh.trex.pojo.TestCasePojo;

public interface IrunCaseDao {


	/**
	 * 查找所有的用例信息
	 * @return
	 */
	public List<Object> getAllTestCaseInfo(Map<String,Object> casemodeId);
	/**
	 * 查找所有的用例信息(除去tcm_listId里面的用例)
	 * @return
	 */
	public List<Object> getAllTcNot(Map<String,Object> casemodeId);
	  /**
     * 获取总记录数
     * @param map
     * @return获取的total数
     */
    public Long getTotal(Map<String, Object> map);
    
	/**
	 * 根据接口id删除用例
	 * @param id
	 * @return
	 */
	public int delTestCaseInfo(int id);
	
	/**
	 * 根据模块id更新已添加的用例
	 * @param id
	 * @param idList
	 * @return
	 */
	public int udListId(int id ,String idList);
	
	/**
	 * 用例执行详细记录保存
	 * @param tRdPojo
	 * @return
	 */
	public int savaTcdRd(TcDetailRdPojo tRdPojo);

}
