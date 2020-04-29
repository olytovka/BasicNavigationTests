package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultTitle {

    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");

        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation");

        for (String searchStr : searchStrs) {
            WebElement search =  driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
            search.clear();
            search.sendKeys(searchStr+ Keys.ENTER);

              String linkUrl = driver.findElement(By.xpath("(//cite[@class='iUh30 tjvcx'])[1]")).getText();
//       System.out.println(linkUrl);
           WebElement firstResult = driver.findElement(By.xpath("(//h3[@class='LC20lb DKV0Md'])[1]"));
           firstResult.click();
           Thread.sleep(2000);

           String currentUrl = driver.getCurrentUrl();

           if(currentUrl.equals(linkUrl)){
               System.out.println("PASS");
           }else{
               System.out.println("FAIL");
               System.out.println("Expected: " + linkUrl);
               System.out.println("But Actual: " + currentUrl);
           }

           driver.navigate().back();
        }
        driver.quit();
    }


}
