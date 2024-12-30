package tests.day08_BasicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_KontrolluYeniWindowOlusturma extends TestBase_Each {


    @Test
    public void test01(){
        // Testotomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com/");

        // url'i ve windowHande degerini yazdirin
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

        String testOtomasyonuWhd = driver.getWindowHandle();

        ReusableMethods.bekle(1);
        // Yeni bir tab acarak wisequarter anasayfaya gidin

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");

        // url'i ve windowHande degerini yazdirin
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

        String wiseQuarterWhd = driver.getWindowHandle();

        ReusableMethods.bekle(1);

        // yeni bir window acarak youtube anasayfaya gidin

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");

        ReusableMethods.bekle(1);

        // url'i ve windowHande degerini yazdirin
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

        String youTubeWhd = driver.getWindowHandle();

        ReusableMethods.bekle(1);

        driver.switchTo().window(testOtomasyonuWhd);

        ReusableMethods.bekle(1);

        driver.switchTo().window(wiseQuarterWhd);

        Assertions.assertTrue(driver.getCurrentUrl().contains("wisequarter"));






    }

}
