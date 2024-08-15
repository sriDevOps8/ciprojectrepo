package stepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.*;

public class LoginSteps {
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {       
    	// Setup WebDriverManager to manage ChromeDriver
        //WebDriverManager.chromedriver().setup();

        // Create ChromeOptions to add additional capabilities
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");

        // Create a map for preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Initialize ChromeDriver with the options
        WebDriver driver = null;
        try {
            driver = new ChromeDriver(options);
        } catch (Exception e) {
            System.out.println("**>uh-oh " + e.getMessage());
        }

        // If driver initialization was successful, perform additional setup
        if (driver != null) {
            driver.manage().deleteAllCookies();

            // Get browser name and version
            Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
            String browserName = cap.getBrowserName();
            String browserVersion = cap.getBrowserVersion();
            System.out.println("Browser name=" + browserName + ", version=" + browserVersion);

            // Open Google
            driver.get("https://google.com/");
            System.out.println(" Done with Jenkins CI - Given step driver initialization 2");
        }
    }

    @When("the user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
        // Selenium code to enter credentials
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        // Selenium code to verify redirection
    }
}

