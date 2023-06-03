package TestBasic;

import java.time.Duration;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuenMatKhau {
	private WebDriver driver;
    
    public QuenMatKhau() {
        // Khởi tạo đường dẫn tới thư mục chứa ChromeDriver
        String driverPath = "D:\\\\thu\\\\Selenium\\\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Khởi tạo WebDriver
        driver = new ChromeDriver();
    }
    @Before
    public void login(String username, String password) {
        // load web mất ~ 3-5s
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:3000");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        // Chọn đến web đăng nhập
        driver.findElement(By.xpath("//a[@id='a_dangnhap']")).click();
    }
    
    public void clickQMK() {
    // Tìm và nhấp vào liên kết "Quên mật khẩu"
    WebElement forgotPasswordLink = driver.findElement(By.cssSelector("a[href='/auth/forget-password']"));
    forgotPasswordLink.click();
    }
    
    public void inputEmail() {
    // Điền thông tin cần thiết trong biểu mẫu quên mật khẩu
    WebElement emailInput = driver.findElement(By.name("email")); // Đổi thành ID của trường email trên trang web của bạn
   // emailInput.sendKeys("minhgagay1@gmail.com"); // Thay đổi email thành email của bạn
    emailInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
    emailInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
//    quantityInput.clear(); // Xóa giá trị cũ trong trường input
    emailInput.sendKeys("newuser@gmail.com"); // Nhập giá trị mới
}
    
    public void sendEmail() {
    // Gửi biểu mẫu
    WebElement submitButton = driver.findElement(By.xpath("//button[@class='e-btn w-100']")); // Đổi thành xpath của nút Gửi trên trang web của bạn
    submitButton.click();
}

public void exit() {
    // Đóng trình duyệt
    driver.quit();
}
    public static void main(String[] args) {
    	QuenMatKhau QMK = new QuenMatKhau();
    	QMK.login("adminaccount","Adminaccount1");
    	QMK.clickQMK();
    	QMK.inputEmail();
    	QMK.sendEmail();
    	//QMK.exit();
//    
    }
}