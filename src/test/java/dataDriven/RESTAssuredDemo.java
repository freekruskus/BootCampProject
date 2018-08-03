package dataDriven;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.StringContains.containsString;

public class RESTAssuredDemo {

    int year = 2017;
    String race = "f1";

    public void getURL(){
        given().that().pathParam("season", year).pathParam("race", race).when().get("http://ergast.com/api/{race}/{season}/drivers/max_verstappen/results").then().statusCode(200);
    }
    @Test
    public void getURLMax(){
        given().pathParam("season", year).pathParam("race", race).when().get("http://ergast.com/api/{race}/{season}/drivers/max_verstappen/results.json").then().body("MRData.RaceTable.driverId", containsString("max_verstappen"));
    }

    public void getURLParameter(){
        given().pathParam("season", year).pathParam("race", race).when().get("http://ergast.com/api/{race}/{season}/last/results.xml").then().statusCode(200);
    }
}
