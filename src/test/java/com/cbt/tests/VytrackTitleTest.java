package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackTitleTest {

    WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");

        String username = "user1";
        String password = "UserUser123";
        driver.findElement(By.cssSelector("input[name='_username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='_password']")).sendKeys(password);

        driver.findElement(By.cssSelector("button[id='_submit']")).click();

        Thread.sleep(2000);

        WebElement nameButton = driver.findElement(By.cssSelector("li>a[class='dropdown-toggle']"));

        nameButton.click();

        String name = nameButton.getText();

        Thread.sleep(2000);

        WebElement config  = driver.findElement(By.cssSelector("li[class='mobile-hide']"));
        config.click();

        Thread.sleep(2000);

        String title = driver.getTitle();

        if(title.startsWith(name)){
            System.out.println("Pass,  Title starts with name " + name);
        }else{
            System.out.println("Fail");
            System.out.println("Expected: " + name + ", but was " + title);
        }

        driver.quit();
    }
}
