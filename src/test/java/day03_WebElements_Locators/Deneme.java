package day03_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Deneme {
    public static void main(String[] args) {

        //1- Bir test class’i olusturun ilgili ayarlari yapin

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.

        //List<WebElement> linkElementList = driver.findElements(By.linkText("a"));
//
        //int expectedContent = 147;
        //int actualContent = linkElementList.size();
//
        //if (actualContent==expectedContent){
        //    System.out.println("passed");
        //}else {
        //    System.out.println("147-failed");
        //}


        //4- Products linkine tiklayin

        driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
        driver.findElement(By.xpath("//path[@stroke='#FAFAFA']")).click();

        WebElement productsElement = driver.findElement(By.id(" Products"));
        productsElement.click();



        //5- special offer yazisinin gorundugunu test edin

        WebElement specialOfferYazisiElement = driver.findElement(By.id("sale_image"));

        if (specialOfferYazisiElement.isDisplayed()){
            System.out.println("passed");
        }else{
            System.out.println("special offer - failed");
        }

        //6- Sayfayi kapatin

        driver.close();



    }
}
