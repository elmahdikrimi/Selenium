package Practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        login(driver,"rahulshettyacademy","learning");
        w.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("footer")));
        addToCart(driver);
    }
    public static void login(WebDriver driver, String username, String password) throws InterruptedException {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='modal-content'] //button[@id='okayBtn']")).click();
        WebElement selector = driver.findElement(By.cssSelector("select.form-control"));
        Select dropdown = new Select(selector);
        dropdown.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }
    public static void addToCart(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/angularpractice/shop");
        List<WebElement> buttons = driver.findElements(By.xpath("//div[contains(@class,'h-100')] //button"));
        System.out.println(buttons.size());
        for(WebElement b:buttons){
            b.click();
        }
        driver.findElement(By.xpath("//div[@id='navbarResponsive']/ul/li")).click();
    }
}
