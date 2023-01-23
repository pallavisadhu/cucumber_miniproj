package stepdef;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import config.ReadConfig;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	WebDriver driver;
	ReadConfig config;
	
	@Before
	public void beforeScenario() throws IOException {
		driver = Base.driverInitialization();
		config = new ReadConfig();
		driver.get(config.getUrl());
		driver.manage().window().maximize();
		System.out.println("Start Test");
	}
	
	@After
	public void afterScenario() {
		System.out.println("After Test");
		driver.quit();
	}


}
