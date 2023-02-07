package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class formPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("El Mahdi");
        driver.findElement(By.name("email")).sendKeys("elmahdi@example.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("ElMahdi123");
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select drop = new Select(dropdown);
        drop.selectByVisibleText("Male");

        driver.findElement(By.id("inlineRadio2")).click();
        driver.findElement(By.name("bday")).sendKeys("24/06/1991");
        driver.findElement(By.className("btn-success")).click();

        String successMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
        System.out.println(successMsg);
        Assert.assertTrue(successMsg.contains("Success! The Form has been submitted successfully!."));

    }
}
