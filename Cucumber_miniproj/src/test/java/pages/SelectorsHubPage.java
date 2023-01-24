package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class SelectorsHubPage {
	
	WebDriver driver;
	Select s;
	Actions action;
	JavascriptExecutor js;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='dropdown-content']//a")
	List<WebElement> dropdown;
	
	@FindBy(id="cars")
	WebElement carsDropdown;
	
	@FindBy(xpath="//iframe[@id='pact']")
	WebElement frame;
	
	@FindBy(id="userPass")
	WebElement userpass;
	
	@FindBy(id="jest")
	WebElement jest;
	
	@FindBy(xpath="(//*[name()='svg'])[10]")
	WebElement svgEle;
	
	@FindBy(xpath="//input[@placeholder='First Enter name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Enter Last name']")
	WebElement lastName;
	
	@FindBy(id="userId")
	WebElement uid;
	
	@FindBy(id="pass")
	WebElement pwd;
	
	@FindBy(name="company")
	WebElement comp;
	
	@FindBy(name="mobile number")
	WebElement mobileno;
	
	
	public SelectorsHubPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		js = (JavascriptExecutor)driver;		

		
	}
	
	public void verifySubmitForm(String userId, String password, String company, String mobile) {
		uid.sendKeys(userId);
		pwd.sendKeys(password);
		comp.sendKeys(company);
		mobileno.sendKeys(mobile);
		submitBtn.submit();
	}
	
	public int verifyCheckoutBtnDropdown() {
		return dropdown.size();
		
	}
	
	public int verifySizeOfCarsDropdown() {
		s = new Select(carsDropdown);
		return s.getOptions().size();
	}
	
	public String verifyOptionsOfCarsDropdown() {
		String str="";
		s = new Select(carsDropdown);
		List<WebElement> list = s.getOptions();
		for(WebElement l:list) {
			str = str + l.getText()+",";
		}
		return str.substring(0, str.length()-1);
	}
	
	public String verifyTestersFoodLink() throws InterruptedException {
		//JavascriptExecutor js = (JavascriptExecutor)driver;		
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		WebElement ele = (WebElement) 
				js.executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('a')");
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		Set<String> handle = driver.getWindowHandles();
		for( String h: handle)
		{
			driver.switchTo().window(h);
		}
		Thread.sleep(3000);
		return driver.getTitle();
	}
	
	public void verifyPasswordText() throws InterruptedException {
		userpass.click();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("password123").perform();;	
		Thread.sleep(2000);
		
	}
	
	public void verifyCoffeeTime () throws InterruptedException {
		driver.switchTo().frame(frame);
		jest.click();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("yes").perform();
		Thread.sleep(2000);
		
	}
	
	public String verifyName(String first, String last) throws InterruptedException {
		svgEle.click();
		Thread.sleep(3000);
		firstName.sendKeys(first);
		js.executeScript("document.querySelector(\"input[placeholder='Enter Last name']\").disabled=false");
		lastName.sendKeys(last);
		return firstName.getAttribute("value")+lastName.getAttribute("value");
		
	}

}
