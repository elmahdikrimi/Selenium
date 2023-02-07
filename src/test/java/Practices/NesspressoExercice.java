package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class NesspressoExercice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ma.buynespresso.com/ma_fr/cafe.html");
        String productName = "TOKYO VIVALTO LUNGO";
        String capsuleQty = "10";
        addToCart(driver,productName);
        selectQty(driver,capsuleQty);
    }

    public static void addToCart(WebDriver driver, String productName){
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-item-info'] //span[@class='product-item-link']"));
        List<WebElement> buttons = driver.findElements(By.cssSelector("div.actions-primary form[data-role='tocart-form']"));
        for(int i=0;i<products.size();i++){
            if(products.get(i).getText().contains(productName)){
                buttons.get(i).click();
            }
        }
    }
    public static void selectQty(WebDriver driver, String capsuleQty){
        List<WebElement> qty = driver.findElements(By.xpath("//div[@class='actions-primary'] //div[contains(@class,'active')] //li"));
        for(int i=0; i<qty.size();i++){
            if(qty.get(i).getText().contains(capsuleQty)){
                qty.get(i).click();
            }
        }
    }
}
