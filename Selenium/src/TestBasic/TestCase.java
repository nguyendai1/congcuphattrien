/**
 * 
 */
package TestBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author daing
 *
 */
public class TestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Cai\\Eclipse\\Selenium\\chromedriver.exe");
		String url = "https://www.selenium.dev/";
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
	}

}
