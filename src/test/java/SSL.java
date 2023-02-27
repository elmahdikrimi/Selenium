import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL {
    public static void main(String[] args) {
        //setting behavior for chrome
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //FirefoxOptions firefoxOptions = new FirefoxOptions();
        //passing the options in the driver
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
    }
}
