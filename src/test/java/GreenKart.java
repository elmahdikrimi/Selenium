import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GreenKart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //implicit wait on the global level
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] veggies = {"Cucumber", "Brocolli"};
        addItems(driver, veggies);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        //Explicit wait on specific element
        w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("promoInfo")));
        System.out.println(driver.findElement(By.className("promoInfo")).getText());
    }



    public static void addItems(WebDriver driver, String[] veggies){
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        System.out.println(veggies.length);
        for(int i=0;i<products.size();i++){
            String[] name = products.get(i).getText().split("-");
            String formatedName = name[0].trim();
            //converting array to array list to use better methods like .contains
            List<String> aL = Arrays.asList(veggies);
            //click on add button
            if(aL.contains(formatedName)){
                driver.findElements(By.xpath("//div[@class='product-action']/button"))
                        .get(i).click();
            }
        }
    }
}
