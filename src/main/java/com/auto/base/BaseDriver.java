package com.auto.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.auto.Util.DataSet;
import com.auto.Util.PropertiesUtil;
import com.auto.driver.WEBdriverImpl;
import com.zjs.Listenner.Listenner;

@Listeners({Listenner.class})
public class BaseDriver {
	public static BaseDriver baseDriverSer=null;
	public static  WebDriver webDriver =null;
	public static Logger logger = null;
	public String reportName;
	public  static Properties config=null;
	

	public void initDriver(String platform){
		config=config==null?PropertiesUtil.getProperties(DataSet.WEB_DRIVER_CONF):config;
		switch (platform.trim().toUpperCase()) {
		case "WEB":baseDriverSer=baseDriverSer==null?new WEBdriverImpl():baseDriverSer; break;
		default:
			break;
		}
	}

	public void Lunch(String evn) {

	}

	public String getRePortName() {
		return null;
	}


	/**
	 * take screenShot截图
	 * 
	 * @author kim
	 */
	public void screenShot() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
		screenShot(df.format(new Date()).toString());
	}
	
	/**
	 * take screenShot by name截图
	 * 
	 * @param name
	 *            name of screenShot
	 * @author kim
	 */
	public void screenShot(String name) {
		//String path = System.getProperty("user.dir")+"\\resources\\screenshot";
		String path = "D:/resources/screenshot";
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		File screenShotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(path +"\\"+ name + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeSuite
	public void init() {
		initLogger();
	}
	
	@AfterSuite(alwaysRun=true)
	public void log() {
		new LogBase().writeLog(Listenner.result,baseDriverSer.getRePortName());
		baseDriverSer=null;
		webDriver=null;
		config=null;
	}
	
	

	public void initLogger() {
		logger = Logger.getLogger(this.getClass().getName());
		// BasicConfigurator replaced with PropertyConfigurator.
		String log4j = getClass().getResource("/config/log4j.properties").getFile();


		PropertyConfigurator.configure(log4j);
		//PropertyConfigurator.configure("D:/resources/config/log4j.properties");
		initLogConfig("BaseLog");
		info("=======================================================");
		info("                    测试开始");
		info("=======================================================");


	}
	
	/**
	 * add logger info
	 * 
	 * 
	 * 
	 */
	public static void info(String info){
		logger.info(info);
	}
	
	/**
	 * initialize LogConfig
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public void initLogConfig(String name){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
		String fileName = df.format(new Date()).toString();
		String ip;
		FileAppender append;
		try {
			ip = java.net.InetAddress.getLocalHost().getHostAddress();
			//String lPath = System.getProperty("user.dir") + "/resources/log/" + fileName + "/" + ip;
			String lPath = "D:/resources/log/" + fileName + "/" + ip;
			System.out.println("====测试报告保存目录：" + lPath);
			File tmp = new File(lPath);
			if (!tmp.getAbsoluteFile().exists()) {
				tmp.getAbsoluteFile().mkdirs();
			}
			append = (FileAppender) logger.getRoot().getAppender("File");
			String logPath = lPath + "//" + name;
			append.setFile(logPath);
			append.activateOptions();
		} catch (Exception e) {}
	}
	
	
}
