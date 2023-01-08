package TestVagrant.codingAssignment;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CodingTest {

	public static void main(String[] args) throws Exception {

		// Creating object of jsonParser class to parse data from json file
		JSONParser jParser = new JSONParser();

		// Loading json file in file reader
		FileReader reader = new FileReader(".\\JsonData\\Players.json");

		// Passing json data through jsonParser object
		Object obj = jParser.parse(reader);

		// Convert java object into json object
		JSONObject playersobj = (JSONObject) obj;

		// Extracting array players from json data
		JSONArray arr = (JSONArray) playersobj.get("player");

		// country count
		int countryCount = 0;

		// wicket keeper count
		int wkCount = 0;

		for (int i = 0; i < arr.size(); i++) {

			// Extracting country and role for each player from json file
			JSONObject players = (JSONObject) arr.get(i);
			String country = (String) players.get("country");
			String role = (String) players.get("role");

			// Applying condition to count number of Foreign country
			if (!country.equals("India")) {
				countryCount = countryCount + 1;
			}

			// Applying condition to count number of wicket keeper in team
			if (role.equals("Wicket-keeper")) {
				wkCount = wkCount + 1;
			}

		}

		// Applying condition to validate Foreign country count
		if (countryCount == 4) {
			System.out.println("Test case is passed as team has only " + countryCount + " foreign players.");
		}

		else {
			System.out.println("Test case is failed.");
		}

		// Applying condition to validate wicket keeper count
		if (wkCount >= 1) {
			System.out.println("Test case is passed as team has " + wkCount + " Wicket-keeper.");
		}

		else {
			System.out.println("Test case is failed.");
		}
	}

}
