package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    By loginButton = By.xpath("//input[@id='index_email']");
    By enter = By.xpath("//span[text()='Войти']");

    public LoginPage() {
        waitVisibleOfElement(loginButton);
    }

    public PasswordPage pushLoginButton(String login) {
        waitVisibleOfElement(loginButton).sendKeys(login);
        waitVisibleOfElement(enter).click();
        return new PasswordPage();
    }
}
