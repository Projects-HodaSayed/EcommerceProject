package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P08_WishList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishList {

    P08_WishList wishList = new P08_WishList();

    @When("User click on wishlist button")
    public void userClickOnWishList() throws InterruptedException {
        wishList.wishbutton().click();
        Thread.sleep(2000);
    }

    @Then("Success message will appear")
    public void successMessageWillAppear() {
        SoftAssert soft = new SoftAssert();
        if(wishList.wishbar().isDisplayed()) {
            System.out.println("yes");
        }
        soft.assertTrue(wishList.wishbar().isDisplayed());

        String actualColor =  wishList.wishbar().getCssValue("color");
        Color excpectedcolor = new Color(255, 255, 255, 1);

        System.out.println(actualColor.toString());
        System.out.println(excpectedcolor.toString());

        soft.assertEquals(Color.fromString(actualColor).equals(excpectedcolor),true);

        soft.assertAll();

    }

    @Then("Check Qty value bigger than zero")
    public void checkQtyValueBiggerThan() {

    }

    @And("After Wishlist success message disappear user open wishlist link")
    public void afterWishlistSuccessMessageDisappearUserOpenWishlistLink() throws InterruptedException {
        //if(wishList.wishbar().isDisplayed())
        //{
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofMillis(2000));
        // Wait till the element is not visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]")));
       // }
        Thread.sleep(2000);

         wishList.wishlistLink().click();

        Thread.sleep(2000);

        System.out.println(wishList.quantity().getAttribute("value"));
        int quantity = Integer.parseInt(wishList.quantity().getAttribute("value"));

        if (quantity > 0) {
            Assert.assertTrue(true);
        }
        else
            Assert.assertTrue(false);

    }
}
