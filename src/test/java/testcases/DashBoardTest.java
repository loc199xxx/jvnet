package testcases;

import common.BaseSetup;
import common.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import common.Log;
import common.commonBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashBoardPage;


@Listeners(TestListener.class)
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
        String title_exp = "JVNET - Công Ty Xuất Khẩu Lao Động Nhật Bản UY Tín";
        String title = DashBoardPage.getHomePageTitle();
        Assert.assertEquals(title,title_exp);
    }
    @Test
    public void TC002_KiemTraCacMucCoTrenHeader(){
        Log.info("Đang chạy TC002: Kiểm tra các mục có trên header");
        DashBoardPage = new DashBoardPage(driver);
        Assert.assertTrue(DashBoardPage.checkElementsHomePage());

    }
    @Test
    public void TC003_KiemTraHienThiBanner(){
        Log.info("Đang chạy TC003: Kiểm tra banner quảng cáo");
        commonBase = new commonBase(driver);
        By banner = By.xpath("//a[@class='fill']//div[@class='fill banner-link']");
        commonBase.verifyElementDisplay(banner);
    }
    @AfterClass
    public void afterDashBoard(){
        driver.quit();
    }
}
