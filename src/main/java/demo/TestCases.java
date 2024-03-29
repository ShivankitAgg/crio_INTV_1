package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///
public class TestCases {
    ChromeDriver driver;
//    public TestCases()
//    {
//        System.out.println("Constructor: TestCases");
//        WebDriverManager.chromedriver().timeout(30).setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void getNewWindowHandle() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equals(currentWindowHandle)) {
                driver.switchTo().window(window);
                break;
            }

        }
    }
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");
    }


}
