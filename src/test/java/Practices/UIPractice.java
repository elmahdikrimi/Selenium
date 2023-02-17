package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class UIPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.cssSelector("#checkbox-example label:nth-child(3) input")).click();
        String option = driver.findElement(By.cssSelector("#checkbox-example label:nth-child(3)")).getText();

        Select dropdown = new Select(driver.findElement(By.cssSelector("div.cen-right-align #dropdown-class-example")));
        dropdown.selectByVisibleText(option);

        driver.findElement(By.id("name")).sendKeys(option);
        driver.findElement(By.id("alertbtn")).click();

        String alert = driver.switchTo().alert().getText();
        System.out.println(alert);
        Assert.assertTrue(alert.contains(option));
        driver.switchTo().alert().accept();
    }
}
