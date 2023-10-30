package SeleniumPractice;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06_ {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10809));

        //5-Navigate to http://www.babayigit.net/murat/testpage.html

        driver.get("http://www.babayigit.net/murat/testpage.html");

        // 6-first name, surname, age, Your Job, Birth Palace, Last graduated school,
        // Number of Children alanlarına gerekli bilgileri yazsın

        driver.findElement(By.id("ad")).sendKeys("Ayse");
        driver.findElement(By.id("soyad")).sendKeys("KARA");
        driver.findElement(By.id("yas")).sendKeys("40");
        driver.findElement(By.id("meslek")).sendKeys("student");
        driver.findElement(By.id("dogum_yeri")).sendKeys("Ankara");
        driver.findElement(By.id("mezun_okul")).sendKeys("ODTU");
        driver.findElement(By.id("cocuk_sayisi")).sendKeys("1");


        // 7-Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@type='submit']")).submit();

        // 8- All information was entered correctly.. yazısının göründüğünü test etsin
        // ve 8. maddededeki Test sonucunu yazdırsın
        WebElement textAfterSubmit = driver.findElement(By.id("uyari"));

        Assert.assertTrue(textAfterSubmit.isDisplayed());

        System.out.println(textAfterSubmit.getText());



        //9- Clear butonu ile tüm butonları temizlesin

        driver.findElement(By.xpath("//input[@type='reset']")).click();

        //10- Manuel olarak temizlendiğini görecek kadar beklesin

        Thread.sleep(3);

        //    11- Sayfayı kapatsın

        driver.quit();


    }
}

/*
    1-Driver oluşturalim
    2-Java class'imiza chnomedriver. exetyi tanitalim
    3-Driver'in tum ekranı kaplamasini saglayalim
    4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
     Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.

    5-Navigate to http://www.babayigit.net/murat/testpage.html
    6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
        alanlarına gerekli bilgileri yazsın
    7-Submit tuşuna bassın.
    8- All information was entered correctly.. yazısının göründüğünü test etsin
    9- Clear butonu ile tüm butonları temizlesin
    10- Manuel olarak temizlendiğini görecek kadar beklesin
    11- Sayfayı kapatsın
    12-8. maddededeki Test sonucunu yazdırsın
     */
