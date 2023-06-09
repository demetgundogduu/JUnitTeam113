package day06_JunitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertion {



    // 1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    WebDriver driver =new ChromeDriver();

    public void mahserin4Atlisi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void test01() {
        mahserin4Atlisi();
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void test02() {
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String unExpectedIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unExpectedIcerik));
    }



    @Test
    public void test03(){

        //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
        mahserin4Atlisi();

        WebElement logoBestBuyElementı= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(logoBestBuyElementı.isDisplayed());
        driver.close();


    }

    @Test
    public void test04(){
        mahserin4Atlisi();
        //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement   francaisLinkTesElementı=driver.findElement(By.className("is-active"));
        Assert.assertTrue(francaisLinkTesElementı.isDisplayed());


        driver.close();
    }


































}
