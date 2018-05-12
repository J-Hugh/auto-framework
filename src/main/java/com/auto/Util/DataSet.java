package com.auto.Util;

import com.auto.entity.TestCaseEntity;

import java.util.List;

public class DataSet {
	
	public static int TESTCASEID=0;
	public static int CASEDESC=1;
	public static int STEP=2;
	public static int STEPDESC=3;
	public static int PAGENAME=4;
	public static int BYTYPE=5;
	public static int BYEXPRESSION=6;
	public static int PAGEOBJECT=7;
	public static int TESTDATA=8;
	public static int TESTEXPECTVALUE=9;
	public static int ACTION=10;
	
	
	
	public static int FIREFOX_DR=0;
	public static int IE_DR=1;
	public static int CHROME_DR=2;


	//传递参数的KEY
	public static String PLATFORM="platform";
	public static String ENV="env";
	public static String PROJECT="projectId";
	public static String TESTSET="testSet";
	public static String TESTCASES="testcases";
	
	
	public static List<TestCaseEntity> casedatas;
	
	
	//driver 读取的配置文件
	public static String WEB_DRIVER_CONF="driver-config.properties";
	
	//driver 配置文件名
	public static String TEST_ENV_URL="TEST_ENV_URL";
	public static String ONLINE_ENV_URL="ONLINE_ENV_URL";
	public static String BROWSER="BROWSER";
	
	//
	public static int TIMEOUT = 15;
}
