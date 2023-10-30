package day02_webDriverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




        // implicitlyWait Selenium dan gelen DINAMIK bir beklemedir. Yani gerektigi kadar bekletir.

        // Sayfanin yuklenmesi veya islem yapilacak webElementlerinin bulunmasi icin beklenecek maximum sureyi belirler.
        // Driver bu sure dolana kadar verilen gorevin yapilip yapilmadigini kontrol eder.
        // Bu sure icerisinde gorev yapilamazsa exception firlatip calismayi durdurur.
        /*
        Exception: Implicit wait throws a NoSuchElementException
        when the WebDriver cannot find the element within the specified timeout.
        In contrast, explicit wait throws a TimeoutException when the element doesn't meet the condition
         within the specified timeout.
         */
        // herbir gorev icin bu sureyi ayri ayri kullanir.

        // Belirledigimiz sureden once islem tamamlanirsa artik beklemez
        // islem tamamlanmazsa her halukarda belirledigimiz surenin sonunda beklemeyi birakir.



        driver.get("https://www.wisequarter.com");
        System.out.println("Baslangic konumu "+driver.manage().window().getPosition());//Baslangic konumu (-8, -8)
        System.out.println("Baslangic size "+driver.manage().window().getSize());//Baslangic size (1552, 832)

        driver.manage().window().setSize(new Dimension(1200, 500));
        driver.manage().window().setPosition(new Point(100,200));

        System.out.println("Degisen konumu "+driver.manage().window().getPosition());//Degisen konumu (100, 200)
        System.out.println("Degisen size "+driver.manage().window().getSize());//Degisen size (1203, 503)

        driver.manage().timeouts();


        Thread.sleep(1000); // java dan gelir ve yazdigimiz sure miktarinca kodlari bekletir.
        // Ne olursa olsun belirledigim sure kadar bekletir. Amacima ulasmissam bile!!!

        // Test bitince Thread.sleep leri silmek lazim. Yoksa test cok uzun surer

        driver.close();

         /*      wait konusunu ilerde tek basina ele alacagiz
                ancak her class icin yapmamiz gereken bir ayar oldugu icin burada kisaca deginelim
                implicitlyWait : driver'a sayfanin yuklenmesi ve kullanacagimiz webelementlerin bulunmasi icin
                                 bekleyecegi maximum sureyi belirtir.
                                 driver bu sure icerisinde sayfa yuklenir/web element bulunursa
                                 beklemeden calismaya devam eder.
                                 bu sure bittigi halde sayfa yuklenememis/webElement bulunamamissa
                                 exception vererek calismayi durdurur

                Duration.ofSeconds(15) : Duration class'i Selenium-4 ile gelen zaman class'idir
                                         Yani driver'a ne kadar bekleyecegini soyler
                                         Duration.ofSeconds(15) yerine milis,minutes,hours da kullanilabilir
         */

        /* NOT :    Driver'in istedigimiz islemleri yaparken sorunla karsilasmamasi icin
                    driver.manage() method'larindan
                    maximize() ve implicitlyWait() method'larinin her test'te kullanilmasi
                    FAYDALI OLACAKTIR

         */


    }
}
