package common;

//import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import common.Log;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
    //    public static void main(String[] args) throws Exception{
//        System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir") + File.separator + "geckordriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//        Thread.sleep(2000);
//    }
    private WebDriver driver;
    static String driverPath ="src/main/resources/driver/";
    public static String BaseURl ="https://jvnet.vn/";
    protected int DEFAULT_TIMEOUT = 180000;
    protected int WAIT_INTERVAL = 1000;
    public int loopCount = 0;
    public final int ACTION_REPEAT = 5;
    public Actions action;
    //@BeforeTest
   // @Parameters({"browserType","appURL"})
    public void initTestBaseSetup(String browserType, String appURL){
        try{
            setDriver(browserType,appURL);

        }catch (Exception e){
            System.out.println("Error..."+ e.getStackTrace());
        }

    }
    public WebDriver getDriver(){
        return driver;
    }
    private void setDriver(String browserType, String appURL){
        switch (browserType.trim().toLowerCase()) {
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL);
        }
    }

    private static WebDriver initFirefoxDriver(String appURL){
        System.out.println("Launching Firefox....");
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    private static WebDriver initChromeDriver(String appURL){
        Log.info("Launching Chrome....");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
       // chromeOptions.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
//    public void waitForPageLoaded(WebDriver driver) {
//        ExpectedCondition<Boolean> expectation = driver1 -> ((JavascriptExecutor) driver1)
//                .executeScript("return document.readyState").toString()
//                .equals("complete");
//
//        try {
//            Thread.sleep(1000);
//            WebDriverWait wait = new WebDriverWait(driver, (DEFAULT_TIMEOUT/1000));
//            wait.until(expectation);
//        } catch (Throwable error) {
//            Assert.fail("Timeout khi cho trang web hoan thanh load");
//        }
//    }
}
