package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends CommonMethods {
    public static WebDriver driver;

    @Given("User Navigates To the URL")
    public void user_navigates_to_the_url() {
        openBrowserAndLaunchApplication();


    }
    @When("User Enters The correct UserName {string}")
    public void user_enters_the_correct_user_name(String username) {
       sendText(login.usernameTextField,"username");


    }
    @When("User Enters The correct Password {string}")
    public void user_enters_the_correct_password(String password) {
        sendText(login.passwordTextField,"password");


    }
    @When("user clicks On login button")
    public void user_clicks_on_login_button() {
        login.loginButton.click();

    }
    @Then("user is logged in")
    public void user_is_logged_in() {

        System.out.println("I am logged in");
    }


    @Given("the user is navigated to the URl")
    public void the_user_is_navigated_to_the_u_rl() {

    }


    @When("user enters username {string} and {string} verify the Error Message {string}")
    public void user_enters_username_and_verify_the_error_message(String username, String password, String error) {
      sendText(login.usernameTextField,username);
      sendText(login.passwordTextField,password);
      login.loginButton.click();
      String errorMsg = login.errorMessage.getText();
      Assert.assertEquals(error,errorMsg);
    }

    @When("user adds the employee")
    public void user_adds_the_employee(DataTable dataTable){
        List<Map<String, String>> employees = dataTable.asMaps();


        for(Map<String,String>employee:employees){
            String Fname=employee.get("firstName");
            String mname=employee.get("middleName");
            String lname=employee.get("lastName");
            System.out.println(Fname);
            System.out.println(mname);
            System.out.println(lname);
        }


    }


}
