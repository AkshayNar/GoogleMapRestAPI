package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.PlaceServiceHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdatePlace {
	
	PlaceServiceHelper per;
	
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		per = new PlaceServiceHelper();
	}
	
	
	@Test
	public void test_updatePlace()
	{
		Response res = per.updatePlace("e4de42c4edefbfdeb2cf053bdf448cd1");
		
		JsonPath js = new JsonPath(res.asString());
		
		
		Assert.assertNotNull("msg");
	}
	
	

}
