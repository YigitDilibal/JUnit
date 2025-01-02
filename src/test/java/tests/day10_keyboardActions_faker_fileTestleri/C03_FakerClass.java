package tests.day10_keyboardActions_faker_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class C03_FakerClass extends TestBase_Each {

    @Test
    public void test01(){

        // fake datalar uretmek icin Faker Class'daki method'lari kullaniriz

        Faker faker = new Faker();

        System.out.println(faker.space().galaxy());
        System.out.println(faker.lordOfTheRings().character()); // Samwise Gamgee

        System.out.println(faker.address().fullAddress());


    }

}
