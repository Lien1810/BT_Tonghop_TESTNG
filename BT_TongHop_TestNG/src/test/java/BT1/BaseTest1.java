package BT1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.time.Duration;

public class BaseTest1 {
    public WebDriver driver;
    public void sleep(Integer secord){
        try {
            Thread.sleep((long)(1000*secord));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void useRobot(){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
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
    @AfterMethod
    public void closeBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
