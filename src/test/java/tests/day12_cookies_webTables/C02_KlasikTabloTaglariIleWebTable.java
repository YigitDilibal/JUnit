package tests.day12_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;
import java.util.Set;

public class C02_KlasikTabloTaglariIleWebTable extends TestBase_Each {

    @Test
    public void test01(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin

        WebElement tumBody = driver.findElement(By.xpath("//tbody"));

        System.out.println(tumBody.getText());
        System.out.println("===================");

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedBodyIcerik = "Comfortable Gaming Chair";
        String actualTumBody = tumBody.getText();

        Assertions.assertTrue(actualTumBody.contains(expectedBodyIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));

        Assertions.assertEquals(tumSatirlar.size(),5);


        //5. Tum satirlari yazdirin
        System.out.println(ReusableMethods.stringListeDonustur(tumSatirlar));
        System.out.println("==============");

              // daha guzel gozukmesi icin satir satir yazdiralim

        for (int i = 0; i < tumSatirlar.size(); i++) {

            System.out.println(1+i+". satir\n"  + tumSatirlar.get(i).getText());

        }


        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
              // WebTable'da sutun yapisi yoktu
              // bunun yerine satirlar ve herbir satirdaki datalar vardir
              // sutun sayisini bulmak icin herhangi bir satirdaki data sayisina bakabiliriz.

        List<WebElement> birinciSatirDataElementleriList = driver.findElements(By.xpath("//tbody/tr[1]/td"));

        Assertions.assertEquals(4,birinciSatirDataElementleriList.size());


        //7. 3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println(ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));

        //8. Tablodaki basliklari yazdirin
              //tek webelement halinde
        WebElement headerSatirElementi = driver.findElement(By.xpath("//thead"));

        System.out.println(headerSatirElementi.getText());
        System.out.println("=======================");
              // ayri elementler halinde
        List<WebElement> baslikDataElementleriList = driver.findElements(By.xpath("//thead//th"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikDataElementleriList));

        System.out.println("============");


        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(dataGetirenMethod(3, 4)); // Go
        System.out.println(dataGetirenMethod(1, 2)); // Electronics


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        Assertions.assertEquals("Furniture",dataGetirenMethod(4,2));



    }

    public String dataGetirenMethod(int satir, int sutun){

        String xPath = "//tbody/tr["+ satir + "]/td["+sutun+"]";

        WebElement veri = driver.findElement(By.xpath(xPath));

        return veri.getText();

    }

}
