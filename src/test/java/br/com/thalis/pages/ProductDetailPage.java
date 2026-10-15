package br.com.thalis.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BasePage {

    // Localizador da tela de Detalhes do Produto (Declarado como By)
    private final By addToCartButton = AppiumBy.accessibilityId("Add To Cart button");

    public ProductDetailPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Clica no botão Add To Cart.
     * @return ProductDetailPage (retorna a própria página permitindo encadeamento)
     */
    public ProductDetailPage clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        return this;
    }
}
