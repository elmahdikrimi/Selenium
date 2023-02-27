import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class WindowsHandler {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.className("blinkingText")).click();
        //getting all the windows id's(parent id, and child id)
        Set<String> windows = driver.getWindowHandles();
        //switch to child window
        Iterator<String> it = windows.iterator();
        //get first index in the Set
        String parentId = it.next();
        // go into the second by using .next() again
        String childId = it.next();
        driver.switchTo().window(childId);
        String rawString = driver.findElement(By.cssSelector(".col-md-8 p.im-para.red"))
                .getText().split("at")[1];
        String email = rawString.split("with")[0].trim();
        System.out.println("extracted email is: " + email);
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}
