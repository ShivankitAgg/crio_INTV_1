package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Automate_imdb_ratings extends TestCases {

    public void imdb_ratings() throws InterruptedException {
        System.out.println("Start Test case: imdb_ratings");
        driver.get("https://www.imdb.com/chart/top");

        Select select = new Select(driver.findElement(By.xpath("//select[@id='sort-by-selector']")));
        select.selectByVisibleText("IMDb rating");
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("(//ul//h3[@class='ipc-title__text'])[1]")).getText());
        System.out.println(driver.findElements(By.xpath("//ul//h3[@class='ipc-title__text']")).size());
        select.selectByVisibleText("Release date");
        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("(//ul//h3[@class='ipc-title__text'])[1]")).getText());
        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("(//ul//h3[@class='ipc-title__text'])[1]")).getText());
        select.selectByVisibleText("Number of ratings");
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("(//ul//h3[@class='ipc-title__text'])[1]")).getText());

    }
}
