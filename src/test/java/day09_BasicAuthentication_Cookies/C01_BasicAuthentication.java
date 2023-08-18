package day09_BasicAuthentication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {
    @Test
    public void test01() {
        //Aşağıdaki bilgileri kullanarak authentication yapınız:

        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //    Congratulations! You must have the proper credentials. yazının çıktığını doğrulayın
        String text = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals("Congratulations! You must have the proper credentials.",text);

        //Elemental Selenium linkine tıklayınız
        driver.findElement(By.xpath("(//a)[2]")).click();
        window(1);//-->TestBase deki window methodu ile yeni açılan sayfaya geçtik

        //Başlığın Elemental Selenium içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));





    }
}
