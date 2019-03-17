package com.zjs.Listenner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.auto.Test.BaseTest;
import com.auto.Util.PropertiesUtil;
import com.auto.Util.ReadExcelFileUtil;




public class Listenner extends TestListenerAdapter{
	public static Properties config=null;
	public static List<String []> testList =new ArrayList<String[]>() ;
	public static String locator = null;
	public static String type = null;
	public static HashMap<String, String[]> result = new HashMap<String, String[]>();
	private int number;

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		//收集log
		setLog(tr,"失败");
		//截图
		SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");
		String name = tr.getName()+"_"+df.format(new Date()).toString();
//		new ElementBase().lightElement(locator,type);
		BaseTest.baseDriverSer.screenShot(name);
		//BaseTest.info("测试方法 "+tr.getName()+" 执行失败, 请参考");
		BaseTest.info("失败，请参考");
		BaseTest.info(name+".jpg ");
		BaseTest.info("【失败原因】");
		BaseTest.info(tr.getThrowable().getMessage());
		BaseTest.info("=======================================================");
	}

    @Override
    public void onTestSkipped(ITestResult tr) {
    	super.onTestSkipped(tr);
    	//收集log
    	setLog(tr,"跳过");
		//BaseTest.info("测试方法 "+tr.getName()+" 跳过");
		BaseTest.info("跳过！");
		BaseTest.info("=======================================================");
    }
	 
    @Override
    public void onTestSuccess(ITestResult tr) {
    	super.onTestSuccess(tr);
    	//收集log
    	setLog(tr,"通过");
    	//BaseTest.info("测试方法 "+tr.getName()+" 执行成功！");
    	BaseTest.info("执行成功！");
    	BaseTest.info("=======================================================");
    }
    
    public void setLog(ITestResult tr,String state){
    	String id = String.valueOf(++ number);
    	String className = tr.getTestClass().getName();
    	if(config==null){
    		config=	PropertiesUtil.getProperties("data-config.properties");
    	}
    	String path=config.getProperty("FILE_EXCEL_PATH");
		String fileName=config.getProperty("FILE_EXCEL_name");
		testList=ReadExcelFileUtil.ReadExcelAll(path+fileName);
		String methodName = null;
		if(testList.get(Integer.valueOf(id)).length==0){
			return;
		}
		methodName = testList.get(Integer.valueOf(id))[1];
        String startTime = getStartTime(tr);
        String totalTime = getTotalTime(tr);
    	String[] array = new String[]{id,className,methodName,state,startTime,totalTime,BaseTest.logName};
    	result.put(id, array);
    }
    
  
    
    private String getTotalTime(ITestResult tr) {
        long start=0, stop=0;
            long tmp_start=tr.getStartMillis(), tmp_stop=tr.getEndMillis();
            if(start == 0)
                start=tmp_start;
            else {
                start=Math.min(start, tmp_start);
            }
            
            if(stop == 0)
                stop=tmp_stop;
            else {
                stop=Math.max(stop, tmp_stop);
            }
        return String.valueOf(stop - start);
    }
    
    private String getStartTime(ITestResult tr){
        Date date = new Date(tr.getStartMillis());  
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制  
        String startTime = sdformat.format(date);  
        return startTime;
    }

}
