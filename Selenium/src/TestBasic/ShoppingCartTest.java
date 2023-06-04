package TestBasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartTest{
	    private WebDriver driver;
	    public ShoppingCartTest() {
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
	    
	    public void TangSanPham()
	    {
	    	WebElement quantityInput = driver.findElement(By.xpath("//input[@id='quantity-0']"));
	    	quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
	    	quantityInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
//	        quantityInput.clear(); // Xóa giá trị cũ trong trường input
	        quantityInput.sendKeys("10"); // Nhập giá trị mới là "2"
	        quantityInput.sendKeys(Keys.ENTER); // Nhấn phím Enter để xác nhận số lượng
	     // Tạm dừng thực thi 10000ms (10s)
	        try {
	            Thread.sleep(10000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    }
	    public void GiamSanPham()
	    {
	    	// Tìm và nhấp vào nút giảm số lượng sản phẩm
	        WebElement decreaseButton = driver.findElement(By.xpath("//input[@id='quantity-0']"));
//	        decreaseButton.click();
	        decreaseButton.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
	        decreaseButton.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
//	        quantityInput.clear(); // Xóa giá trị cũ trong trường input
	        decreaseButton.sendKeys("2"); // Nhập giá trị mới là "2"
	        decreaseButton.sendKeys(Keys.ENTER); 
	    }
	    public void tearDown() {
	// Đóng trình duyệt
//	        driver.quit();
			System.out.println("--ĐÓNG--");
			System.out.println("-------------Test script executed successfully.-----------");
	    }

	    public static void main(String[] args) {
	    	ShoppingCartTest navigateToProductPage = new ShoppingCartTest();
	    	navigateToProductPage.login("adminaccount","Adminaccount1");
	    	navigateToProductPage.ProductPage();
	    	navigateToProductPage.addProduct(2);
	    	navigateToProductPage.TangSanPham();
	    	navigateToProductPage.GiamSanPham();
	    	navigateToProductPage.tearDown();
	}
}
