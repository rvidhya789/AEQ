package com.pages.inventoryPage;

import com.pages.basePage.BasePage;
import com.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage {

    private WebDriver driver;
    WaitUtils waitUtils;
    public InventoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    @FindBy(xpath = "//button[text()=\"ADD TO CART\"]")
    WebElement addToCartBtns;

    @FindBy(xpath = ".//div[@id='shopping_cart_container']/a/span")
    WebElement cartCounter;

    @FindBy(xpath = ".//div[@id='inventory_filter_container']/div")
    WebElement productsLabel;

    List<WebElement> addToCartBtnsList;

    public boolean userOnInventoryPage(){
    return driver.getCurrentUrl().contains("inventory");
    }

    public void addItemsToCart(){
        addToCartBtnsList = driver.findElements(By.xpath("//button[text()=\"ADD TO CART\"]"));
        for(WebElement btn : addToCartBtnsList){
            waitUtils.getElementAfterShortWait(btn).click();
        }
    }

    public boolean validateCartCount(){
        int cartSize = Integer.parseInt(cartCounter.getText());
        return addToCartBtnsList.size() == cartSize;
    }

    public boolean addeditemsNotInCart(){
        int cartSize = Integer.parseInt(cartCounter.getText());
        return cartSize < addToCartBtnsList.size();
    }

    public long elementsNotVisibleAFterQuickLoad(){
        waitUtils.getElementAfterLongWait(productsLabel).isDisplayed();
        return System.currentTimeMillis();
    }


}
