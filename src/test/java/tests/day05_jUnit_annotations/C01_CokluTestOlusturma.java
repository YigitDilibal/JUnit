package tests.day05_jUnit_annotations;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CokluTestOlusturma {

    /*
        1- @Test notasyonu siradan method'lari
           bagimsiz olarak calisabilir Test Method'lari haline getirir

        2- Bir method'un gecici bir sure icin kullanilmamasini istersek
           method'u @Disable olarak isaretleyebiliriz

        3- JUnit test method'larini belirli bir kriter olmadan
           rastgele bir siralama ile calistirir
           bu siralamayi ONGORMEMIZ veya KONTROL ETMEMIZ mumkun degildir
           (ekstra bazi notasyonlarla bu saglanabilir)

        4- Eger sirali calismasini istedigimiz test method'lari olursa
           isimlerini test01, test02, test03 ... yaparsak
           bu siralamaya uygun olarak test method'larini calistirir

     */

    // 3 farkli method olusturup asagidaki gorevleri yapin
    // 1- testotomasyonu sayfasina gidin ve url'in testotomasyonu icerdigini test edin
    // 2- youtube ana sayfaya gidin ve Title'in YouTube oldugunu test edin
    // 3- wisequarter anasayfaya gidin ve Title'in case sensitive olmadan wisequarter icerdigini test edin

    @Test
    public void testotomasyonuTesti() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- testotomasyonu sayfasina gidin

        driver.get("https://www.testotomasyonu.com");

        // ve url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu Testi PASSED");
        } else System.out.println("Testotomasyonu Testi FAILED");

        Thread.sleep(1000);
        driver.quit();

    }

    // @Disabled  Gecici olarak bu method'un kullanilmamasini istedigimizde
    @Test
    public void youtubeTesti() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- youtube ana sayfaya gidin ve
        driver.get("https://www.youtube.com");

        // Title'in YouTube oldugunu test edin

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("Youtube testi PASSED");
        } else System.out.println("Youtube testi FAILED");

        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void wisequarterTesti() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3- wisequarter anasayfaya gidin ve
        driver.get("https://www.wisequarter.com");

        // Title'in case sensitive olmadan wisequarter icerdigini test edin

        String expectedTitleIcerik = "wisequarter";
        String actualTitle = driver.getTitle().toLowerCase();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");

        Thread.sleep(1000);
        driver.quit();

    }


}