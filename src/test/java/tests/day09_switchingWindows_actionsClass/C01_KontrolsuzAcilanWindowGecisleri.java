package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.HashSet;
import java.util.Set;

public class C01_KontrolsuzAcilanWindowGecisleri extends TestBase_Each {

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




        Set<String> eskiWhdler = new HashSet<>();

        eskiWhdler.add(driver.getWindowHandle());

        Set<String> whdler = driver.getWindowHandles();

        String yeniSekme="";

        for (String each:whdler){

            for (String eachEski: eskiWhdler){
                if (!each.equals(eachEski)) {
                    yeniSekme = each;
                    break;
                }
            }
        }

        driver.switchTo().window(yeniSekme);

        System.out.println(driver.getWindowHandle());


        ReusableMethods.bekle(2);



    }

}
