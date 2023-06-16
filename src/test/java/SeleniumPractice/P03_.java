package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03_ {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

        //Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        //Click on  Calculater under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
        //Type any number in the first input
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("5");
        //Type any number in the second input

        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("6");

        //Click on Calculate

        driver.findElement(By.xpath("//input[@id='calculate']")).click();

        //Get the result
        driver.findElement(By.xpath("/html/body/div/div[3]/div/p")).getText();
        String resultElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/p")).getText();

        //Print the result

        System.out.println(resultElement);

        driver.quit();

        // Answer : 11














    }
}


//Exercise3...
//Navigate to  https://testpages.herokuapp.com/styled/index.html
//Click on  Calculater under Micro Apps
//Type any number in the first input
//Type any number in the second input
//Click on Calculate
//Get the result
//Print the result