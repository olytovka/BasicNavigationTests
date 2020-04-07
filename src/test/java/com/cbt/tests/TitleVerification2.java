package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    @Test
    public void test1() throws InterruptedException{
        WebDriver driver = BrowserFactory.getDriver("chrome");

        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com",
                "https://www.westelm.com","https://walmart.com");

        List<String>titles = new ArrayList<>();
        for (String url : urls) {
            driver.get(url);
            Thread.sleep(1000);
            titles.add(driver.getTitle().replaceAll(" ", "").toLowerCase());
        }

        Thread.sleep(3000);
        for(int i =0; i<urls.size(); i++ ){
            driver.get(urls.get(i));
            if(driver.getCurrentUrl().contains(titles.get(i))){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
            }
        }
        driver.quit();
    }

}
