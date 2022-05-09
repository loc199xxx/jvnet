package pages;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.commonBase;
public class Subscribe {
    private WebDriver driver = null;   //khai bao driver
    private commonBase commonBase;
    public Subscribe(WebDriver driver){
        this.driver=driver;
        commonBase = new commonBase(this.driver);
    }

    private By btnSubscribe = By.xpath("//span[@class='btn-toggle-register dk_btn']");
    private By titleFormSub= By.xpath("//h4[contains(text(),'Vui lòng điền đầy đủ thông tin vào mẫu bên dưới!')]");
    private By inpHoVaTen =By.xpath("//div[@id='wpcf7-f12-o2']//input[@placeholder='Họ và Tên']");
    private By inpDiaChi =By.xpath("//div[@id='wpcf7-f12-o2']//input[@placeholder='Địa chỉ']");
    private By inpSDT =By.xpath("//div[@id='wpcf7-f12-o2']//input[@placeholder='Số điện thoại']");
    private By inpEmail =By.xpath("//div[@id='wpcf7-f12-o2']//input[@placeholder='Email']");
    private By inpNamSinh =By.xpath("//div[@id='wpcf7-f12-o2']//input[@placeholder='Năm sinh']");
    private By dropGioiTinh =By.xpath("//div[@id='wpcf7-f12-o2']//select[@name='menu-749']");



    private By dropBietQua =By.xpath("//div[@id='wpcf7-f12-o2']//select[@name='menu-991']");
    private By inpGhiChu =By.xpath("//div[@id='wpcf7-f12-o2']//textarea[@placeholder='Ghi chú']");
    private By btnSubmitDangky =By.xpath("//div[@id='wpcf7-f12-o2']//input[@value='Đăng ký']");


    public void ChooseGioiTinh(String gioitinh){
        Select dropGT = new Select(driver.findElement(dropGioiTinh));
        dropGT.selectByValue(gioitinh);
    }
    public void ChoosebietQua(String bietqua){

        Select dropGT = new Select(driver.findElement(dropBietQua));
        dropGT.selectByValue(bietqua);
    }
    public void inputInforamtion(String Hoten, String diachi,String sdt,String email,String namsinh,String gioitinh,String bietqua, String ghichu){
        commonBase.clickElement(btnSubscribe);
        commonBase.setText(inpHoVaTen,Hoten);
        commonBase.setText(inpDiaChi,diachi);
        commonBase.setText(inpSDT,sdt);
        commonBase.setText(inpEmail,email);
        commonBase.setText(inpNamSinh,namsinh);
        ChooseGioiTinh(gioitinh);
        ChoosebietQua(bietqua);
        commonBase.setText(inpGhiChu,ghichu);
    }
    public void clickSubmit(){
        commonBase.clickElement(btnSubmitDangky);
    }
    public void notifError(String text){
        commonBase.verifyElementDisplay(By.xpath("//span[contains(text(),\""+text+"\")]"));
    }
}
