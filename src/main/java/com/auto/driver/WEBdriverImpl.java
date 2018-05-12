package com.auto.driver;

import java.util.List;
import java.util.concurrent.TimeUnit;



import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.util.CollectionUtils;

import com.auto.Util.DataSet;
import com.auto.base.BaseDriver;
import com.auto.base.TestHelper;




public class WEBdriverImpl extends BaseDriver  {
	//获取程序地址
	private String getPahts(){
		List<String[]> list=TestHelper.initExcelPath();
		if(CollectionUtils.isEmpty(list)||list.get(0)==null||list.get(0).length==0){
			System.out.println("-------请在第一个Sheet中配置测试系统路径--------------");
		}
		//行-列
		return list.get(0)[0];
	}

	public void Lunch(String env) {
		String URL = "http://zjs.t.nxin.com/login.do";
		switch (env.toUpperCase().trim()) {
		//判断被测得环境map.get(DataSet.ENV)
		case "TEST": URL=getPahts();break;
		case "ONLINE":URL=config.getProperty(DataSet.ONLINE_ENV_URL) ;break;
		default: break;
		}
		if(StringUtils.isBlank(URL)){
			System.out.println("-------请在第一个Sheet中配置测试系统路径--------------");
		}
		System.out.println("-------请求的系统:"+URL);
		//本机测试时使用
		webDriver = webDriver==null?new FirefoxDriver():webDriver;
		//使用分布式进行测试
		//		DesiredCapabilities capabilities = new DesiredCapabilities();
		//		
		//		try {
		//			webDriver=new RemoteWebDriver(new URL(""), capabilities);
		//		} catch (MalformedURLException e) {
		//			e.printStackTrace();
		//		}
		//打开地址
		webDriver.get(URL);
		//设置全局等待
		webDriver.manage().timeouts().implicitlyWait(DataSet.TIMEOUT,TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		
	}


	public String getRePortName() {
		reportName=config.getProperty("reportName");
		System.out.println(reportName);
		return reportName;
	}



}
