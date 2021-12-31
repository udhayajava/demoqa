package VelSir;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.common.value.qual.ArrayLenRange;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class Demoqa implements Operation {
    WebDriver driver;

    @Override
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://demoqa.com/");

    }

    @Override
    public void getAllLinks() throws InterruptedException {
        List<WebElement> linkList = driver.findElements(By.xpath("//a"));
        for (int l = 1; l < linkList.size(); l++) {
            System.out.println("links" + l + "  " + linkList.get(l).getAttribute("href"));
        }

    }

    @Override
    public void confirmDialogBox() {
        driver.navigate().to("https://demoqa.com/alerts");
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
    public void dialogBox() {
        driver.navigate().to("https://demoqa.com/modal-dialogs");
        WebElement smallModalDialogBox = driver.findElement(By.xpath("" +
                "//div[@id='modalWrapper']/div/child::button[@id='showSmallModal']"));
        smallModalDialogBox.getText();
        smallModalDialogBox.click();
        System.out.println("small dialog box appears");
        driver.findElement(By.xpath(
                "//div[@class='modal-footer']//child::button[@id='closeSmallModal']")).click();
        System.out.println("closed small dialogBox successfully");
        System.out.println("------------------------------------------------------");
        WebElement largeBox = driver.findElement(By.xpath("" +
                "//div[@id='modalWrapper']/div/child::button[@id='showLargeModal']"));
        largeBox.click();
        System.out.println("Large dialogBox appear");
        driver.findElement(By.xpath("" +
                "//div[@class='modal-footer']//child::button[@id='closeLargeModal']")).click();
        System.out.println("Closed large dialogBox");
        System.out.println("--------------------------------------------------------");

    }

    @Override
    public void getLinkCount() {
        driver.navigate().to("https://demoqa.com/links");
        List<WebElement> taskLink = driver.findElements(By.xpath("//p/child::a"));
        int linkCount = 0;
        for (; linkCount < taskLink.size(); linkCount++) {
            System.out.println("Link------------->" + taskLink.get(linkCount).getText());
        }
        System.out.println("total number of links " + linkCount);
    }

    @Override
    public void getListItem() {
        driver.navigate().to("https://demoqa.com/sortable");
        List<WebElement> list = driver.findElements(By.xpath("" +
                "//div[@class='vertical-list-container mt-4']/child::div"));
        int getListItem = list.size();
        System.out.println("List of item -->" + getListItem);
    }

    @Override
    public void isChecked() {
        driver.navigate().to("https://demoqa.com/checkbox");
        WebElement checkBox = driver.findElement(By.xpath("" +
                "//span[@class='rct-checkbox']//child::*[name()='svg']"));
        boolean selected = checkBox.isSelected();
        {
            System.out.println("Checkbox is selected is " + selected);
        }
        WebElement checkboxClick = driver.findElement(By.xpath("" +
                "//span[@class='rct-checkbox']//child::*[name()='svg']"));
        if (checkboxClick.isSelected()) {
            System.out.println("already selected");
        } else {
            checkboxClick.click();
            System.out.println("Selected the checkbox");
        }
//        WebElement homeCheckBox = driver.findElement(By.xpath("
// button[@title='Expand all']//*[name()='svg']//*[name()='path' and contains(@d,'M19 3H5c-1')]"));
//        homeCheckBox.click();
//

    }

    @Override
    public void closeBrowser() {
        driver.quit();
    }
}
