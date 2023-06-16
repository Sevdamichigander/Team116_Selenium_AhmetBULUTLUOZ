package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01_SeleniumPractice {
    public static void main(String[] args) throws InterruptedException {

/*
   /....Exercise-1:...
    Create a new class with main method
    Set Path
    Create a chrome driver
    Maximize window
    Open google home page https://www.google.com
    On the same class, navigate to amazon home page https://www.amazon.com and navigate back to google
    Wait about 4 sn
    Navigate forward to amazon
    Refresh page
    Close/quit the browser
    And Last step print "All is well" on console
  */

        //    Set Path-    Create a chrome driver -    Maximize window

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver_win32.zip");
        // Burada driver imizi tanittik ve driver in yolunu gosterdik.

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();// pencereyi menuler ve dugmeler kaybolmadan en buyuk boyutuna ulastirir.
        //driver.manage().window().fullscreen();//pencereyi menuler ve dugmeler OLMAYACAK sekilde en buyuk boyutuna ulastirir
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    Open google home page https://www.google.com

        driver.get("https://www.google.com");

        /*
        - get ve navigate.to ayni isi yapar fakat get daha hizli calisir.
        - navigate komutu genelde bagimli durumlarda tercih edilir.
          Yani icinde oldugumuz pencereyi kapatmadan o pencerede iken baska bir web sitesine gitmek.
         */

        // On the same class, navigate to amazon home page https://www.amazon.com and navigate back to google

        driver.navigate().to("https://www.amazon.com");
        driver.navigate().back();

        //    Wait about 4 sn

        Thread.sleep(4000);//x saniye bekler
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); ==>
        //  sayfa yuklenene kadar 15 saniye bekler. 3. saniyede yuklenirse kalan 12 saniyeyi beklemez.

        //    Navigate forward to amazon

        driver.navigate().forward();

        // Refresh page
        driver.navigate().refresh();

        //    Close/quit the browser
        driver.close();// sadece uzerince test yaptigimiz pencereyi kapatir.
        // driver.quit();// butun pencereleri kapatir

        System.out.println("All is well");
        System.err.println("All is well");//Kirmizi renkli yaziyor


    }
}
