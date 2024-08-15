package BT3;

import BT1.BaseTest1;
import BT1.LocatorCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BT_Assert extends BaseTest1 {
    public void LoginCMS() {
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

    public void openCategoryPage() {
        //Click de vao màn Category
        LoginCMS();
        driver.findElement(By.xpath(LocatorCMS.menuProduct)).click();
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
    }

    public String CATEGORY_NAME = "Váy Babydoll";
    @Test
    public void addNewCategory() {
        openCategoryPage();
        driver.findElement(By.xpath(LocatorCMS.buttonAddNewCategory)).click();
        //Kiem tra hien thi header man AddNewCategory
        String checkHeaderAddNewCategoryPage = driver.findElement(By.xpath(LocatorCMS.headerAddNewCategory)).getText();
        Assert.assertEquals(checkHeaderAddNewCategoryPage, "Category Information");

        //Nhap vao cac truong trong man add new category

        driver.findElement(By.xpath(LocatorCMS.inputNameCategory)).sendKeys(CATEGORY_NAME);

        driver.findElement(By.xpath(LocatorCMS.dropdownParentCategory)).click();
        driver.findElement(By.xpath(LocatorCMS.searchParentCategory)).sendKeys("quynh");
        driver.findElement(By.xpath(LocatorCMS.selectParentCategory)).click();

        driver.findElement(By.xpath(LocatorCMS.inputOrderingNumber)).sendKeys("327");

        driver.findElement(By.xpath(LocatorCMS.dropdownTypeCategory)).click();
        driver.findElement(By.xpath(LocatorCMS.selectTypeCateGory)).click();
        //chon hình ảnh cho trường Banner và Icon
        driver.findElement(By.xpath(LocatorCMS.chooseBannerImage)).click();
        driver.findElement(By.xpath("//div[@title='z5220336240903_2ca39db85c00d221d90da8243d0c3f3f.jpg']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.chooseIconImage)).click();
        driver.findElement(By.xpath("//div[@title='cd63d3149a1472cc76afb0b005583e90.jpg']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(1);

        driver.findElement(By.xpath(LocatorCMS.inputMetaTitle)).sendKeys("Váy đẹp");
        driver.findElement(By.xpath(LocatorCMS.inputMetaDescription)).sendKeys("chất liệu lụa mát");
        sleep(2);

        driver.findElement(By.xpath(LocatorCMS.dropdownFilterAttribute)).click();
        driver.findElement(By.xpath(LocatorCMS.searchFilterAttribute)).sendKeys("size");
        driver.findElement(By.xpath(LocatorCMS.searchFilterAttribute)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCMS.dropdownFilterAttribute)).click();
        sleep(2);

        //Luu lai thong tin da nhap
        driver.findElement(By.xpath(LocatorCMS.buttonSaveCategory)).click();
        sleep(1);

        // Trở về menu Category (trang list)
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();

        //search lại category moi vua tao
        driver.findElement(By.xpath(LocatorCMS.inputSearchCategory)).sendKeys(CATEGORY_NAME);
        driver.findElement(By.xpath(LocatorCMS.inputSearchCategory)).sendKeys(Keys.ENTER);
        sleep(2);

        //Kiem tra Text của item đầu tiên cột Name dưới Table sau khi search xem đúng không
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.firstItemOnCategoryTable)).getText(), CATEGORY_NAME);
        sleep(3);
        // Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.firstItemOnCategoryTable)).isDisplayed());-Vì cột name k phải dạng hyperlink, k có thẻ a <link> nên k dùng assertTrue
    }
}

