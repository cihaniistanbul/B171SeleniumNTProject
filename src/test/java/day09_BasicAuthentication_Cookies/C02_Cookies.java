package day09_BasicAuthentication_Cookies;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {
    /*
    Cookie denildiğinde aklıma manage() methodu gelmeli. manage() methodu ile cookielerle ilgili tüm işleri yaparız.
     */
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        //2-tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();//-->Tüm cookieleri cookieSet'e attık
        int sayac = 1;
        for (Cookie c:cookieSet) {
            System.out.println(sayac+". cookie : "+c);
            System.out.println(sayac+". cookie Name : "+c.getName());
            System.out.println(sayac+". cookie Value : "+c.getValue());
            sayac++;
        }

        bekle(3);
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookilerin Sayisi = "+cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);
        bekle(2);
        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();//-->USD
        Assert.assertEquals("USD",actualCookieValue);
        bekle(2);
        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);//-->Cookie ekledik
        System.out.println("**********************************");
        cookieSet = driver.manage().getCookies();//-->Ekleme yaptıktan sonra cookieSet'e tekrar tüm cookie'leri atadık
        int sayac1 = 1;
        for (Cookie e:cookieSet) {
            System.out.println(sayac1+". cookie : "+e);
            System.out.println(sayac1+". cookie Name : "+e.getName());
            System.out.println(sayac1+". cookie Value : "+e.getValue());
            sayac1++;
        }
        bekle(2);

        //6-eklediginiz cookie’nin sayfaya eklendigini test
        Assert.assertTrue(cookieSet.contains(cookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookieSet = driver.manage().getCookies();//-->Silme işleminden sonra cookieSet'i tekrar güncelledik
        System.out.println("***************************");
        int sayac2 = 1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac2+". cookie : "+w);
            System.out.println(sayac2+". cookie Name : "+w.getName());
            System.out.println(sayac2+". cookie Value : "+w.getValue());
            sayac2++;
        }
        bekle(2);
        Assert.assertFalse(cookieSet.contains(driver.manage().getCookieNamed("skin")));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//-->Tüm cookieleri sildik
        cookieSet = driver.manage().getCookies();//-->CookieSet'i tekrar güncelledik
        Assert.assertTrue(cookieSet.isEmpty());//-->isEmpty() methodu ile cookieSet'in içinin boş olduğunu doğrularız
    }
}
