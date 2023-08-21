package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void test01() {
        String path = "C:\\Users\\Lenovo\\Downloads\\b10 all test cases, code (4).docx";
        try {
            Files.delete(Paths.get(path));
        } catch (IOException e) {
            System.out.println("DOSYA BULUNAMADI");
        }

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//a)[3]")).click();
        bekle(5);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        //"C:\Users\Lenovo\Downloads\b10 all test cases, code (4).docx"
        String dosyaYolu = "C:\\Users\\Lenovo\\Downloads\\b10 all test cases, code (4).docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {
        //"C:\Users\Lenovo      \Downloads\b10 all test cases, code (4).docx"
        String farkliYol = System.getProperty("user.home");//-->C:\Users\Lenovo
        String ortakYol ="\\Downloads\\b10 all test cases, code (4).docx";
        String dosyaYolu = farkliYol+ortakYol;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
