package PageObjectModule;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageObject {
	
	WebDriver driver;
    
	private By signup_button = By.id("h_sin_up");
	private By name_field = By.id("lgn_name");
	private By mob_no_field = By.id("lgn_mob");
	private By send_otp_button = By.id("lgn_smtn");
	private By opt_msg = By.xpath("//div[@class='otp-text wrapper pb-10']");
	private By otp_msg_with_wrong_mobNo = By.xpath("//div[@class='error dn wrapper']");
	
	public SignUpPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click_on_signup_button()
	{
		WebElement sign_up = driver.findElement(signup_button);
		sign_up.click();

	}
	
	public void sign_to_the_application(String text, String text1)
	{
		WebElement userName = driver.findElement(name_field);
		userName.sendKeys(text);
		WebElement mob_no = driver.findElement(mob_no_field);
		mob_no.sendKeys(text1);
		WebElement click_on_otp = driver.findElement(send_otp_button);
		click_on_otp.click();
		
	}
	
	/*public void sign_in_application_with_correct_name_and_wrong_mobNo(String name, String mobNo)
	{
		
	}*/
	
	public void otp_WindowValidation()
	{
		String expected = "OTP is sent on number";
		String actual = driver.findElement(opt_msg).getText();
		Assert.assertEquals("Otp validation", expected, actual);

	}
	
	public void opt_validation_for_wrong_mobNo()
	{
		String expected = "Please Enter valid Mobile number!";
		String actual = driver.findElement(otp_msg_with_wrong_mobNo).getText();
		Assert.assertEquals("Otp validation when user eneter wrong mobile no", expected, actual);
	}


}
