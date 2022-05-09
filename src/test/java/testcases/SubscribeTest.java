package testcases;
import common.BaseSetup;
import common.commonBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Subscribe;

public class SubscribeTest extends BaseSetup{
    private WebDriver driver;
    public pages.Subscribe Subscribe;
    public commonBase commonBase;

    @BeforeClass
    public void setUp(){
        initTestBaseSetup("chrome",BaseURl);
        driver=getDriver();
    }
    @Test
    public void TC012_BoTrongHoVaTen(){
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
//        String[] valueNam = {"",""}
//        Subscribe.inputInforamtion(Hoten="",diachi=);
    }
}
