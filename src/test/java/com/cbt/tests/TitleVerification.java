package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    @Test
    public void test1 () throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        List <String> titles = new ArrayList<>();

        for (String url : urls) {
            driver.get(url);
            Thread.sleep(2000);
            titles.add(driver.getTitle());
            Assert.assertTrue(driver.getCurrentUrl(), driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com"));
        }


        Assert.assertEquals(titles.get(0), titles.get(1));
        Assert.assertEquals(titles.get(1), titles.get(2));
        Assert.assertEquals(titles.get(0), titles.get(2));

        driver.quit();
    }
}
