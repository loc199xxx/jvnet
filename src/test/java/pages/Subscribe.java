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
    private By inpHoVaTen =By.xpath("//form[@class='wpcf7-form init']//input[@placeholder='Họ và Tên']");
    private By inpDiaChi =By.xpath("//form[@class='wpcf7-form init']//input[@placeholder='Địa chỉ']");
    private By inpSDT =By.xpath("//form[@class='wpcf7-form init']//input[@placeholder='Số điện thoại']");
    private By inpEmail =By.xpath("//form[@class='wpcf7-form init']//input[@placeholder='Email']");
    private By inpNamSinh =By.xpath("//form[@class='wpcf7-form init']//input[@placeholder='Năm sinh']");
    private By dropGioiTinh =By.xpath("//div[@id='wpcf7-f12-o2']//select[@name='menu-749']");
    private By valueNam =By.xpath("///div[@id='wpcf7-f12-o2']//select[@name='menu-749']//child::option[@value='Nam')]");
    private By valueNu =By.xpath("///div[@id='wpcf7-f12-o2']//select[@name='menu-749']//child::option[@value='Nữ')]");


    private By dropBietQua =By.xpath("//form[@class='wpcf7-form init']//input[@placeholder='Họ và Tên']");
    private By inpGhiChu =By.xpath("//form[@class='wpcf7-form init']//input[@placeholder='Họ và Tên']");
    private By btnSubmitDangky =By.xpath("///form[@class='wpcf7-form init']//input[@value='Đăng ký']");

    public void ChooseGioiTinh(String gioitinh){
        commonBase.clickElement(btnSubscribe);
        Select dropGT = new Select(driver.findElement(dropGioiTinh));
        dropGT.selectByValue(gioitinh);
    }
    public void ChoosebietQua(String bietqua){
        commonBase.clickElement(btnSubscribe);
        Select dropGT = new Select(driver.findElement(dropGioiTinh));
        dropGT.selectByValue(bietqua);
    }
    public void inputInforamtion(String Hoten, String diachi,String sdt,String email,String namsinh,String gioitinh,String bietqua, String ghichu){
        commonBase.setText(inpHoVaTen,Hoten);
        commonBase.setText(inpDiaChi,diachi);
        commonBase.setText(inpSDT,sdt);
        commonBase.setText(inpEmail,email);
        commonBase.setText(inpNamSinh,namsinh);
        ChooseGioiTinh(gioitinh);
        ChoosebietQua(bietqua);
        commonBase.setText(inpGhiChu,ghichu);

    }
}
