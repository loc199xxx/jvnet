package pages;

import common.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.commonBase;
import org.testng.Assert;

public class SearchPage {
    private WebDriver driver = null;   //khai bao driver
    private commonBase commonBase;
    private By inpSearch = By.id("input-searchcs");
    private By btnSearch = By.id("searchsubmit");
    private By tintuc = By.xpath("//*[@class=\"block-card__dh result_search colums-block_posts col-md-6 mb-4\"]");
    private By nothingFound = By.xpath("//*[contains(text(),\"Nothing Found\")]");


    public SearchPage(WebDriver driver){
        this.driver=driver;
        commonBase = new commonBase(this.driver);
    }
    // nhap va search
    public void inputAndSearch(String text){
        commonBase.waitForPageLoaded();
        commonBase.setText(inpSearch,text);
        commonBase.clickElement(btnSearch);
    }

    public void clickSearch(){
        commonBase.clickElement(btnSearch);
    }
    public void KhongCoTinTuc(){
        commonBase.verifyElementDisplay(nothingFound);
    }
    // kiem tra so luong tin tuc
    public void KiemTraSoLuongTinTuc(int soluong){
        Assert.assertEquals(commonBase.countElement(tintuc),soluong);
    }
    // clean search input
    public void cleanInpSearch(){
        commonBase.clearText(inpSearch);
    }
}
