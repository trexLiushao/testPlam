package com.lwlsh.trex.dao;

import java.util.List;
import java.util.Map;

import com.lwlsh.trex.pojo.InterfacePojo;

public interface IinterfaceDao {
	
	/**
	 *查找到所有的接口名称加载到下拉列表
	 */
	public List<InterfacePojo>  getAllIntName(String  itf_smgId);
	
	/**
	 *查找id 查询接口
	 */
	public InterfacePojo  getItfById(int  itfId);
	/**
	 *查找到某接口下的参数值
	 */
	public InterfacePojo  getParamValue(String  itf_smgId);
	
	/**
	 * 根据sysid查找到所有的接口名
	 */
	public List<InterfacePojo>  getInterfaceName(int sysid);

	/**
	 * 获取参数字段值，返回到页面展示
	 * @return
	 */
	public InterfacePojo  showParamInfo();
	
	/**
	 * 根据itf_smgid查找到所有的系统名称
	 */
	public List<String>  smgNameByid(int itf_smgid);

	
	/**
	 * 新增接口信息
	 * @param interfacePojo
	 * @return
	 */
	public  int addInterfaceInfo(InterfacePojo interfacePojo);
	
	
	/**
	 * 根据接口id删除接口信息
	 * @param id
	 * @return
	 */
	public int delInterfaceInfo(int id);
	
	/**
	 * 编辑接口信息(其实就是更新)
	 * @return
	 */
	public int editInterfaceInfo(InterfacePojo interfacePojo);
	/**
	 * 查找系统主机
	 * @return
	 */
	public List<Object> selectAllInterfaceInfo(Map<String,Object> map);
	  /**
     * 获取总记录数
     * @param map
     * @return获取的total数
     */
    public Long getTotal(Map<String, Object> map);
	

}
