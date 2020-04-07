package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestVerification3 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver;

        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com",
                "https://www.westelm.com","https://walmart.com");
        driver =  BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        Thread.sleep(2000);
        String title1 =  driver.getTitle().replaceAll(" ", "").toLowerCase();
        if(driver.getCurrentUrl().contains(title1)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();

        driver = BrowserFactory.getDriver("firefox");
        driver.get(urls.get(1));
        Thread.sleep(2000);
        String title2 =  driver.getTitle().replaceAll(" ", "").toLowerCase();
        if(driver.getCurrentUrl().contains(title2)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();

        driver = BrowserFactory.getDriver("safari");
        driver.get(urls.get(2));
        Thread.sleep(2000);
        String title3 =  driver.getTitle().replaceAll(" ", "").toLowerCase();
        if(driver.getCurrentUrl().contains(title3)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();

        driver = BrowserFactory.getDriver("firefox");
        driver.get(urls.get(3));
        Thread.sleep(2000);
        String title4 =  driver.getTitle().replaceAll(" ", "").toLowerCase();
        if(driver.getCurrentUrl().contains(title4)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();
    }

}
