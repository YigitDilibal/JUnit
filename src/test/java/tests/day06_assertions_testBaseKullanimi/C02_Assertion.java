package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.util.List;

public class C02_Assertion {

    static WebDriver driver;

    /*
        JUnit bir test method'u problemsiz calisip bittiyse
        o method'u PASSED olarak,
        Kodlar calisirken bir problem olursa
        o method'u FAILED olarak isaretler.

        Eger if else ile yaptigimiz kontrol sonucunun
        JUnit tarafindan farkedilmesini isterseniz
        kontrol sirasinda FAILED olan testler icin
        exception firlatabiliriz.
     */


    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // 1- testotomasyonu anasayfaya gidip,

        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

//        if (actualUrl.contains(expectedUrlIcerik)){
//            System.out.println("Url testi PASSED");
//        }else{
//            System.out.println("Url testi FAILED");
//            throw new AssertionFailedError();
//        }

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }

    @Test
    public void test02(){
        // 2- phone icin arama yapip,
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElemenleriList = driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualSonucSayisi = bulunanUrunElemenleriList.size();

//        if (actualSonucSayisi>0){
//            System.out.println("Urun bulma testi PASSED");
//        }else {
//            System.out.println("Urun bulma testi FAILED");
//            throw new AssertionFailedError();
//        }

        Assertions.assertTrue(actualSonucSayisi>10);

    }

    @Test
    public void test03(){
        // 3- ilk urunu tiklayip, acilan sayfadaki urun isminde
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();


        //    case sensitive olmadan "phone" bulundugunu test edin

        WebElement urunisimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = urunisimElementi.getText().toLowerCase();

//        if (actualUrunIsmi.contains(expectedIsimIcerik)){
//            System.out.println("Urun isim testi PASSED");
//        }else{
//            System.out.println("Urun isim testi FAILED");
//            throw new AssertionFailedError();
//        }

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));
    }

}
