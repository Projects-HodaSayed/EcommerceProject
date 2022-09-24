package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_Currency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D03_Currency {

    P03_Currency currency = new P03_Currency();

    @When("user select euro option")
    public void selectEuro()
    {
        WebElement currencyList = Hooks.driver.findElement(By.id("customerCurrency"));
        Select select = new Select(currencyList);
        select.selectByVisibleText("Euro");
    }

    @Then("euro symbol is displayed on all products")
    public void euroSymbolIsDisplayedOnAllProducts()
    {
        if(!currency.prices().isEmpty())
        {
            SoftAssert soft = new SoftAssert();
            for (int x = 0; x < currency.prices().size(); x++)
            {
                String pricevalue = currency.prices().get(x).getText();
                soft.assertTrue(pricevalue.contains("€"));
            }
            soft.assertAll();
        }
    }
}
