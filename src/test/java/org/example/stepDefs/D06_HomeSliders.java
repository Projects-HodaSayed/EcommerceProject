package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P06_HomeSliders;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class D06_HomeSliders {

    P06_HomeSliders sliders = new P06_HomeSliders();

    String currentUrl;

    @Given("user open the home page")
    public void homePage()
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("User click the first slider")
    public void userClickTheFirstSlider()
    {
        sliders.sliders("1").click();
        System.out.println(sliders.sliders("1").getText());
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        currentUrl = Hooks.driver.getCurrentUrl();
        System.out.println(currentUrl);
    }

    @When("User click the second slider")
    public void userClickTheSecondSlider() {
        sliders.sliders("2").click();
        System.out.println(sliders.sliders("2").getText());
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        currentUrl = Hooks.driver.getCurrentUrl();
        System.out.println(currentUrl);
    }

    @Then("Iphone page url is opened")
    public void iphonePageUrlIsOpened() {
        Assert.assertEquals(currentUrl,"https://demo.nopcommerce.com/iphone-6");
    }

    @Then("Nokia page url is opened")
    public void nokiaPageUrlIsOpened() {
        Assert.assertEquals(currentUrl,"https://demo.nopcommerce.com/nokia-lumia-1020");
    }
}
