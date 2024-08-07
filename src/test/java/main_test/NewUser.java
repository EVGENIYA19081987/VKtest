package main_test;
//1) Залогининться под логином и паролем, написанным выше.
//2) Перейти в свой профиль.
//3) Получить текст из последнего опубликованного поста на стене
import base_test.SetDriverTest;
import helper.StringHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.VKpage;
import provider.DataProviders;

public class NewUser extends SetDriverTest {
    @Test
    public void test() {

        VKpage user = new LoginPage()
                .pushLoginButton(DataProviders.LOGIN)
                .typePassword(DataProviders.PASSWORD)
                .getProfile();
        Assert.assertTrue(user.isVisible());
        Assert.assertEquals(user.getTextFromPost(), StringHelper.TEXT);
    }

}
