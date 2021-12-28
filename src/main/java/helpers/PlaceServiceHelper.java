package helpers;

import java.io.IOException;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import model.Place;
import model.location;
import utils.configClass;

public class PlaceServiceHelper {
	
	
	private static String BASE_URL =  null;
	
	
	configClass config = new configClass();
	
	public PlaceServiceHelper() throws IOException
	{
		
		BASE_URL = config.readConfigData("baseUrl");
		
		RestAssured.baseURI = BASE_URL;
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	
	
	public Response addPlace()
	{
		location loc = new location();
		loc.setLat(32.349283);
		loc.setLng(67.23279);
		
		ArrayList list = new ArrayList();
		list.add("oooo");
		list.add("kkkk");
		
		Place place = new Place();
		place.setLocation(loc);
		place.setAccuracy(20);
		place.setName("Akshay");
		place.setPhoneNumber("3197342864");
		place.setAddress("Nanded Road, Latur");
		place.setTypes(list);
		place.setWebsite("https://akjbRSDC.com");
		place.setLanguage("English");
		
		System.out.println(place);
		
		Response res = RestAssured.given().contentType(ContentType.JSON)
				.queryParam("key", "qaclick123").log().all()
				.body(place)
				.when().post(EndPoints.ADD_PLACE)
				.then().log().all().assertThat().statusCode(200)
				.extract().response();
		
		return res;
	}
	
	public Response getPlace(String place_id)
	{
		Response res1 = RestAssured.given().contentType(ContentType.JSON)
				.queryParam("key", "qaclick123").queryParam("place_id", place_id)
				.when().get(EndPoints.GET_PLACE)
				.then().log().all().assertThat().statusCode(200)
				.extract().response();
		
		return res1;
	}
	
	public Response updatePlace(String place_id)
	{
		
		Place place = new Place();
		place.setAddress("Nath Nagar, Latur");
		place.setAdditionalProperty("key", "qaclick123");
		place.setAdditionalProperty("place_id", place_id);
		
		Response res2 = RestAssured.given().contentType(ContentType.JSON)
				.body(place)
				.when().put(EndPoints.UPDATE_PLACE)
				.then().log().all().assertThat().statusCode(200)
				.extract().response();
		return res2;
	}
	
	public Response deletePlace(String place_id)
	{
		Place place = new Place();
		
		
		
		place.setAdditionalProperty("place_id", place_id);
		
		Response res = RestAssured.given().queryParam("key", "qaclick123")
				.contentType(ContentType.JSON)
				.body(place)
				.when().delete(EndPoints.DELETE_PLACE)
				.then().log().all().extract().response();
		
		return res;
	}

	
}
