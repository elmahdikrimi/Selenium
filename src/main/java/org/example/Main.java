package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.quit();

        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Mehdi");
        System.out.println(arr.size());
        System.out.println(arr.get(0));

    }
}