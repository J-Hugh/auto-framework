package com.auto.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

	//public static Properties props =null;
	public static  long lastModifyTime=0;

	public static Properties getProperties(String fileName){
		//File file = new File(PropertiesUtil.class.getClassLoader().getResource(fileName).getFile());

		Properties props = getPropertiesFirstTime(fileName);
		return props;
	}

	public static String getPath(String Name){
		String path=null;
		File file = new File(PropertiesUtil.class.getClassLoader().getResource(Name).getFile());
		path=file.getPath();
		return path;
	}


	public static Properties getPropertiesFirstTime(String fileName){
		Properties props = null;
		if(props==null){
			InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);


			try {
				BufferedReader buffer = new BufferedReader(new InputStreamReader(is,"UTF-8"));  

				props = new Properties();
				props.load(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return props;
	}
}
