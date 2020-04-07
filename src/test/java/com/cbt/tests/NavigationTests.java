package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationTests {
    WebDriver driver;


    @Test
    public void test1() throws InterruptedException{
        driver = BrowserFactory.getDriver("chrome");
        Thread.sleep(3000);
        driver.get("https://www.google.com/");
        String titleGoogle = driver.getTitle();

        driver.get("https://www.etsy.com/");
        Thread.sleep(2000);
        String titleEtsy = driver.getTitle();

//        System.out.println(titleEtsy + " " + titleGoogle);

        driver.navigate().back();

        String actualTitle = driver.getTitle();

        StringUtility.verifyEquals(titleGoogle, actualTitle);
        Thread.sleep(2000);

        driver.navigate().forward();

        actualTitle = driver.getTitle();

        StringUtility.verifyEquals(titleEtsy, actualTitle);

        Thread.sleep(2000);

        driver.close();
    }

    @Test
    public void test2() throws InterruptedException{
        driver = BrowserFactory.getDriver("firefox");
        Thread.sleep(3000);
        driver.get("https://www.google.com/");
        String titleGoogle = driver.getTitle();

        driver.get("https://www.etsy.com/");
        Thread.sleep(2000);
        String titleEtsy = driver.getTitle();

//        System.out.println(titleEtsy + " " + titleGoogle);

        driver.navigate().back();

        String actualTitle = driver.getTitle();

        StringUtility.verifyEquals(titleGoogle, actualTitle);
        Thread.sleep(2000);

        driver.navigate().forward();

        actualTitle = driver.getTitle();

        StringUtility.verifyEquals(titleEtsy, actualTitle);

        Thread.sleep(2000);

        driver.close();
    }

    @Test
    public void test3() throws InterruptedException{
        driver = BrowserFactory.getDriver("safari");
        Thread.sleep(3000);
        driver.get("https://www.google.com/");
        String titleGoogle = driver.getTitle();

        driver.get("https://www.etsy.com/");
        Thread.sleep(2000);
        String titleEtsy = driver.getTitle();

//        System.out.println(titleEtsy + " " + titleGoogle);

        driver.navigate().back();

        String actualTitle = driver.getTitle();

        StringUtility.verifyEquals(titleGoogle, actualTitle);
        Thread.sleep(2000);

        driver.navigate().forward();

        actualTitle = driver.getTitle();

        StringUtility.verifyEquals(titleEtsy, actualTitle);

        Thread.sleep(2000);

        driver.close();
    }











}
