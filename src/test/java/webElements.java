import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class webElements {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //Static Select Dropdown
        //creating a variable WebElement to store a web element in it
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //creating object of the class and pass the WebElement
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");

        //Dynamic dropdowns
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("divpaxinfo")).click();
        //Thread.sleep(2000);
        for (int i=0;i<3;i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //Selecting from multiple same elements using Xpath using index
        driver.findElement(By.xpath("(//a[@value='MAA'])[1]")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        //Parent - child find method using xpath
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HBX']")).click();

        //AutoSuggestive dropdown
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        //find multiple elements
        List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item a"));
        //iterate through the list elements using enhanced for loop
        for(WebElement option :options){
            if(option.getText().equalsIgnoreCase("india")){
                option.click();
                break;
            }
        }

        //Checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        //check if checkbox is selected
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());


        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

        //using html attributes to verify if an element is enabled or disabled
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            Assert.assertTrue(true);
            System.out.println("Radio button is Enabled");
        } else {
            System.out.println("Radio button is Disabled");
            Assert.assertFalse(false);
        }


    }
}
