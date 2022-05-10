package common;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import common.Log;

public class TestListener implements ITestListener{
    @Override
    public void onFinish(ITestContext result) {
        Log.info("Kết thúc quá trình AutoTest");
    }

    @Override
    public void onStart(ITestContext result) {
        Log.info("Bắt đầu thực hiện quá trình AutoTest");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("=======> TEST CASE: " + result.getName()+" FAIL");

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("=======> TEST CASE: " + result.getName()+" SKIP");

    }
    @Override
    public void onTestStart(ITestResult result) {
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("=======> TEST CASE: " + result.getName()+" PASS");
    }
}
