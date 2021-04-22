package com.appium.test.pnclatest;

/**
 * Hello world!
 *
 */
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.*;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.android.AndroidDriver;






public class App {
	WebDriver driver;
	
	MobileDriver devicedriver;
	String Deviceid;
	WebElement PIN;
	String pinnumber;
	WebElement PINValue;
	
	

		@Test
		public void setup() throws IOException, InterruptedException {
			//DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ALL);

			//Device device = deviceInfo.getFirstDevice();
			DesiredCapabilities capabilities =new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			//capabilities.setCapability(MobileCapabilityType.UDID, "42001d8ae41683ad");
			//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			capabilities.setCapability("appPackage", "com.aetherpal.enterprise");
			//capabilities.setCapability("automationName", "uiautomator2");
			capabilities.setCapability("appWaitActivity", "com.aetherpal.smartcare.ValetScueActivity");
			capabilities.setCapability("appActivity", "com.aetherpal.smartcare.ValetScueActivity");
			capabilities.setCapability("dontStopAppOnReset", false);
			//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

			//capabilities.setCapability(, 60);
			URL url1 = new URL("http://127.0.0.1:4723/wd/hub");
			devicedriver = new AppiumDriver<MobileElement>(url1, capabilities);
			//driver1 = new AndroidDriver<MobileElement>(url, capabilities);
				
		}

			@Test(dependsOnMethods = { "setup" })
			public void enrollment() throws IOException, InterruptedException {
			FileInputStream FIS = new FileInputStream(new File("C:\\selenium drivers\\TenantExcel.xlsx"));
			XSSFWorkbook Wb = new XSSFWorkbook(FIS);
			XSSFSheet sheet = Wb.getSheetAt(0);
			String InputData = sheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println("The data read from the excel is " +InputData);
			
			
			//System.out.println(driver1.findElement(text).getText());
			System.out.println("PNC HC");
			Thread.sleep(5000);
			// Sending values from excel
			devicedriver.findElement(By.id("loginUser")).sendKeys(InputData);

			//devicedriver.hideKeyboard();
			devicedriver.findElement(By.id("login_btn")).click();
			Thread.sleep(50000);
			System.out.println("50 sec waited");
			//WebElement permission = devicedriver.findElement(By.id("com.android.packageinstaller:id/permission_message"));
			//System.out.println("message is : " +permission);
			//Wait.until(ExpectedConditions.visibilityOf(permission));
			//System.out.println(devicedriver.findElement(By.id("com.android.packageinstaller:id/permission_message")).getText());
			devicedriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			System.out.println("allow button clicked");
			Thread.sleep(500);
			//Turning On Accessibility
			System.out.println(devicedriver.findElement(By.id("android:id/alertTitle")).getText());
			System.out.println(devicedriver.findElement(By.id("com.aetherpal.enterprise:id/dialogText")).getText());
			devicedriver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(20000);
			swipescreen();
			Thread.sleep(10000);
			 //((Object) driver).scrollTo("Mobile support");
			
			//devicedriver.findElement(By.name("Mobile Support")).click();  
			//devicedriver.findElement(By.id("android:id/title")).click();
			//devicedriver.findElement(By.linkText("Mobile Support")).click();
			devicedriver.findElement(By.xpath("//android.widget.TextView[@text='Mobile Support']")).click();
			Thread.sleep(10000);
			devicedriver.findElement(By.id("com.android.settings:id/switch_widget")).click();
			Thread.sleep(2000);
			devicedriver.findElement(By.id("android:id/button1")).click(); 
			Thread.sleep(10000);
			devicedriver.navigate().back();
			devicedriver.navigate().back();
			devicedriver.navigate().back();
			//Thread.sleep(20000);
			devicedriver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			//Wait.until(ExpectedConditions.visibilityOf(draw));
			//try {
			//System.out.println("overlay permission is seen");
			WebElement draw = devicedriver.findElement(By.id("com.aetherpal.enterprise:id/dialogText"));
			String draw1= devicedriver.findElement(By.id("com.aetherpal.enterprise:id/dialogText")).getText();
			System.out.println(devicedriver.findElement(By.id("com.aetherpal.enterprise:id/dialogText")).getText());
			devicedriver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(10000);
			devicedriver.findElement(By.id("android:id/switch_widget")).click();
			System.out.println("Draw over other apps is   turned ON now");
			devicedriver.navigate().back();
			devicedriver.findElement(By.id("android:id/button1")).click();
			//} catch (Exception e) {
			//	Thread.sleep(2000);
			//	System.out.println("Draw over other apps is already enabled");
				//Thread.sleep(2000);
				//devicedriver.findElement(By.id("android:id/button1")).click();
				
			//}
			
			
			//devicedriver.pressKeyCode(AndroidKeyCode.BACK);
			//Thread.sleep(1000);
			//((AndroidDriver) devicedriver).pressKey(new KeyEvent(AndroidKey.HOME));
			//((AndroidDriver) devicedriver).pressKeyCode(AndroidKey.BACK);
			//((AndroidDriver) devicedriver).pressKeyCode(AndroidKey.BACK);
			
			
			//Getting deviceId from device
			Thread.sleep(5000);
			String Deviceuniqueid = devicedriver.findElement(By.id("device_name")).getText();
			System.out.println(Deviceuniqueid);
			// Taking only the Device ID
			Deviceid = Deviceuniqueid.substring(11);
			System.out.println("Device ID value is: " + Deviceid);
			}
			
			 //swipe till down int durationMS = 4000; Dimension size =
			// devicedriver.manage().window().getSize(); for (int i = 0; i <= 1; i++) {
			 //int startx = size.width / 2; System.out.println(size); int starty =
			 //(int) (size.height * 0.60); int endy = (int) (size.height * 0.10);
			// devicedriver.swipe(startx, starty, startx, endy, durationMS);
			//  System.out.println(i); }
			  
			  //Thread.sleep(1000); // Turnning ON Accessibility
			  //devicedriver.findElement(MobSupport).click();
			  //devicedriver.findElement(ToggleButton).click();
			  //devicedriver.findElement(OkButton).click(); Thread.sleep(1000);
			
			
			// Screen vertical swiping to turn ON accessibility
			 private void swipescreen() {
			  //Get the size of screen.
			  Dimension dim = devicedriver.manage().window().getSize();
			  System.out.println(dim);
			  int height =dim.getHeight();
			  int width = dim.getWidth();
			  
			  int startx=width/2;
		      int endx=width/2;
		      int starty=(int) (height*.60);
		      int endy=(int) (height*.10);
		      
		      TouchAction action = new TouchAction(devicedriver);
		      action.press(PointOption.point(startx,starty))
		      .moveTo(PointOption.point(endx,endy))
		      .release()
		      .perform();
		      System.out.println("swiped Vertically");
			}
			// public WebElement getitemsview() {
			//	 return devicedriver.findElement(By.xpath("//android.widget.TextView[@text='Mobile Support']"));	
			//	 }
			
			//public void scrollTillwebview() {
		//	 getitemsview().click();
			//}
			//WebDriverWait wait = new WebDriverWait(driver, 60);
			//Thread.sleep(3000);
			//Wait.until(ExpectedConditions.visibilityOf(permission));
				
			@Test(dependsOnMethods = { "consolelogin" })
			public void searchconnect() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(By.id("searchPhoneNumber")).sendKeys(Deviceid);
			driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnConnect")).click();
			Thread.sleep(2000);

			System.out.println("Waiting for PIN");
			//Thread.sleep(7000);
			WebDriverWait wait1 = new WebDriverWait(driver, 60);
			System.out.println("sleep time is over");
			//PIN = driver.findElement(By.id("pinvalue"));
			
			//System.out.println("Waiting to get pin number" + "PIN");
			//pinnumber = PIN.getText();
			//System.out.println(pinnumber);
			
			
			//pinnumber = driver.findElement(By.id("pinvalue")).getText();
			//System.out.println(pinnumber);
			//System.out.println("this get executed");

			WebElement PINInstruction = driver.findElement(By.id("txtInstructionalMessage"));
			wait1.until(ExpectedConditions.visibilityOf(PINInstruction));
			String PINInst = PINInstruction.getText();
			System.out.println("PIN Instruction is " + PINInst);
			
			

			System.out.println("Waiting to get pin number");
			PINValue = driver.findElement(By.id("pinvalue"));
			pinnumber = PINValue.getText();
			System.out.println(pinnumber);
			
			devicedriver.findElement(By.id("com.aetherpal.enterprise:id/editPin")).sendKeys(pinnumber);
			Thread.sleep(1000);
			devicedriver.hideKeyboard();
			Thread.sleep(1000);
			devicedriver.findElement(By.id("com.aetherpal.enterprise:id/buttonAccept")).click();
			String Devicemodel = driver.findElement(By.xpath(".//*[@id='spansummarytooltip']")).getText();
			System.out.println("Connected device is " + Devicemodel);
			
			try {
				System.out.println("Remote Control button clicked after entering PIN");
				Thread.sleep(2000);
				// Take RC page SS
				File MobSS6 = ((TakesScreenshot) devicedriver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(MobSS6, new File("C:\\selenium drivers\\Appscreen.png"));
				System.out.println("App screen with disconnect button while in session is seen");
			} catch (Exception e) {
				System.out.println("Focus not in app");
			}
			Thread.sleep(20000);
			driver.findElement(By.xpath("//*[@id=\"remotedesktop_breadcrum_menu_ul\"]/ul/li[8]/i")).click();
			
			
		}
			
		
			@Test(dependsOnMethods = { "enrollment" })
		public void consolelogin() {
			System.setProperty("webdriver.chrome.driver", "C://selenium drivers//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://pnc.aetherpal.com/wbc");
			//Input Username/password

			WebElement username = driver.findElement(By.xpath(".//*[@id='txtUserName']"));
			username.sendKeys("healthcheck");
			WebElement password = driver.findElement(By.xpath(".//*[@id='txtPassword']"));
			password.sendKeys("vmware@1");
			driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
			//return driver;
			
		}
			@Test(dependsOnMethods = { "searchconnect" })
			public void uninstallclient() throws Throwable {
				
				DesiredCapabilities cap =new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
				//cap.setCapability(MobileCapabilityType.UDID, "42001d8ae41683ad");
				//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
				cap.setCapability(MobileCapabilityType.NO_RESET, "true");
				cap.setCapability(MobileCapabilityType.FULL_RESET, "false");
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
				cap.setCapability("appPackage", "com.android.vending");
				cap.setCapability("appWaitActivity", "com.android.vending.AssetBrowserActivity");
				cap.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
				cap.setCapability("dontStopAppOnReset", false);
				//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
				
				//capabilities.setCapability(, 60);
				URL url2 = new URL("http://127.0.0.1:4723/wd/hub");
				devicedriver = new AppiumDriver<MobileElement>(url2, cap);
				//driver1 = new AndroidDriver<MobileElement>(url2, capabilities);
				Thread.sleep(10000);
				
				devicedriver.findElement(By.id("com.android.vending:id/search_bar_hint")).click();
				devicedriver.findElement(By.id("com.android.vending:id/search_bar_text_input")).sendKeys("aetherpal mobile support");
				//Thread.sleep(4000);
				devicedriver.findElement(By.id("com.android.vending:id/suggest_text")).click();
				//devicedriver.hideKeyboard();
				//devicedriver.navigate().back();
				//Thread.sleep(10000);
				WebDriverWait wait = new WebDriverWait(driver, 60);
				devicedriver.findElement(By.id("com.android.vending:id/bucket_items")).click();
				//Thread.sleep(5000);
				WebDriverWait wait1 = new WebDriverWait(driver, 60);
				devicedriver.findElement(By.id("com.android.vending:id/left_button")).click();
				//Thread.sleep(4000);
				WebDriverWait wait2 = new WebDriverWait(driver, 60);
				devicedriver.findElement(By.id("android:id/button1")).click();
			}
			
		
		}
		
	
		
	


	

	


