package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IinterfaceDao;
import com.lwlsh.trex.pojo.InterfacePojo;
import com.lwlsh.trex.service.IinterfaceService;

@Service("IinterfaceService")
public class InterfaceServiceImpl implements IinterfaceService {
	
	@Autowired
	private IinterfaceDao iDao;
	

	public InterfacePojo showParamInfo() {
		return iDao.showParamInfo();
	}


	public List<String> smgNameByid(int itf_smgid) {
		return iDao.smgNameByid(itf_smgid);
	}

	public int addInterfaceInfo(InterfacePojo interfacePojo) {
		return iDao.addInterfaceInfo(interfacePojo);
	}

	public int delInterfaceInfo(int id) {
		return iDao.delInterfaceInfo(id);
	}

	public int editInterfaceInfo(InterfacePojo interfacePojo) {
		return iDao.editInterfaceInfo(interfacePojo);
	}

	public List<Object>  selectAllInterfaceInfo(Map<String, Object> map) {
		return iDao.selectAllInterfaceInfo(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return iDao.getTotal(map);
	}



	public List<InterfacePojo> getAllIntName(String  itf_smgId) {
		return iDao.getAllIntName(itf_smgId);
	}


	public InterfacePojo getParamValue(String itf_smgId) {
		return iDao.getParamValue(itf_smgId);
	}


	@Override
	public List<InterfacePojo> getInterfaceName(int sysid) {
		// TODO Auto-generated method stub
		return iDao.getInterfaceName(sysid);
	}


	@Override
	public InterfacePojo getItfById(int itfId) {
		// TODO Auto-generated method stub
		return iDao.getItfById(itfId);
	}



}
