import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class testOne {
    public static <TestOne> void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //implicit timeout applies to all (waiting for elements to show)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //locators
        String name = "rahul";
        String password = getPassword(driver);
        System.out.println(name + " " + password);
        driver.findElement(By.className("go-to-login-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        
        System.out.println(
            driver.findElement(By.tagName("p"))
            .getText());

        Assert.assertEquals(
            driver.findElement(By.tagName("p"))
            .getText()
            ,"You are successfully logged in.");
            
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Hello "+name+",");
        //Selecting a button with its text using Xpath, using regular expression *
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();
    }
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordText.split("'");
        return passwordArray[1].split("'")[0];
    }
}
