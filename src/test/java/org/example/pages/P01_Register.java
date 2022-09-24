package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_Register
{
//    public WebElement registerLink()
//    {
//        WebElement reg = Hooks.driver.findElement(By.className("ico-register"));
//        return reg;
//    }

    public P01_Register()
    {
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "ico-register")
    public WebElement registerLink;

    @FindBy(className = "male")
    public WebElement male;

    @FindBy(className = "female")
    public WebElement female;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement birthDay;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement birthMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement birthYear;

    @FindBy(className = "result")
    public WebElement result;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "register-button")
    public WebElement registerbutton;
}
