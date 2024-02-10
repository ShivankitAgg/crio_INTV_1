package demo;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Automate_nested_frames_text extends TestCases{

    public void printFrameText() throws InterruptedException{
        System.out.println("Start Test case: printFrameText");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.xpath("//html[1]/body[1]")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("//html[1]/body[1]")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.xpath("//html[1]/body[1]")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("//html[1]/body[1]")).getText());


    }
}
