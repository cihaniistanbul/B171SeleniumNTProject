package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FakerTest extends TestBase {
    @Test
    public void faker() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //“firstName” giris kutusuna bir isim yazin
        //“lastname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,fakeEmail);
        bekle(2);
        firstName.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,fakeEmail,Keys.TAB,faker.internet().password(),
                Keys.TAB,Keys.TAB,"20",Keys.TAB,"May",Keys.TAB,"2007",Keys.TAB,Keys.TAB,Keys.ARROW_RIGHT,Keys.ENTER);


        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='2']")).isSelected());



    }
}
