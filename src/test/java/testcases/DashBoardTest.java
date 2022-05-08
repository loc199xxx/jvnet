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
        initTestBaseSetup("chrome123",BaseURl);
        driver=getDriver();
    }
    @Test
    public void TC001_KiemTraTieuDeTrang(){
        Log.info("Đang chạy TC001: Kiểm tra tiêu đề của trang web");
        DashBoardPage = new DashBoardPage(driver);
        String title = DashBoardPage.getHomePageTitle();
        try {
            Assert.assertEquals(title,"JVNET - Công Ty Xuất Khẩu Lao Động Nhật Bản UY Tín2");
            Log.info("TC001: PASS");
        } catch (Exception e){
            Log.error("TC001: FAIL");
            Log.info("TC001: FAIL");
        }
    }
    @Test
    public void TC002_KiemTraCacMucCoTrenHeader(){
        Log.info("Đang chạy TC002: Kiểm tra các mục có trên header");
        DashBoardPage = new DashBoardPage(driver);
        try {
            Assert.assertTrue(DashBoardPage.checkElementsHomePage());
            Log.info("TC002: PASS");
        }catch (Exception e){
            Log.error("TC002: PASS");
        }



    }
}
