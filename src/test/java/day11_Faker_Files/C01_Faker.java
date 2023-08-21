package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {
    @Test
    public void faker() {
        /*
            Faker class'ı ile sahte datalar oluşturabilmek için öncelikle mvnrepository.com adresinden github-javafaker
        dependency'i pom.xml dosyasına koymamız gerekiyor. Sonra Faker class'ından bir obje oluşturup fake datalar
        üretebiliriz.
         */

        Faker faker = new Faker();
        //faker objesi ile fake bir isim yazdırınız
        System.out.println(faker.name().firstName());

        //faker objesi ile fake bir soyisim yazdırınız
        System.out.println(faker.name().lastName());

        //faker objesi ile fake bir adress yazdırınız
        System.out.println(faker.address().fullAddress());

        //faker objesi ile fake bir telefon No yazdırınız
        System.out.println(faker.phoneNumber().phoneNumber());

        //faker objesi ile fake bir email yazdırınız
        System.out.println(faker.internet().emailAddress());

        //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
        System.out.println(faker.number().digits(15));

        //faker objesi ile fake bir isim soyisim sayi yazdırınız
        System.out.println(faker.name().fullName());





    }
}
