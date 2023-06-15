package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme {
    public static void main(String[] args) throws InterruptedException {

         /*

        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        2- Add Element butonuna basin
        3- Delete butonu’nun gorunur oldugunu test edin
        4- Delete tusuna basin
        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

         */

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2-  https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");

        //3-  Browseri tam sayfa yapin

        driver.manage().window().maximize();

        //4-  Sayfayi “refresh” yapin

        driver.navigate().refresh();

        //5-  Sayfa basliginin “Spend less” ifadesi icerdigini test edin

        String actualTitle = driver.getTitle();
        String expectedIcerik = "Spend less";

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi passed");
        }else {
            System.out.println("Title testi failed");
        }



        //6-  Gift Cards sekmesine basin

    driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();


        //7-  Birthday butonuna basin

    driver.findElement(By.xpath("//img[@alt='Birthday']")).click();


        //8-  Best Seller bolumunden ilk urunu tiklayin

driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();

        //9-  Gift card details’den 25 $’i  secin
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();


        //10-Urun ucretinin 25$ oldugunu test edin
        WebElement ucretElementi = driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]"));

        String expectedUrunUcretiElement = "25$";
        String actualUrunUcretiElement = ucretElementi.getText();

        if (actualUrunUcretiElement.equals(expectedUrunUcretiElement)){
            System.out.println("ucret testi passed");
        }else{
            System.out.println("ucret testi failed");
        }


        //11-Sayfayi kapatin

        Thread.sleep(3000);
        driver.close();
















    }
}
