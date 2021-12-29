package VelSir;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.common.value.qual.ArrayLenRange;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.accessibility.AccessibleEditableText;
import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Demoqa implements Operation {
WebDriver driver;
    @Override
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://demoqa.com/");
//        WebElement addClose = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M0,0l15,0l')]"));
//        addClose.click();
        WebElement addFrame = driver.findElement(By.xpath("//img[@title='Ad.Plus Advertising']//parent::a"));
        addFrame.click();
    }

    @Override
    public void getAllLinks() throws InterruptedException {
        List<WebElement>linkList = driver.findElements(By.xpath("//a"));
        for (int l = 1; l < linkList.size(); l++) {
            System.out.println("links"+l+"  "+linkList.get(l).getAttribute("href"));}
        driver.navigate().to("https://demoqa.com/links");

        }

    @Override
    public void confirmDialogBox() {
        driver.navigate().to("https://demoqa.com/alerts");

        //1st
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
            }

    @Override
    public void cancelDialogBox() {
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Override
    public void getLinkCount() {
        List<WebElement>taskLink = driver.findElements(By.xpath("//p/child::a"));
        for (int i = 0; i < taskLink.size() ; i++) {
            System.out.println("LinkCount"+taskLink.size());
    }}

    @Override
    public void getListItem() {
     driver.navigate().to("https://demoqa.com/sortable");
     List<WebElement>list=driver.findElements(By.xpath("//div[@class='vertical-list-container mt-4']/child::div"));
     int getListItem = list.size();
        System.out.println("List of item" +getListItem);
    }

    @Override
    public void isChecked() {
          driver.navigate().to("https://demoqa.com/checkbox");
          WebElement checkBox = driver.findElement(By.xpath("//span[@class='rct-checkbox']//child::*[name()='svg']"));


    }

    @Override
    public void closeBrowser() {
    driver.quit();
    }
}
