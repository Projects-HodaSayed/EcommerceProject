package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P07_FollowUs;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_FollowUs {
    P07_FollowUs follow = new P07_FollowUs();

    @When("user opens {string} link")
    public void userOpensLink(String link) throws InterruptedException {
        switch(link)
        {
            case "facebook": follow.facebookLink().click();
                break;
            case "twitter": follow.twitterLink().click();
                break;
            case "rss": follow.rssLink().click();
                break;
            case "youtube": follow.youtubeLink().click();
                break;
        }
        Thread.sleep(2000);
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String CurrentLink) {
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(Hooks.driver.getCurrentUrl());
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println(Hooks.driver.getCurrentUrl());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(),CurrentLink);
    }
}
