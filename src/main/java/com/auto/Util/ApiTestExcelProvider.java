package com.auto.Util;

import java.util.Iterator;

import com.auto.base.TestHelper;
import com.auto.entity.TestStepEntity;




public class ApiTestExcelProvider extends TestHelper implements Iterator<Object[]> {

	private static int index = 1;

	public ApiTestExcelProvider() {
		super();
	}

	@Override
	public boolean hasNext() {
		if(TestHelper.testList!=null)
			return ApiTestExcelProvider.index < TestHelper.testList.size();
		return false;
	}

	
	@Override
	public Object[] next() {
		TestStepEntity t = null ;
		System.out.println("输出对象");
		String [] str =TestHelper.testList.get(index);
		for (int i = 0; i < str.length; i++) {
			t=new TestStepEntity();
			t.setTestCaseId(str[DataSet.TESTCASEID]);
			t.setTestCaseDesc(str[DataSet.CASEDESC]);
			t.setStep(Integer.parseInt(str[DataSet.STEP]));
			t.setStepDescription(str[DataSet.STEPDESC]);
			t.setPageName(str[DataSet.PAGENAME]);
			t.setByType(str[DataSet.BYTYPE]);
			t.setByExpression(str[DataSet.BYEXPRESSION]);
			t.setPageObjectName(str[DataSet.PAGEOBJECT]);
			t.setTestData(str[DataSet.TESTDATA]);
			t.setTestExpectValue(str[DataSet.TESTEXPECTVALUE]);
			t.setActionKeyword(str[DataSet.ACTION]);
		}
		Object[] obj ={ t };
		index++;
		return obj;
	}

	@Override
	public void remove() {

	}

}
