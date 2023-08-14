package day06_Junit;

import org.junit.*;

public class C02_BeforeAfter {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class'dan önce 1 kez çalışır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan önce bir kez @Before çalışır");
    }

    @Test
    public void test01() {
        System.out.println("Test01 çalişti");
    }

    @Test
    public void test02() {
        System.out.println("Test02 çalişti");
    }

    @Test
    public void test03() {
        System.out.println("Test03 çalişti");
    }

    @Test
    public void test04() {
        System.out.println("Test04 çalişti");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra bir kez @After çalışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'dan sonra 1 kez çalışır");
    }

    /*
    Bir class'da 4 tane test methodu 1 tane before 1 tane after method varsa class'da toplam kaç method çalışmış olur
     */
    /*
        Junit framework'ünde test'lerinizi istediğiniz sıralamada çalıştırmak isterseniz alfabetik ve numerik olarak
    test methodlarınızı isimlendirmeniz gerekmektedir.
     */
}
