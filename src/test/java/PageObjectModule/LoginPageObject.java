package PageObjectModule;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	
	WebDriver driver;

	private By login_link = By.id("h_login");
	private By login_name = By.id("lgn_name");
	private By login_mobNo = By.id("lgn_mob");
	private By login_submit = By.id("lgn_smtn");
	private By opt_window_with_empty_nameandmobNo = By.xpath("//div[@class='error dn wrapper']");
	//private By error_msg_for_
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void user_click_login_link()
	{
		WebElement loginlink = driver.findElement(login_link);
		loginlink.click();
		
	}
	
	public void login_with_EmptyFields()
	{
	  /*WebElement login_name_field = driver.findElement(login_name);
	  login_name_field.sendKeys("");
	  WebElement login_phoneNo_field = driver.findElement(login_mobNo);
	  login_phoneNo_field.sendKeys("");*/
	  WebElement submit = driver.findElement(login_submit);
	  submit.click();
	}
	
	
	public void otp_window_validation_with_empty_fields()
	{
		String expected = "Please enter a valid name !!";
		String actual = driver.findElement(opt_window_with_empty_nameandmobNo).getText();
		Assert.assertEquals("Error message for empty fields", expected, actual);
	}


}
