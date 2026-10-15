package br.com.thalis;

import br.com.thalis.pages.CartPage;
import br.com.thalis.pages.HomePage;
import br.com.thalis.pages.ProductDetailPage;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyDemoAppTests extends BaseTest {

    @Test
    @DisplayName("CT-01 Verificar quando adicionar um produto no carrinho com sucesso")
    public void verifyInsertProductOnCart() {
        // Arrange
        HomePage homePage = new HomePage(driver);

        // Act
        ProductDetailPage productPage = homePage.clickStoreItem();
        productPage.clickAddToCart();

        // Assert
        // Aguarda a quantidade do carrinho aparecer dentro do badge
        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//android.view.ViewGroup[@content-desc='cart badge']//android.widget.TextView")
        ));

        Assertions.assertEquals("1", quantityElement.getText());
    }

    @Test
    @DisplayName("CT-02 Verificar quando remover um item do carrinho com sucesso")
    public void verifyRemoveProductFromCart() {
        // Arrange
        HomePage homePage = new HomePage(driver);
        ProductDetailPage productPage = homePage.clickStoreItem();
        productPage.clickAddToCart();

        // Act
        CartPage cartPage = productPage.clickCart();
        cartPage.clickRemoveItem();

        // Assert
        // 1. Verifica se o texto "No Items" é apresentado na tela do carrinho
        WebElement noItemsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//android.widget.TextView[@text='No Items']")
        ));
        Assertions.assertEquals("No Items", noItemsElement.getText());

        // 2. Verifica se o número do badge na NavBar desapareceu (o que confirma que o carrinho está vazio)
        boolean isBadgeInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(
            AppiumBy.xpath("//android.view.ViewGroup[@content-desc='cart badge']//android.widget.TextView")
        ));
        Assertions.assertTrue(isBadgeInvisible);
    }
}
