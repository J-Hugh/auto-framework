package com.auto.Test;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auto.Util.ApiTestExcelProvider;
import com.auto.entity.TestStepEntity;


public class AutoTest extends BaseTest {

	@DataProvider(name = "dataRedy")
	public Iterator<Object[]>  DataProvider(){
		Iterator<Object[]> step=new ApiTestExcelProvider();
		return step;
	}


	@Test(dataProvider="dataRedy")
	public void AutoTests(TestStepEntity testStep) throws NumberFormatException, InterruptedException{
		//执行测试 
		info("【用例描述】"+testStep.getTestCaseDesc());
		info("【步骤"+testStep.getStep()+"】:"+testStep.getStepDescription());
		info("【要查找的元素】"+testStep.getByType() +":"+testStep.getByExpression());
		testStep.Action(env);
	}
}
