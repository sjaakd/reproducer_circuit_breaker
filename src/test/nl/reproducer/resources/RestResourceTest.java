package nl.reproducer.resources;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class RestResourceTest {

    @Test
    public void registerTransaction() {

        given()
            .when()
            .post( "/reproduce" )
            .then()
            .statusCode( 500 );

        given()
            .when()
            .body( "test" )
            .post( "/reproduce" )
            .then()
            .statusCode( 200 );

    }

}