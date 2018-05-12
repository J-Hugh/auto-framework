package com.auto.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TestCaseEntity  implements Serializable {

	private List<TestStepEntity> testStep;
	
	private int id;
	
	private String testCaseId;
	
	private String caseDescription;
	
	private int projectId;
	
	private String projectName;
	
	private String platform;
	
	private int runMode;
	
	private String testSet;
	
	private String createTime;
	
	private String updateTime;
	
	
	@Override
	public String toString() {
		return "TestCaseEntity [id=" + id + ", "
				+ "testCaseId=" + testCaseId+ ", "
				+ "caseDescription=" + caseDescription + ", "
			    + "projectId=" + projectId + ","
			    + "projectName="+projectName+","
			    + "platform=" + platform+ ", "
				+ "runMode=" + runMode + ", "
			    + "testSet=" + testSet + ","
			    + "createTime="+createTime+","
			    + "updateTime=" + updateTime + "]";
	}
	
	public List<TestStepEntity> getTestStep() {
		return testStep;
	}

	public void setTestStep(List<TestStepEntity> testStep) {
		this.testStep = testStep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	public String getCaseDescription() {
		return caseDescription;
	}

	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getRunMode() {
		return runMode;
	}

	public void setRunMode(int runMode) {
		this.runMode = runMode;
	}

	public String getTestSet() {
		return testSet;
	}

	public void setTestSet(String testSet) {
		this.testSet = testSet;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
