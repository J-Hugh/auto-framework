package com.auto.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import com.auto.Test.AutoTest;
import com.auto.Util.XmlSuiteUtil;

public class Start {
	
	public static void main(String[] args) {
		Map<String ,String> map=new HashMap<String, String>();
		map.put("map", "{'testcase':'登录','env':'TEST','projectId':'0'}");
		List<XmlSuite> XmlSuites=XmlSuiteUtil.getListXmlSuite(AutoTest.class, map);	
		TestNG testNG =new TestNG();
		testNG.setXmlSuites(XmlSuites);
		testNG.setOutputDirectory("D:/report");
		testNG.run();
		
	}
}
