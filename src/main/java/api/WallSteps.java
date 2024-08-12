package api;

import constant.ApiPathConstants;
import constant.UserIdConstant;
import constant.WallPostConstant;
import org.apache.hc.core5.http.HttpStatus;
import provider.ConfigProviders;
import provider.DataProviders;

import static io.restassured.RestAssured.given;

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
                .contentType(io.restassured.http.ContentType.JSON)
                .when().post()
                .then().statusCode(HttpStatus.SC_OK).log();
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
                .contentType(io.restassured.http.ContentType.JSON)
                .when().post()
                .then().statusCode(HttpStatus.SC_OK).log();
    }

    public static void getTextFromPost() {
        given()
                .relaxedHTTPSValidation()
                .baseUri(DataProviders.API_URL)
                .basePath("/wall.get")
                .param("owner_id", UserIdConstant.UserID)
                .param("access_token", ApiPathConstants.TOKEN)
                .param("v", ConfigProviders.API_VERSION)
                .contentType(io.restassured.http.ContentType.JSON)
                .when().get(WallPostConstant.FIRST_POST_TEXT)
                .then().statusCode(HttpStatus.SC_OK).log();
    }
}
