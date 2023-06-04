package TestBasic;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xoadonhang {
    private WebDriver driver;
    public xoadonhang() {
        // Khởi tạo đường dẫn tới thư mục chứa ChromeDriver
        String driverPath = "D:\\\\thu\\\\Selenium\\\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Khởi tạo WebDriver
        driver = new ChromeDriver();
    }
    @Before
    // đăng nhập trên web
    public void login(String username, String password) {
        // load web mất ~ 3-5s
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:3000");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        // Chọn đến web đăng nhập
        driver.findElement(By.xpath("//a[@id='a_dangnhap']")).click();

        // Nhập thông tin đăng nhập
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='Dang_Nhap']"));
        loginButton.click();
       
    }

    
    // chuyển vào danh sach dơn hang xoa nháp
	public void checkdonhang(){
        WebElement Checkdonhang = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[1]"));
        Checkdonhang.click();
        
        WebElement xoaDoNhang = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[2]//a[2]"));
        xoaDoNhang.click();
        
        WebElement DSDH = driver.findElement(By.xpath("//td[@id='xoanhap_test']//i[1]"));
        DSDH.click();
        
	    WebElement clickchonxoa = driver.findElement(By.xpath("//div[@class='swal2-actions']//button[3]"));
	    clickchonxoa.click();
    
    
	}
	// khôi phục lại đơn hàng
	public void checklaihang(){
        WebElement Checkdonhang = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[1]"));
        Checkdonhang.click();
        

        
        WebElement xoaDoNhang = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[2]//a[2]"));
        xoaDoNhang.click();

        
        // chuyển vào danh sách nháp
        WebElement DSDH = driver.findElement(By.xpath("//a[@id='donhangxoa_test']"));
        DSDH.click();
        
        // khôi phục lại đơn hàng
        WebElement khoiphucnhap = driver.findElement(By.xpath("//td[@id='khophuclai_test']//i[1]"));
        khoiphucnhap.click();
	}
	
    // xoa hẳn đơn hàng
	public void checklaixoadonhang(){
        WebElement Checkdonhang = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[1]"));
        Checkdonhang.click();
        
        WebElement xoaDoNhang = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[2]//a[2]"));
        xoaDoNhang.click();
        
        // chuyển vào danh sách nháp
        WebElement DSDH = driver.findElement(By.xpath("//a[@id='donhangxoa_test']"));
        DSDH.click();

        WebElement khoiphucnhap = driver.findElement(By.xpath("//td[@id='xoakhoidr_test']//i[1]"));
        khoiphucnhap.click();

        
	    WebElement clickchonxoakhoidata = driver.findElement(By.xpath("//div[@class='swal2-actions']//button[3]"));
	    clickchonxoakhoidata.click();
	}
    
	@After

    public void tearDown() {
        // Đóng trình duyệt
//        driver.quit();
		System.out.println("--ĐÓNG--");
		System.out.println("-------------Test script executed successfully.-----------");
    }


	public static void main(String[] args) {
		xoadonhang Xoadonhang = new xoadonhang();
		Xoadonhang.login("adminaccount","Adminaccount1");
	     //chuyển vào danh sach dơn hang xoa nháp
//        Xoadonhang.checkdonhang();
		
		// khôi phục lại đơn hàng
//        Xoadonhang.checklaihang();
		
	    // xoa hẳn đơn hàng
        Xoadonhang.checklaixoadonhang();
        Xoadonhang.tearDown();
	}
}
