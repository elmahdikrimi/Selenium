import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators3 {

    public static void main(String[] arg){

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Xpath locators Siblings using /following-sibling::tagName (tagName[index] if there is multiple siblings)
        driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]"))
                        .getText();

        //Xpath traverse from Child to Parent using /parent::tagName
        driver.findElement(By.xpath("//header/div/button[1]/parent::div"));
    }
}
