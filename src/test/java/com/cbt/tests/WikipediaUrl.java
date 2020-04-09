package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaUrl {

    WebDriver driver;

    @Test
    public void test1() throws InterruptedException{
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class = 'pure-button pure-button-primary-progressive']"));

        searchButton.click();

        Thread.sleep(2000);

        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(2000);

        if(driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();
    }
}
