package TestBasic;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;


public class NavigateToProductPage extends Login{
    private WebDriver driver;
    public NavigateToProductPage() {
        // Khởi tạo đường dẫn tới thư mục chứa ChromeDriver
        String driverPath = "D:\\\\thu\\\\Selenium\\\\chromedriver.exe";
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
    public void ProductPage() {
        // Chuyển đến trang sản phẩm
        WebElement productMenu = driver.findElement(By.xpath("//ul[@id='menu_test']//a[text()='SẢN PHẨM']"));
        productMenu.click();
    }

    public void addProduct(int quantity) {
        // Thêm sản phẩm vào giỏ hàng
        for (int i = 0; i < quantity; i++) {
            // Thêm sản phẩm vào giỏ hàng
            WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='right-shared-text-more']//i[1]"));
            addToCartButton.click();
            
            // Đợi một khoảng thời gian trước khi thêm sản phẩm tiếp theo (nếu cần)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void xoa1SP() {
    	WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='cart-product-remove']"));
        addToCartButton.click();
    }
    
    // xóa nhiều sản phẩm 
    public void xoanSP() {
    	WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='right-right-share-top-delete']"));
        addToCartButton.click();
        // chọn xác nhận xóa nhiều
        WebElement addToCartbutton = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled swal2-default-outline']"));
        addToCartbutton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void tearDown() {
        // Đóng trình duyệt
//        driver.quit();
		System.out.println("--ĐÓNG--");
		System.out.println("-------------Test script executed successfully.-----------");
    }


    public static void main(String[] args) {
        NavigateToProductPage navigateToProductPage = new NavigateToProductPage();
    	navigateToProductPage.login("adminaccount","Adminaccount1");
    	navigateToProductPage.ProductPage();
    	// thêm sản phẩm
    	navigateToProductPage.addProduct(3);
    	// xóa 1 sản phẩm
//    	navigateToProductPage.xoa1SP();
    	// xóa nhiều sản phẩn
    	navigateToProductPage.xoanSP();
    	navigateToProductPage.tearDown();

    }
}
