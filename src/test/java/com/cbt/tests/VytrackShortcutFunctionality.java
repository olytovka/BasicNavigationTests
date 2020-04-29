package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackShortcutFunctionality {

    WebDriver driver;

    @Test
    public void test() throws InterruptedException {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");

        String username = "salesmanager101";
        String password = "UserUser123";
        driver.findElement(By.cssSelector("input[name='_username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='_password']")).sendKeys(password);

        driver.findElement(By.cssSelector("button[id='_submit']")).click();

        Thread.sleep(2000);

        String subtitleName = driver.findElement(By.cssSelector("div>h1[class='oro-subtitle']")).getText();

        if(subtitleName.equals("Dashboard")){

        }else{
            System.out.println("Fail 1");
        }

        Thread.sleep(2000);

        WebElement shortcut = driver.findElement(By.cssSelector("div[class='dropdown header-dropdown-shortcut header-utility-dropdown']"));
        shortcut.click();

        Thread.sleep(1000);

        WebElement fullList = driver.findElement(By.linkText("See full list"));
        fullList.click();

        Thread.sleep(1000);

        driver.findElement(By.linkText("Opportunities")).click();

        Thread.sleep(2000);

        subtitleName  = driver.findElement(By.cssSelector("div>h1[class='oro-subtitle']")).getText();
        if(subtitleName.equals("Open Opportunities")){

        }else{
            System.out.println("Fail");
            System.out.println("Expected 'Open Opportunities', but was " + subtitleName);
        }

        Thread.sleep(2000);

        shortcut.click();

        Thread.sleep(2000);

        fullList.click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Vehicle Services Logs")).click();

        Thread.sleep(2000);

        //You do not have permission to perform this action.
        String expectedErrorMessage = "You do not have permission to perform this action.";
       String actualErrorMessage  = driver.findElement(By.cssSelector("div[class='message']")).getText();

       Thread.sleep(2000);

       if(actualErrorMessage.equals(expectedErrorMessage)){

       }else{
           System.out.println("FAILED " + actualErrorMessage);
       }

       Thread.sleep(2000);
        String title  = driver.getTitle();

        if(title.equals("Shortcut Actions List")){

        }else{
            System.out.println("Fail");
            System.out.println("Expected 'Shortcut Actions List', but was " + title);
        }

        driver.quit();

    }
}
