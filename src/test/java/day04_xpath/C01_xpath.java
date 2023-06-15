package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_xpath {
    public static void main(String[] args) throws InterruptedException {
        /*

        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        2- Add Element butonuna basin
        3- Delete butonu’nun gorunur oldugunu test edin
        4- Delete tusuna basin
        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna basin

        WebElement addElementButon = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));

        addElementButon.click();

        // driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click(); if vs kullanmayacaksak bu satir da yeterli

        Thread.sleep(3000);

        // 3- Delete butonu’nun gorunur oldugunu test edin

        WebElement deleteButon = driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));

        deleteButon.isDisplayed();

        if (deleteButon.isDisplayed()){
            System.out.println("delete button gorunme testi PASSED");
        }else {
            System.out.println("System.out.println(\"delete button gorunme testi FAILED");
        }

        // 4- Delete tusuna basin

        deleteButon.click();
        Thread.sleep(3000);

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveElement = driver.findElement(By.xpath("//*[@id=\"content\"]/h3"));
        addRemoveElement.isDisplayed();

        if (addRemoveElement.isDisplayed()){
            System.out.println("add/remove testi PASSED");
        }else {
            System.out.println("add/remove testi FAILED");
        }

        Thread.sleep(3000);

        driver.close();

    }

}
