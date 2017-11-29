package college.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import college.model.Employee;

public class FileHandler {

	public String readFile(String filename)
	{
		byte[] encoded = null;
		String path = getClass().getResource("/files/" + filename + ".json").getPath();
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(encoded);
	}
	
	public JsonArray getJsonArr(String type) {
		String content = readFile(type);
		
		JsonParser jsonParser = new JsonParser();
		JsonObject jo = (JsonObject)jsonParser.parse(content);
		return jo.getAsJsonArray(type);
	}

	public List<Employee> parseEmployeeJson() {
		JsonArray jsonArr = getJsonArr("employee");

		List<Employee> list = new ArrayList<Employee>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Employee>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		
		return list;
	}
}
