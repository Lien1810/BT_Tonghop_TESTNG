package BT2;

import BT1.LocatorCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCateGory extends BaseTest2 {
    String CATEGORY_NAME = "Chuột không dây 5";

    @Test(priority = 1)
    public void gotoCategory() {
        driver.findElement(By.xpath(LocatorCMS.menuProduct)).click();
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
    }

    @Test(priority = 2)
    public void checkHeaderCategoryPage() {
        String checkHeaderCategoryPage = driver.findElement(By.xpath(LocatorCMS.headerCategoryPage)).getText();
        Assert.assertEquals(checkHeaderCategoryPage, "All categories");
    }

    @Test(priority = 3)
    public void checkColorButtonAddNewCategoryPage() {
        String cssValue = driver.findElement(By.xpath(LocatorCMS.buttonAddNewCategory)).getCssValue("background-color");
        System.out.println(cssValue);
    }

    @Test(priority = 4)
    public void gotoAddNewCategoryPage() {
        driver.findElement(By.xpath(LocatorCMS.buttonAddNewCategory)).click();
    }

    @Test(priority = 5)
    public void checkHeaderNewCategoryPage() {
        String checkHeaderAddNewCategoryPage = driver.findElement(By.xpath(LocatorCMS.headerAddNewCategory)).getText();
        Assert.assertEquals(checkHeaderAddNewCategoryPage, "Category Information");
    }

    @Test(priority = 6)
    //Kiem tra hien thi header man AddNewCategory
    public void addCategory() {
        //Nhap vao cac truong trong man add new category
        driver.findElement(By.xpath(LocatorCMS.inputNameCategory)).sendKeys(CATEGORY_NAME);

        driver.findElement(By.xpath(LocatorCMS.dropdownParentCategory)).click();
        driver.findElement(By.xpath(LocatorCMS.searchParentCategory)).sendKeys("quynh");
        driver.findElement(By.xpath(LocatorCMS.selectParentCategory)).click();

        driver.findElement(By.xpath(LocatorCMS.inputOrderingNumber)).sendKeys("0038374");

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

        driver.findElement(By.xpath(LocatorCMS.inputMetaTitle)).sendKeys("Gì cũng có");
        driver.findElement(By.xpath(LocatorCMS.inputMetaDescription)).sendKeys("Chuột không dây thế hệ mới");
        sleep(2);

        driver.findElement(By.xpath(LocatorCMS.dropdownFilterAttribute)).click();
        driver.findElement(By.xpath(LocatorCMS.searchFilterAttribute)).sendKeys("size");
        driver.findElement(By.xpath(LocatorCMS.searchFilterAttribute)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCMS.dropdownFilterAttribute)).click();
        sleep(2);

        //Luu lai thong tin da nhap
        driver.findElement(By.xpath(LocatorCMS.buttonSaveCategory)).click();
    }

    @Test(priority = 7)
    public void researchCategory() {
        // Trở về menu Category (trang list)
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();

        //search lại category moi vua tao
        driver.findElement(By.xpath(LocatorCMS.inputSearchCategory)).sendKeys(CATEGORY_NAME);
        driver.findElement(By.xpath(LocatorCMS.inputSearchCategory)).sendKeys(Keys.ENTER);
        sleep(2);
    }

    @Test(priority = 8)
    public void recheckNameFirstItemCategory() {
        //Kiem tra Text của item đầu tiên cột Name dưới Table sau khi search xem đúng không
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.firstItemOnCategoryTable)).getText(), CATEGORY_NAME);
        sleep(3);
    }
}

