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

    public void clearText(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).clear();
    }

    public void setText(By element, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(value);
    }
    public void clickElement(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
    }
    public void  verifyElementDisplay(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public boolean verifyUrl(String url)
    {
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);

        return driver.getCurrentUrl().contains(url); //True/False
    }
    public boolean verifyElementText(By element, String textValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText().equals(textValue); //True/False
    }

    public boolean verifyElementExist(By element){
        //Tạo list lưu tất cả đối tượng WebElement
        List<WebElement> listElement = driver.findElements(element);
        int total = listElement.size();
        if(total > 0){
            return true;
        }
        return false;
    }
    public int countElement(By element){
        int count = 0;
        List<WebElement> listElement = driver.findElements(element);
        for (int i = 0; i < listElement.size(); i++){
            count++;
        }
        return count;
    }
    public boolean verifyPageLoaded(String pageLoadedText) {
        waitForPageLoaded();
        Boolean res = false;

        List<WebElement> elementList = driver.findElements(By.xpath("//*[contains(text(),'" + pageLoadedText + "')]"));
        if (elementList.size() > 0) {
            res = true;
            System.out.println("Page loaded (" + res + "): " + pageLoadedText);
        } else {
            res = false;
            System.out.println("Page loaded (" + res + "): " + pageLoadedText);
        }
        return res;
    }
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
