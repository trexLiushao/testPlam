package com.lwlsh.trex.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lwlsh.trex.pojo.KwElementPojo;
import com.lwlsh.trex.pojo.KwPagePojo;

@Resource
public interface IkwElementmgservice {
	
	/**
	 * 获取所有的element页面
	 * @param map
	 * @return
	 */
		public List<KwElementPojo> getAllEl(Map<String,Object> map);
		
		
		
		/**
		 *查找
		 */
		public List<KwElementPojo> getElmgById(int  pageid);
		
		
		/**
		 * 新增element页面
		 * @return
		 */
		public int addElementmg(KwElementPojo kwElementPojo);
		
		/**
		 * 删除element
		 * @return
		 */
		public int delElementmg(int elementid);
		

}
