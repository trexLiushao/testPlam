package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IkwTcDao;
import com.lwlsh.trex.pojo.KwTcasePojo;
import com.lwlsh.trex.service.IkwTcaseservice;

@Service("IkwTcaseservice")
public class KwTcaseServiceImpl implements IkwTcaseservice{
	
	@Autowired
	private  IkwTcDao ikwTcDao;

	@Override
	public List<KwTcasePojo> getAllTc(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ikwTcDao.getAllTc(map);
	}

	@Override
	public KwTcasePojo getTcById(int tcid) {
		// TODO Auto-generated method stub
		return ikwTcDao.getTcById(tcid);
	}

	@Override
	public int addTcase(KwTcasePojo kwTcasePojo) {
		// TODO Auto-generated method stub
		return ikwTcDao.addTcase(kwTcasePojo);
	}

	@Override
	public int delTcase(int tcid) {
		// TODO Auto-generated method stub
		return ikwTcDao.delTcase(tcid);
	}

	@Override
	public int updateTcase(KwTcasePojo kwTcasePojo) {
		// TODO Auto-generated method stub
		return ikwTcDao.updateTcase(kwTcasePojo);
	}

	@Override
	public String getNameById(int testcaseId) {
		// TODO Auto-generated method stub
		return ikwTcDao.getNameById(testcaseId);
	}

	@Override
	public List<KwTcasePojo> getAllTcbyId(int testcaseId) {
		// TODO Auto-generated method stub
		return ikwTcDao.getAllTcbyId(testcaseId);
	}

	@Override
	public String getDescById(int testcaseId) {
		// TODO Auto-generated method stub
		return ikwTcDao.getDescById(testcaseId);
	}
	

}
