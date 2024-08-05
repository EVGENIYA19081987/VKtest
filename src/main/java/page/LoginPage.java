package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    By loginButton = By.xpath("//input[@id='index_email']");
    By enter = By.xpath("//span[text()='Войти']");
    By passButton=By.xpath("//input[@name='password']");
    By continueButton=By.xpath("//span[text()='Продолжить']");

    public LoginPage() {
        waitVisibleOfElement(loginButton);
    }

    public LoginPage setLogin(String login) {
        waitVisibleOfElement(loginButton).sendKeys(login);
        waitVisibleOfElement(enter).click();
        return this;
    }

    public VKpage setPasswordAndNavigateToMainPage(String pass) {
        waitVisibleOfElement(passButton).sendKeys(pass);
        waitVisibleOfElement(continueButton).click();
        return new VKpage();
    }
}
