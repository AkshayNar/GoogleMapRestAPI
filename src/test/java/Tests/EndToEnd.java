package Tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helpers.PlaceServiceHelper;
import io.restassured.path.json.JsonPath;


public class EndToEnd {
	
	PlaceServiceHelper plc;
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		plc = new PlaceServiceHelper();
	}
	
	
	
	@Test
	public void test_AddPlace_UpdateAddress_DeletePlace()
	{
		
		String body = plc.addPlace().asString();
		
		JsonPath js = new JsonPath(body);
		
		System.out.println("Place Added");
		
		String place_id = js.getString("place_id");
		
		//Place Added
		
		
		String body1 = plc.getPlace(place_id).asString();
		
		System.out.println("Place Updated");
		
		//Place Updated
		
		
		String body2 = plc.deletePlace(place_id).asString();
		
		System.out.println("Place Deleted");
		
		//Place Deleted
		
	}
	

}
