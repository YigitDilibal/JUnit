package tests.day08_BasicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C04_windowVsSayfa extends TestBase_Each {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com/");

        // url'i ve windowHande degerini yazdirin

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

        driver.findElement(By.xpath("(//*[.='Electronics'])[5]")).click();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

        driver.findElement(By.xpath("(//*[@class='product-box mb-2 pb-1'])[1]")).click();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

        driver.findElement(By.xpath("(//*[.='Account'])[1]")).click();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

    }

}
