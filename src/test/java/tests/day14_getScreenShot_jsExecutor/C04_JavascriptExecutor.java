package tests.day14_getScreenShot_jsExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_JavascriptExecutor extends TestBase_Each {

    @Test
    public void test01(){

        ReusableMethods.bekle(1);
        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");

        //  isitme kaybi checkbox gorunecek kadar asagi inin


                // 1. adim : JavascriptExecutor objesi olusturun, deger olarak driveri atayip cast edin.
        JavascriptExecutor jse = (JavascriptExecutor) driver;
                // 2. adim : kullanmak istediginiz webElement'i locate edip kaydedin
        WebElement isitmeKaybiCheckbox = driver.findElement(By.id("hastalikCheck5"));
                // 3. adim : jse objesi ile executeScript() kullanin
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",isitmeKaybiCheckbox);

        ReusableMethods.bekle(1);

        //  jse kullanarak isitme kaybi checkbox'i isaretleyin

        jse.executeScript("arguments[0].click();",isitmeKaybiCheckbox);

        //   javascript Alert kullanarak "JUnit BITTTIIIII" yazdirin

        jse.executeScript("alert('JUnit BITTTIIIII');");

        ReusableMethods.bekle(1);


    }


}
