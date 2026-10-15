package br.com.thalis.pages;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By removeItemButton = By.xpath("//android.widget.TextView[@text=\"Remove Item\"]");

    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Remove o item do carrinho clicando no botão "Remove Item".
     * @return CartPage
     */
    public CartPage clickRemoveItem() {
        wait.until(ExpectedConditions.elementToBeClickable(removeItemButton)).click();
        return this;
    }

    
}
