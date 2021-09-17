package com.gittigidiyor.test.automation.util;

import org.openqa.selenium.By;

public class ElementUtils {
    //Login page params
    public static By LOGIN_PAGE_USERNAME = By.id("L-UserNameField");
    public static By LOGIN_PAGE_PASSWORD = By.id("L-PasswordField");
    public static By LOGIN_BUTTON = By.id("gg-login-enter");

    //Search bar params
    public static By SEARCH_BAR = By.xpath("//input[@data-cy='header-search-input']");
    public static By SEARCH_BUTTON = By.xpath("//button[@data-cy='search-find-button']");

    //Product params
    public static By PRODUCT_LIST = By.xpath("//div[@data-testid='content']");
    public static By PRODUCT_CARD_ITEM = By.xpath("//article[@data-cy= 'product-card-item']");
    public static By PRODUCT_PRICE = By.xpath("//span[@data-cy='buy-price']");
    public static By ADD_TO_CART = By.id("add-to-basket");

    //Cart params
    public static By ITEM_BOX_CONTAINER = By.className("product-item-box-container");
    public static By PRICE_OF_ITEM = By.className("total-price");
    public static By SELECTED_BOX_PRICE = By.xpath("//select[@class='amount']");
    public static By CHOOSE_TWO_ITEM_OF_SELECT = By.xpath("//option[@value='2']");
    public static By REMOVE_FROM_CART = By.className("btn-delete");

}
