package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
public class APIsSteps {
    private String loginEndpoint;
    private Response response;
    private String token;

    @Given("the login endpoint is available")
    public void theLoginEndpointIsAvailable() {
        loginEndpoint = "https://login.railinc.com/api/login";
    }

    @When("I make a POST request to the login endpoint with invalid credentials")
    public void iMakeAPostRequestToTheLoginEndpointWithInvalidCredentials() {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("User ID", "myusername");
        credentials.put("Password", "mypassword");

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(credentials)
                .post(loginEndpoint);

        token = response.getHeader("Authorization");
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }
}
