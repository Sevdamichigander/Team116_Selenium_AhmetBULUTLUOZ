package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05_SelgunBeyOrnek {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver_win32.zip");

        // Chrome Driver Olusturma - Option Ayari Gizli Sekme Olarak Acmak Icin
        ChromeOptions option = new ChromeOptions();
        option.addArguments("incognito");
        WebDriver driver = new ChromeDriver(option);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //        1- boyner.com.tr ye git
        driver.get("https://www.boyner.com.tr");

        // Firsat Kuponu'nu Cikiyorsa Kapatmak Icin Alttaki 2 Satirin // Kaldirin.
        // driver.findElement(By.xpath("//span[text()='×']")).click();
        // driver.findElement(By.xpath("//span[text()='×']")).click();

       //        2- valiz aramasi yap.
        driver.findElement(By.xpath("//p[text()='Hadi gel aradığını hızlıca bulalım...']")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("valiz" + Keys.ENTER);

        //        3- sonuclar arasindan "National Geographic" markali olanlari filtrele.
        driver.findElement(By.xpath("//div[text()='Marka']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'National Geographic')]")).click();
        Thread.sleep(2000);

        //        4- Artan fiyatli sirala
        driver.findElement(By.className("product-list-options_selectedOption__STacx")).click();
        driver.findElement(By.xpath("//span[text()='Fiyat - Düşükten Yükseğe']")).click();
        Thread.sleep(2000);

        //        5- Su an en dusuk fiyatli urunun ilk fiyatini ve indirimli fiyatini yazdirin.
        driver.findElement(By.className("product-item_productListItem__t_UMA")).click();
        Thread.sleep(2000);

        String priceInfo = driver.findElement(By.className("product-price_priceContainer__TsWtz")).getText();
        System.out.print("En Dusuk Fiyatli Urun\n"+writeFirstLastPrices(priceInfo)+"\n");
        Thread.sleep(2000);

        //        6- Onceki sayfaya don
        driver.navigate().back();

        //        7- Azalan fiyatli sirala
        driver.findElement(By.className("product-list-options_selectedOption__STacx")).click();
        driver.findElement(By.xpath("//span[text()='Fiyat - Yüksekten Düşüğe']")).click();
        Thread.sleep(2000);

        //        8- Su an en yuksek fiyatli urunun ilk fiyatini ve indirimli fiyatini yazdirin
        driver.findElement(By.className("product-item_productListItem__t_UMA")).click();
        Thread.sleep(2000);

        priceInfo = driver.findElement(By.className("product-price_priceContainer__TsWtz")).getText();
        System.out.print("En Yuksek Fiyatli Urun\n"+writeFirstLastPrices(priceInfo));
        Thread.sleep(2000);

        //      9- Driver Kapa
        driver.close();
    }

    private static String writeFirstLastPrices(String priceInfo) {
        String[] priceInfos = priceInfo.split("\n");
        return "Ilk Fiyat: " + priceInfos[0] + "\nSon Fiyat: " + priceInfos[2];

    }

}

/*
Dun gonderdigimde xPath li guncellemeler yaptim. Promosyon gelirse 1 deki // olan kismi kaldirmayi unutmayin.

 */
