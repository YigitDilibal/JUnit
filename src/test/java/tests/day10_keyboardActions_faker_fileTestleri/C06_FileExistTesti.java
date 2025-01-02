package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistTesti {

    @Test
    public void test01() throws Exception {

        // day10 package'i altinda deneme.txt diye bir dosya bulundugunu test edin.


        // Selenium WebDriver objesi ile kullanilir
        // yani web sayfalari ile calisir
        // ancak fiziki olarak bilgisayarimizda bulunan bir dosyaya erismek
        // ve varligini test etmek icin Java'dan yardim alacagiz

        // Java'nin bir dosyaya ulasabilmesi icin
        // dosya yoluna ihtiyacimiz var

        String dosyaYolu = "src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme.txt";
        String downloadsTxtYolu = "C:\\Users\\arche\\Downloads\\deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        Files.copy(Paths.get(dosyaYolu),Paths.get(downloadsTxtYolu));

        Assertions.assertTrue(Files.exists(Paths.get(downloadsTxtYolu)));

        String herkesteFarkliOlanKisim = System.getProperty("user.home");
        System.out.println(herkesteFarkliOlanKisim);


    }

}
