package com.lwlsh.trex.dao;

import java.util.List;
import java.util.Map;

import com.lwlsh.trex.pojo.KwPagePojo;

public interface IkwPagemgDao {
	
	
/**
 * 获取所有的page页面
 * @param map
 * @return
 */
	public List<KwPagePojo> getAllPage(Map<String,Object> map);
	
	
	
	/**
	 *查找
	 */
	public  KwPagePojo getPgmgById(int  pageid);
	
	/**
	 * 新增page页面
	 * @return
	 */
	public int addPagemg(KwPagePojo kwPagePojo);
	
	/**
	 * 删除page
	 * @return
	 */
	public int delPagemg(int pageid);
	
	
	/**
	 * 根据pageID获取pageName
	 * @param pageId
	 * @return
	 */
	public String getNameById(int pageId);

}
