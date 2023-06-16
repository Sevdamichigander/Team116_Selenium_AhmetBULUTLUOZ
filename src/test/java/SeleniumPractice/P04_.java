package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04_ {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32.zip");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

        //Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
       // Under the ORIGINAL CONTENTS click on Alerts
        driver.findElement(By.xpath("//a[@id = 'alerts']")).click();

        // print the URL
        System.out.println(driver.getCurrentUrl());

        //navigate back
        driver.navigate().back();
        //print the URL
        System.out.println(driver.getCurrentUrl());

        //Click on Basic Ajax
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();

        //print the URL
        System.out.println(driver.getCurrentUrl());

        //enter value 20 and ENTER
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("20"+ Keys.ENTER);

        //and then verify Submitted Values is displayed open page
        WebElement actualSubmittedValueElement= driver.findElement(By.xpath("/html/body/p[1]"));
        actualSubmittedValueElement.isDisplayed();

        String expectedSubmittedValueElement =  "Submitted Values";
        //String actualSubmittedValueElement = driver.findElement(By.xpath("/html/body/p[1]")).getText();

        if (actualSubmittedValueElement.equals(expectedSubmittedValueElement)){
            System.out.println("Submitted Value testi passed");
        }else {
            System.out.println("Submitted Value testi failed");
        }
        //close driver

        driver.close();


    }
}
/*
Navigate to website https://testpages.herokuapp.com/styled/index.html
Under the ORIGINAL CONTENTS
click on Alerts
print the URL
navigate back
print the URL
Click on Basic Ajax
print the URL
enter value 20 and ENTER
and then verify Submitted Values is displayed open page
close driver
 */
