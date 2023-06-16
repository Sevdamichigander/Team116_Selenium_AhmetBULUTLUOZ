package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02_ {
    public static void main(String[] args) {
         /*
     . .Exercise2...
1-Driver oluşturalim
2-Java class'imiza chnomedriver.exet i tanitalim
3-Driver'in tum ekranı kaplamasini saglayalim
5-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
4-"https://www.otto.de" adresine gidelim
6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
8-Ardindan "https://wisequarter.com/" adresine gidip
9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
10-Bir onceki web sayfamiza geri donelim
11-Sayfayı yenileyelim
12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 4-"https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");

        //5-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.

        driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));
       // driver


       // 6-Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim

        driver.getTitle();
        driver.getCurrentUrl();

        // 7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim

        String actualTitle = driver.getTitle();
        String actualURL= driver.getCurrentUrl();


        System.out.println(actualTitle);

        if (actualTitle.contains("OTTO")&&(actualURL.contains("OTTO"))){
            System.out.println("Title ve URL OTTO kelimesi iceriyor : Test passed");
        }else{
            System.out.println("Test failed" +"\nEn az biri aranan kelimeyi icermiyor.");
        }

        //8-Ardindan "https://wisequarter.com/" adresine gidip
        driver.get("https://wisequarter.com/");

        //9-Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini kontrol edelim
        driver.getTitle();
        String actualTitleWQ = driver.getTitle();

        if (actualTitleWQ.contains("Quarter")){
            System.out.println("WQ title Test passed");
        }else{
            System.out.println("WQ title Test failed");

        }

        //10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        //11-Sayfayı yenileyelim
        driver.navigate().refresh();

        // 12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
        driver.navigate().forward();
        driver.close();

        //13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
















    }
}
