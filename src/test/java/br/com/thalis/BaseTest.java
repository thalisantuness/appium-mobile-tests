package br.com.thalis;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.saucelabs.mydemoapp.rn");
        options.setAppActivity(".MainActivity");

        options.setCapability("appium:uiautomator2ServerLaunchTimeout", 90000);
        options.setCapability("appium:adbExecTimeout", 60000);

        // Inicializa o driver apontando para o servidor local do Appium
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        
        // Inicializa a espera explícita padrão
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Trata o botão de alerta/permissão caso apareça
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button2"))).click();
        } catch (Exception e) {
            System.out.println("Alerta de compatibilidade não apareceu ou já foi descartado.");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            // Fecha a sessão do driver
            driver.quit();
        }
    }
}
