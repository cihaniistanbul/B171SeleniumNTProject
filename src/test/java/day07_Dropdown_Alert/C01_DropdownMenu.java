package day07_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropdownMenu {
    /*
    Dropdown menu; Altbaşlıkların listelendiği webelemente denir.
         Bu webelementteki alt başlıklara ulaşabilmek bu altbaşlıkları handle edebilmek için öncelikle
    webelementin locate'ini alırız. Sonra Select class'ından bir obje oluşturup parametre olarak locate'ini
    aldığımız webelementi yazarız. Ve bu obje ile selectByIndex(),selectByValue() ve selectByVisibleTest() methodlarını
    kullanarak alt başlıkları seçebiliriz. getOptions() methodu bize bu alt başlıkların hepsini verir.
        Çoğu zaman bu dropdown webelementine sendKeys() methodu ile alt başlıklardaki herhangi bir seçeneği
    gönderebiliriz.
        Dropdown menudeki ilk seçili olan seceneği getFirstSelectedOption() methodu ile alabiliriz.
     */
/*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

     */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay = driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun = driver.findElement(By.xpath("(//select)[4]"));

        //b. Select objesi olustur
        Select selectYil = new Select(yil);
        Select selectAy = new Select(ay);
        Select selectGun = new Select(gun);

        //c. Select object i kullanarak 3 farkli sekilde secim yapiniz
        selectYil.selectByIndex(5);
        selectAy.selectByValue("4");
        selectGun.selectByVisibleText("15");
    }

    @Test
    public void test02() {
        // a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletler = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(eyaletler);
        List<WebElement> eyaletlerListesi = select.getOptions();
        //eyaletlerListesi.forEach(t-> System.out.println(t.getText()));//-->Lambda
        for (WebElement each:eyaletlerListesi) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void listOrnek() {
        List<WebElement> eyaletlerListesi = driver.findElements(By.xpath("//select[@id='state']//option"));
        eyaletlerListesi.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test03() {
        //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletler = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(eyaletler);
        String seciliOlanOption = select.getFirstSelectedOption().getText();//-->Select a State
        String expectedOption = "Select a State";
        System.out.println(seciliOlanOption);
        Assert.assertEquals(expectedOption,seciliOlanOption);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }
}
