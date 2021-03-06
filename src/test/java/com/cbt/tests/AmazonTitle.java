package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitle {
    WebDriver driver;

    @Test
    public void test1() throws InterruptedException{
        driver = BrowserFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");

        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Monitor");

        WebElement searchButton = driver.findElement(By.className("nav-input"));
        searchButton.click();

        if(driver.getTitle().contains("Monitor")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(2000);

        driver.quit();
    }


}
