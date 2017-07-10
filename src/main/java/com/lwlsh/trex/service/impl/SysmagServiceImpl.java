package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IsysmagDao;
import com.lwlsh.trex.pojo.Sysmag;
import com.lwlsh.trex.service.IsysmagService;


@Service("IsysmagService")
public class SysmagServiceImpl implements IsysmagService {
	@Autowired
	private IsysmagDao isysmagDao;

	public int addSysmag(Sysmag sysmag) {
		 return isysmagDao.addSysmag(sysmag);
	}

	public List<Sysmag> getAllsmgName() {
		return isysmagDao.getAllsmgName();
	}
	
	public int delSysmag(int smg_id) {
		return  isysmagDao.delSysmag(smg_id);
	}
	public int  editSysmag(Sysmag sysmag) {
		return  isysmagDao.editSysmag(sysmag);
	}

	public List<Sysmag> selectAllSysmagr(Map<String,Object> map) {
		return  isysmagDao.selectAllSysmagr(map);
	}


	public Long getTotal(Map<String, Object> map) {
		return isysmagDao.getTotal(map);
	}


	public List<Sysmag> selectAllSysmag() {
		return isysmagDao.selectAllSysmag();
	}

	@Override
	public Sysmag getSysById(int sysid) {
		return isysmagDao.getSysById(sysid);
	}
}
