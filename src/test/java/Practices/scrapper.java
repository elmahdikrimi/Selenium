package Practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrapper {
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ma.buynespresso.com/ma_fr/cafe.html");
        
        List<WebElement> titles =  driver.findElements(By.xpath("//div[@class='product-item-info'] //span[@class='product-item-link']"));
        List<WebElement> prices =  driver.findElements(By.xpath("//div[@class='product-item-info'] //span[@class='price']"));
        List<WebElement> intensity =  driver.findElements(By.xpath("//div[@class='product-item-info']"));

        

        for(int i=0;i<titles.size();i++){
            System.out.println(titles.get(i).getText().toLowerCase() + " Price " + prices.get(i).getText().toLowerCase() + " Intensity " + intensity.get(i).getText());
        }
        driver.close();
    }


}
