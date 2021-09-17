package com.gittigidiyor.test.automation.controller;

import com.gittigidiyor.test.automation.constants.ApplicationConstants;
import com.gittigidiyor.test.automation.util.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstProduct() {
        WebElement element = find(ElementUtils.ITEM_BOX_CONTAINER);
        log.info("Get First Product In My Cart");
        return element;
    }

    public String getProductsPrice(WebElement product) {
        return product.findElement(ElementUtils.PRICE_OF_ITEM).getText();
    }

    public void changeProductCount(WebElement product) {
        WebElement selectBox = product.findElement(ElementUtils.SELECTED_BOX_PRICE);
        selectBox.click();
        selectBox.findElement(ElementUtils.CHOOSE_TWO_ITEM_OF_SELECT).click();
        log.info("Product count changed. Value = 2" );
    }

    public String getProductCount(WebElement product)  {
        WebElement selectBox = product.findElement(ElementUtils.SELECTED_BOX_PRICE);
        return selectBox.getAttribute(ApplicationConstants.VALUE);
    }

    public void removeFirstItemFromBasket(WebElement product) {
        WebElement removeButton = product.findElement(ElementUtils.REMOVE_FROM_CART);
        removeButton.click();
        log.info("Remove product from cart");
    }

    public int getNumberOfProducts() {
        List<WebElement> basketProductsList = driver.findElements(ElementUtils.ITEM_BOX_CONTAINER);
        int productSize = basketProductsList.size();
        log.info("Remaining product size : " + productSize);
        return productSize;
    }


}
