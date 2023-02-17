package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Tabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());

        WebElement firstColumn = footer.findElement(By.xpath("//table //ul"));
        System.out.println(firstColumn.findElements(By.tagName("li")).size());
        Actions a = new Actions(driver);

        //clicking on keys by using SendKey and sending to webElement(example a tag)
        String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER); //a sequence of keys
        for(int i=1;i<firstColumn.findElements(By.tagName("a")).size();i++){
            firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        // hasNext() Returns true if the iteration has more elements.
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
