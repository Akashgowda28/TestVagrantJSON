package resources;

import java.util.List;

import com.google.gson.JsonObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {
	
	public String getJsonPath(JsonObject json)
	 {
		String resp = json.toString();
		 JsonPath js= new JsonPath(resp);
		return resp;
		 
	 }
	

}
