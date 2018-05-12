package com.auto.entity;

import java.io.Serializable;

import org.openqa.selenium.By;

import com.auto.base.ElementActionBase;

@SuppressWarnings("serial")
public class TestStepEntity extends ElementActionBase implements Serializable{

	private int id;
	
	private String testCaseDesc;

	private String testCaseId;

	private int step;

	private String stepDescription;

	private String pageName;

	private String byType;

	private String byExpression;

	private String pageObjectName;

	private String actionKeyword;

	private String testData;

	private String testExpectValue;

	private String officalData;

	private String officalExpectValue;

	private int parentId;

	private String parentDesc;

	private int childId;

	private String childDesc;

	private int dataRow;

	private String createTime;

	private String updateTime;


	@Override
	public String toString() {
		return "TestStepEntity [id=" + id + ", "
				+ "testCaseId=" + testCaseId+ ", "
				+ "step=" + step + ", "
				+ "stepDescription=" + stepDescription + ","
				+ "pageName="+pageName+","
				+ "byType=" + byType+ ", "
				+ "byExpression=" + byExpression + ", "
				+ "pageObjectName=" + pageObjectName + ","
				+ "actionKeyword=" + actionKeyword+ ", "
				+ "testData=" + testData + ", "
				+ "testExpectValue=" + testExpectValue + ","
				+ "officalData="+officalData+","
				+ "officalExpectValue=" + officalExpectValue+ ", "
				+ "parentId=" + parentId + ", "
				+ "parentDesc=" + parentDesc + ","
				+ "childId="+childId+","
				+ "childDesc=" + childDesc+ ", "
				+ "dataRow=" + dataRow + ", "
				+ "createTime="+createTime+","
				+ "updateTime=" + updateTime + "]";
	}



	public String getTestCaseDesc() {
		return testCaseDesc;
	}

	public void setTestCaseDesc(String testCaseDesc) {
		this.testCaseDesc = testCaseDesc;
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

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getStepDescription() {
		return stepDescription;
	}

	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getByType() {
		return byType;
	}

	public void setByType(String byType) {
		this.byType = byType;
	}

	public String getByExpression() {
		return byExpression;
	}

	public void setByExpression(String byExpression) {
		this.byExpression = byExpression;
	}

	public String getPageObjectName() {
		return pageObjectName;
	}

	public void setPageObjectName(String pageObjectName) {
		this.pageObjectName = pageObjectName;
	}

	public String getActionKeyword() {
		return actionKeyword;
	}

	public void setActionKeyword(String actionKeyword) {
		this.actionKeyword = actionKeyword;
	}

	public String getTestData() {
		return testData;
	}

	public void setTestData(String testData) {
		this.testData = testData;
	}

	public String getTestExpectValue() {
		return testExpectValue;
	}

	public void setTestExpectValue(String testExpectValue) {
		this.testExpectValue = testExpectValue;
	}

	public String getOfficalData() {
		return officalData;
	}

	public void setOfficalData(String officalData) {
		this.officalData = officalData;
	}

	public String getOfficalExpectValue() {
		return officalExpectValue;
	}

	public void setOfficalExpectValue(String officalExpectValue) {
		this.officalExpectValue = officalExpectValue;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentDesc() {
		return parentDesc;
	}

	public void setParentDesc(String parentDesc) {
		this.parentDesc = parentDesc;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public String getChildDesc() {
		return childDesc;
	}

	public void setChildDesc(String childDesc) {
		this.childDesc = childDesc;
	}

	public int getDataRow() {
		return dataRow;
	}

	public void setDataRow(int dataRow) {
		this.dataRow = dataRow;
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



	public void Action(String env) throws NumberFormatException, InterruptedException{
		String type=actionKeyword.trim().toLowerCase();

		switch (type) {
		case "input":
			String data=env.trim().toLowerCase().endsWith("test")?this.testData:this.officalData;
			inputText(data);break;
		case "clear":clear();break;
		case "click":click();break;
		case "check":check(testExpectValue);break;
		case "right_click":rightClick();break;
		case "sleep":sleep(Integer.parseInt(testExpectValue));break;
		case "select":selectByVal(testData);break;
		case "date":date(Integer.parseInt(testExpectValue));break;
		case "switchto_new":switchToNewWindow();break;
		case "uploadimage":uploadimage(testData);break;
		//case "":;break;
		default:
			break;
		}
	}


	public By getBy(){
		By by;
		String value=byExpression;
		switch (byType.trim().toLowerCase()) {
		case "id":
			by=By.id(value);
			break;
		case "name":
			by=By.name(value);
			break;
		case "css":
			by=By.cssSelector(value);
			break;
		case "xpath":
			by=By.xpath(value);
			break;
		case "classname":
			by=By.className(value);
			break;
		case "atext":
			by=By.linkText(value);
			break;
		case "patext":
			by=By.partialLinkText(value);
			break;
		case "tagname":
			by=By.tagName(value);
			break;
		default:
			by=By.xpath(value);
			break;
		}
		return by;
	}

}
