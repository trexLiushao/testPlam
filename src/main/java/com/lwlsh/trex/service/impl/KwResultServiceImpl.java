package com.lwlsh.trex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IkwResultDao;
import com.lwlsh.trex.pojo.KwRunResultPojo;
import com.lwlsh.trex.pojo.KwTcasePojo;
import com.lwlsh.trex.service.IkwResultService;

@Service("IkwResultService")
public class KwResultServiceImpl  implements IkwResultService{
	
	@Autowired
	private IkwResultDao ikwResultDao;

	@Override
	public int addTcrusultDetail(KwRunResultPojo kwRunResultPojo) {
		return ikwResultDao.addTcrusultDetail(kwRunResultPojo);
	}

	@Override
	public List<KwTcasePojo> getRsByName(String tcmodelName) {
		return ikwResultDao.getRsByName(tcmodelName);
	}

}
