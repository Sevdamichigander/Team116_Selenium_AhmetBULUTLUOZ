package day03_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators_AutomationExercise {
    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver_win32.zip");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));


        //2- https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin

        List<WebElement> categoryElementleriList = driver.findElements(By.className("panel-heading"));

        //4- Category bolumunde 3 element oldugunu test edin

        int expectedCategorySayisi = 3;
        int actualCategorySayisi = categoryElementleriList.size();

        if (expectedCategorySayisi == actualCategorySayisi) {
            System.out.println("Category sayisi testi Passed");
        }
        else {
            System.out.println("Category sayisi testi Failed");
        }

            //5- Category isimlerini yazdirin

            /*
            Biz bir listeyi direk olarak yazdirabiliriz ancak bu liste webElementler icerdigi icin
            direk yazdirmak istersek bize 3 tane reference degeri yazdirir.

            WebElementleri direk yazdiramayacagimiz icin bir foreach loop kullanarak
             herbir web elementi alip onun uzerindeki text i yazdirmaliyiz.

             */
            // System.out.println(categoryElementleriList);

            for (WebElement eachElement: categoryElementleriList
                 ) {
                System.out.println(eachElement.getText());
            }

            //6- Sayfayi kapatin

            Thread.sleep(2000);
            driver.close();


    }
}
