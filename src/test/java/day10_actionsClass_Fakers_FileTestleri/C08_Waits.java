package day10_actionsClass_Fakers_FileTestleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08_Waits {


    @Test
    public void test01(){


        // implicitly wait'in rolunu gorebilmek icin
        // baslangic ayarlarini bu test method'unda yapalim
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //AMAZON ANA SAYFASINA GIDELIM
        driver.get("https://www.amazon.com");

        //Nutella aratalım
        WebElement aramaKutusuElementı= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementı.sendKeys("Nutella " + Keys.ENTER);
        //arama sonuclarının Nutella içerdiğini test edelim
        WebElement sonucYazıElementı= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedNutella="Nutella";
        String actualNutella=sonucYazıElementı.getText();
        Assert.assertTrue(actualNutella.contains(expectedNutella));









    }




































}
