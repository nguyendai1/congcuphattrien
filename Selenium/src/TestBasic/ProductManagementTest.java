package TestBasic;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductManagementTest {
	private WebDriver driver;
    
    public ProductManagementTest() {
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
    
	public void CheckProduct(){
        WebElement Check = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[1]"));
        Check.click();
        
        WebElement CheckProduct = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[2]//a[3]"));
        CheckProduct.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void MoreProduct() {
    	WebElement linkElement = driver.findElement(By.cssSelector("a[href='/products/create/admin']"));
    	linkElement.click();
    	try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	//chọn ảnh
    	WebElement divElement = driver.findElement(By.id("anh_test"));
    	WebElement inputElement = divElement.findElement(By.id("formFileSm"));
    	inputElement.sendKeys("D:\\Ki6\\TTCN\\btl\\Duck_King_MilkTea\\Duck_King_MilkTea\\public\\images\\3_003d1af42d474d3e9b9412555e8f4f70_1024x1024.png");
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	//Nhập tên
    	WebElement nameInput = driver.findElement(By.name("name"));
    	nameInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
    	nameInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
    	nameInput.sendKeys("Trà sữa matcha25"); // Nhập giá trị mới 
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	//nhập giá
    	WebElement priceInput = driver.findElement(By.name("price"));
    	priceInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
    	priceInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
    	priceInput.sendKeys("65000"); // Nhập giá trị mới 
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	//Nhập thể loại
    	WebElement categoryInput = driver.findElement(By.name("category"));
    	categoryInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
    	categoryInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
    	categoryInput.sendKeys("Trà sữa"); // Nhập giá trị mới 
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	//Nhập mô tả
    	WebElement descriptionInput = driver.findElement(By.name("description"));
    	descriptionInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
    	descriptionInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
    	descriptionInput.sendKeys("Ngon mát"); // Nhập giá trị mới 
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	//Tạo
    	WebElement buttonElement = driver.findElement(By.id("tao_test"));
    	buttonElement.click();
    	
    	WebElement buttonElement1 = driver.findElement(By.xpath("//div[@class='swal2-actions']//button[1]"));
        buttonElement1.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void functionProduct() {
    	WebElement Check = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[1]"));
        Check.click();
        
        WebElement CheckProduct = driver.findElement(By.xpath("//div[@id='adminQL_test']//div[2]//a[3]"));
        CheckProduct.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    	WebElement tableElement = driver.findElement(By.xpath("//td[@id='chucnang_test']//i[2]"));
    	tableElement.click();
    	try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	WebElement buttonElement = driver.findElement(By.xpath("//div[@class='swal2-actions']//button[3]"));
        buttonElement.click();
    }
    
    public static void main(String[] args) {
    	ProductManagementTest ProductManagementTest = new ProductManagementTest();
    	ProductManagementTest.login("adminaccount","Adminaccount1");
    	ProductManagementTest.CheckProduct();
//   	ProductManagementTest.MoreProduct();
   	ProductManagementTest.functionProduct();
    }
}
