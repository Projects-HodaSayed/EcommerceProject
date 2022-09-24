package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef
{
    P01_Register register = new P01_Register();

    @Given("user go to register page")
    public void registerPage()
    {
        register.registerLink.click();
    }

    @When("user select gender type")
    public void selectGender()
    {
        register.male.click();
    }

    @And("user enter first name {string} and last name {string}")
    public void firstLastName(String firstname , String lastname)
    {
        register.firstName.sendKeys(firstname);
        register.lastName.sendKeys(lastname);
    }
    
    @And("user enter date of birth")
    public void dateofBirth()
    {
        Select select = new Select(register.birthDay);
        select.selectByIndex(10);

        select = new Select(register.birthMonth);
        select.selectByValue("3");

        select = new Select(register.birthYear);
        select.selectByVisibleText("1998");
    }

    @And("user enter email {string} field")
    public void personalDetails(String email)
    {
        register.email.sendKeys(email);
    }

    @And("user fills Password fields {string}")
    public void userFillsPasswordFields(String password)
    {
        register.password.sendKeys(password);
        register.confirmPassword.sendKeys(password);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton()
    {
        register.registerbutton.click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        String excpectedResult = "Your registration completed";
        String actualResult = register.result.getText();

        String actualColor =  register.result.getCssValue("color");
        Color excpectedcolor = new Color(76, 177, 124, 1);

        SoftAssert soft = new SoftAssert();

        soft.assertTrue(actualResult.contains(excpectedResult),"First Assertion");
        soft.assertEquals(actualResult.contains(excpectedResult),true);

        soft.assertTrue(Color.fromString(actualColor).equals(excpectedcolor),"Second Assertion");
        soft.assertEquals(Color.fromString(actualColor).equals(excpectedcolor),true);
        soft.assertAll();
    }

}
