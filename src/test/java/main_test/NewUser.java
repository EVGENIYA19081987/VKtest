package main_test;
//1) Залогининться под логином и паролем, написанным выше.
//2) Перейти в свой профиль.
//3) Получить текст из последнего опубликованного поста на стене

import api.WallSteps;
import base_test.SetDriverTest;
import constant.UserIdConstant;
import constant.WallPostConstant;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.UserProfilePage;
import provider.DataProviders;
import static api.WallSteps.*;


public class NewUser extends SetDriverTest {
    @Test
    public void test() {
        UserProfilePage userProfilePage = new LoginPage()
                .setLogin(DataProviders.LOGIN)
                .setPasswordAndNavigateToMainPage(DataProviders.PASSWORD)
                .clickToMyProfileButton();
        Assert.assertEquals(userProfilePage.getTextFromPost(), WallPostConstant.FIRST_POST_TEXT);



//        Получить текст из нового поста при помощи апи метода.
        WallSteps.getTextFromPostByIndex(3);

//        Написать комментарий к посту:
        createComment("Приветики", 550);

//        Создать пост с картинкой

        String server = getWallUploadServer();
        System.out.println(server);

        JSONObject jsonObject = new JSONObject(postPhotoToServer(server));

        String mediaId = getIdPhotoFromServer(
                jsonObject.getString("photo"),
                jsonObject.getInt("server"),
                jsonObject.getString("hash"));

        JSONObject photos = new JSONObject(mediaId);
        String photoTemplate = String.format("photo%s_%d", UserIdConstant.UserID,
                photos.getJSONArray("response").getJSONObject(0).getInt("id"));

            createPostWithPhoto("Incredible", photoTemplate);
            createCommentWithPhoto("Классный заяц",photoTemplate,550);
    }
    public static void main(String[] args) {
        //       Создать пост с текстом
        WallSteps.createPost("Юхуууу!!");
       createComment("ho ho ho",552);
    }
}

