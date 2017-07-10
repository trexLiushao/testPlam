package com.lwlsh.trex.pojo;

/**
 * 用例模块管理
 * @author Administrator
 *
 */
public class TestCaseModelPojo {

	private int id;
	private int tcm_sysId;
	private String tcm_tcListId;
	private String tcm_name;
	private String tcm_status;
	private String tcm_tcmDes;
/*	private TestCasePojo testCaseInfo; 
	public TestCasePojo getTestCaseInfo() {
		return testCaseInfo;
	}
	public void setTestCaseInfo(TestCasePojo testCaseInfo) {
		this.testCaseInfo = testCaseInfo;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTcm_sysId() {
		return tcm_sysId;
	}
	public void setTcm_sysId(int tcm_sysId) {
		this.tcm_sysId = tcm_sysId;
	}
	public String getTcm_tcListId() {
		return tcm_tcListId;
	}
	public void setTcm_tcListId(String tcm_tcListId) {
		this.tcm_tcListId = tcm_tcListId;
	}
	public String getTcm_name() {
		return tcm_name;
	}
	public void setTcm_name(String tcm_name) {
		this.tcm_name = tcm_name;
	}
	public String getTcm_status() {
		return tcm_status;
	}
	public void setTcm_status(String tcm_status) {
		this.tcm_status = tcm_status;
	}
	public String getTcm_tcmDes() {
		return tcm_tcmDes;
	}
	public void setTcm_tcmDes(String tcm_tcmDes) {
		this.tcm_tcmDes = tcm_tcmDes;
	}
}
