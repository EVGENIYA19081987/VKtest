package page;

import org.openqa.selenium.By;

public class VKpage extends BasePage {

    By profileButton = By.xpath("//span[text()='My profile']");

    public VKpage() {
        waitVisibleOfElement(profileButton);
    }

    public UserProfilePage clickToMyProfileButton() {
        waitVisibleOfElement(profileButton).click();
        return new UserProfilePage();
    }
}
