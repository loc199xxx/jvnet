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
    private String hoten="Nguyễn Văn a";
    private String diachi="Đây là địa chỉ test";
    private String sdt="090992200021";
    private String namsinh="1900";
    private String ghichu="ghi chú test";
    private String email="testtest@gmail.com";
    private String gioitinhNam="Nam";
    private String gioitinhNu="Nữ";
    private String bietquaMXH="Facebook, Zalo, Youtube";
    private String bietquaWebsite="Website";
    private String bietquaGT="Người quen";

    @BeforeClass
    public void setUp(){
        initTestBaseSetup("chrome",BaseURl);
        driver=getDriver();
    }
    @Test
    public void TC012_BoTrongHoVaTen() throws InterruptedException {
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);

        Subscribe.inputInforamtion("",diachi,sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Subscribe.clickSubmit();
        Subscribe.notifError("Cột được yêu cầu.");
        Thread.sleep(4000);

    }
}
