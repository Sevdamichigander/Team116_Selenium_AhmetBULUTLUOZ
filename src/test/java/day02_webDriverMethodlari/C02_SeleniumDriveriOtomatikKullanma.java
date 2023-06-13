package day02_webDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C02_SeleniumDriveriOtomatikKullanma {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        // firefox driver i indirmememize ragmen Selenium un kendi driver i sayesinde driver imiz calisti.


        /*

        driver objesini her olusturdugumuzda Selenium istedigimiz browser in bir kopyasini olusturur.
        Kapat demezsek olusturulan browser acik kalir.

        Kodlar cok hizli calistigi icin bazi asamalari gozle gorebilmek
        veya internette ki yavasliktan dolayi
        testin failed olmamasi icin java dan
        Thread.sleep() ile kodlari istedigimiz sure kadar durdurabiliriz.

        Selenium da hersey hazir ve elimizin altinda. Sadece onlari nerde bulacagimizi bilmeliyiz.

         */

        Thread.sleep(2000);

        driver.get("https://www.amazon.com");
        // get(url) methodu olusturdugumuz kopya browser i verilen url 'e goturur

        Thread.sleep(3000);
        driver.close();
    }
}
