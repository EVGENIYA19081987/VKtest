package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import providers.ConfigProviders;

import java.time.Duration;

import static drivers.HeadDriver.getDriver;

public abstract class BasePage {
    public static WebDriverWait getExplicityWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigProviders.EXPLICITY_WAIT));
    }

    public static WebElement waitVisibleOfElement(By element) {
        return getExplicityWait().until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}

