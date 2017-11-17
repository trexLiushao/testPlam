package com.lwlsh.trex.pojo;

import java.util.Date;

public class KwRunResultPojo {
	
	private int id;
	private Date beginTime;
	private Date endTime;
	private String runResult;
	private String failContent;
	private String failImageName;
	private String sucImageName;
	private String tcmodelName;
	private int testcaseId;
	private int projectId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getRunResult() {
		return runResult;
	}
	public void setRunResult(String runResult) {
		this.runResult = runResult;
	}
	public String getFailContent() {
		return failContent;
	}
	public void setFailContent(String failContent) {
		this.failContent = failContent;
	}
	public String getFailImageName() {
		return failImageName;
	}
	public void setFailImageName(String failImageName) {
		this.failImageName = failImageName;
	}
	public String getSucImageName() {
		return sucImageName;
	}
	public void setSucImageName(String sucImageName) {
		this.sucImageName = sucImageName;
	}
	public String getTcmodelName() {
		return tcmodelName;
	}
	public void setTcmodelName(String tcmodelName) {
		this.tcmodelName = tcmodelName;
	}
	public int getTestcaseId() {
		return testcaseId;
	}
	public void setTestcaseId(int testcaseId) {
		this.testcaseId = testcaseId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	

}
