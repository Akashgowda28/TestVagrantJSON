package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


import static org.junit.Assert.assertEquals;

import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import resources.Utils;


import resources.jsonPayLoad;

public class Validate {
	
	
	JsonObject json;
	String resp;
	boolean wicketKeeperPresent;
	
	@Given("Get The Json Of The Team")
	public void get_the_json_of_the_team(){
	    // Write code here that turns the phrase above into concrete actions
		// Code to send the Request in Json format and Store it in String 
		
		given().baseUri("").queryParam("").body(jsonPayLoad.playersJson()).toString();
		String req=jsonPayLoad.playersJson();
		String jsonString = readJsonFile(req);
		 json = new JsonParser().parse(jsonString).getAsJsonObject();
	    
	}

	private String readJsonFile(String req) {
		// TODO Auto-generated method stub
		return null;
	}

	@When("Validate the Number of Foreign Players")
	public void validate_the_number_of_foreign_players() {
	    // Write code here that turns the phrase above into concrete actions
		JsonArray players = json.get("player").getAsJsonArray();
		// Initialize count of foreign players
		int foreignPlayerCount = 0;
		// Loop through players to check for foreign players
		for (JsonElement player : players) {
		JsonObject playerObject = player.getAsJsonObject();
		String country = playerObject.get("country").getAsString();
		if (!country.equals("India")) {
		foreignPlayerCount++;
		}
		}
		// Assert that the count of foreign players is 4
		assertEquals(4, foreignPlayerCount);
		
	}

	@Then("Validation Is SuccessFull")
	public void validation_is_success_full() {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println("validation is SuccessFull");
		System.out.println("wicketKeeperPresent");
		
		
	    
	}

	@When("Validate the Atleast one wicket Keeper is present")
	public void validate_the_atleast_one_wicket_keeper_is_present() {
	    // Write code here that turns the phrase above into concrete actions
		
		
		
		// Get the player details
		
		List<String> players = js.getList("player.role");
		// Check if there is at least one wicket keeper in the list
		wicketKeeperPresent = players.stream().anyMatch(role -> role.equals("Wicket-keeper"));
		}

	   
	}


