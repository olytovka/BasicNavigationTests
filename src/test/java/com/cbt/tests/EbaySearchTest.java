package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class EbaySearchTest {

    WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");

        driver.get("https://www.ebay.com/");
        WebElement search = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
                search.sendKeys("wooden spoon"+ Keys.ENTER);
               Thread.sleep(2000);
                String numberOfResults = driver.findElement(By.xpath("//div/h1/span[@class ='BOLD'][1]")).getText();

        int totalNumberOfResults = Integer.parseInt(numberOfResults.replaceAll(",",""));

        WebElement all = driver.findElement(By.linkText("All"));
        all.click();

        String numOfRes2 = driver.findElement(By.xpath("//div/h1/span[@class ='BOLD'][1]")).getText();
        int totalNumOfRes2 = Integer.parseInt(numOfRes2.replaceAll(",",""));

        if(totalNumOfRes2>totalNumberOfResults){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("Number of results: " + totalNumberOfResults);
            System.out.println("Total number of results: " + totalNumOfRes2);
        }

        driver.navigate().back();

        WebElement searchBoxValue = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        String woodenSpoon = searchBoxValue.getAttribute("value");
        if(woodenSpoon.equals("wooden spoon")){
            System.out.println("Pass: Wooden spoon is displayed");
        }else{
            System.out.println("Fail");
        }

        driver.navigate().back();

         String searchBox = driver.findElement(By.id("gh-ac")).getText();
        if(searchBox.isEmpty()){
            System.out.println("Pass: Search box is empty");
        }else{
            System.out.println("Fail");
            System.out.println("Expected: blank" + ", but was: " +  woodenSpoon);
        }

        driver.quit();






    }

}
