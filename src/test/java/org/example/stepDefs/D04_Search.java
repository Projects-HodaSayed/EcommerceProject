package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D04_Search {

    P04_Search search = new P04_Search();

    @When("user clicks on search field")
    public void searchField()
    {
        search.searchField().click();
    }

    @And("user search with {string}")
    public void userSearchWith(String searchwords) {

        search.searchField().sendKeys(searchwords);
        search.searchbtn().click();
    }

    @Then("user could field {string} relative results")
    public void userCouldFieldRelativeResults(String results) {
        if(!search.searchResult().isEmpty())
        {
            SoftAssert soft = new SoftAssert();
            for (int x = 0; x < search.searchResult().size(); x++)
            {
                String actualresult = search.searchResult().get(x).getText();
                soft.assertTrue(actualresult.toLowerCase().contains(results));
            }
            soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q"));
            soft.assertAll();
        }
    }

    @Then("user could field {string} inside product detail page")
    public void userCouldFieldInsideProductDetailPage(String skuwords)
    {
        if (!search.searchResult().isEmpty()) {
            Assert.assertEquals(search.searchResult().size(), 1);
            for (int x = 0; x < search.searchResult().size(); x++) {
                search.searchResult().get(x).click();
                Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                Assert.assertEquals(Hooks.driver.findElement(By.cssSelector("span[id*=\"sku-\"]")).getText(), skuwords);
            }
        }
    }

}
