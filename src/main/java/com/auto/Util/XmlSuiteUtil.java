package com.auto.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class XmlSuiteUtil {
	@SuppressWarnings("rawtypes")
	public static List<XmlSuite> getListXmlSuite(Class clazz,Map<String, String> paramters){

		List<XmlSuite> xmlSuites =new ArrayList<XmlSuite>();

		XmlClass xmlClass =new XmlClass();
		xmlClass.setClass(clazz);

		XmlSuite xmlSuite =new XmlSuite();
		xmlSuite.setParameters(paramters);
		xmlSuite.setName("Auto_Test");

		List<XmlClass> xmlClasses =new ArrayList<XmlClass>();
		xmlClasses.add(xmlClass);

		XmlTest xmlTest =new XmlTest(xmlSuite);
		xmlTest.setClasses(xmlClasses);
		
		xmlSuites.add(xmlSuite);

		return xmlSuites;
	}
}
