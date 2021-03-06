package eu.specsolutions.bddcourse.geekpizza.api_tests.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import eu.specsolutions.bddcourse.geekpizza.dto.LoginRequestDto;
import eu.specsolutions.bddcourse.geekpizza.dto.RegisterRequestDto;
import eu.specsolutions.bddcourse.geekpizza.api_tests.support.WebApiContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationStepDefinitions {

    private HttpStatus registerResult;

    @Autowired
    private WebApiContext webApiContext;

    @Given("there is a user registered with user name {string} and password {string}")
    public void thereIsAUserRegisteredWithUserNameFordAndPassword(String userName, String password) {

        //TODO: the code duplication will be eliminated in a later exercise

        RegisterRequestDto registerRequestDto = new RegisterRequestDto(userName, password, password);
        HttpStatus result = webApiContext.executePost("/api/user", registerRequestDto);
        assertEquals(HttpStatus.OK, result);
    }

    @When("the client attempts to register with user name {string} and password {string}")
    public void theClientAttemptsToRegisterWithUserNameAndPassword(String userName, String password) {

        RegisterRequestDto registerRequestDto = new RegisterRequestDto(userName, password, password);
        registerResult = webApiContext.executePost("/api/user", registerRequestDto);
    }

    @Then("the registration should be successful")
    public void theRegistrationShouldBeSuccessful() {
        assertEquals(HttpStatus.OK, registerResult);
    }
}
