package com.lwlsh.trex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IresultDao;
import com.lwlsh.trex.pojo.ResultPojo;
import com.lwlsh.trex.service.IresultService;
@Service("IresultService")
public class ResultSeviceImpl implements IresultService {
	@Autowired
	private IresultDao iresultDao;

	@Override
	public int addResultInfo(ResultPojo resultPojo) {
		return iresultDao.addResultInfo(resultPojo);
	}

	@Override
	public int updResultInfo(ResultPojo resultPojo) {
		return iresultDao.updResultInfo(resultPojo);
	}

}
