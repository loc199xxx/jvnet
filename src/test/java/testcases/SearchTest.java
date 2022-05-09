package testcases;

import common.BaseSetup;
import common.Log;
import common.commonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.util.List;

public class SearchTest extends BaseSetup {
    private WebDriver driver;
    public pages.SearchPage SearchPage;
    public commonBase commonBase;

    @BeforeClass
    public void setUp(){
        initTestBaseSetup("chrome",BaseURl);
        driver=getDriver();
    }
    @Test
    public void TC004_BoTrongVaTimKiem(){
        Log.info("Đang chạy TC004: Bỏ trống và ấn tìm kiếm");
        SearchPage= new SearchPage(driver);
        commonBase = new commonBase(driver);
        SearchPage.clickSearch();
        SearchPage.KiemTraSoLuongTinTuc(12);
        SearchPage.cleanInpSearch();
    }

    @Test
    public void TC005_NhapSpace() {
        Log.info("Đang chạy TC005: Nhập toàn Space");
        SearchPage = new SearchPage(driver);
        commonBase = new commonBase(driver);
        SearchPage.inputAndSearch("      ");
        SearchPage.KiemTraSoLuongTinTuc(12);
        SearchPage.cleanInpSearch();
    }
    @Test
    public void TC006_SpaceDauCuoi() {
        Log.info("Đang chạy TC006: Nhập space đầu cuối chuỗi kí tự");
        SearchPage = new SearchPage(driver);
        commonBase = new commonBase(driver);
        SearchPage.inputAndSearch("        nhat      ");
        SearchPage.KiemTraSoLuongTinTuc(12);
        SearchPage.cleanInpSearch();
    }
    @Test
    public void TC007_NhapKyTuDacBiet() {
        Log.info("Đang chạy TC007: Nhập kí tự đặc biệt");
        SearchPage = new SearchPage(driver);
        commonBase = new commonBase(driver);
        SearchPage.inputAndSearch("!@#");
        SearchPage.KhongCoTinTuc();
        SearchPage.cleanInpSearch();
    }
    @Test
    public void TC008_NhapSo() {
        Log.info("Đang chạy TC008: Nhập số");
        SearchPage = new SearchPage(driver);
        commonBase = new commonBase(driver);
        SearchPage.inputAndSearch("123123");
        SearchPage.KhongCoTinTuc();
        SearchPage.cleanInpSearch();
    }
    @Test
    public void TC009_NhapMotChuCai() {
        Log.info("Đang chạy TC009: Nhập 1 chữ cái");
        SearchPage = new SearchPage(driver);
        commonBase = new commonBase(driver);
        SearchPage.inputAndSearch("a");
        SearchPage.KiemTraSoLuongTinTuc(12);
        SearchPage.cleanInpSearch();
    }
    @Test
    public void TC010_NhapChuoiKyTu(){
        Log.info("Đang chạy TC010: Nhập chuỗi kí tự");
        SearchPage = new SearchPage(driver);
        commonBase = new commonBase(driver);
        SearchPage.inputAndSearch("nhat ban");
        SearchPage.KiemTraSoLuongTinTuc(12);
        SearchPage.cleanInpSearch();
    }
    @Test
    public void TC011_NhapTiengViet(){
        Log.info("Đang chạy TC011: Nhập tiếng việt");
        SearchPage = new SearchPage(driver);
        commonBase = new commonBase(driver);
        SearchPage.inputAndSearch("Nhật bản");
        SearchPage.KiemTraSoLuongTinTuc(12);
        SearchPage.cleanInpSearch();
    }
}
