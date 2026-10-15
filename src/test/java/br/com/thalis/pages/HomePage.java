package br.com.thalis.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By storeItem = AppiumBy.accessibilityId("store item");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Clica em um item da loja e navega para a tela de detalhes do produto.
     * @return ProductDetailPage
     */
    public ProductDetailPage clickStoreItem() {
        wait.until(ExpectedConditions.elementToBeClickable(storeItem)).click();
        return new ProductDetailPage(driver);
    }
}
