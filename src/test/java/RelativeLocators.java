import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.cssSelector("form input[name='name']"));
        //relative locator above()
        driver.findElement(with(By.tagName("label")).above(nameEditBox));
        //relative locator below()
        WebElement label = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(label)).click(); //relative locator skip elements that has 'flex'
        //relative locator toLeftOf()
        WebElement text = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(text)).click();
        //relative locator toRightOf()
        WebElement radio = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
    }
}
