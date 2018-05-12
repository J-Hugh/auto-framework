package com.auto.base;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ElementActionBase {
	WebDriver driver =BaseDriver.webDriver;	
	private static SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * execute javascript
	 * @param script to execute javascript
	 */
	public void jsExecutor(String script) {
		try {
			WebElement e = getWebElement();
			((JavascriptExecutor) driver).executeScript(script, e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * drag scrollbar to make element into view
	 */
	public void scrollIntoView() {
		jsExecutor("arguments[0].scrollIntoView();");
	}

	public void check(String expectValue){
		scrollIntoView();
		WebElement w= getWebElement();
		String data = "";
		if(w!=null)
			data=w.getText();
		try {
			Assert.assertEquals(data, expectValue);
		} catch (Exception e) {
			BaseDriver.info("CHECK ERROR----------------实际值与期望值不一致，期望:' "+expectValue+"'   实际值：'"+data+"'");
		}

	}

	/**
	 * click element
	 */
	public void click() {
		scrollIntoView();
		WebElement w= getWebElement();
		if(w!=null)
			w.click();

	}

	/**
	 * clean value
	 */
	public void clear() {
		scrollIntoView();	
		WebElement w= getWebElement();
		if(w!=null)
			w.clear();
	}

	/**
	 * input text to a element
	 * 
	 * @param text
	 */	
	public void inputText(String text) {
		scrollIntoView();
		WebElement e = getWebElement();
		if(e!=null){
			e.clear();
			e.sendKeys(text);
		}
	}


	/**
	 * select by text 
	 * 
	 * @param text
	 */	
	public void selectByText(String text) {
		scrollIntoView();
		WebElement e = getWebElement();
		if (e!=null){
			Select sel = new Select(e);
			sel.selectByVisibleText(text);
		}
	}


	/**
	 * select by value 
	 * 
	 * @param text
	 */	
	public void selectByVal(String val) {
		scrollIntoView();
		WebElement e = getWebElement();
		if (e!=null){
			Select sel = new Select(e);
			sel.selectByValue(val);
		}
	}
	/**
	 * move focus to element
	 * 
	 * @param text
	 */		
	public void moveToElement() {
		scrollIntoView();
		WebElement e = getWebElement();
		if (e!=null){
			Actions action = new Actions(driver);
			action.moveToElement(e).perform();
		}
	}

	/**
	 * click element by action
	 * 
	 * @param text
	 */	
	public void actionClick() {
		scrollIntoView();

		WebElement e = getWebElement();
		if (e!=null){
			Actions action = new Actions(driver);
			action.click(e).perform();}
	}

	/**
	 * double click element 
	 * 
	 * @param text
	 */	
	public void doubleClick() {
		scrollIntoView();
		Actions action = new Actions(driver);
		WebElement e = getWebElement();
		if (e!=null)
			action.doubleClick(e).perform();
	}

	/**
	 * right click element 
	 * 
	 * @param text
	 */	
	public void rightClick() {
		scrollIntoView();
		Actions action = new Actions(driver);
		WebElement e = getWebElement();
		if (e!=null)
			action.contextClick(e).perform();
	}

	/**
	 * get element text align
	 * 
	 * @param text
	 */	
	public String getTextAlign(){
		return getWebElement().getCssValue("text-align");
	}


	/**
	 * get attribute value
	 * 
	 * @param attribute
	 * @return attribute value
	 */
	public String  getAttribute(String attribute){
		return getWebElement().getAttribute(attribute);
	}

	/**
	 * get element text
	 * 
	 * @return element text
	 */
	public String getText(){
		return getWebElement().getText();
	}

	/**
	 * get css value value
	 * 
	 * @param css value
	 * @return css value value
	 */
	public String  getCssValue(String cssValue){
		return getWebElement().getCssValue(cssValue);
	}


	public void sleep(int time) throws InterruptedException{
		Thread.sleep(time);
	}
	
	/**
	 * 切换至新窗口
	 * 
	 */
	
	public void switchToNewWindow() {
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		java.util.Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String win = it.next();
			if (win.equals(currentWindow)) {
				continue;
			}
			WebDriver window = driver.switchTo().window(win);// 切换到新窗口
			System.out.println("New page title is:" + window.getTitle());
			break;
		}

		
	}
	/**
	 * 
	 * 上传图片
	 * @param url
	 */
	public void uploadimage(String url) {
		scrollIntoView();
		Runtime time = Runtime.getRuntime();

		 try{

		    time.exec(new String[]{"cmd","/c","upfile.exe"},null,new File(url));

		   }catch(Exception e){

		    e.printStackTrace();

		   } 
	}

	/**
	 * 日期加减
	 * @param date
	 * @return
	 */
	public String date(int date) {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, date);

		return adf.format(calendar.getTime());
	}
	
//	/**
//	 * 向上滑动
//	 * @param driver
//	 * @param during
//	 */
//	public void swipeToUp() {
//		int width = driver.manage().window().getSize().width;
//		int height = driver.manage().window().getSize().height;
//		((AppiumDriver) driver).swipe(width / 2, height * 3 / 4, width / 2, height / 4, 1000);
//	}
//
//	/**
//	 *向下滑动
//	 */
//	public void swipeToDown() {
//		int width = driver.manage().window().getSize().width;
//		int height = driver.manage().window().getSize().height;
//		((AppiumDriver) driver).swipe(width / 2, height / 4, width / 2, height * 3 / 4, 1000);
//	}
//
//	/**
//	 *向左滑动
//	 */
//	public void swipeToLeft() {
//		int width = driver.manage().window().getSize().width;
//		int height = driver.manage().window().getSize().height;
//		((AppiumDriver) driver).swipe(width * 3 / 4, height / 2, width / 4, height / 2, 1000);
//	}
//
//	/**
//	 *向右滑动
//	 */
//	public void swipeToRight() {
//		int width = driver.manage().window().getSize().width;
//		int height = driver.manage().window().getSize().height;
//		((AppiumDriver) driver).swipe(width / 4, height / 2, width * 3 / 4, height / 2, 1000);
//	}


	/**
	 * 获取元素
	 * @param driver
	 * @param by
	 * @return
	 */
	public WebElement getWebElement(){
		WebElement element = null;
		//boolean result =false;
		//	try {
		//	driver.findElement(getBy());
		//	result=true;
		//	} catch (Exception e) {
		//	System.out.println("没有获取到要查找的元素");
		//	}
		//	if (result)  {
		element=driver.findElement(getBy());
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].style.border = '3px solid black'",element);
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].style.border = 'none'",element);
		//}
		return element;
	}


	/**
	 * 获取By
	 * @param value
	 * @return
	 */
	public By getBy(){
		return null;
	}
}
