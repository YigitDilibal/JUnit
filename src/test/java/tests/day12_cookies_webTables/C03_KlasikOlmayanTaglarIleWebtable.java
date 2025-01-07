package tests.day12_cookies_webTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C03_KlasikOlmayanTaglarIleWebtable extends TestBase_Each {

    @Test
    public void test01(){

        //1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers da bulunan basliklari yazdirin

        WebElement headers = driver.findElement(By.xpath("//*[@role='hdata']"));

        System.out.println(headers.getText());

        System.out.println("=================");


        // 3. 3.sutunun basligini yazdirin

        WebElement baslik3 = driver.findElement(By.xpath("//*[@role='hdata'][3]"));
        System.out.println(baslik3.getText());

        System.out.println("==============");

        // 4. Tablodaki tum datalari yazdirin

        WebElement tumTablo = driver.findElement(By.className("table"));
        System.out.println(tumTablo.getText());

        System.out.println("==============");


        // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        List<WebElement> tumHucreler = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));

        System.out.println(tumHucreler.size());

        System.out.println("=========");

        // 6. Tablodaki satir sayisini yazdirin

        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][1]"));

        System.out.println(tumSatirlar.size());

        System.out.println("=============");

        // 7. Tablodaki sutun sayisini yazdirin

        List<WebElement> tumSutunlar = driver.findElements(By.xpath("//*[@role='trow'][1]/*[@role='tdata']"));

        System.out.println(tumSutunlar.size());

        System.out.println("============");

        // 8. Tablodaki 3.kolonu yazdirin

        List<WebElement> kolon3 = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        System.out.println(ReusableMethods.stringListeDonustur(kolon3));

        System.out.println("===============");


        // 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        List<WebElement> kolon2 = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][2]"));

        int index = 0;
        for (int i = 0; i < kolon2.size() ; i++) {

            if (ReusableMethods.stringListeDonustur(kolon2).get(i).equals("Furniture")){
                index = i+1;
            }
        }

        String dinamikXpath = "//*[@role='trow']["+index+"]/*[@role='tdata'][3]";

        WebElement furnitureFiyat = driver.findElement(By.xpath(dinamikXpath));

        System.out.println(furnitureFiyat.getText());

        System.out.println("===============");

        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin

        System.out.println(getCellData(2, 3));
        System.out.println(getCellData(1, 3));
        System.out.println(getCellData(3, 2));


    }

    public String getCellData (int satirNo, int sutunNo){

        String dinamikXpath = "//*[@role='trow'][" + satirNo + "]/*[@role='tdata'][" + sutunNo + "]";

        WebElement hedefElement = driver.findElement(By.xpath(dinamikXpath));

        return hedefElement.getText();


    }


}
