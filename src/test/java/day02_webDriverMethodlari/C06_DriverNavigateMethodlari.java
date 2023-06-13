package day02_webDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));


        //wise quarter ana sayfaya gidelim

        driver.navigate().to("https://www.wisequarter.com");
        Thread.sleep(2000);

        //ayni browser da amazon anasayfaya gidelim

        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        // tekrar wise anasayfaya donun

        driver.navigate().back();
        Thread.sleep(2000);

        // yeniden amazon a gidelim

        driver.navigate().forward();
        // back ile geri geldiysel forward ile ileri gidebilirim. yoksa to ile gitmek lazim

        Thread.sleep(2000);
        
        driver.close();

    }
}
