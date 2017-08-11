package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IkwElementmgDao;
import com.lwlsh.trex.dao.IkwPagemgDao;
import com.lwlsh.trex.pojo.KwElementPojo;
import com.lwlsh.trex.pojo.KwPagePojo;
import com.lwlsh.trex.service.IkwElementmgservice;
import com.lwlsh.trex.service.IkwPagemgservice;

@Service("IkwElementmgservice")
public class KwElementmgSerivceImpl implements IkwElementmgservice {
	
	
	@Autowired
	private IkwElementmgDao ikwElementmgDao;

	@Override
	public List<KwElementPojo> getAllEl(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ikwElementmgDao.getAllEl(map);
	}

	@Override
	public List<KwElementPojo>  getElmgById(int pageid) {
		// TODO Auto-generated method stub
		return ikwElementmgDao.getElmgById(pageid);
	}

	@Override
	public int addElementmg(KwElementPojo kwElementPojo) {
		// TODO Auto-generated method stub
		return ikwElementmgDao.addElementmg(kwElementPojo);
	}

	@Override
	public int delElementmg(int elementid) {
		// TODO Auto-generated method stub
		return ikwElementmgDao.delElementmg(elementid);
	}


	
}
