package com.lwlsh.trex.pojo;

public class KwTcModePojo {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	public String getTestdesc() {
		return testdesc;
	}
	public void setTestdesc(String testdesc) {
		this.testdesc = testdesc;
	}
	public int id;
	public int testcaseId;
	public int getTestcaseId() {
		return testcaseId;
	}
	public void setTestcaseId(int testcaseId) {
		this.testcaseId = testcaseId;
	}
	public String  testdesc;
	public String testName;
}
