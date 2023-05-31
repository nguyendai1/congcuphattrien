package TestBasic;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	static WebDriver driver;
	 
	@Before
	public void connect() throws InterruptedException {
		// khởi chạy trình duyệt Chrome
		System.setProperty("webdriver.chrome.driver","D:\\thu\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
 
		// load web mất ~ 3-5s
				driver.manage().window().setPosition(new Point(0, 0));
				driver.manage().window().setSize(new Dimension(1024, 768));
				driver.manage().deleteAllCookies();
				driver.get("http://localhost:3000");
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
				
					// Chọn đến webdangnhap
//				driver.findElement(By.xpath("//body/div[@id='DangNhap']//a[2]")).click();
				driver.findElement(By.xpath("//a[@id='a_dangnhap']")).click();

				
				// Tìm phần tử input username
		        WebElement usernameInput = driver.findElement(By.name("username"));

		        // Nhập giá trị username
		        usernameInput.sendKeys("adminaccount");

		        // Tìm phần tử input password
		        WebElement passwordInput = driver.findElement(By.name("password"));

		        // Nhập giá trị password
		        passwordInput.sendKeys("Adminaccount1");

		        // Tìm phần tử button đăng nhập
		        WebElement loginButton = driver.findElement(By.id("Dang_Nhap"));

		        // Click vào button đăng nhập
		        loginButton.click();

		        // Kiểm tra kết quả đăng nhập thành công bằng cách kiểm tra URL hoặc phần tử hiển thị sau khi đăng nhập
		        String expectedUrl = "https://example.com/dashboard";
		        String actualUrl = driver.getCurrentUrl();
		        Assert.assertEquals(expectedUrl, actualUrl);
			}

		        // Kiểm tra điều kiện userFName
//		        if (userFName) {
//		            // Thực hiện các hành động khi userFName tồn tại
//		            // Ví dụ: Kiểm tra phần tử hiển thị dành riêng cho userFName
//		            WebElement userFNameElement = driver.findElement(By.id("userFNameElement"));
//		            Assert.assertTrue(userFNameElement.isDisplayed());
//		        }
		//
//		        // Kiểm tra điều kiện userRole
//		        if (userRole.equals("admin")) {
//		            // Thực hiện các hành động khi userRole là 'admin'
//		            // Ví dụ: Kiểm tra phần tử hiển thị dành riêng cho admin
//		            WebElement adminElement = driver.findElement(By.id("adminElement"));
//		            Assert.assertTrue(adminElement.isDisplayed());
//		        }
 
	// đóng trình duyệt
	@After
	public void closeBrowser() {
//		driver.quit();
		System.out.println("--ĐÓNG--");
		System.out.println("-------------Test script executed successfully.-----------");
	}
}
