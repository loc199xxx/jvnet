package pages;

import common.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.commonBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DashBoardPage {
    private WebDriver driver = null;   //khai bao driver
    private commonBase commonBase;
    private By btnGioiThieu = By.xpath("//*[@class=\"nav-top-link\"][contains(text(),\"Đơn Hàng Đi Nhật\")]");
    private By btnDonHangDiNhat =By.xpath("//*[@class=\"nav-top-link\"][contains(text(),\"Ưu Đãi\")]");
    private By btnUuDai = By.xpath("//*[@class=\"nav-top-link\"][contains(text(),\"Ưu Đãi\")]");
    private By btnTinTuc = By.xpath("//*[@class=\"nav-top-link\"][contains(text(),\"Tin Tức – Sự Kiện\")]");
    private By btnQA = By.xpath("//*[@class=\"nav-top-link\"][contains(text(),\"Hỏi & Đáp\")]");
    private By btnLienHe = By.xpath("//*[@class=\"nav-top-link\"][contains(text(),\"Liên Hệ\")]");
// Cac element locator search




    public DashBoardPage(WebDriver driver){
        this.driver=driver;
        commonBase = new commonBase(this.driver);

    }
    public String getHomePageTitle(){
        commonBase.waitForPageLoaded();
        String pageTitle = driver.getTitle();
        return pageTitle;
    }



    public boolean verifyListElementExist(By[] list) {
        for (int i = 0; list.length > i; i++) {
            try{
                commonBase.verifyElementDisplay(list[i]);
             }catch (Exception e){
                Log.error("Element trong danh sach ko dc hien thi");
                return false;
            }
        }
        return true;
    }
    public boolean checkElementsHomePage(){
        By[] list = {btnDonHangDiNhat,btnQA,btnLienHe,btnUuDai,btnTinTuc,btnGioiThieu};
        try {
            if (verifyListElementExist(list)==true){
                return true;
            }else{
                return false;
            }
        } catch (Exception e){
            Log.error("Trang khong hien thi day du cac element");
            return false;
        }
    }

}
