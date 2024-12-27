package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;

public class C01_DropdownMenu extends TestBase_Each {


    @Test
    public void dopdownmenuTesti(){

        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");
        //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

          // dropdown menu ile islem yapmak icin 3 adim var
            // 1. adim : kullanilacak dropdown menuyu locate edip kaydedelim
        WebElement gunDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
            // 2. adim : bir select objesi olusturalim
        Select selectGun = new Select(gunDdm);
            // 3. adim : select objesi ile istenen islemi yapalim
        selectGun.selectByIndex(5); // 5. secenegin indexi de 5

        //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByValue("nisan");

        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDdm);
        selectYil.selectByVisibleText("1990");

        //	4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        System.out.println("---------");
        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
            // 1. alternatif
        System.out.println(ayDdm.getText());

        System.out.println("----------");
            // 2. alternatif select objesi kullanilarak, tum optionlari bir liste olarak kaydedebiliriz.
        List<WebElement> ayDdmOptionList = selectAy.getOptions();

        for (WebElement each: ayDdmOptionList){
            System.out.println(each.getText());
        }

        System.out.println("---------");

        // ay dropdown menusunde mart kelimesinin gecmedigini test edin.

//        for (WebElement each: ayDdmOptionList){
//            Assertions.assertNotEquals(each.getText(),"mart");
//        }

            // 1. alternatif, bir flag olusturup for each loop ile mart kelimesi varmi bakalim
        boolean martVarmi= false;

        for (WebElement each: ayDdmOptionList){
            if (each.getText().equals("mart")){
                martVarmi = true;
            }
        }

        Assertions.assertFalse(martVarmi);

            // 2. alternatif: elimizdeki web element'lerden olusan listeyi
            //                Stringlerden olusan bir listeye cevirip
            //                bu listenin mart icermedigini test edebiliriz

        List<String> ddmOptionsStringList = new ArrayList<>();

        for (WebElement each: ayDdmOptionList){
            ddmOptionsStringList.add(each.getText());
        }

        Assertions.assertFalse(ddmOptionsStringList.contains("mart"));

        //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        Assertions.assertEquals(13, ayDdmOptionList.size());


        ReusableMethods.bekle(1);




    }


}
