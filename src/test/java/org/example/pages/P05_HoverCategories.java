package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class P05_HoverCategories
{
    public List<WebElement> categories()
    {
        return Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
    }

    public List<WebElement> subCategories(int categoryNum)
    {
        categoryNum = categoryNum + 1;
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+categoryNum+"]/ul[@class=\"sublist first-level\"]/li"));
    }

    public WebElement pageTitle() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]"));

    }
}
