package PageObjectModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageObject {
	
	WebDriver driver;
    
	private By signup_button = By.id("h_sin_up");
	private By name_field = By.id("lgn_name");
	private By mob_no_field = By.id("lgn_mob");
	private By send_otp_button = By.id("lgn_smtn");
	
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


}
