import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSorting {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement drop = driver.findElement(By.id("page-menu"));
        Select dropdown = new Select(drop);
        dropdown.selectByVisibleText("20");

        List<WebElement> veggies = driver.findElements(By.cssSelector("tr td:first-child"));
        List<String> sorted = veggies.stream().map(s -> s.getText())
                .sorted().collect(Collectors.toList());
        driver.findElement(By.cssSelector("tr th:first-child")).click();
        List<String> sortedSecond =driver.findElements(By.cssSelector("tr td:first-child"))
                .stream().map(s -> s.getText()).collect(Collectors.toList());
        Assert.assertEquals(sorted,sortedSecond);

        //get the price of the veggie based on its name
        List<String> price = veggies.stream().filter(s -> s.getText().contains("Beans")).
                map(s -> getPrice(s)).collect(Collectors.toList());
        //print every item in the list
        price.forEach(s -> System.out.println(s));

    }
    //search starting from an element using findElement on it, we can chain multiple findElements
    public static String getPrice(WebElement element){
        return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
