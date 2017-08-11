package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IkwPagemgDao;
import com.lwlsh.trex.pojo.KwPagePojo;
import com.lwlsh.trex.service.IkwPagemgservice;

@Service("IkwPagemgservice")
public class KwPagemgSerivceImpl implements IkwPagemgservice {
	
	
	@Autowired
	private IkwPagemgDao ikwPagemgDao;


	@Override
	public List<KwPagePojo> getAllPage(Map<String, Object> map) {
		return ikwPagemgDao.getAllPage(map);
	}

	@Override
	public KwPagePojo getPgmgById(int pageid) {
		return ikwPagemgDao.getPgmgById(pageid);
	}

	@Override
	public int addPagemg(KwPagePojo kwPagePojo) {
		return ikwPagemgDao.addPagemg(kwPagePojo);
	}

	@Override
	public int delPagemg(int pageid) {
		return ikwPagemgDao.delPagemg(pageid);
	}

	@Override
	public String getNameById(int pageId) {
		// TODO Auto-generated method stub
		return ikwPagemgDao.getNameById(pageId);
	}

}
