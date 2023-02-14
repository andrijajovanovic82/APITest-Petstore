import Files.petstorePayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Files.petstorePayload.*;
import static io.restassured.RestAssured.given;

public class PetstoreAPI {



    @Test
    public void getInventory(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/store/inventory")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void addNewPetWithPayload() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        String response = given().log().all()
                .header("Content-Type", "application/json")
                .body(createAddNewPetBody())
                .when().post("/pet")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = new JsonPath(response);
        String petName = js.getString("name");
        String petStatus = js.getString("status");
        Assert.assertEquals(petName, "Pinky");
        Assert.assertEquals(petStatus, "sold");
    }

    @Test
    public void findPetByID() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        String response = given().log().all()
                .header("Content-Type", "application/json")
                .body(createAddNewPetBody())
                .when().post("/pet")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = new JsonPath(response);
        String petID = js.getString("id");
        System.out.println(petID);
        String response1 = given().log().all()
                .when().get("/pet/" + petID)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js1 = new JsonPath(response1);
        String petName = js1.getString("name");
        String status = js1.getString("status");

        Assert.assertEquals(petName, "Pinky");
        Assert.assertEquals(status, "sold");
    }

    @Test
    public void deletePet(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        String  response = given().log().all()
                .header("Content-Type", "application/json")
                .body(createAddNewPetBody())
                .when().post("/pet")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = new JsonPath(response);
        String petID = js.getString("id");

        given().log().all()
                .when().delete("/pet/"+ petID)
                .then().log().all()
                .assertThat().statusCode(200);

        given().log().all()
                .when().get("/pet/"+ petID)
                .then().log().all()
                .assertThat().statusCode(404);
    }

    //--------------------------------------------------------------

    @Test
    public void createUser(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .header("Content-Type", "application/json")
                .body(createUserBody())
                .when().post("/user")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void getUserByUsername(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/user/Pera")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void updateUser(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .header("Content-Type", "application/json")
                .body(updateUserBody())
                .when().put("/user/Pera")
                .then().log().all()
                .assertThat().statusCode(200);

    }

    @Test
    public void deleteUser(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().delete("/user/Pera")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void getUserAfterDelete(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/user/Pera")
                .then().log().all()
                .assertThat().statusCode(404);
    }



}
