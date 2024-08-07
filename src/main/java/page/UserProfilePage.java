package page;

import org.openqa.selenium.By;

import static page.BasePage.waitVisibleOfElement;

public class UserProfilePage {
    By userPhoto = By.xpath("//img[@alt='User photo']");
    By firstPostAtPage = By.xpath("(//div[@class='wall_post_text'])[1]");

    public UserProfilePage() {
        waitVisibleOfElement(userPhoto);
    }

    public String getTextFromPost() {
        return waitVisibleOfElement(firstPostAtPage).getText();
    }
}
