package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TableGridPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("Rows: " + driver.findElements(By.cssSelector("div.left-align #product tr")).size());
        System.out.println("Columns: " + driver.findElements(By.cssSelector("div.left-align #product th")).size());
        System.out.println("Rows :" + driver.findElements(By.cssSelector("div.left-align #product tr")).get(2).getText());

        driver.findElement(By.id("autocomplete")).sendKeys("mor");
        List<WebElement> countries = driver.findElements(By.cssSelector("li.ui-menu-item"));
        System.out.println(countries.size());
        for(int i=0;i<countries.size();i++){
            if(countries.get(i).getText().contains("Morocco")) {
                System.out.println("yes");
            }
            }
        }


    }

