package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.commonBase;

public class DashBoardPage {
    private WebDriver driver = null;   //khai bao driver
    private commonBase commonBase;
    private By btnGioiThieu = By.xpath("//*[@class=\"nav-top-link\"][contains(text(),\"Giới thiệu\")]");
    private By btnDonHangDiNhat = By.xpath("//*[@class=\"nav-top-link\"][contains(text(),\"Đơn Hàng Đi Nhật\")]");
    private By btnUuDai = By.id("filter_upcoming");
    private By btnTinTuc = By.id("filters_labels");
    private By btnQA = By.xpath("//button[@aria-label='Add Project']");
    private By btnLienHe = By.id("list_holder");
// Cac element locator search
    private By inpSearch = By.id("input-searchcs");
    private By btnSearch = By.id("searchsubmit");


    public DashBoardPage(WebDriver driver){
        this.driver=driver;
        commonBase = new commonBase(this.driver);

    }
    public String geHomePageTitle(){
        commonBase.waitForPageLoaded();
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public void inputAndSearch(String text){
        commonBase.waitForPageLoaded();
        commonBase.setText(inpSearch,text);
        commonBase.clickElement(btnSearch);
    }


}
