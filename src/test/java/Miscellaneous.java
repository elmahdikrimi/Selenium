import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Miscellaneous {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        //Maximizing the window
        driver.manage().window().maximize();
        //delete all the cookies
        driver.manage().deleteAllCookies();
        //delete a specific cookie by name
        //driver.manage().deleteCookieNamed("nameOfCookie");
        driver.get("https://www.linkedin.com/");
        //Take a screenshot, we need to convert our driver into a screenshot object
        //Casting the driver ((TakeScreenshot)driver)
        //taking a screenshot as a FILE
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //moving the screenshot to our system
        FileUtils.copyFile(src, new File("C:/Users/emkrimi/Desktop/screenShot.png"));



    }
}
