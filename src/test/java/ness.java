import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ness {
    public static void main(String[] arg) throws InterruptedException{

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://ma.buynespresso.com/ma_fr/cafe.html");

        driver.findElement(By.cssSelector
        ("div[data-url*='tokyo'] .product-details-wrapper .product-item-inner"))
        .click();   
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("div[data-url*='tokyo'] .product-item-inner .actions-primary")).click();
        //div[data-url*='tokyo'] .product-item-inner .actions-primary form div.qty-box .qty-box__overlay-wrapper ul
        //List<WebElement> lis = driver.findElements(By.cssSelector("div[data-url*='tokyo'] .product-item-inner .actions-primary form div.qty-box .qty-box__overlay-wrapper ul li"));
        List<WebElement> lis = driver.findElements(By.xpath("//div[contains(@data-url,'tokyo')]  //li[@class='qty-item']"));
        System.out.println("Size of the list is: " + lis.size());
        System.out.println(lis.get(9).getText());
        lis.get(9).click();
        
        Thread.sleep(1000);
        //driver.findElement(By.cssSelector("[data-block='minicart'] a.action.showcart div span.counter .counter-number")).click();
        //System.out.println(miniCart.getText());
        String text = driver.findElement(By.cssSelector(".message-success.success.message div")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "Vous avez ajouté TOKYO VIVALTO LUNGO à votre panier.");
        Assert.assertTrue(text.contains("Vous avez ajouté"));
        
        String qty = driver.findElement(
            By.cssSelector("[data-block='minicart'] a.action.showcart div span.counter .counter-number"))
            .getText();

        System.out.println(qty);
        //Assert.assertEquals(Integer.parseInt(qty), 10);
    }
}
