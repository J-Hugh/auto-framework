package com.auto.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.auto.Util.PropertiesUtil;
import com.auto.Util.ReadExcelFileUtil;


public class TestHelper {

	public static Properties config=null;
	public static List<String []> testList =new ArrayList<String[]>() ;

	public TestHelper(){
		initConfig();
		initExcelData();
	}


	public  Properties initConfig(){
		if(config==null)
			config=	PropertiesUtil.getProperties("data-config.properties");
		return config;
	}
	
	public  void initExcelData(){
		String path=config.getProperty("FILE_EXCEL_PATH");
		String fileName=config.getProperty("FILE_EXCEL_name");
		//testList=(testList==null)?ReadExcelFileUtil.ReadExcelAll(path+fileName):testList;
		testList=ReadExcelFileUtil.ReadExcelAll(path+fileName);
	}
	
	public static List<String[]> initExcelPath(){
		Properties config1=PropertiesUtil.getProperties("data-config.properties");
		String path=config1.getProperty("FILE_EXCEL_PATH");
		String fileName=config1.getProperty("FILE_EXCEL_name");
		return ReadExcelFileUtil.ReadExcelPath(path+fileName);
	}
}
