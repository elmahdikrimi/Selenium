import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * checkboxAssign
 */
public class checkboxAssign {

    public static void main(String[] args) {
     
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        WebElement checkbox = driver.findElement(By.xpath("//div[@class='block large-row-spacer'] //input[@name='checkBoxOption1']"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected());

        List<WebElement> chkbx = driver.findElements(By.xpath("//div[@class='block large-row-spacer'] //input[@type='checkbox']"));
        System.out.print(chkbx.size());

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select drop = new Select(dropdown);
        drop.selectByIndex(1);
        drop.selectByValue("option3");
        
    }
}