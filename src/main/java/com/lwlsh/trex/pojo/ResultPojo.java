package com.lwlsh.trex.pojo;

import java.util.Date;

public class ResultPojo {

	private int id;
	private int tcr_tcmId;
	private Date tcr_runTime;
	private Date tcr_endTime;
	private int tcr_passCaseNum;
	private int tcr_failCaseNum;
	private int tcr_skipCaseNum;
	public int tcr_isRunStaus;
	public int getTcr_isRunStaus() {
		return tcr_isRunStaus;
	}
	public void setTcr_isRunStaus(int tcr_isRunStaus) {
		this.tcr_isRunStaus = tcr_isRunStaus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTcr_tcmId() {
		return tcr_tcmId;
	}
	public void setTcr_tcmId(int tcr_tcmId) {
		this.tcr_tcmId = tcr_tcmId;
	}
	public Date getTcr_runTime() {
		return tcr_runTime;
	}
	public void setTcr_runTime(Date tcr_runTime) {
		this.tcr_runTime = tcr_runTime;
	}
	public Date getTcr_endTime() {
		return tcr_endTime;
	}
	public void setTcr_endTime(Date tcr_endTime) {
		this.tcr_endTime = tcr_endTime;
	}
	public int getTcr_passCaseNum() {
		return tcr_passCaseNum;
	}
	public void setTcr_passCaseNum(int tcr_passCaseNum) {
		this.tcr_passCaseNum = tcr_passCaseNum;
	}
	public int getTcr_failCaseNum() {
		return tcr_failCaseNum;
	}
	public void setTcr_failCaseNum(int tcr_failCaseNum) {
		this.tcr_failCaseNum = tcr_failCaseNum;
	}
	public int getTcr_skipCaseNum() {
		return tcr_skipCaseNum;
	}
	public void setTcr_skipCaseNum(int tcr_skipCaseNum) {
		this.tcr_skipCaseNum = tcr_skipCaseNum;
	}
	
}
