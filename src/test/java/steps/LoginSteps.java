package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;
import utils.Constants;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    public static WebDriver driver;

    @Given("User Navigates To the URL")
    public void user_navigates_to_the_url() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");

        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);


    }
    @When("User Enters The correct UserName {string}")
    public void user_enters_the_correct_user_name(String username) {

        System.out.println(username);
    }
    @When("User Enters The correct Password {string}")
    public void user_enters_the_correct_password(String password) {

        System.out.println(password);
    }
    @When("user clicks On login button")
    public void user_clicks_on_login_button() {

        System.out.println("4");
    }
    @Then("user is logged in")
    public void user_is_logged_in() {

        System.out.println("5");
    }

}
