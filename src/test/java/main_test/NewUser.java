package main_test;

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
                .typePassword(DataProviders.PASSWORD);
        Assert.assertTrue(user.isDisplayed());
        Assert.assertEquals(user.getTextFromPost(), StringHelper.TEXT);
    }
}
