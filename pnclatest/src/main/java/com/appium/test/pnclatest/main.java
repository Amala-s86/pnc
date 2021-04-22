package com.appium.test.pnclatest;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		//your test scripts logic...

				TestNG testng = new TestNG();
				List<String> suites= new ArrayList<String>();
				suites.add("C:\\Selenium project\\pnclatest\\testng1.xml");
				//FileReader inputReader = new FileReader("testng1.xml");
				//BufferedReader reader = new BufferedReader(inputReader);
				//String line = null;
				//while((line = reader.readLine()) !=null) {
				//	System.out.println(line);
				//}
				//reader.close();
				
				testng.setTestSuites(suites);
				System.out.println("started");

				System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
				testng.run();
				service.stop();


	}

}
