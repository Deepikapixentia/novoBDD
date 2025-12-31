package stepdefinitions;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;


	
	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			try {
				throw new InvalidBrowserException();
			} catch (InvalidBrowserException e) {
				System.out.println(e.getMessage());
			}

			break;
		}
	  
	}
	@Given("user launched the application URL {string}")
	public void user_launched_the_application_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@When("user enters username {string} in text field using xpath {string}")
	public void user_enters_username_in_text_field_using_xpath(String text, String xpath) {
	    driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user enters password {string} in text field using xpath {string}")
	public void user_enters_password_in_text_field_using_xpath(String text, String xpath) {
	    driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user clicks on the login button using xpath {string}")
	public void user_clicks_on_the_login_button_using_xpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	@Then("user will redirects to {string} tab")
	public void user_will_redirects_to_tab(String title) {
		 Assertions.assertEquals(title, driver.getTitle());
	}

}
