package Laba6;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static Laba6.Utils.driver;


public class TestingLaba {
    List<WebElement> prices;
    List<String> sortedPrices;


    @BeforeMethod
    public void setUp() {
        Utils.instantiate();
    }


    @Test(testName = "Test1")
    public void Test1() throws InterruptedException {
        driver.get("https://pn.com.ua/ct/1003/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[5]/div[2]/span/a")).click();
        Thread.sleep(1000);
        List<WebElement> List = driver.findElements(By.xpath("//div[@id='column-center']/section/div[3]"));
        List<WebElement> ListElement = new ArrayList<>();
        for(int i = 0; i < List.size();i++ ){
            if(List.get(i).getText().contains("Acer"));
            ListElement.add(List.get(i));
            Assert.assertEquals(List.size(),ListElement.size());
        }
        Thread.sleep(2000);
    }

    @Test(testName = "Test2")
    public void Test2() throws InterruptedException {
        driver.get("https://pn.com.ua/ct/1003/");
        Thread.sleep(1000);
        String field = driver.findElement(By.xpath("//div[5]/div[2]/span/a/small")).getText();
        Assert.assertTrue(field.contains(field));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[5]/div[2]/span/a")).click();
        Thread.sleep(1000);
        String field2 = driver.findElement(By.xpath("//b")).getText();
        Assert.assertTrue(field2.contains(field2));
        Thread.sleep(1000);

    }


    @Test(testName = "Test3")
    public void Test3() throws InterruptedException {
        driver.get("https://pn.com.ua/ct/1003/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@onclick='event.preventDefault()'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@onclick='event.preventDefault()'])[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='column-center']/section/div/div/a")).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("compare"));
        Thread.sleep(1000);
        Assert.assertEquals(2,2);
        Thread.sleep(1000);
    }

    @Test(testName = "Test4")
    public void Test4() throws InterruptedException {
        driver.get("https://pn.com.ua/ct/1003/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='column-center']/section/div[2]/ul/li[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Цена от дешевых')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='column-center']/section/div[2]/ul/li[2]/a")).isDisplayed();
        Thread.sleep(1000);
        prices = driver.findElements(By.xpath("//span[contains(.,'Цена, грн')]"));
        sortedPrices = new ArrayList<>();
        for(int i = 0; i < prices.size(); i++){
            prices.get(i).getText().replace("грн","");
            System.out.println(prices.get(i).getText().replace("грн",""));
            sortedPrices.add(String.format(prices.get(i).getText().replaceAll("Цена,грн","")));
        }
            }



    @Test(testName = "Test5")
    public void Test5() throws InterruptedException {
        driver.get("https://pn.com.ua/ct/1003/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='column-center']/section/div[3]/article/div[2]/div[3]/span[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@onclick='event.preventDefault()'])[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@onclick='event.preventDefault()'])[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@onclick='event.preventDefault()'])[8]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href, '/compare/1003/')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href, '/compare/delete-all/1003/')]")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.getCurrentUrl();
        Thread.sleep(1000);
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}