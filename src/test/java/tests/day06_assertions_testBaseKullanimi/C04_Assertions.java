package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    //https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver =  new ChromeDriver();

    @BeforeAll
    public static void setup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void urlTest(){

        // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        Assertions.assertEquals("https://www.bestbuy.com/",driver.getCurrentUrl());
    }

    @Test
    public void titleTest(){

        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        Assertions.assertFalse(driver.getTitle().contains("Rest"));
    }

    @Test
    public void logoTest(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin

        Assertions.assertTrue(driver.findElement(By.className("logo")).isDisplayed());
    }

    @Test
    public void FrancaisTest(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        Assertions.assertTrue(driver.findElement(By.xpath("//*[.='Français']")).isDisplayed());

    }


}
