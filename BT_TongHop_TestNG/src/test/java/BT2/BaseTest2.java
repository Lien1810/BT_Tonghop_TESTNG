package BT2;

import BT1.LocatorCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest2 {
    WebDriver driver;
    public void sleep(Integer secord){
        try {
            Thread.sleep((long)(1000*secord));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @BeforeSuite
    public void createBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void createBrowser(String browserName) {
        if (driver.toString().toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (driver.toString().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }
        if (driver.toString().toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeTest
    public void Login() {
        //Dang Nhap
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath(LocatorCMS.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCMS.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCMS.buttonLogin)).click();
        sleep(1);

        //Check xem co o dung man Dashboard khong?
        boolean checkDaskBoard = driver.findElement(By.xpath(LocatorCMS.menuDashBoard)).isDisplayed();
        Assert.assertTrue(checkDaskBoard);
    }
    @AfterSuite
    public void closeBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
