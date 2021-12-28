package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.PlaceServiceHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddPlace {
	
	PlaceServiceHelper per;
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		per = new PlaceServiceHelper();
	}
	
	
	
	@Test
	public void test_AddPlace()
	{
		
		Response takeResponse = per.addPlace();
		
		JsonPath js = new JsonPath(takeResponse.asString());
		
		System.out.println(js.getString("place_id"));
	}

}
