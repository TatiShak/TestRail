import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class TESTAPI {
//        @Test
//        public void loginWithValidCredentials() {
//            given()
//                    .param("username", "valid_username")
//                    .param("password", "valid_password")
//                    .when()
//                    .post("https://login.railinc.com/login")
//                    .then()
//                    .statusCode(200)
//                    .body("status", equalTo("success"))
//                    .body("message", equalTo("Login successful"));
//        }

        @Test
        public void loginWithInvalidCredentials() {
            String credentials = "{\"username\":\"invalid_username\",\"password\":\"invalid_password\"}";
            given()
                    .contentType(ContentType.JSON)
                    .body(credentials)
                    .when()
                    .post("https://login.railinc.com/api/v1/authn")
                    .then()
                    .statusCode(401)
                    .body("errorSummary", equalTo("Authentication failed"));
        }

        @Test
        public void loginWithMissingCredentials() {
            String credentials = "{\"username\":\"\",\"password\":\"\"}";
            given()
                    .contentType(ContentType.JSON)
                    .body(credentials)
                    .when()
                    .post("https://login.railinc.com/api/v1/authn")
                    .then()
                    .statusCode(400)
                    .body("errorCauses[0].errorSummary", equalTo("The 'username' and 'password' attributes are required in this context."));
        }

    }
