package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automate_image_urls {

    WebDriver driver;
    public Automate_image_urls()
    {
        System.out.println("Constructor: Automate_image_urls");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void printUrl()
    {
        System.out.println("Start Test case: printUrl");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        List<WebElement> imageUrl= driver.findElements(By.xpath("//div[@class='style__WidgetContainerBody-sc-lnhrs7-4 YeNog']//img"));
        for (WebElement w: imageUrl) {
            System.out.println(w.getAttribute("src"));
        }
        System.out.println(driver.findElement(By.xpath("//h2[text()='Premieres']/ancestor::div[contains(@class,'sc-133848s-3 cZuToi')]/following-sibling::div//a[2]//div[@class='sc-133848s-2 sc-133848s-12 hxPdAO']")).getText());
        System.out.println(driver.findElement(By.xpath("//h2[text()='Premieres']/ancestor::div[contains(@class,'sc-133848s-3 cZuToi')]/following-sibling::div//a[2]//div[@class='sc-133848s-2 sc-133848s-12 hxPdAO'][2]")).getText());
    }


    public void endTest()
    {
        System.out.println("End Test: Automate_image_urls");
        driver.close();
        driver.quit();
    }
}
