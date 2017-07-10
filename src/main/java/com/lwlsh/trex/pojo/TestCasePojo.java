package com.lwlsh.trex.pojo;

/**
 * 用例管理表
 * @author Administrator
 *
 */
public class TestCasePojo {
	
	private int id;
	private int tc_interfaceId;
	private String  tc_inputData;
	private String tc_exptData;
	private String tc_caseLevel;
	private int tc_sysId;

	private int  tc_supInterId;
	private String tc_valDb;
	private String tc_sqlyuju;
	private String tc_sqlexptData;
	private String tc_tcdesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTc_interfaceId() {
		return tc_interfaceId;
	}
	public void setTc_interfaceId(int tc_interfaceId) {
		this.tc_interfaceId = tc_interfaceId;
	}
	public String getTc_inputData() {
		return tc_inputData;
	}
	
	public void setTc_inputData(String tc_inputData) {
		this.tc_inputData = tc_inputData;
	}
	public String getTc_exptData() {
		return tc_exptData;
	}
	public void setTc_exptData(String tc_exptData) {
		this.tc_exptData = tc_exptData;
	}
	public String getTc_caseLevel() {
		return tc_caseLevel;
	}
	public void setTc_caseLevel(String tc_caseLevel) {
		this.tc_caseLevel = tc_caseLevel;
	}
	public int getTc_sysId() {
		return tc_sysId;
	}
	public void setTc_sysId(int tc_sysId) {
		this.tc_sysId = tc_sysId;
	}

	public int getTc_supInterId() {
		return tc_supInterId;
	}
	public void setTc_supInterId(int tc_supInterId) {
		this.tc_supInterId = tc_supInterId;
	}
	public String getTc_valDb() {
		return tc_valDb;
	}
	public void setTc_valDb(String tc_valDb) {
		this.tc_valDb = tc_valDb;
	}
	public String getTc_sqlyuju() {
		return tc_sqlyuju;
	}
	public void setTc_sqlyuju(String tc_sqlyuju) {
		this.tc_sqlyuju = tc_sqlyuju;
	}
	public String getTc_sqlexptData() {
		return tc_sqlexptData;
	}
	public void setTc_sqlexptData(String tc_sqlexptData) {
		this.tc_sqlexptData = tc_sqlexptData;
	}
	public String getTc_tcdesc() {
		return tc_tcdesc;
	}
	public void setTc_tcdesc(String tc_tcdesc) {
		this.tc_tcdesc = tc_tcdesc;
	}

}
