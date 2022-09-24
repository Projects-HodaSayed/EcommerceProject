package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.pages.P02_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_Login
{
    P02_Login login = new P02_Login();

    @Given("user go to login page")
    public void loginPage()
    {
       login.loginlink().click();
    }

    @When("user login with {string} {string} and {string}")
    public void userLoginWithAnd(String validInValid, String email, String password)
    {
        login.email().sendKeys(email);
        login.password().sendKeys(password);

    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginBtn().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully()
    {
        SoftAssert softassert = new SoftAssert();

        softassert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        softassert.assertTrue(login.accountLink().isDisplayed());

        softassert.assertAll();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem()
    {
        SoftAssert softassert = new SoftAssert();

        softassert.assertEquals(login.errorMsg().getText().contains("Login was unsuccessful."),true);
        softassert.assertTrue(login.errorMsg().isDisplayed());

        String actualColor =  login.errorMsg().getCssValue("color");
        Color excpectedcolor = new Color(228, 67, 75, 1);

        softassert.assertEquals(Color.fromString(actualColor).equals(excpectedcolor),true);

        softassert.assertAll();
    }
}
