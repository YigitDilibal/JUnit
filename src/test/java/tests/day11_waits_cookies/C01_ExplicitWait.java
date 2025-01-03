package tests.day11_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitWait {

    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

    WebDriver driver;

    @Test
    public void implicitWaitTest() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBoxElementi = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textBoxElementi.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("//*[.='Enable']")).click();

        //implicitly wait 2 islem icin bekler
        // 1- sayfanin yuklenmesi,
        // 2- webelement'in locate edilebilmesi
        // sayfa zaten yuklu, text box da zaten locate edildi
        // bu durumda implicitly wait bekleme yapmaz, hemen assertion'a gecer
        // ama enable olmasi icin zaman ihtiyac oldugundan assertion failed verir.
        // bu gorevin tamamlanabilmesi icin explicitly wait veya Thread.sleep kullanmak zorundayiz.

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Thread.sleep(3000);
        // bu zamani ayarlarken
        //hem gorevin yerine getirilmesi
        // hem de fazladan bekleme yapilmamasini dikkate alacak
        // optimum cozumu bulmaya gayret etmeliyiz.

        Assertions.assertTrue(textBoxElementi.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledYaziElementi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());


        driver.quit();

    }


    @Test
    public void explicitWaitTest(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBoxElementi = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textBoxElementi.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("//*[.='Enable']")).click();

            // explicitWait icin 3 adim kullanacagiz
            // 1. adim bir WebdriverWait objesi olusturun
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

            // 2. adim wait ile kullanilacak elementi locate etmek mumkunse, locate edip kaydedin
            // bu gorevde textboxu kullanacagiz ve zaten locate etmistik

            // 3. adim wait ile baslayip hangi islem icin bekleyeceginizi tanimlayin.
            wait.until(ExpectedConditions.elementToBeClickable(textBoxElementi));


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBoxElementi.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledYaziElementi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());


        driver.quit();

    }


}
