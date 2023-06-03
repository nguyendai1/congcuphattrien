package TestBasic;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserManagement {
    private WebDriver driver;
    
    public UserManagement() {
        // Khởi tạo đường dẫn tới thư mục chứa ChromeDriver
        String driverPath = "D:\\thu\\Selenium\\chromedriver.exe";
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

        // Nhập thông tin đăng nhập
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='Dang_Nhap']"));
        loginButton.click();
    }
    @Test
    
	public void CheckUser(){
        WebElement Check = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[1]"));
        Check.click();
        
        WebElement CheckUser = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[2]//a[1]"));
        CheckUser.click();
    }
        
    public void DeleteUser(){
        //xóa
        WebElement tableElement = driver.findElement(By.xpath("//td[@id='user_test']//i[2]"));
        tableElement.click();
        
        WebElement buttonElement = driver.findElement(By.xpath("//div[@class='swal2-actions']//button[3]"));
        buttonElement.click();
    }
        
    //xem đơn hàng
    public void ViewOrders() {
        WebElement buttonElement1 = driver.findElement(By.xpath("//td[@id='xemdonhang1_test']//a[1]//i[1]"));
        buttonElement1.click();
    }
    //sửa
    public void FixUser() {
//   	WebElement tableElement = driver.findElement(By.id("user_test"));
//      WebElement tdElement = tableElement.findElement(By.id("sua_test"));
//      tdElement.click();
        WebElement tableElement = driver.findElement(By.xpath("//td[@id='user_test']//i[1]"));
        tableElement.click();
   
	}
	
    
	@After

    public void tearDown() {
	// Đóng trình duyệt
//  driver.quit();
	System.out.println("--ĐÓNG--");
	System.out.println("-------------Test script executed successfully.-----------");
}


public static void main(String[] args) {
	UserManagement UserManagementTest = new UserManagement();
	UserManagementTest.login("adminaccount","Adminaccount1");
	UserManagementTest.CheckUser();
//	UserManagementTest.DeleteUser();
	UserManagementTest.ViewOrders();
//	UserManagementTest.FixUser();
	UserManagementTest.tearDown();
}
}
