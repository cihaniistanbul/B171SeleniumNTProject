package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle extends TestBase {
    @Test
    public void test01() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);//-->WindowType.WINDOW yeni pencere
                                                       //-->WindowType.TAB yeni sekme
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
    }

    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir sekme) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);//-->WindowType.WINDOW yeni pencere
                                                   //-->WindowType.TAB yeni sekme
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir sekme) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
    }

    @Test
    public void test03() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir sekme) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);//-->WindowType.WINDOW yeni pencere
                                                    //-->WindowType.TAB yeni sekme
        driver.get("https://www.youtube.com");


        //Window 3'te (yeni bir sekme) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        bekle(2);


        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        /*
            Yukarıdaki arrayList sayesinde açılmış olan tüm pencereleri getWindowHandles() methodu sayesinde alıp
        index ile istediğimiz pencereye çok rahat geçişler yapabiliriz
         */

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(pencereler.get(0));
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(pencereler.get(1));
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(pencereler.get(2));
    }

    @Test
    public void test04() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir sekme) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);//-->WindowType.WINDOW yeni pencere
        //-->WindowType.TAB yeni sekme
        driver.get("https://www.youtube.com");


        //Window 3'te (yeni bir sekme) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        bekle(2);


        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
    }
}
