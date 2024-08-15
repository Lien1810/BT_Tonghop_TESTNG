package BT1;

public class LocatorCMS {
    //Login CMS
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String checkboxRememberLogin = "//span[normalize-space()='Remember Me']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPW = "//a[normalize-space()='Forgot password ?']";
    public static String headerLogin = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String descriptionLogin = "//p[normalize-space()='Login to your account.']";

    //Menu
    public static String menuDashBoard = "//span[normalize-space()='Dashboard']";
    public static String menuProduct = "//span[normalize-space()='Products']";
    public static String menuCategory = "//span[normalize-space()='Category']";
    public static String headerCategoryPage = "//h1[normalize-space()='All categories']";
    //Search Category
    public static String inputSearchCategory = "//input[@id='search']";
    public static String firstItemOnCategoryTable = "//tbody/tr[1]/td[2]";
    //Add Category
    public static String buttonAddNewCategory = "//a[@class='btn btn-primary']";
    public static String headerAddNewCategory = "//h5[normalize-space()='Category Information']";
    public static String inputNameCategory = "//input[@id='name']";
    public static String dropdownParentCategory = "//button[@title='No Parent']";
    public static String searchParentCategory = "(//input[@aria-label='Search'])[1]";
    public static String selectParentCategory = "//a[@id='bs-select-1-6']/child::span[normalize-space()='-------- QuynhNN']";
    public static String inputOrderingNumber = "//input[@id='order_level']";
    public static String dropdownTypeCategory = "//button[@title='Physical']";
    public static String selectTypeCateGory = "//li[@class='selected active']";
    public static String chooseBannerImage = "(//label[@for='signinSrEmail'])[1]/following-sibling::div//div[@class='input-group']";
    public static String chooseIconImage = "(//label[@for='signinSrEmail'])[2]/following-sibling::div//div[@class='input-group']";
    public static String inputMetaTitle = "//input[@placeholder='Meta Title']";
    public static String inputMetaDescription = "//textarea[@name='meta_description']";
    public static String dropdownFilterAttribute = "(//div[@class='col-md-9'])[9]/div";
    public static String searchFilterAttribute = "//input[@aria-controls='bs-select-3']";
    public static String selectValueFilterAttribute = "//li[@class='selected active']";
    public static String buttonSaveCategory = "//button[@type='submit']";

    //Add new Product
    //Product Information
    public static String menuAddNewProduct = "//span[normalize-space()='Add New Product']";
    public static String titleNewProductPage = "//h5[normalize-space()='Add New Product']";
    public static String inputProductName = "//label[contains(normalize-space(),'Product Name')]/following-sibling::div/input";
    public static String dropdownCategoryProduct ="//label[.='Category *']/following-sibling::div/div";
    public static String inputSearchCategoryProduct = "//div[@id='category']//input";
    public static String dropdownBrand = "//button[@data-id='brand_id']";
    public static String inputSearchBrand = "//div[@class='bs-searchbox']//input[@aria-controls='bs-select-2']";
    public static String inputUnit = "//input[@name='unit']";
    public static String inputWeight = "//input[@name='weight']";
    public static String inputMinPurchaseQty = "//input[@name='min_qty']";
    public static String inputTags = "//span[@role='textbox']";
    //product image
    public static String selectGalleryImages ="//label[.='Gallery Images (600x600)']/following-sibling::div/div[@data-type='image']";
    public static String selectThumbnailImages ="//label[contains(.,'Thumbnail Image')]/following-sibling::div/div[@data-type='image']";
    //Product Videos
    public static String inputVideoProvider = "//button[@data-id='video_provider']";
    public static String inputLinkVideo = "//input[@name='video_link']";
    //Product Variation
    public static String buttonEnableColors="//div[@class='col-md-1']//span";
    public static String dropdownColors = "//button[@data-id='colors']";
    public static String  selectColor1 ="//a[@id='bs-select-4-0']";
    public static String  selectColor2 ="//a[@id='bs-select-4-1']";
    public static String  selectColor3="//a[@id='bs-select-4-2']";
    public static String dropdownAttributes = "//button[@data-id='choice_attributes']";
    public static String inputSearchAttributes="//div[@class='dropdown-menu show']//input[@aria-label='Search']";

    //Product price + stock
    public static String inputUnitPrice = "//input[@name='unit_price']";
    public static String inputDiscountRangeDate = "//input[@placeholder='Select Date']";
    public static String inputDiscount = "//input[@name='discount']";
    public static String inputQuantity = "//input[@name='current_stock']";
    public static String inputSku = "//input[@name='sku']";
    public static String inputExternalLinks = "//input[@name='external_link']";
    public static String inputExternalLinkButtonText = "//input[@name='external_link_btn']";
    //Product Description
    public static String inputDescription = "//input[@name='min_qty']";
    //PDF Specification
    public static String uploadFilePDF = "//div[@data-type='document']";
    //Button Save
    public static String buttonSavePublish ="//button[normalize-space()='Save & Publish']";
    public static String buttonSaveUnpublish ="//button[normalize-space()='Save & Publish']";






}
