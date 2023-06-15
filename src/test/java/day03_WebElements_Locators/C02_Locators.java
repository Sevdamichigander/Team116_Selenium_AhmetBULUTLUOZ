package day03_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_Locators {
    public static void main(String[] args) throws InterruptedException {
        /*
        Locator :  verdigimiz locate bilgisini kullanarak driver in locate etmesini saglayan hazir method lardir.
                    Selenium da 8 adet locator vardir.

                 Ilk 6 tanesi webelementi olusturan HTML kodun icerigine baglidir.
                 1- By.id
                 2- By.name
                 3- By.classname
                 4- By.tagName
                 5- By.linkText
                 6- By.partiallyLinkText

                 Son 2 tane ise her turlu web element icin kullanilabilir.
                 7- By.xPath
                 8- By.cssSelector

         */


        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));


        // amazon anasayfaya gidelim

        driver.get("https://www.amazon.com");

        // arama kutusuna Nutella yazip aratalim

       /* WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));

        (By.id("Twotabsearchtextbox")); T yi buyuk yazdinca ve elementi locate edemedi.
         NoSuchElementException verdi
         */

        WebElement searchBoxElement = driver.findElement(By.name("field-keywords"));

        searchBoxElement.sendKeys("Nutella" + Keys.ENTER)  ;


        //searchBoxElement.sendKeys("Nutella");
        //searchBoxElement.submit();

        // gosterilen urun resimlerinin 10 dan fazla oldugunu test edin

        /*
        List<WebElement> urunIsimElementleriList = driver.findElements(By.className("a-size-base-plus a-color-base a-text-normal"));

        // Locator stratejisi olarak By.className secildiginde class attribute urun degeri space iceriyorsa
        locate islemi basarisiz olabilir.

        if (urunIsimElementleriList.size()>10){
            System.out.println("Listelenen urun sayisi testi Passed");
        }else {
            System.out.println("Listelenen urun sayisi testi Failed");
        }
        */

        List<WebElement> urunIsimElementleriList = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        if (urunIsimElementleriList.size()>10){
            System.out.println("Listelenen urun sayisi testi Passed");
        }else {
            System.out.println("Listelenen urun sayisi testi Failed");
        }

        // 5. urun ismini yazdirin ve ismin Nutella icerdigini test edin

        String besinciUrunIsmi = urunIsimElementleriList.get(4).getText();
        System.out.println("besinci urun ismi : " + besinciUrunIsmi);

        String expectedIcerik = "Nutella";
        if (besinciUrunIsmi.contains(expectedIcerik)){
            System.out.println("besinci urun ismi testi PASSED");
        }else {
            System.out.println("besinci urun ismi testi FAILED");
        }

        //Thread.sleep(2000);
        driver.close();

    }
}
