package day02_webDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverOlusturma {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip"); // path from content root

        // bu class a kulanilacak WebDriver i(chrome, edge vs)
        // ve bu driver ile ilgili dosyalari nerede bulabilecegimizi tanimlar.

        WebDriver driver = new ChromeDriver();
        // driver objesi olusturur
        // bu obje bizim icin istedigimiz web sayfalarina gidebilecek
        // o sayfalarda istedgimiz islemi yapabilecek ozelliklerdedir.
        // web sayfalarina gidebilmek ve islemler yapabilmek icin bir browser a ihtiyac oldugundan
        // driver objesi setProperty ile tanimladigimiz browser in bir kopyasini olusturur
        // ve bu kopya browser ile tum islemleri yapar.

        /*
        Selenium 4.7 versiyonu ile kendi webDriver ini olusturdu.
        Yani biz chromedriver.exe dosyasini indirmemis olsak bile
        9. satiri yazmasak da Selenium devreye girip kendi driver ini olusturur.

         */

    }
}

/*
Selenium u projemize dahil edebilmek icin normalde Maven altyapisini kullaniriz.Ancak,
Maven sart degildir.

Bir framework e Selenium dosyalarini eklerseniz Selenium kutuphanelerini kullanabilirsiniz.

Bir projeye Selenium eklemenin en ilkel yolu

File, Project Structure, Modules, Dependencies i secip tum dosyalari + ile manuel olarak projemize eklemektir.

Ancak bu yontem tek basina yeterli degildir. Selenium yaninda kullancagimiz WebDriver i da projemize eklememiz gerekir.
Her bilgisayarda kullanilan browser ve o browser in versiyonu farkli olacagindan bu yontemi kullandigimizda her class ta
kullanilacak driver i sisteme tanitmamiz gerekir.

Selenium ile otomasyon yapabilmek icin browser a ihtiyacimiz var.
 */