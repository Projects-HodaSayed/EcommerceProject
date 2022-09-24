package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_Login {

   // public P02_Login()
   // {
        //PageFactory.initElements(Hooks.driver,this);
   // }
    public WebElement loginlink()
    {
        WebElement login = Hooks.driver.findElement(By.className("ico-login"));
        return login;
    }
    public WebElement email()
    {
        WebElement email = Hooks.driver.findElement(By.id("Email"));
        return email;
    }
    public WebElement password()
    {
        WebElement password = Hooks.driver.findElement(By.id("Password"));
        return password;
    }
    public WebElement loginBtn()
    {
        WebElement loginBtn = Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
        return loginBtn;
    }
    public WebElement accountLink()
    {
        WebElement accountLink = Hooks.driver.findElement(By.className("ico-account"));
        return accountLink;
    }
    public WebElement errorMsg()
    {
        WebElement errorMsg = Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
        return errorMsg;
    }
}
