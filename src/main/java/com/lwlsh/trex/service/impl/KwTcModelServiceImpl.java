package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IkwTcModelDao;
import com.lwlsh.trex.pojo.KwTcModePojo;
import com.lwlsh.trex.service.IkwTcModelservice;
import com.sun.mail.handlers.image_gif;

@Service("IkwTcModelservice")
public class KwTcModelServiceImpl implements IkwTcModelservice {
	
	@Autowired
	private IkwTcModelDao ikwTcModelDao;

	@Override
	public List<KwTcModePojo> getAllTc(Map<String, Object> map) {
		return ikwTcModelDao.getAllTc(map);
	}

	@Override
	public KwTcModePojo getTcById(int tcid) {
		return ikwTcModelDao.getTcById(tcid);
	}

	@Override
	public int addTcModel(KwTcModePojo kwTcModePojo) {
		return ikwTcModelDao.addTcModel(kwTcModePojo);
	}

	@Override
	public int delTcModel(int tcid) {
		return ikwTcModelDao.delTcModel(tcid);
	}

	@Override
	public List<KwTcModePojo> getTcCaseById(String tcmdName) {
		return ikwTcModelDao.getTcCaseById(tcmdName);
	}



}
