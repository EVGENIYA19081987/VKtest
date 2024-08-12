package main_test;
//1) Залогининться под логином и паролем, написанным выше.
//2) Перейти в свой профиль.
//3) Получить текст из последнего опубликованного поста на стене

import api.WallSteps;
import base_test.SetDriverTest;
import constant.PhotoConstant;
import constant.WallPostConstant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.UserProfilePage;
import provider.DataProviders;

public class NewUser extends SetDriverTest {
    @Test
    public void test() {
        UserProfilePage userProfilePage = new LoginPage()
                .setLogin(DataProviders.LOGIN)
                .setPasswordAndNavigateToMainPage(DataProviders.PASSWORD)
                .clickToMyProfileButton();
        Assert.assertEquals(userProfilePage.getTextFromPost(), WallPostConstant.FIRST_POST_TEXT);

        WallSteps.createPost(WallPostConstant.FIRST_POST_TEXT);
        Assert.assertEquals(userProfilePage.getTextFromPost(), WallPostConstant.FIRST_POST_TEXT);

//        4) Создать новый пост с текстом и картинкой. (При помощи АПИ)
        WallSteps.createPostWithPhoto(WallPostConstant.FIRST_POST_TEXT, PhotoConstant.attachePhoto());

//        5) Получить текст из нового поста при помощи апи метода.
        WallSteps.getTextFromPostByIndex(0);
        int i = 0;
    }
}
