package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebelementLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Techpro sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Arama kutusunu locate edip java aratalım
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));
        aramaKutusu.sendKeys("java");
        Thread.sleep(3000);

        //Çıkan seçeneklerden full stack java developer seçeneğine tıklayalım
        List<WebElement> linkler = driver.findElements(By.linkText("Full Stack Java Developer"));
        /*
            Eğer birden fazla webelementi handle etmek istiyorsak bu webelementleri bir list'e atmamız gerekir.
        List kullandığımız zaman birden fazla webelement olduğu için findElements() methodunu kullanırız.

            Full Stack Java Developer linktext'ine sahip tüm webelmentleri WebElement türünde oluşturmuş olduğum
        liste attım
            Bir webElemente sahip text'i yada bir webelement üzerindeki yazıyı alabilmek ve yazdırabilmek için getText()
        methodunu kullanırız.
         */
        for (WebElement w:linkler) {
            System.out.println(w.getText());
        }
        linkler.get(0).click();

        //Başlığın Java içerdiğini test edelim
        if (driver.getTitle().contains("Java")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //Sayfada kaç tane link olduğunu yazdıralım
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayisi = "+linklerListesi.size());

        //Sayfadaki linklerin isimlerini konsola yazdıralım

        //LAMBDA
        //linklerListesi.forEach(t-> System.out.println(t.getText()));

        for (WebElement each:linklerListesi) {
            if (!each.getText().isEmpty()){
                System.out.println(each.getText());
            }
        }

        //sayfayı kapatalım
        driver.close();
    }
}
