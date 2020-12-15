package com.automation.stepdefs;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectModule.SignUpPageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import junit.framework.Assert;
import io.cucumber.java.en.When;

public class JustDial_StepDefs {
	
	WebDriver driver;
	String base_url = "https://www.justdial.com/";
    int implicit_wait_timeout_in_sec = 20;
    Scenario scn;
    
    SignUpPageObject signUpPageObject;
    
    @Before
    public void set_up(Scenario scn)
    {
    	 this.scn = scn;
		 driver = new ChromeDriver();
		 scn.log("Browser invoked");
		 
		 signUpPageObject = new SignUpPageObject(driver);
    }
    
    @After(order=1)
    public void clean_up()
    {
    	driver.close();
    	scn.log("Browser closed");
    }
    
    @After(order=2)
    public void takeScreenShot(Scenario s) {
        if (s.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }


	
	@Given("User navigates to the application url")
	public void user_navigates_to_the_application_url() {
		 driver.get(base_url);
		 scn.log("Browser navigated to the url:" +base_url );
		 String expected = "Justdial - Local Search, Social, News, Videos, Shopping";
		 String actual = driver.getTitle();
		 Assert.assertEquals("Application Title Validation", expected, actual);
		 scn.log("Application Title:" +expected);
	}

	@When("User click on the sign up link of the application")
	public void user_click_on_the_sign_up_link_of_the_application() {
		signUpPageObject.click_on_signup_button();
		scn.log("User clicked on signup button");
		
	}
	@When("User enters name as {string} and phone number as {string} ans click on submit button")
	public void user_enters_name_as_and_phone_number_as_ans_click_on_submit_button(String string, String string2) {
		signUpPageObject.sign_to_the_application(string, string2);
		scn.log("Usser entered name:" + "Trupti");
		scn.log("User entered phone no:" +"9011831537");
		
	}
	@Then("User is displayed with the message as {string}")
	public void user_is_displayed_with_the_message_as(String string) {
		String Expected = "OTP is sent on number";
		scn.log("Expected popup title is:" +Expected );
		String Actual = driver.switchTo().alert().getText();
		scn.log("actual popup Title is:" +Actual);
		Assert.assertEquals("popup dispayed validation", Expected, Actual);
		
	}




}
