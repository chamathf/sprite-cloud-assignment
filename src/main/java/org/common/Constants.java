package org.common;

public class Constants {


    public static final String APP_URL = System.getProperty("app.url" ,"https://www.saucedemo.com/");
    public static final String USER_NAME=System.getProperty("User.name" ,"standard_user");
    public static final String PASSWORD= System.getProperty("account.password","secret_sauce");
    public static final String PRODUCT_NAME_1 = System.getProperty("product.item1","Sauce Labs Backpack");
    public static final String PRODUCT_NAME_2 = System.getProperty("product.item2","Sauce Labs Bike Light");
    public static final String PRODUCT_NAME_3 = System.getProperty("product.item3","Sauce Labs Fleece Jacket");

    public static final String FIRST_NAME=System.getProperty("first.name" ,"Chamath");

    public static final String LAST_NAME=System.getProperty("lasst.name" ,"Fernando");
    public static final String ZIP_CODE= System.getProperty("zip.code","12500");

    public static final String PAYMENT_INFORMATION
            = System.getProperty("payment.information","SauceCard #31337");
    public static final String SHIPPING_INFORMATION= System.getProperty("shipping.information","Free Pony Express Delivery!");
    public static final String ITEM_TOTAL= System.getProperty("item.total","Total: $97.17");
    public static final String TAX= System.getProperty("tax","Tax: $7.20");
    public static final String TOTAL= System.getProperty("total","Total: $97.17");
    public static final String SUCCESS_MESSAGE= System.getProperty("success.message","Thank you for your order!");

    public static final String FILTER_TYPE= System.getProperty("filter.dropdown","Name (Z to A)");

    public static final String INVALID_USER_NAME= System.getProperty("invalid.username","Test123");

    public static final String INVALID_PASSWORD= System.getProperty("invalid.password","Test123");

    public static final String LOGIN_ERROR_MESSAGE= System.getProperty("error.message","Epic sadface: Username and password do not match any user in this service");


}
