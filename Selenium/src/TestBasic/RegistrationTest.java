package TestBasic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
	private WebDriver driver;

	@Before
    public void setUp() {
        // Khởi chạy trình duyệt Chrome
        System.setProperty("webdriver.chrome.driver", "D:\\thu\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }
	
    @Test
    public void testRegistration() {
        // Mở trang đăng ký
        driver.get("http://localhost:3000/auth/register");

        // Điền thông tin đăng ký
        WebElement nameInput = driver.findElement(By.name("full_name"));
        nameInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
        nameInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
//        quantityInput.clear(); // Xóa giá trị cũ trong trường input
        nameInput.sendKeys("user"); // Nhập giá trị mới 
        nameInput.sendKeys(Keys.ENTER); 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
        emailInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
//        quantityInput.clear(); // Xóa giá trị cũ trong trường input
        emailInput.sendKeys("newuser@gmail.com"); // Nhập giá trị mới 
        emailInput.sendKeys(Keys.ENTER); 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement phoneInput = driver.findElement(By.name("phone_number"));
        phoneInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
        phoneInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
//        quantityInput.clear(); // Xóa giá trị cũ trong trường input
        phoneInput.sendKeys("0987654321"); // Nhập giá trị mới 
        phoneInput.sendKeys(Keys.ENTER); 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
        usernameInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
//        quantityInput.clear(); // Xóa giá trị cũ trong trường input
        usernameInput.sendKeys("newuser"); // Nhập giá trị mới 
        usernameInput.sendKeys(Keys.ENTER); 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
        passwordInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
//        quantityInput.clear(); // Xóa giá trị cũ trong trường input
        passwordInput.sendKeys("password123"); // Nhập giá trị mới 
        passwordInput.sendKeys(Keys.ENTER); 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement confirmPasswordInput = driver.findElement(By.name("cfpassword"));
        confirmPasswordInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
        confirmPasswordInput.sendKeys(Keys.BACK_SPACE); // Xóa giá trị đã chọn
//        quantityInput.clear(); // Xóa giá trị cũ trong trường input
        confirmPasswordInput.sendKeys("password123"); // Nhập giá trị mới 
        confirmPasswordInput.sendKeys(Keys.ENTER); 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement registerButton = driver.findElement(By.xpath("//button[@class='e-btn w-100')]"));
        registerButton.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Chọn toàn bộ nội dung trong trường input
        registerButton.click();

        // Kiểm tra xác nhận đăng ký thành công
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Đăng ký thành công.')]"));
        assert successMessage.isDisplayed();
    }
    
    @After
	public void closeBrowser() {
//		driver.quit();
		System.out.println("--ĐÓNG--");
		System.out.println("-------------Test script executed successfully.-----------");
	}
}
