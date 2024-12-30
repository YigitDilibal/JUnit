package tests.day08_BasicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C06_KontolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){

        // https://testotomasyonu.com/discount sayfasina gidin

        driver.get("https://testotomasyonu.com/discount");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(fashionIFrame);

        driver.findElement(By.id("men-slim-shirt")).click();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

        Set<String> whdler = driver.getWindowHandles();

        String yeniSekme="";

        for (String each:whdler){

            if (!each.equals(driver.getWindowHandle())){
                yeniSekme=each;
            }
        }

        driver.switchTo().window(yeniSekme);

        System.out.println(driver.getWindowHandle());


        ReusableMethods.bekle(2);



    }



}
