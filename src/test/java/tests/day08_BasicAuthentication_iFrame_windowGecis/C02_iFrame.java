package tests.day08_BasicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_iFrame extends TestBase_Each {

    @Test
    public void iFrameTest(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // Websayfasini inceledigimizde
        // Elektronics products yazisinin bir iframe icerisine oldugunu gorduk
        // ONCE bu iFrame'i locate edip kaydedip, iframe'e gecis yapmaliyiz

        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe)[1]"));

        driver.switchTo().frame(electronicsIFrame);
        ReusableMethods.bekle(1);

        WebElement electronics = driver.findElement(By.xpath("//h2[.='Electronics Products']"));

        Assertions.assertTrue(electronics.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin]

        String expectedYazi = "DELL Core I3 11th Gen";
        WebElement dellPC = driver.findElement(By.xpath("//*[.='DELL Core I3 11th Gen ']"));

        Assertions.assertEquals(expectedYazi,dellPC.getText());


        //4- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        // driver'i bir iframe'e gecis yaptirdigimizda
        // biz tekrar driver'i anasayfaya dondurmedikce
        // driver iframe'de kalir.

        driver.switchTo().defaultContent(); // ana sayfaya doner
        driver.switchTo().parentFrame(); // bir ust frame'e doner

        WebElement someProducts = driver.findElement(By.xpath("//*[.='Here are some products.']"));

       Assertions.assertTrue(someProducts.isDisplayed());


        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(fashionIFrame);

        WebElement fashionYazisi = driver.findElement(By.xpath("//*[.='Fashion']"));

        Assertions.assertTrue(fashionYazisi.isDisplayed());

        //6- Fashion bolumundeki ilk ilk urun isminde "Men Slim Fit" gectigini test edin

        WebElement ilkUrun = driver.findElement(By.id("men-slim-shirt"));

        Assertions.assertTrue(ilkUrun.getText().contains("Men Slim Fit"));

    }

}
