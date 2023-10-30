package day02_webDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wisequarter.com");

        Thread.sleep(6000);



        System.out.println(driver.getTitle());

        // sayfa title inin Wise icerdigini test edin

        String expectedIcerik ="Wise";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("passed");
        }else {
            System.out.println("Title Wise icermiyor, test failed");
        }
        // url in https://wisequarter.com oldugunu test edin

        String expectedUrl = "https://www.wisequarter.com";
        String actualUrl = driver.getCurrentUrl(); // o anki url i alir ve string dondurur

        if (actualUrl.equals(expectedUrl)){
            System.out.println("passed");
        }else{
            System.out.println("url test - failed");
            System.out.println("Actual url " + actualUrl);
        }

        //System.out.println(driver.getPageSource()); // sayfanin kaynak kodlarini verir

        System.out.println(driver.getWindowHandle()); // C68ACFCB199924576FCB3B578606E73E

        // Sistemde her olusturulan browser icin unique bir wondow handle degeri atanir.
        // bu handle degeri sayfalar arasinda gecis yapmak icin kullanilir.
        // driver her acilis kapanista yeni bir hash kod degeri atanir.
        // bu window acik iken biz baska bir window da calisiyorsak
        // ve bu window a gecmek istiyorsak " window handle degeri x olan su driver a git"
        // dersek driver bu window a gecis yapar

        System.out.println(driver.getWindowHandles()); // [C68ACFCB199924576FCB3B578606E73E]
        // bize set dondurur. Bulundugumuz class ta ki driver tarafindan olusturulan
        // ve acik olan tum window larin window handle degerlerini bir set olarak bize dondurur.



        driver.close();

    }
}
