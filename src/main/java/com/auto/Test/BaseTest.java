package com.auto.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.auto.base.BaseDriver;
/**
 * 此类中只做操作处理，数据直接在启启动时就以 List<TestCaseEntity> 形式传递过来
 * 由于使用XMlSuite 方式启动TestNG 传递参数的方式为Map<String >所以此处选择使用全局变量方式进行存储读取测试用例数据
 * 或者直接存进全局变量中
 * @author 201509060197
 *
 */

public class BaseTest extends BaseDriver{
	
    public String env;
    public static String logName;
	public static int timeout = 15;

	
	/**
	 * 测试环境  WEB 端driver 准备
	 * @param map
	 */
	@BeforeClass
	public void beforeClass(){
		this.env="TEST";
		initDriver("WEB");
		//initDriver("Android");
		baseDriverSer.Lunch(env);
	}


	@BeforeTest
	public void beforeTest(){
		initCaseLogger();
	}

	@AfterTest
	public void afterTest(){
		webDriver.quit();
	}

	
	
	
	public void initCaseLogger() {
		String name=this.getClass().getName();
		String caseNumber = name.substring(name.lastIndexOf(".")+1, name.length());
		SimpleDateFormat df = new SimpleDateFormat("HHmmss");
		name = caseNumber+"_"+df.format(new Date()).toString()+"Log";
		logName=name;
		logger = Logger.getLogger(this.getClass().getName());
		// BasicConfigurator replaced with PropertyConfigurator.
		//PropertyConfigurator.configure("resources//config//log4j.properties");
		initLogConfig(name);
		info("=======================================================");
		info("                    开始测试  "+caseNumber);
		info("=======================================================");
		
	}
}
