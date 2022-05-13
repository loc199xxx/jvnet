package common;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import common.Log;

public class TestListener implements ITestListener{
    @Override
    public void onFinish(ITestContext result) {
        Log.info("Kết thúc quá trình AutoTest");
    } // ghi log khi ket thuc

    @Override
    public void onStart(ITestContext result) {
        Log.info("Bắt đầu thực hiện quá trình AutoTest");
    } //ghi log khi bat dau

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("=======> TEST CASE: " + result.getName()+" FAIL");   // Ghi lai test case fail

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("=======> TEST CASE: " + result.getName()+" SKIP");       // Ghi lai test case bo qua

    }
    @Override
    public void onTestStart(ITestResult result) {
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("=======> TEST CASE: " + result.getName()+" PASS");
    } // Ghi lai test case Pass
}
