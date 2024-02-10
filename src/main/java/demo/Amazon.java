package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amazon extends TestCases{

    //WebDriver driver;
//    public Amazon()
//    {
//        System.out.println("Constructor: Amazon");
//        WebDriverManager.chromedriver().timeout(30).setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }

    public void checkAmazon() throws InterruptedException {
        System.out.println("Start Test case: checkAmazon");
        driver.navigate().to("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("amazon");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='H9lube']/following-sibling::div/span")));
        Thread.sleep(8000);
        List<WebElement> amazonList = driver.findElements(By.xpath("//span[@class='H9lube']/following-sibling::div/span"));
        for (WebElement a: amazonList )
        {
            System.out.println(a.getText());
            if(a.getText().contains("Amazon"))
            {
                System.out.println("amazon is present in list");
                break;
            }
        }
    }
//
//    public void close()
//    {
//        System.out.println("End Test: TestCases");
//        driver.close();
//        driver.quit();
//    }




}
