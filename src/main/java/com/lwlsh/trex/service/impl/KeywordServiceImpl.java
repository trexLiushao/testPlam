package com.lwlsh.trex.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.KeywordDao;
import com.lwlsh.trex.pojo.KeywordPojo;
import com.lwlsh.trex.service.KeywordService;
@Service("KeywordService")
public class KeywordServiceImpl implements KeywordService {
	@Autowired
	private  KeywordDao kDao;

	@Override
	public List<KeywordPojo> getAllkeyword(Map<String, Object> map) {
		return kDao.getAllkeyword(map);
	}


}
