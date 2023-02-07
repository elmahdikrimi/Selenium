import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector("#nav-link-accountList"));
        //hover over an element
        a.moveToElement(menu).build().perform();

        WebElement inputSearch = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        a.moveToElement(inputSearch).click().keyDown(Keys.SHIFT)
                .sendKeys("Asus").doubleClick().build().perform();
    }
}
