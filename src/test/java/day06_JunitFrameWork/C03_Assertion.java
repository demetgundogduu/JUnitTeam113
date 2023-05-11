package day06_JunitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {


      /*
        Bir Assertion failed olursa
        Assertion'in oldugu satirda exception olusur
        ve assertion satirindan sonraki kodlar CALISMAZ
     */


    WebDriver driver;

    @Test
    public void googleTest(){
        //1- google anasayfaya gidip, url'in google icerdigini test edin
        mahserın4Atlısı();
        driver.get("https://www.google.com");
        String expectedIcerık="google";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerık));
        driver.close();

    }


    @Test
    public void  wiseTest(){
        //  2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        mahserın4Atlısı();
        driver.get("https://www.wisequarter.com");
        String expectedWiseIcerık="wisequarter";
        String actualWise=driver.getCurrentUrl();
        Assert.assertTrue(actualWise.contains(expectedWiseIcerık));
        driver.close();

    }


    @Test
    public void amazon(){
        // 3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        mahserın4Atlısı();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(amazonLogoElementi.isDisplayed());

        driver.close();


    }

    public void mahserın4Atlısı(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }


































}
