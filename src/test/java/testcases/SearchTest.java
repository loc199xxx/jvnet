package testcases;

import common.BaseSetup;
import common.Log;
import common.commonBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashBoardPage;

public class SearchTest extends BaseSetup {
    private WebDriver driver;
    public pages.DashBoardPage DashBoardPage;
    public commonBase commonBase;

    @BeforeClass
    public void setUp(){
        initTestBaseSetup("chrome",BaseURl);
        driver=getDriver();
    }
    @Test
    public void kiemTraTitleWeb() throws InterruptedException {
        Log.info("SSSSSSSSSSs");

        DashBoardPage = new DashBoardPage(driver);
        DashBoardPage.inputAndSearch("di nhat");
        Thread.sleep(5000);
    }
}
