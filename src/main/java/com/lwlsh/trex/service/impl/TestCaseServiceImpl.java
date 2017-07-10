package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.ItestCaseDao;
import com.lwlsh.trex.pojo.TestCasePojo;
import com.lwlsh.trex.service.ItestCaseService;

@Service("ItestCaseService")
public class TestCaseServiceImpl implements ItestCaseService {
	
	@Autowired
	private ItestCaseDao itcdao;

	public int addTestcaseInfo(TestCasePojo testCasePojo) {
		return itcdao.addTestcaseInfo(testCasePojo);
	}

	public List<Object> selectAllTestCaseInfo(Map<String, Object> map) {
		return itcdao.selectAllTestCaseInfo(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return itcdao.getTotal(map);
	}

	@Override
	public int delTcModelInfo(int id) {
		return itcdao.delTcModelInfo(id);
	}

	@Override
	public TestCasePojo getTcById(int id) {
		return itcdao.getTcById(id);
	}

	@Override
	public int editSysmag(TestCasePojo testCasePojo) {
		return itcdao.editSysmag(testCasePojo);
	}


}
