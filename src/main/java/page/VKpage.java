package page;

import org.openqa.selenium.By;

public class VKpage extends BasePage {

    By profile = By.xpath("//span[text()='My profile']");
    By wallPost = By.xpath("//div[text()='Привет, Крош']/..");

    public VKpage() {
        waitVisibleOfElement(profile);
    }

    public VKpage getProfile(){
        waitVisibleOfElement(profile).click();
        return this;
    }

    public String getTextFromPost() {
        return waitVisibleOfElement(wallPost).getText();
    }

    public boolean isVisible() {
        return waitVisibleOfElement(wallPost).isDisplayed();
    }
}
