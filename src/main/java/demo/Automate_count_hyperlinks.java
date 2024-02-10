package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automate_count_hyperlinks {

    WebDriver driver;
    public Automate_count_hyperlinks()
    {
        System.out.println("Constructor: Automate_count_hyperlinks");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void printHyperlink(){
    System.out.println("Start Test case: printHyperlink");
    driver.get("https://in.bookmyshow.com/explore/home/chennai");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("Total Number of Links " + allLinks.size());
        System.out.println("end Test case: testCase01");
}

    public void endTest()
    {
        System.out.println("End Test: Automate_count_hyperlinks");
        driver.close();
        driver.quit();
    }

}
