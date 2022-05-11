package testcases;
import common.BaseSetup;
import common.Log;
import common.TestListener;
import common.commonBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Subscribe;

@Listeners(TestListener.class)
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
    @Parameters("browserType")
    public void setUp(String browserType){
        initTestBaseSetup(browserType);
        driver=getDriver();
    }
    @AfterClass
    public void afterSubscribe(){
        driver.quit();
    }
    @BeforeMethod
    public void clickSub(){
        Subscribe = new Subscribe(driver);
        Subscribe.clickSubscribe();
    }

    @Test(groups = {"subscribe","hoten", "validate"})
    public void TC012_BoTrongHoVaTen(){
        Log.info("Đang chạy TC012: Bỏ trống trường Họ và Tên");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion("",diachi,sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Assert.assertTrue(Subscribe.SubmitAndVerifyNotif("Cột được yêu cầu."));
        Subscribe.clickCloseSub();
    }
    @Test(groups = {"subscribe","hoten", "validate"})
    public void TC013_NhapToanSpace(){
        Log.info("Đang chạy TC013: Nhập toàn space trường Họ và Tên");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion("      ",diachi,sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Assert.assertTrue(Subscribe.SubmitAndVerifyNotif("Cột được yêu cầu."));
        Subscribe.clickCloseSub();
    }
    @Test(groups = {"subscribe","hoten", "validate"})
    public void TC014_NhapSpaceDauCuoi(){
        Log.info("Đang chạy TC014: Nhập space đầu cuối trường Họ và Tên");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion("   nguyen van a   ",diachi,sdt,email,namsinh,gioitinhNam,bietquaWebsite,ghichu);
        Subscribe.checkSuccessAndBackHome("Đăng ký thành công");

    }
    @Test(groups = {"subscribe","hoten", "validate"})
    public void TC015_NhapSo() throws InterruptedException {
        Log.info("Đang chạy TC015: Nhập số trường Họ và Tên");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion("123",diachi,sdt,email,namsinh,gioitinhNu,bietquaGT,ghichu);
        Subscribe.checkSuccessAndBackHome("Đăng ký thành công");

    }
    @Test(groups = {"subscribe","hoten", "validate"})
    public void TC016_NhapChu() throws InterruptedException {
        Log.info("Đang chạy TC016: Nhập chữ trường Họ và Tên");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion("nguyen van a",diachi,sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Subscribe.checkSuccessAndBackHome("Đăng ký thành công");
        Subscribe.waitFormClosed();
    }
    @Test(groups = {"subscribe","hoten", "validate"})
    public void TC017_NhapKyTuDacBiet(){
        Log.info("Đang chạy TC017: nhập ký tự đặc biệt trường Họ và Tên");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion("!@#",diachi,sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Assert.assertTrue(Subscribe.SubmitAndVerifyNotif("Họ và tên không hợp lệ"));
        Subscribe.clickCloseSub();
    }
    @Test(groups = {"subscribe","diachi", "validate"})
    public void TC018_BoTrongDiaChi(){
        Log.info("Đang chạy TC018: Bỏ trống trường địa chỉ");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion(hoten,"",sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Assert.assertTrue(Subscribe.SubmitAndVerifyNotif("Cột được yêu cầu."));
        Subscribe.clickCloseSub();
    }
    @Test(groups = {"subscribe","diachi", "validate"})
    public void TC019_NhapSpaceDiaChi(){
        Log.info("Đang chạy TC019: Nhập toàn space trường địa chỉ");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion(hoten,"       ",sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Assert.assertTrue(Subscribe.SubmitAndVerifyNotif("Cột được yêu cầu."));
        Subscribe.clickCloseSub();
    }
    @Test(groups = {"subscribe","diachi", "validate"})
    public void TC020_NhapSpaceDauCuoi(){
        Log.info("Đang chạy TC020: Nhập space đầu cuối trường địa chỉ");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion(hoten,"   ha noi  ",sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Subscribe.checkSuccessAndBackHome("Đăng ký thành công");

    }
    @Test(groups = {"subscribe","diachi", "validate"})
    public void TC021_NhapSoVaoDiaChi(){
        Log.info("Đang chạy TC021: nhập số trường địa chỉ");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion(hoten,"123123",sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Subscribe.checkSuccessAndBackHome("Đăng ký thành công");

    }
    @Test(groups = {"subscribe","diachi", "validate"})
    public void TC022_NhapChuVaoDiaChi(){
        Log.info("Đang chạy TC022: nhập chữ vao trường địa chỉ");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion(hoten,"ha noi",sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Subscribe.checkSuccessAndBackHome("Đăng ký thành công");

    }
    @Test(groups = {"subscribe","diachi", "validate"})
    public void TC023_NhapKyTuDacBietVaoDiaChi() {
        Log.info("Đang chạy TC023: nhập ký tự đặc biệt trường địa chỉ");
        commonBase = new commonBase(driver);
        Subscribe = new Subscribe(driver);
        Subscribe.inputInforamtion(hoten,"!@##@!",sdt,email,namsinh,gioitinhNam,bietquaMXH,ghichu);
        Subscribe.checkSuccessAndBackHome("Đăng ký thành công");
    }
}
