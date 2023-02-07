package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Cart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/angularpractice/shop");
        List<WebElement> buttons = driver.findElements(By.xpath("//div[contains(@class,'h-100')] //button"));
        System.out.println(buttons.size());

        for(WebElement b:buttons){
            b.click();
        }
        driver.findElement(By.xpath("//div[@id='navbarResponsive']/ul/li")).click();
    }
}
