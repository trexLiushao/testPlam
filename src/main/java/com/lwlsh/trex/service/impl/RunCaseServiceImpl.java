package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IrunCaseDao;
import com.lwlsh.trex.service.IrunCaseService;

@Service("IrunCaseService")
public class RunCaseServiceImpl implements IrunCaseService{
	
	@Autowired
	private IrunCaseDao irunCaseDao;

	@Override
	public List<Object> getAllTestCaseInfo(Map<String, Object> casemodeId) {
		// TODO Auto-generated method stub
		return irunCaseDao.getAllTestCaseInfo(casemodeId);
	}
	@Override
	public Long getTotal(Map<String, Object> map) {
		return irunCaseDao.getTotal(map);
	}
	@Override
	public int delTestCaseInfo(int id) {
		return irunCaseDao.delTestCaseInfo(id);
	}
	@Override
	public List<Object> getAllTcNot(Map<String, Object> casemodeId) {
		return irunCaseDao.getAllTcNot(casemodeId);
	}
	@Override
	public int udListId(int id, String idList) {
		return irunCaseDao.udListId(id, idList);
	}



}
