package com.gittigidiyor.test.automation.controller;

import com.gittigidiyor.test.automation.constants.ApplicationConstants;
import com.gittigidiyor.test.automation.util.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void goToSecondPage()  {
        driver.get(ApplicationConstants.BASE_URL +"arama/?k=bilgisayar&sf=2");
    }

    public WebElement getSelectedRandomProduct() {
        WebElement productsUL = driver.findElement(ElementUtils.PRODUCT_LIST);
        List<WebElement> productList = productsUL.findElements(ElementUtils.PRODUCT_CARD_ITEM);

        Random rand = new Random();
        int randomProductNumber = rand.nextInt(productList.size() - 1);
        log.info("Product size: " + productList.size() + "- random value: " + randomProductNumber);
        return productList.get(0);
    }

    public String getSelectedProductPrice(WebElement webElement){
        String price = webElement.findElement(ElementUtils.PRODUCT_PRICE).getText();
        log.info("Selected product amount: " + price);
        return price;
    }


    public void addProductToCart(){
        click(ElementUtils.ADD_TO_CART);
        log.info("Product add to cart.");
    }

    public void goToMyCart() {
        navigate(ApplicationConstants.MY_CART_URL);
        log.info("Entried to my cart page.");
    }

}