package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.ItestCasemodelDao;
import com.lwlsh.trex.pojo.TestCaseModelPojo;
import com.lwlsh.trex.service.ItestCaseModelService;

@Service("ItestCaseModelService")
public class TestCaseModelServiceImpl implements ItestCaseModelService {
	
	@Autowired
	private ItestCasemodelDao itestCasemodelDao;

	public int addTestcaseModeInfo(TestCaseModelPojo testCaseModelPojo) {
		return itestCasemodelDao.addTestcaseModeInfo(testCaseModelPojo);
	}

	public List<Object> selectAllTestCaseModel(Map<String, Object> map) {
		return itestCasemodelDao.selectAllTestCaseModel(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return itestCasemodelDao.getTotal(map);
	}

	public int updateTcModelInfo(TestCaseModelPojo testCaseModelPojo) {
		return itestCasemodelDao.updateTcModelInfo(testCaseModelPojo);
	}

	public int delTcModelInfo(int id) {
		return itestCasemodelDao.delTcModelInfo(id);
	}

}
