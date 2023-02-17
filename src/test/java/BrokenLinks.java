import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //getting the href attribute of the link
        String href = driver.findElement(By.linkText("Broken Link")).getAttribute("href");
        System.out.println(href);

        HttpURLConnection connection = (HttpURLConnection)new URL(href).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        int resCode = connection.getResponseCode();
        System.out.println(resCode);

        //iterate through all the links in the footer section
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG'] //li/a"));

        SoftAssert as = new SoftAssert();

        for(WebElement link:links){
            String a = link.getAttribute("href");
            HttpURLConnection con = (HttpURLConnection)new URL(a).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int rc = con.getResponseCode();
            //soft Assertions saves the assertion failures and doesn't stop the loop when it fails
            as.assertTrue(rc<400,link.getText() + " is broken with Status code " + rc);
            //prints the message as a part of the failure message(in red)
        }
            //call assertAll() to fail the test if there is a failure and report
            as.assertAll();
    }
}
