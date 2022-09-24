package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_HoverCategories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class D05_HoverCategories
{
    P05_HoverCategories hover = new P05_HoverCategories();

    String category;

    @When("User hover category and select subcategory")
    public void user_hover_category()
    {
        int categoriesCount = hover.categories().size();
        int randomNumber = new Random().nextInt(hover.categories().size()-1);

        Actions hoverAction = new Actions(Hooks.driver);
        hoverAction.moveToElement(hover.categories().get(randomNumber)).perform();
        List<WebElement> subcategories = hover.subCategories(randomNumber);

        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        if(!hover.subCategories(randomNumber).isEmpty()) {
            int sizeSubcategories = hover.subCategories(randomNumber).size();
            //ThreadLocalRandom random = ThreadLocalRandom.current();
            //int randomNumbersub = random. nextInt(1, 3);
            int randomNumbersub = new Random().nextInt(3);

            subcategories.get(randomNumbersub).click();
            this.category = hover.subCategories(randomNumber).get(randomNumbersub).getText().trim();
        }
        else
        {
            hover.categories().get(randomNumber).click();
            this.category = hover.categories().get(randomNumber).getText().trim();
        }

    }

    @Then("Subcategory page opened")
    public void subcategoryPageOpened()
    {
        Assert.assertTrue(category.contains(hover.pageTitle().getText()));
    }
}
