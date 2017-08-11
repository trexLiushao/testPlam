package com.lwlsh.trex.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lwlsh.trex.pojo.KeywordPojo;
import com.lwlsh.trex.pojo.KwPagePojo;
@Resource
public interface KeywordService {

	
	public List<KeywordPojo> getAllkeyword(Map<String,Object> map);
	
	

}
