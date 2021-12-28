package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.PlaceServiceHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Place;

public class GetPlace {
	
	
	PlaceServiceHelper helper;
	
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		helper = new PlaceServiceHelper();
	}
	
	
	@Test
	public void test_GETPlace()
	{
		Response res = helper.getPlace("e4de42c4edefbfdeb2cf053bdf448cd1");
		
		JsonPath js = new JsonPath(res.asString());
		
	//	Assert.assertEquals(js.getString("address"), "Nanded Road, Latur");
		
		
	}

}
