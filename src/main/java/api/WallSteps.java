package api;

import constant.ApiPathConstants;
import constant.UserIdConstant;
import io.restassured.http.ContentType;
import org.apache.hc.core5.http.HttpStatus;
import org.json.JSONObject;
import provider.ConfigProviders;
import provider.DataProviders;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class WallSteps {
    private final static File photo =
            new File(System.getProperty("user.dir") + "//src//main//resources//photo.jpg");

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
                .queryParam("message", message)
                .queryParam("attachments", attachment)
                .queryParam("access_token", ApiPathConstants.TOKEN)
                .queryParam("v", ConfigProviders.API_VERSION)
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().all();
    }

    public static String getTextFromPostByIndex(int index) {
        return given()
                .relaxedHTTPSValidation()
                .baseUri(DataProviders.API_URL)
                .basePath("/wall.get")
                .param("owner_id", UserIdConstant.UserID)
                .param("access_token", ApiPathConstants.TOKEN)
                .param("v", ConfigProviders.API_VERSION)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(HttpStatus.SC_OK).log()
                .body().extract().jsonPath().get(String.format("response.items[%d].text", index));
    }


    public static String getWallUploadServer() {
        return given()
                .relaxedHTTPSValidation()
                .baseUri(DataProviders.API_URL)
                .basePath("/photos.getWallUploadServer")
                .queryParam("owner_id", UserIdConstant.UserID)
                .queryParam("access_token", ApiPathConstants.TOKEN)
                .queryParam("v", ConfigProviders.API_VERSION)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(SC_OK)
                .extract().body().jsonPath().get("response.upload_url");
    }

    public static String postPhotoToServer(String serverForUploadPhoto) {
        return given()
                .relaxedHTTPSValidation()
                .multiPart(photo)
                .when().post(serverForUploadPhoto)
                .then().statusCode(SC_OK)
                .extract().body().asString();
    }

    public static String getIdPhotoFromServer(Object serverPhoto, Object serverId, Object serverHash) {
        return given()
                .relaxedHTTPSValidation()
                .baseUri(DataProviders.API_URL)
                .basePath("/photos.saveWallPhoto")
                .queryParam("server", serverId)
                .queryParam("photo", serverPhoto)
                .queryParam("hash", serverHash)
                .queryParam("access_token", ApiPathConstants.TOKEN)
                .queryParam("v", ConfigProviders.API_VERSION)
                .when().post()
                .then()
                .statusCode(SC_OK)
                .extract().asString();
    }

    public static void main(String[] args) {
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

        System.out.println(photoTemplate);

        createPostWithPhoto("привет, Крош!", photoTemplate);

        //  https://jsonformatter.curiousconcept.com/#
    }
}
