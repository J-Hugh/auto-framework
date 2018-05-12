package com.auto.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcelFileUtil {

	/**
	 * 读取Excel的全部用例
	 * 不包括列名
	 * @param excelFile
	 * @return  返回为list集合
	 */
	public static List<String[]> ReadExcelAll(String FilePath) {
		List<String[]> result = null;
		String [] str;
		try{
			File file = new File(FilePath);		
			FileInputStream fis = null ; 
			if (file.isFile() && file.exists()) 
				fis = new FileInputStream(file);
			if(fis!=null){
				result=new ArrayList<String[]>();
				jxl.Workbook rwb = Workbook.getWorkbook(fis);   
				Sheet[] sheet = rwb.getSheets();   
				//从第二页开始读取
				for (int i = 1; i < sheet.length; i++) {   
					Sheet rs = rwb.getSheet(i);  
					for (int j = 0; j < rs.getRows(); j++) {   
						Cell[] cells = rs.getRow(j); 
						str=new String [cells.length];
						for(int k=0;k<cells.length;k++){
							str[k]=cells[k].getContents();
						}
						if(str.length==0){
							continue;
						}
						result.add(str);			
					}   
				}   
				fis.close();      
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("not found file!");
		}
		return result;
	}

	/**
	 * 读取第一页的项目地址
	 * @param excelFile
	 * @return  返回为list集合
	 */
	public static List<String[]> ReadExcelPath(String FilePath) {
		List<String[]> result = null;
		String [] str;
		FileInputStream fis = null ;
		try{
			File file = new File(FilePath);		
			if (file.isFile() && file.exists()) {
				
				fis = new FileInputStream(file);
			}else{
				System.out.println("_____________请在系统的:"+FilePath+"路径下填写配置文件________");
			}
			if(fis!=null){
				result=new ArrayList<String[]>();
				jxl.Workbook rwb = Workbook.getWorkbook(fis);   
				Sheet rs = rwb.getSheet(0);   
					for (int j = 0; j < rs.getRows(); j++) {   
						Cell[] cells = rs.getRow(j); 
						str=new String [cells.length];
						for(int k=0;k<cells.length;k++){
							str[k]=cells[k].getContents();
						}
						if(str.length==0){
							continue;
						}
						result.add(str);			
					}      
				   
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("not found file!");
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}	
			}   
		}
		return result;
	}

	/**
	 * 将获取的数据存放在Map集合
	 * @param list   已经读取的数据集
	 * @return       返回Map形式存放的数据集
	 */
	public static Map<String, List<String>> ToMapWithModules(List<String> list){
		Map<String, List<String>> result = null;
		if(list!=null){
			result=new HashMap<String, List<String>>();
			for (int i = 0; i < list.size(); i++) {
				String str[]=list.get(i).split(";");
				List<String> listMap = new ArrayList<String>();
				String string=null;
				if(i>0){
					String strT[]=list.get(i-1).split(";");
					string=strT[0];
				}
				if(string!=null&& str[0].equals(string)){
					listMap=result.get(str[0]);
					listMap.add(list.get(i));
					result.remove(str[0]);
					result.put(str[0], listMap);
				} else{
					listMap.add(list.get(i));
					result.put(str[0], listMap);
				}
			}
		}
		return result;
	}
	


	/**
	 * 将获取的数据存放在Map集合
	 * @param list   已经读取的数据集
	 * @param row    存放的key值所在的�? 例如:   用例编号:4    功能:3
	 * @return       返回Map形式存放的数据集
	 */
	public static Map<String, List<String[]>> ToMapWithModule(List<String[]> list,int row){
		Map<String, List<String[]>> result = null;
		if(list!=null){
			result=new HashMap<String, List<String[]>>();
			for (int i = 0; i < list.size(); i++) {
				String[] str=list.get(i);
				List<String[]> listMap = new ArrayList<String[]>();
				String string=null;
				if(i>0){
					String strT[]=list.get(i-1);
					string=strT[row];
				}
				if(string!=null&& str[row].equals(string)){
					listMap=result.get(str[row]);
					listMap.add(str);
					result.remove(str[row]);
					result.put(str[row], listMap);
				} else{
					listMap.add(str);
					result.put(str[row], listMap);
				}
			}
		}
		return result;
	}
	
	
	
	public static Map<String, List<String[]>> ToListWithModule(List<String[]> list,int row){
		Map<String, List<String[]>> result = null;
		
		if(list!=null){
			result=new HashMap<String, List<String[]>>();
			for (int i = 0; i < list.size(); i++) {
				String[] str=list.get(i);
				List<String[]> listMap = new ArrayList<String[]>();
				String string=null;
				if(i>0){
					String strT[]=list.get(i-1);
					string=strT[row];
				}
				if(string!=null&& str[row].equals(string)){
					listMap=result.get(str[row]);
					listMap.add(str);
					result.remove(str[row]);
					result.put(str[row], listMap);
				} else{
					listMap.add(str);
					result.put(str[row], listMap);
				}
			}
		}
		return result;
	}
}




