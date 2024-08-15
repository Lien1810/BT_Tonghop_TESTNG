package BT4;

import BT1.BaseTest1;
import BT1.LocatorCMS;
import BT1.LoginCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AddProduct extends BaseTest1 {
    public void LoginCMS() {
        //Dang Nhap
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath(LocatorCMS.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCMS.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCMS.buttonLogin)).click();
        sleep(1);
    }

//    public void openCategoryPage() {
//        //Click de vao màn Category
//        LoginCMS();
//        driver.findElement(By.xpath(LocatorCMS.menuProduct)).click();
//        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
//    }
//
    public String CATEGORY_NAME = "Áo đẹp";
//    public void addNewCategory() {
//        openCategoryPage();
//        driver.findElement(By.xpath(LocatorCMS.buttonAddNewCategory)).click();
//        //Kiem tra hien thi header man AddNewCategory
//        String checkHeaderAddNewCategoryPage = driver.findElement(By.xpath(LocatorCMS.headerAddNewCategory)).getText();
//        Assert.assertEquals(checkHeaderAddNewCategoryPage, "Category Information");
//
//        //Nhap vao cac truong trong man add new category
//
//        driver.findElement(By.xpath(LocatorCMS.inputNameCategory)).sendKeys(CATEGORY_NAME);
//
//        driver.findElement(By.xpath(LocatorCMS.dropdownParentCategory)).click();
//        driver.findElement(By.xpath(LocatorCMS.searchParentCategory)).sendKeys("quynh");
//        driver.findElement(By.xpath(LocatorCMS.selectParentCategory)).click();
//
//        driver.findElement(By.xpath(LocatorCMS.inputOrderingNumber)).sendKeys("002");
//
//        driver.findElement(By.xpath(LocatorCMS.dropdownTypeCategory)).click();
//        driver.findElement(By.xpath(LocatorCMS.selectTypeCateGory)).click();
//        //chon hình ảnh cho trường Banner và Icon
//        driver.findElement(By.xpath(LocatorCMS.chooseBannerImage)).click();
//        driver.findElement(By.xpath("//div[@title='aoThun1.jpg']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
//        sleep(1);
//
//        //Luu lai thong tin da nhap
//        driver.findElement(By.xpath(LocatorCMS.buttonSaveCategory)).click();
//        sleep(1);
//
//        // Trở về menu Category (trang list)
//        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
//
//        //search lại category moi vua tao
//        driver.findElement(By.xpath(LocatorCMS.inputSearchCategory)).sendKeys(CATEGORY_NAME);
//        driver.findElement(By.xpath(LocatorCMS.inputSearchCategory)).sendKeys(Keys.ENTER);
//        sleep(2);
//    }

    @Test
    public void addNewProduct() throws AWTException {
        LoginCMS();
//        addNewCategory();
        driver.findElement(By.xpath(LocatorCMS.menuProduct)).click();
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
        driver.findElement(By.xpath(LocatorCMS.menuAddNewProduct)).click();

        //Nhap data vao man
        driver.findElement(By.xpath(LocatorCMS.inputProductName)).sendKeys("Áo 2 dây");

        driver.findElement(By.xpath(LocatorCMS.dropdownCategoryProduct)).click();
        driver.findElement(By.xpath(LocatorCMS.inputSearchCategoryProduct)).sendKeys(CATEGORY_NAME);
        driver.findElement(By.xpath(LocatorCMS.inputSearchCategoryProduct)).sendKeys(Keys.ENTER);
        sleep(2);

        driver.findElement(By.xpath(LocatorCMS.inputUnit)).sendKeys("VNĐ");

        WebElement inputField = driver.findElement(By.xpath(LocatorCMS.inputMinPurchaseQty));
        inputField.clear();//xoa gia tri mac dinh ban dau cua trg
        inputField.sendKeys("200");
        sleep(1);

        //Tạo  3 trường Tags
        /*Cách 1: Tạo bthg
        driver.findElement(By.xpath(LocatorCMS.inputTags)).sendKeys("S");
        driver.findElement(By.xpath(LocatorCMS.inputTags)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCMS.inputTags)).sendKeys("M");
        driver.findElement(By.xpath(LocatorCMS.inputTags)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCMS.inputTags)).sendKeys("L");
        driver.findElement(By.xpath(LocatorCMS.inputTags)).sendKeys(Keys.ENTER);
        sleep(1); */
        //Cách 2 sử dụng Robot Class
        driver.findElement(By.xpath(LocatorCMS.inputTags)).click();
        Robot robot = new Robot();
        robot.setAutoDelay(100); // phải có delay, nếu k có delay kQ là s, sm , sml
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Cuon chuot sd Action Class
        WebElement element1 = driver.findElement(By.xpath(LocatorCMS.dropdownAttributes));
        Actions actions = new Actions(driver);
        actions.scrollToElement(element1).perform();
        sleep(1);

        driver.findElement(By.xpath(LocatorCMS.buttonEnableColors)).click();
        sleep(1);

        String COLOR_NAME = "3 items selected"; //Sử dụng biến toàn cục
        driver.findElement(By.xpath(LocatorCMS.dropdownColors)).click();
        driver.findElement(By.xpath(LocatorCMS.selectColor3)).click();
        driver.findElement(By.xpath(LocatorCMS.selectColor1)).click();
        driver.findElement(By.xpath(LocatorCMS.selectColor2)).click();
        driver.findElement(By.xpath(LocatorCMS.dropdownColors)).click();
        sleep(1);
        //Kiem tra Text của item sau khi chọn xem đúng không
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.dropdownColors)).getText(),COLOR_NAME);
        sleep(3);

        driver.findElement(By.xpath(LocatorCMS.inputUnitPrice)).sendKeys("100");
        driver.findElement(By.xpath(LocatorCMS.inputDiscount)).sendKeys("10%");
        sleep(1);
        //driver.findElement(By.xpath(LocatorCMS.inputQuantity)).sendKeys("10"); // khi chọn màu color thì trường Quatity bị mất đi

       //Cuon chuot xuong cuoi man de click nút Save & Publish
        WebElement element2 = driver.findElement(By.xpath(LocatorCMS.buttonSavePublish));
        actions.scrollToElement(element2).perform();
        sleep(2);
        driver.findElement(By.xpath(LocatorCMS.buttonSavePublish)).click();
    }
}
