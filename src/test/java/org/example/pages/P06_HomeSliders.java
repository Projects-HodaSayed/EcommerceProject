package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P06_HomeSliders {

    public String homePage()
    {
        String homePageLink = Hooks.driver.getCurrentUrl();
        return homePageLink;
    }
    public WebElement sliders(String num)
    {
        return Hooks.driver.findElement(By.cssSelector("[class=\"nivo-imageLink\"]:nth-child("+num+")"));
    }

}
