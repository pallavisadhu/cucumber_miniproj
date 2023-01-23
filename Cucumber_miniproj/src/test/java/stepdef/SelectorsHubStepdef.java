package stepdef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SelectorsHubPage;

public class SelectorsHubStepdef {
	
	WebDriver driver = Base.driver;
	SelectorsHubPage sp = new SelectorsHubPage(driver);
	String title,text;
	int count;
	List<List<String>> data;


	@When("^the user checks the title of the webpage$")
	public void the_user_checks_the_title_of_the_webpage() throws Throwable {
		title = driver.getTitle();
	}

	@Then("^the title should be \"([^\"]*)\"$")
	public void the_title_should_be(String arg1) throws Throwable {
		Assert.assertEquals(title, arg1);
	}

	@When("^the user enter following details in the form$")
	public void the_user_enter_following_details_in_the_form(DataTable arg1) throws Throwable {
		
		data = arg1.raw();
		driver.findElement(By.id("userId")).sendKeys(data.get(1).get(1));
		driver.findElement(By.id("pass")).sendKeys(data.get(2).get(1));
		driver.findElement(By.name("company")).sendKeys(data.get(3).get(1));
		driver.findElement(By.name("mobile number")).sendKeys(data.get(2).get(1));
		
	}

	@When("^the user click on the Submit button$")
	public void the_user_click_on_the_Submit_button() throws Throwable {
		sp.submitForm();

	}

	@Then("^the values to be added$")
	public void the_values_to_be_added() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains(data.get(2).get(1)));
		
	}
	@When("^the user click on the checkout here button$")
	public void the_user_click_on_the_checkout_here_button() throws Throwable {
		count = sp.verifyCheckoutBtnDropdown();
	    
	}

	@Then("^the number of links should be (\\d+)\\.$")
	public void the_number_of_links_should_be(int arg1) throws Throwable {
	    Assert.assertEquals(count, arg1);
	}

	@When("^the user click on the drop down$")
	public void the_user_click_on_the_drop_down() throws Throwable {
		count = sp.verifySizeOfCarsDropdown();
	    
	}

	@Then("^the number of options should be (\\d+)$")
	public void the_number_of_options_should_be(int arg1) throws Throwable {
	    Assert.assertEquals(count, arg1);
	}

	@Then("^the options are \"([^\"]*)\"$")
	public void the_options_are(String arg1) throws Throwable {
		String actual = sp.verifyOptionsOfCarsDropdown();
		Assert.assertEquals(actual, arg1);
	   
	}
	@When("^the user click on the Testers Food link$")
	public void the_user_click_on_the_Testers_Food_link() throws Throwable {
	    title = sp.verifyTestersFoodLink();
	}

	
	@Then("^the linke should be opened in another window$")
	public void the_linke_should_be_opened_in_another_window() throws Throwable {
		Assert.assertEquals(title, "SelectorsHub - XPath, CssSelector, Recorder Plugin, TestCase");	    
	}
	
	@When("^the user enters password$")
	public void the_user_enters_password() throws Throwable {
		sp.verifyPasswordText();
	    
	}

	@Then("^the password should be \"([^\"]*)\"$")
	public void the_password_should_be(String arg1) throws Throwable {
		Assert.assertEquals("password", arg1);
	    
	}

	@When("^the user enters text in the coffee time textbox$")
	public void the_user_enters_text_in_the_coffee_time_textbox() throws Throwable {
		sp.verifyCoffeeTime();
	   
	}

	@Then("^the text should be \"([^\"]*)\"$")
	public void the_text_should_be(String arg1) throws Throwable {
		Assert.assertEquals("yes", arg1);
	    
	}
	
	@When("^user enters \"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enters(String arg1, String arg2) throws Throwable {
		text = sp.verifyName(arg1, arg2);
	   
	}

	@Then("^the name should be \"([^\"]*)\"$")
	public void the_name_should_be(String arg1) throws Throwable {
		Assert.assertEquals(text,arg1);
	    
	}

}
