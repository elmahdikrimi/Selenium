import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserActivities {

    public static void main(String[] arg){
        WebDriver driver = new ChromeDriver();
        //run in maximize mode
        driver.manage().window().maximize();
        driver.get("https://google.com");
        // internally navigate
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        //Navigate back
        driver.navigate().back();
        driver.navigate().forward();
    }

}
