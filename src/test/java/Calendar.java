import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    driver.findElement(By.cssSelector("#flightSearchContainer .picker-first2 #ctl00_mainContent_view_date1")).click();
    List<WebElement> dates = driver.findElements(By.cssSelector("div.ui-datepicker-group-first td[data-handler='selectDay']"));

    for(int i=0;i< dates.size();i++){
        //if(dates.get(i).getText().equalsIgnoreCase("24"))
        if(dates.get(i).getText().contains("24")){
            dates.get(i).click();
        }
    }
    }
}
