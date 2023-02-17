import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Scroll {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //using a JavascriptExecutor class to execute JS code
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //.executeScript() method to provide the script
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        //table scroll
        //using DOM to get the table and using method scrollTop
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        //Handling table grids
        List<WebElement> values = driver.findElements(By.cssSelector("#product td:nth-child(4)"));
        int sum=0;
        for(int i=0;i< values.size();i++){
            sum += Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        String result = driver.findElement(By.cssSelector(".right-align fieldset:last-child .totalAmount")).getText().split(" ")[3];
        Assert.assertEquals(sum,Integer.parseInt(result));

    }
}
