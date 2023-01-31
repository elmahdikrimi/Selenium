package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //implicit timeout applies to all (waiting for elements to show)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //locators
        driver.findElement(By.id("inputUsername")).sendKeys("rahulShetty");
        driver.findElement(By.name("inputPassword")).sendKeys("admin123");
        driver.findElement(By.className("signInBtn")).click();
        //driver.findElement(By.cssSelector("input[placeholder='Username']"));

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        //Xpath selector //Tagname[@attribute='value']
        driver.findElement(By.xpath("//input[@placeholder='Name']"))
                .sendKeys("El mahdi");
        driver.findElement(By.cssSelector("input[placeholder='Email']"))
                .sendKeys("elmahdi@gmail.com");
        //find a specific elements by index from multiple same elements using xpath
        driver.findElement(By.xpath("//input[@type='text'][3]"))
                .sendKeys("+21206985612");
        //.clear() to clear a text input
        driver.findElement(By.xpath("//input[@type='text'][3]")).clear();
        //finding element by index using CSS Selector from multiple same elements
        driver.findElement(By.cssSelector("input[type='text']:nth-child(4)"))
                .sendKeys("+1326589845");
        //Parent-Child traverse //parentTagName/ChildTagName
        driver.findElement(By.xpath("//form/input[3]"));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        // Parent-Child traverse in Css
        //Thread.sleep() pausing the script
        //Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        //selecting using regular expressions with Xpath
        driver.findElement(By.xpath("//div[contains(@class,'btn-conainer')]/button[contains(@class,'login-btn')]"))
                .click();
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("El mahdi");
        //selecting using regular expressions with CSS selectors
        driver.findElement(By.cssSelector("input[type*='pass']"))
                .sendKeys("rahulshettyacademy");
        Thread.sleep(2000);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.className("signInBtn")).click();

        





    }

}
