package com.automation.stepdefs;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectModule.LoginPageObject;
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
    LoginPageObject loginPageObject;
    
    @Before
    public void set_up(Scenario scn)
    {
    	 this.scn = scn;
		 driver = new ChromeDriver();
		 scn.log("Browser invoked");
		 
		 signUpPageObject = new SignUpPageObject(driver);
		 loginPageObject = new LoginPageObject(driver);
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
	public void user_enters_name_as_and_phone_number_as_ans_click_on_submit_button(String name, String mobno) {
		signUpPageObject.sign_to_the_application(name, mobno);
		scn.log("Usser entered name:" + "Trupti");
		scn.log("User entered phone no:" +"9011831537");
		
	}
	@Then("User is displayed with the message as {string}")
	public void user_is_displayed_with_the_message_as(String string) {
		signUpPageObject.otp_WindowValidation();
		scn.log("Opt window displayed");
	}
	
	@When("User enters name as {string} and phone number as {string} and click on submit button")
	public void user_enters_name_as_and_wrong_phone_number_as_ans_click_on_submit_button(String name, String mobno) {
		signUpPageObject.sign_to_the_application(name, mobno);
		scn.log("Usser entered name:" + "Trupti");
		scn.log("User entered phone no:" +"1234567890");
	
	}
       
	@Then("User gets an error message {string}")
	 public void user_gets_an_error_message(String string) {
		signUpPageObject.opt_validation_for_wrong_mobNo();
    }
	
	@When("User click on the login link at the top right corner of application")
	public void user_click_on_the_login_link_at_the_top_right_corner_of_application() {
		loginPageObject.user_click_login_link();
		
	}

	@When("User do not right any name and phone number but clicks on submit button")
	public void user_do_not_right_any_name_and_phone_number_but_clicks_on_submit_button() {
		loginPageObject.login_with_EmptyFields();
	}
	@Then("User gets error message as {string}")
	public void user_gets_error_message_as(String string) {
		loginPageObject.otp_window_validation_with_empty_fields();
	}
	
	@Then("User is able to enter only {string} digits in mobile no text box")
	public void user_is_able_to_enter_only_digits_in_mobile_no_text_box(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}









}
