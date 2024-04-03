package utils;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;

public class JsonFileManager {

    // Variables
    String jsonFilePath;
    String jsonReader;


    public JsonFileManager(String jsonFilePath){
        this.jsonFilePath = jsonFilePath;
        try{
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(jsonFilePath));
            jsonReader = jsonObject.toJSONString();
        }
        catch (IOException | ParseException e){
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Get the test data from a json file after being converted to sting file
     * @param jsonKey -> is the path inside the json file objects
     * @return String Value of the Key provided from the user
     */
    public String getTestData(String jsonKey){
        String testData = "";
        try {
            testData = JsonPath.read(jsonReader, jsonKey);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
            Assert.fail("No value found that represent key value : " + jsonKey + " in file path : " + jsonFilePath);
        }
        return testData;
    }
}
