package br.com.thalis.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    private final By cartBadge = AppiumBy.accessibilityId("cart badge");

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Clica no ícone do carrinho no cabeçalho (NavBar) e navega para a tela do carrinho.
     * @return CartPage
     */
    public CartPage clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBadge)).click();
        return new CartPage(driver);
    }
}
