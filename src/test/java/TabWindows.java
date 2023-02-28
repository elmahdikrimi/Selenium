import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class TabWindows {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //Opening new tab/window
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentId = it.next();
        String childId = it.next();

        //Switch to the new tab created by passing the tab id
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");
        String course = driver.findElements(By.xpath("//div[@id='courses-block'] //h2")).get(0).getText();
        System.out.println(course);
        //switching back to the other window
        driver.switchTo().window(parentId);
        WebElement name = driver.findElement(By.cssSelector("form input[name='name']"));
        name.sendKeys(course);
        //Take a partial Screenshot of the web Element
        File file = name.getScreenshotAs(OutputType.FILE);
        //Convert the file into a png and save it
        FileUtils.copyFile(file, new File("C:/Users/emkrimi/Desktop/element.png"));

        //get Height and Width of a web Element
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());


        driver.quit();


    }
}
