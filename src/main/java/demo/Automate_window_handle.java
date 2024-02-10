package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Automate_window_handle {
    WebDriver driver;

    public void getNewWindowHandle() {
        String currentwindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equals(currentwindow)) {
                driver.switchTo().window(window);
                break;
            }

        }
    }

    public static void takeScreenshot(WebDriver driver) {

            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File screenshot = scrShot.getScreenshotAs(OutputType.FILE);

        try {
            File theDir = new File("screenshots");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
            String timestamp = String.valueOf(java.time.LocalDateTime.now());
            String screenShotname = String.format("screenshot_%s.png", timestamp);

            String DestFilenName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + screenShotname;
            File destFile = new File(DestFilenName);
            Thread.sleep(5000);
            FileHandler.copy(screenshot, destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Automate_window_handle() {
        System.out.println("Constructor: Automate_window_handle");
        WebDriverManager.chromedriver().timeout(10).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void window_handling() {
        System.out.println("Start Test case: window_handling");
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        String currentwindow = driver.getWindowHandle();
        getNewWindowHandle();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        takeScreenshot(driver);
        driver.close();
        driver.switchTo().window(currentwindow);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
}
