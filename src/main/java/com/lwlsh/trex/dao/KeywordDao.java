package com.lwlsh.trex.dao;

import java.util.List;
import java.util.Map;

import com.lwlsh.trex.pojo.KeywordPojo;

public interface KeywordDao {
	
	public List<KeywordPojo> getAllkeyword(Map<String,Object> map);

}
