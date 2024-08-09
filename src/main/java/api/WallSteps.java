package api;

import constant.ApiPathConstants;
import constant.UserIdConstant;
import constant.WallPostConstant;
import dev.failsafe.internal.util.Assert;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import provider.ConfigProviders;
import provider.DataProviders;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class WallSteps {

    public static void createPost(String message) {
        given()
                .relaxedHTTPSValidation()  // для решения проблемы с сертификатами (HTTPS)
                .baseUri(DataProviders.API_URL)
                .basePath("/wall.post")
                .param("owner_id", UserIdConstant.UserID)
                .param("message", message)
                .param("access_token", ApiPathConstants.TOKEN)
                .param("v", ConfigProviders.API_VERSION)
                .contentType(ContentType.JSON)
                .when().post()
                .then().statusCode(SC_OK).log();
    }

    public static void createPostWithPhoto(String message, String attachment) {
        given()
                .relaxedHTTPSValidation()
                .baseUri(DataProviders.API_URL)
                .basePath("/wall.post")
                .param("owner_id", UserIdConstant.UserID)
                .param("message", message)
                .param("attachment", attachment)
                .param("access_token", ApiPathConstants.TOKEN)
                .param("v", ConfigProviders.API_VERSION)
                .contentType(ContentType.JSON)
                .when().post()
                .then().statusCode(SC_OK).log();
    }

    public static void getTextFromPost() {
        given()
                .relaxedHTTPSValidation()
                .baseUri(DataProviders.API_URL)
                .basePath("/wall.get")
                .param("owner_id", UserIdConstant.UserID)
                .param("access_token", ApiPathConstants.TOKEN)
                .param("v", ConfigProviders.API_VERSION)
                .contentType(ContentType.JSON)
                .when().get(WallPostConstant.FIRST_POST_TEXT)
                .then().statusCode(SC_OK).log();
    }

}
