package com.lwlsh.trex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IresultDao;
import com.lwlsh.trex.dao.ItcdetailRdDao;
import com.lwlsh.trex.pojo.ResultPojo;
import com.lwlsh.trex.pojo.TcDetailRdPojo;
import com.lwlsh.trex.service.IresultService;
import com.lwlsh.trex.service.ItcdetailRdService;
@Service("ItcdetailRdService")
public class TcdetailRdSeviceImpl implements ItcdetailRdService {
	@Autowired
	private ItcdetailRdDao itcdetailRdDao;

	@Override
	public int addTcdetailRdInfo(TcDetailRdPojo resultPojo) {
		return itcdetailRdDao.addTcdetailRdInfo(resultPojo);
	}

	@Override
	public int updTcdetailRdInfo(TcDetailRdPojo resultPojo) {
		return itcdetailRdDao.updTcdetailRdInfo(resultPojo);
	}

}
