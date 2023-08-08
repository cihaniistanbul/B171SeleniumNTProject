package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//-->Max. 15 saniye sayfadaki tüm elementlerin oluşması için bekler
        /*
            Manuel olarak bir sayfayı açtığımızda nasıl maximize yapıyorsak, otomosyon ilede yukarıdaki örnekteki gibi
         sayfayı maximize yapabiliriz. Driver'ın tüm elementleri net bir şekilde görebilmesi için bunu yapmamız testleri-
         mizin daha sağlıklı çalışması için önemlidir. Maximize yaptıktan sonra tüm elementlerin oluşmasını beklemek
         için yine manage() methodu, timeouts().implicitlyWait() methodu ile bekleme yapmamız gerekir.
            Bir sayfaya gittiğimizde internetten kaynaklı yada sayfaya çok fazla aynı anda giriş yapılmasından kaynaklı
         web elementler hemen oluşmayabilir. Dolayısıyla müdahale etmek istediğimiz bir element oluşmaz ve o elementi
         handle etmek istediğimde kodlarım seri bir şekilde çalışmaya devam ettiği diğer satirdaki koda geçip hata alırız.
         Bu yüzden implcitlyWait bekleme konusunda bizim işimizi yüzde 80 çözer. Geri yüzde 20 lik kızmı ise daha sonra
         wait konusunda explicit wait olarak göreceğiz.
         */
        //techpro sayfasına gidiniz
        driver.get("https://techproeducation.com");

        //sayfa başlığının TechPro Education olduğunu test ediniz
        String actualTitle = driver.getTitle();
        String expectedTitle = "TechPro Education";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //facebook sayfasına gidiniz
        driver.get("https://facebook.com");

        //sayfa url'inin facebook içerdiğini test ediniz
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //techpro sayfasına geri dönününüz
        driver.navigate().back();
        Thread.sleep(3000);

        //Geri döndüğünüzü test ediniz
        if (actualTitle.equals(expectedTitle)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //sayfayı kapatını
        driver.close();



    }
}
