package pages;

import org.openqa.selenium.By;

public class VKpage extends BasePage{

    By profile = By.xpath("//span[text()='My profile']");
    By wallPost = By.xpath("//div[text()='Привет, Крош']/..");

    public VKpage() {
        waitVisibleOfElement(profile);
    }

    public String getTextFromPost() {
        return waitVisibleOfElement(wallPost).getText();
    }

    public boolean isDisplayed() {
    return waitVisibleOfElement(wallPost).isDisplayed();
}}
