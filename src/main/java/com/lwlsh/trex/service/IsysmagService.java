package com.lwlsh.trex.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lwlsh.trex.pojo.Sysmag;

@Resource
public interface IsysmagService {
	/**
	 * 新增系统主机
	 * @return
	 */
	public int addSysmag(Sysmag sysmag);
	
	/**
	 *查找id 查询系统
	 */
	public  Sysmag getSysById(int  sysid);
	
	/**
	 *查找到所有的系统名称加载到下拉列表
	 */
	public List<Sysmag>  getAllsmgName();
	/**
	 * 删除系统主机
	 * @return
	 */
	public int delSysmag(int smg_id);
	/**
	 * 编辑系统主机
	 * @return
	 */
	public int editSysmag(Sysmag sysmag);
	
	/**
	 * 查找系统主机(暂时用着的)
	 * @return
	 */
	public List<Sysmag> selectAllSysmag();
	/**
	 * 查找系统主机
	 * @return
	 */
	public List<Sysmag> selectAllSysmagr(Map<String,Object> map);
	  /**
     * 获取总记录数
     * @param map
     * @return获取的total数
     */
    public Long getTotal(Map<String, Object> map);
	
	
}
