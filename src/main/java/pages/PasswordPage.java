package pages;

import org.openqa.selenium.By;

public class PasswordPage extends BasePage {
    By passButton=By.xpath("//input[@name='password']");
    By continueButton=By.xpath("//span[text()='Продолжить']");
    public PasswordPage(){
        waitVisibleOfElement(passButton);
    }
    public VKpage typePassword(String pass) {
        waitVisibleOfElement(passButton).sendKeys(pass);
        waitVisibleOfElement(continueButton).click();
        return new VKpage();
    }
}
