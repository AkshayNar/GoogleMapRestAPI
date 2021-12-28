package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.PlaceServiceHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeletePlace {
	
	
	PlaceServiceHelper plc;
	
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		plc = new PlaceServiceHelper();
	}
	
	@Test
	public void test_deletePlace()
	{
		Response res = plc.deletePlace("5bac4f8e2b0de4de4e75047b1278c047");
		
		JsonPath js = new JsonPath(res.asString());
		
	
	}

}
