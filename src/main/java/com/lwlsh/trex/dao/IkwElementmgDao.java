package com.lwlsh.trex.dao;

import java.util.List;
import java.util.Map;

import com.lwlsh.trex.pojo.KwElementPojo;

public interface IkwElementmgDao {
	
	
/**
 * 获取所有的element页面
 * @param map
 * @return
 */
	public List<KwElementPojo> getAllEl(Map<String,Object> map);
	
	
	
	/**
	 *查找
	 */
	public  List<KwElementPojo>  getElmgById(int  pageid);
	
	
	/**
	 * 新增page页面
	 * @return
	 */
	public int addElementmg(KwElementPojo kwElementPojo);
	
	/**
	 * 删除page
	 * @return
	 */
	public int delElementmg(int elementid);
	

}
