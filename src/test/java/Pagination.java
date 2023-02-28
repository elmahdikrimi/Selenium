import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //iterate through the items, if item found break,else click on next page
        List<String> price;
        do
        {
            List<WebElement> veggies = driver.findElements(By.cssSelector("tr td:first-child"));
            price = veggies.stream().filter(s -> s.getText().contains("Beans")).
                    map(s -> getPrice(s)).collect(Collectors.toList());
            price.forEach(s -> System.out.println(s));
            if(price.size()<1){
                //clicking next page
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.size()<1);
    }
    public static String getPrice(WebElement element){
        return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
