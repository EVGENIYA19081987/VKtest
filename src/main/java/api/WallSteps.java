package api;

import constant.ApiPathConstants;
import constant.UserIdConstant;
import io.restassured.http.ContentType;
import provider.ConfigProviders;
import provider.DataProviders;

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
                .param("access_token", ApiPathConstants.PathConst)
                .param("v", ConfigProviders.API_VERSION)
                .contentType(ContentType.JSON)
                .when().post()
                .then().statusCode(SC_OK).log();
    }
}
