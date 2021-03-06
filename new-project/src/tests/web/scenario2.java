package tests.web;

import org.openqa.selenium.By;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class scenario2 {
	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        
        //open ebay
        driver.get("https://ebay.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String text = "macbook";
        
        //Click Input Text
        driver.findElement(By.id("gh-ac")).click();
        //driver.findElement(By.className("gh-tb")).click();
        //driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("gh-ac")).clear();
        driver.findElement(By.id("gh-ac")).sendKeys(text);
        Thread.sleep(2000);
        
        //Select Category
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")));
        Thread.sleep(1000);
        select.selectByVisibleText("Computers/Tablets & Networking");
        driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")).click();
        Thread.sleep(2000);
        
        //Click Button Search
        driver.findElement(By.className("gh-spr")).click();
        Thread.sleep(5000);
        
        //Verify that the page loads completely 
        try {
        	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        	System.out.print("Page Loaded Successfully!");
        } catch (UnsupportedCommandException e) {
        	System.out.print("Page Failed to Loaded!");
        }
        
        //Verify that the first result name matches with the search string.
        String getString = driver.findElement(By.xpath("id(\"srp-river-results\")/ul[@class=\"srp-results srp-list clearfix\"]/li[@class=\"s-item s-item__pl-on-bottom s-item--watch-at-corner\"]/div[@class=\"s-item__wrapper clearfix\"]/div[@class=\"s-item__info clearfix\"]/a[@class=\"s-item__link\"]/h3[@class=\"s-item__title\"]/span[@class=\"BOLD\"]")).getText();
        System.out.println('\n'+getString.toLowerCase());
        if(getString.toLowerCase().contains(text)){
        	System.out.println("Text is Matched");
        }else{
        	System.out.println("Text is not Matched");
        }

        Thread.sleep(5000);
        
        driver.quit();
    }
}
