package com.lwlsh.trex.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lwlsh.trex.pojo.KwPagePojo;

@Resource
public interface IkwPagemgservice {
	
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
	
	public String getNameById(int pageId);
	

}
