package tests.day14_getScreenShot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C03_WebElementScreenshot extends TestBase_Each {

    @Test
    public void test01() throws IOException {

        // 1- testotomasyonu anasayfaya gidip,

        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin


        Assertions.assertTrue(driver.getCurrentUrl().contains("testotomasyonu")) ;

        // 2- phone icin arama yapip,
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String unexpectedSonuc = "0 Products Found";
        String actualSonuc = aramaSonucElementi.getText();

        Assertions.assertNotEquals(unexpectedSonuc,actualSonuc);

        // 3- ilk urunu tiklayip,

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // acilan sayfadaki urun isminde
        // case sensitive olmadan "phone" bulundugunu test edin

        String expectedIsimIcerik = "phone";

        WebElement isimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String actualIsim = isimElementi.getText().toLowerCase();

        ReusableMethods.bekle(1);
        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));

        // testin sorunsuz calistigini ispatlamak icin
        // urun isminin screenshot'ini alip kaydedin

        // 1. adim : screenshot alinmasi istenen Webelement'i locate edip kaydedin
                // biz zaten locate edip kaydettik

        // 2. adim : screenshot'in kaydedilecegi asil File'i olusturun

        File asilResim = new File("target/screenshots/WebElementScreenshot.jpg");

        // 3. adim : resmini cekmek istediginiz webElement uzerinden get.screenshot() kullanin
        File geciciResim = isimElementi.getScreenshotAs(OutputType.FILE);

        // 4. adim : FileUtils ile gecici dosyayi asilResim dosyasina kopyalayin.
        FileUtils.copyFile(geciciResim,asilResim);

        ReusableMethods.webElementScreenshot(isimElementi);
        ReusableMethods.isimliWebElementScreenshot(isimElementi,"ilkUrunTesti");


        driver.quit();







    }


}
