package day07_JUnit_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropdownMenu {




    static WebDriver driver;

    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //  1. Kategori menusunden Books secenegini  secin
    //  2. Arama kutusuna Java yazin ve aratin
    //  3. Bulunan sonuc sayisini yazdirin
    //  4. Sonucun Java kelimesini icerdigini test edin



    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");




    }

    @AfterClass
    public static void teardown(){

        driver.close();





    }

    @Test
    public void test01(){

        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        // Element dropdown menu oldugu ıcın select class'ınddan olusturacagımız
        //obje ile ilgili methodları kullanmalıyız

        WebElement dropdownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownMenu);
        int expecetdOptionSayısı=45;
        int actualOptionSayısı=select.getOptions().size();
        Assert.assertEquals(expecetdOptionSayısı,actualOptionSayısı);


        // Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);





    }






    @Test
    public void test02(){




        WebElement dropdownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownMenu);
        //  1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");
        //  2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        //  3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayısı=driver.findElement(By.xpath("(//span[@class='rush-component'])[1]"));
        System.out.println(sonucSayısı.getText());
        //  4. Sonucun Java kelimesini icerdigini test edin

        String expecetedIcerık="Java";
        String actualSonuc=sonucSayısı.getText();
        Assert.assertTrue(actualSonuc.contains(expecetedIcerık));









    }





































}
