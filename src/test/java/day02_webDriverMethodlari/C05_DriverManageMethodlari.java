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
        // herbir gorev icin bu sureyi ayri ayri kullanir.

        // Belirledigimiz sureden once islem tamamlanirsa artik beklemez
        // islem tamamlanmazsa her halukarda bekledigimiz surenin sonunda beklemeyi birakir.



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


    }
}
