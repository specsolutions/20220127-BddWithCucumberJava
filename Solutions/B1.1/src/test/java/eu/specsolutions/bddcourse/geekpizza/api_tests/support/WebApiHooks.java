package eu.specsolutions.bddcourse.geekpizza.api_tests.support;

import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// configure Spring Boot to start the app on a random port
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebApiHooks {

    @Autowired
    private WebApiContext webApiContext;

    @Before("@webapi")
    public void InitWebApi(){
        // initialization moved to WebApiContext constructor
        // here we just make sure that the WebApiContext was initialized
        assertNotNull(webApiContext);
    }
}
