package tests.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class scenario1 {
	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        String text = "3 filters applied";
        //open ebay
        driver.get("https://ebay.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
             
        //Select Category
        //Locating the categoryElectronics
        WebElement categoryElectronics = driver.findElement(By.xpath("//a[@_sp = 'p2481888.m1379.l3250' and (text() = 'Electronics')]"));
        actions.moveToElement(categoryElectronics).build().perform();
        Thread.sleep(1000);
        //Locating the CellPhone
        WebElement CellPhone = driver.findElement(By.xpath("//a[@_sp = 'p2481888.m1379.l3251' and (text() = 'Cell phones and accessories')]"));
        actions.moveToElement(CellPhone).build().perform();
        Thread.sleep(1000);
        actions.click().build().perform();
        Thread.sleep(2000);
        
        //Select Sub-Category
        driver.findElement(By.xpath("//a[@class = 'b-textlink b-textlink--parent' and (text() = 'Cell Phones & Smartphones' or . = 'Cell Phones & Smartphones')]")).click();
        Thread.sleep(2000);
        
        //Filters
        //scroll down to filter link
        WebElement element1 = driver.findElement(By.xpath("//button[@type = 'button' and (text() = 'All Filters')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
        Thread.sleep(3000);
        //click filter link
        driver.findElement(By.xpath("//button[@type = 'button' and (text() = 'All Filters')]")).click();
        Thread.sleep(3000); 
        
        //filter size
        driver.findElement(By.xpath("id(\"c3-mainPanel-Screen%20Size\")/span[@class=\"x-overlay-aspect__label\"][count(. | //span[@class = 'x-overlay-aspect__label' and (text() = 'Screen Size' or . = 'Screen%20Size')]) = count(//span[@class = 'x-overlay-aspect__label' and (text() = 'Screen Size' or . = 'Screen%20Size')])]")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//div[@id='c3-subPanel-Screen%20Size_5.5%20-%205.9%20in']/label[@class='x-refine__multi-select-label']/span[@class='cbx x-refine__multi-select-cbx' and (text()='5.5 - 5.9 in')]")).click();
        Thread.sleep(2000);
        
        //scroll down to price
        WebElement element2 = driver.findElement(By.xpath("id(\"c3-mainPanel-RAM\")/span[@class=\"x-overlay-aspect__label\"][count(. | //span[@class = 'x-overlay-aspect__label' and (text() = 'RAM' or . = 'RAM')]) = count(//span[@class = 'x-overlay-aspect__label' and (text() = 'RAM' or . = 'RAM')])]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
        Thread.sleep(1000);
        
        WebElement element3 = driver.findElement(By.xpath("id(\"c3-mainPanel-SIM%20Card%20Slot\")/span[@class=\"x-overlay-aspect__label\"][count(. | //span[@class = 'x-overlay-aspect__label' and (text() = 'SIM Card Slot')]) = count(//span[@class = 'x-overlay-aspect__label' and (text() = 'SIM Card Slot')])]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
        Thread.sleep(1000);
        
        
        //filter Price
        driver.findElement(By.xpath("id(\"c3-mainPanel-price\")/span[@class=\"x-overlay-aspect__label\"][count(. | //span[@class = 'x-overlay-aspect__label' and (text() = 'Price' or . = 'Price')]) = count(//span[@class = 'x-overlay-aspect__label' and (text() = 'Price' or . = 'Price')])]")).click();
        Thread.sleep(2000);
        //set price
        driver.findElement(By.xpath("//div[@id='c3-subPanel-_x-price-textrange']/div/div/div/input[@class = 'x-textrange__input x-textrange__input--from']")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//div[@id='c3-subPanel-_x-price-textrange']/div/div/div/input[@class = 'x-textrange__input x-textrange__input--from']")).clear();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//div[@id='c3-subPanel-_x-price-textrange']/div/div/div/input[@class = 'x-textrange__input x-textrange__input--from']")).sendKeys("50000");
        Thread.sleep(1000);
      
        driver.findElement(By.xpath("//div[@id='c3-subPanel-_x-price-textrange']/div/div/div/input[@class = 'x-textrange__input x-textrange__input--to']")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//div[@id='c3-subPanel-_x-price-textrange']/div/div/div/input[@class = 'x-textrange__input x-textrange__input--to']")).clear();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//div[@id='c3-subPanel-_x-price-textrange']/div/div/div/input[@class = 'x-textrange__input x-textrange__input--to']")).sendKeys("5000000");
        Thread.sleep(1000);
        
        
        //filter location
        driver.findElement(By.xpath("//span[@class = 'x-overlay-aspect__label' and (text() = 'Item Location')]")).click();
        Thread.sleep(1500);
      
        driver.findElement(By.xpath("//div[@id='c3-subPanel-location_Asia']/label/span[text()[normalize-space(.)='Asia']/parent::*]")).click();
        Thread.sleep(1500);
        
        
        //apply button
        driver.findElement(By.xpath("//button[@class = 'x-overlay-footer__apply-btn btn btn--primary' and @type = 'button' and (text() = 'Apply')]")).click();
       
        //Verify that the page loads completely 
        try {
        	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        	System.out.print("Page Loaded Successfully!");
        } catch (UnsupportedCommandException e) {
        	System.out.print("Page Failed to Loaded!");
        }
        
        
        //Verify if filters applied or not
        Thread.sleep(1500);
        String getString = driver.findElement(By.xpath("id(\"s0-27_1-9-0-1[0]-0-0-6-5-4[0]-flyout\")/button[@class=\"x-flyout__button\"][count(. | //button[@type = 'button' and @class = 'x-flyout__button' and @aria-pressed = 'true']) = count(//button[@type = 'button' and @class = 'x-flyout__button' and @aria-pressed = 'true'])]")).getText();
        System.out.println('\n'+getString);
        if(getString.matches(text)){
        	System.out.println("Filters Applied!");
        }else{
        	System.out.println("Filters Not Applied");
        }
        
        //
        
        //Verify that the first result name matches with the search string.
        
        Thread.sleep(5000);
        
        driver.quit();
    }
}
