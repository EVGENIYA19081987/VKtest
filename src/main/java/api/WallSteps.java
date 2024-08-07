package api;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class WallSteps {

    public static void createPost(String message) {
        given()
                .relaxedHTTPSValidation()  // для решения проблемы с сертификатами (HTTPS)
                .baseUri("https://api.vk.com/method")
                .basePath("/wall.post")
                .param("owner_id", "673888630")
                .param("message", message)
                .param("access_token", "vk1.a.aCSSsepWHsSzphJHmKI1GayHhCK2VDoGwIk3FQfja66Y2TAxD9ufih" +
                        "454Qifa298k8UVapK8eStKcrFjdjp6su47zD4N2x_mGnbzHIVcqvUFN21ZdILooLaBQGKhefrfRkBoGgyFBvIEy" +
                        "Hg6zxdoMjdSWez4tz8_4DxnGX6tPMC-v4yi2-zuCF-zyWjGIZNjWw8B9uQU_9za9_OMWIw9Kw")
                .param("v", "5.199")
                .contentType(ContentType.JSON)
                .when().post()
                .then().statusCode(SC_OK).log();
    }
}
