package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class P04_Search {

    public WebElement searchField()
    {
        WebElement searchField = Hooks.driver.findElement(By.id("small-searchterms"));
        return searchField;
    }

    public WebElement searchbtn()
    {
        WebElement searchbtn = Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
        return searchbtn;
    }

    public List<WebElement> searchResult()
    {
        List<WebElement> searchResult= Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a"));
        return searchResult;
    }
}
