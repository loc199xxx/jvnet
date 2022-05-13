package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class commonBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private int timeoutWaitForPageLoaded = 30;

    public commonBase(WebDriver _driver){
        driver = _driver;
        wait = new WebDriverWait(driver,10);
    }
    // ham clean text
    public void clearText(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).clear();
    }
    // ham nhap text
    public void setText(By element, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(value);
    }
    // ham clean text va nhap text
    public void cleanAndSetText(By element, String value){

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }
    // ham click vao doi tuong
    public void clickElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    // Ham kiem tra phan tu da hien thi
    public void  verifyElementDisplay(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    // Ham kiem tra phan tu khong hien thi
    public void  verifyElementNotDisplay(By element){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
    // Ham kiem tra phan tu xuat hien
    public boolean verifyElementExist(By element){
        //Tạo list lưu tất cả đối tượng WebElement
        List<WebElement> listElement = driver.findElements(element);
        int total = listElement.size();
        if(total > 0){
            return true;
        }
        return false;
    }
    // ham dem so luong phan tu
    public int countElement(By element){
        int count = 0;
        List<WebElement> listElement = driver.findElements(element);
        for (int i = 0; i < listElement.size(); i++){
            count++;
        }
        return count;
    }

    // Ham tro cho Website load xong
    public void waitForPageLoaded(){

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        try {
            wait = new WebDriverWait(driver, timeoutWaitForPageLoaded);
            wait.until(jsLoad);
        } catch (Throwable error) {
            Assert.fail("Quá thời gian load trang.");
        }
    }
}
