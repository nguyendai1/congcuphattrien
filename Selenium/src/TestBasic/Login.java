package TestBasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	private WebDriver driver;
	
	public Login() {
        // Khởi tạo đường dẫn tới thư mục chứa ChromeDriver
        String driverPath = "D:\\thu\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Khởi tạo WebDriver
        driver = new ChromeDriver();
    }
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
 
	// đóng trình duyệt
    public void tearDown() {
	System.out.println("--ĐÓNG--");
	System.out.println("-------------Test script executed successfully.-----------");
}
	
    public static void main(String[] args) {
		Login lg = new Login();
		lg.login("adminaccount","Adminaccount1");
	}
}
