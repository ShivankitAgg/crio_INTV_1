package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Automate_post_on_linkedin {
    WebDriver driver;
    public Automate_post_on_linkedin()
    {
        System.out.println("Constructor: Automate_post_on_linkedin");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void PostOnLinkedIN() throws InterruptedException {
        System.out.println("Start Test case: PostOnLinkedIN");
        driver.get("https://in.linkedin.com/");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("shivankitaggarwal@gmail.com");
        driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("ShivankitP@725");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        Thread.sleep(4000);
//        System.out.println(driver.findElement(By.xpath("(//div[@class='ember-view t-12 t-black--light t-bold mr2']/parent::div)[1]/following-sibling::div//strong")).getText());
//        System.out.println(driver.findElement(By.xpath("(//div[@class='ember-view t-12 t-black--light t-bold mr2']/parent::div)[2]/following-sibling::div//strong")).getText());
        driver.findElement(By.xpath("//div[@class='share-box-feed-entry__top-bar']//button")).click();
        driver.findElement(By.xpath("//span[@class='text-body-large-bold truncate']")).click();
        driver.findElement(By.xpath("//div[@role='radiogroup']/div//span[@class='sharing-shared-generic-list__description-double-line']")).click();
        driver.findElement(By.xpath("(//div[@class='share-box-footer__main-actions']//span[@class='artdeco-button__text'])[2]")).click();
        driver.findElement(By.xpath("(//div[@class='editor-content ql-container']/div)[1]")).sendKeys("testing purpose");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='share-box_actions']/button")).click();
    }

    public void endTest()
    {
        System.out.println("End Test: Automate_post_on_linkedin");
        driver.close();
        driver.quit();
    }
}
