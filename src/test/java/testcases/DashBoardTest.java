package testcases;

import common.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import common.Log;
import common.commonBase;
import org.testng.annotations.Test;
import pages.DashBoardPage;

public class DashBoardTest extends BaseSetup {
    private WebDriver driver;
    public DashBoardPage DashBoardPage;
    public commonBase commonBase;

    @BeforeClass
    public void setUp(){
        initTestBaseSetup("chrome",BaseURl);
        driver=getDriver();
    }
    @Test
    public void TC001_KiemTraTieuDeTrang(){
        Log.info("=====>  Đang chạy TC001: Kiểm tra tiêu đề của trang web <=====");
        DashBoardPage = new DashBoardPage(driver);
        String title = DashBoardPage.geHomePageTitle();
        System.out.println(title);
        Assert.assertEquals(title,"JVNET - Công Ty Xuất Khẩu Lao Động Nhật Bản UY Tín");
    }
    //testtttttttttttttt
}
