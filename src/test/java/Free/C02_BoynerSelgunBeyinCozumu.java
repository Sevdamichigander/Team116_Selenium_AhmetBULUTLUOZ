package Free;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class C02_BoynerSelgunBeyinCozumu {
        static String [] brands={"Dockers by Gerli","Lumberjack","Columbia","Jack Wolfskin","Merrell","Skechers", "Caterpillar", "The North Face", "Timberland", "Birkenstock", "Havaianas"};
        static String [] sizes={"42 ","42.5 ","43 "};

        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
            ChromeOptions option = new ChromeOptions();
            option.addArguments("incognito");
            WebDriver driver=new ChromeDriver(option);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Boyner.com'a git.
            driver.get("https://www.boyner.com.tr");

            // Eger indirim kuponu cikiyorsa kapat

            if(driver.findElement(By.xpath("//div[@class='ins-content-wrapper ins-content-wrapper-2187']")).isDisplayed()) {
                driver.findElement(By.xpath("//span[text()='×']")).click();
                driver.findElement(By.xpath("//span[text()='×']")).click();
            }

            // Erkek Sekmesinden Ayakkabi - Sandalet & Terlik Sec
            WebElement erkekOption=driver.findElement(By.xpath("//a[@class='mega-menu_gift__ccvMi' and @href='/erkek-c-2']"));
            Actions action=new Actions(driver);
            action.moveToElement(erkekOption).perform();
            driver.findElement(By.xpath("//a[@href='/erkek-sandalet-terlik-modelleri-c-3302065']")).click();
            Thread.sleep(3000);

            // Beden olarak 42, 42.5, 43 varsa sec.
            driver.findElement(By.xpath("//div[text()='Beden']")).click();
            List<WebElement> sizeList = driver.findElements(By.className("checkbox_label__pjGfx"));

            for (int i = 0; i <sizes.length; i++) {
                for (int j = 0; j < sizeList.size(); j++) {
                    if (sizeList.get(j).getText().contains(sizes[i])) {
                        sizeList.get(j).click();
                        Thread.sleep(1600);
                        break;
                    }
                }
            }

            // Soldan varsa Dockers by Gerli, Lumberjack, Columbia, Jack Wolfskin, Merell,
            // Skechers, Caterpillar, The North Face, Timberland, Birkenstock, Havaianas sec.
            driver.findElement(By.xpath("//div[text()='Marka']")).click();
            String search;
            for (int i = 0; i < brands.length; i++) {
                search="//span[contains(text(),'"+brands[i]+"')]";
                if(driver.findElement(By.xpath(search)).isDisplayed()) {
                    driver.findElement(By.xpath(search)).click();
                }
                Thread.sleep(1500);
            }

            // Fiyati dusukten yuksege sirala
            driver.findElement(By.className("product-list-options_selectedOption__STacx")).click();
            driver.findElement(By.xpath("//span[text()='Fiyat - Düşükten Yükseğe']")).click();

            Thread.sleep(3000);

            // Filtelenen Tum Urunleri markalarini ve satis fiyatlarini liste halinde ile yazdirin.

            // Oncelikle Filtelenen Urun Adedini Bulmak Gerekli.
            int listedProductNumber=Integer.parseInt(driver.findElement(By.className("product-list_total__TvMCW")).getText().replaceAll("\\D", ""));

            // Tum urunlerin yuklenmesi icin sayfasyi asagiya indirmek gerekli.
            for (int i = 0; i < listedProductNumber/6; i++) {
                action.sendKeys(Keys.PAGE_DOWN).perform();
                Thread.sleep(1500);
            }
            System.out.println("Total Filtered Product Number: "+listedProductNumber);

            String brand, price;
            String [][] productBrandPrice=new String[listedProductNumber+1][2];
            for (int i = 1; i <= listedProductNumber; i++) {
                brand="(//div[@class='product-item_brand__LFImW'])["+i+"]";
                price="(//strong)["+i+"]";
                productBrandPrice[i][0]=driver.findElement(By.xpath(brand)).getText();
                productBrandPrice[i][1]=driver.findElement(By.xpath(price)).getText();
                System.out.println(i+"- Brand: "+productBrandPrice[i][0]+"\n"+i+"- Price: "+productBrandPrice[i][1]);
            }

            // Skechers'in Kahve Erkek Lifestyle Ayakkabı 204351 BRN LOMELL goruntulendigini test et.
            if(driver.findElement(By.xpath("//a[@href='/skechers-sandalet-1399018']")).isDisplayed()) {
                System.out.println("204351 Apperance Test Passed.");
            } else {
                System.out.println("204351 Apperance Test Failed.");
            }

            driver.close();
        }
    }

