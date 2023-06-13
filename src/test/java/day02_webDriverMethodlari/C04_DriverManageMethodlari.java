package day02_webDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wisequarter.com");
        System.out.println("ilk sayfanin size degeri"+ driver.manage().window().getSize());//ilk sayfanin size degeri(1051, 798)
        System.out.println("ilk sayfanin konumu " + driver.manage().window().getPosition());//ilk sayfanin konumu (9, 9)

        driver.manage().window().maximize();
        System.out.println("mawimize edilen sayfanin size degeri"+ driver.manage().window().getSize());//mawimize edilen sayfanin size degeri(1552, 832)
        System.out.println("maximize edilen ilk sayfanin konumu " + driver.manage().window().getPosition());//maximize edilen ilk sayfanin konumu (-8, -8)

        Thread.sleep(2000);

        driver.manage().window().fullscreen();
        System.out.println("full screen size degeri"+ driver.manage().window().getSize());// full screen size degeri(1536, 864)

        System.out.println("full screen konumu " + driver.manage().window().getPosition()); //full screen konumu (0, 0)

        Thread.sleep(3000);
        driver.close();
    }
}
