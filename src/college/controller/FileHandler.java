package college.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

import college.model.Country;
import college.model.GradeAux;

public class FileHandler {
	
	public GradeAux loadUserFromJSONGson(String jsonString) {
		Gson gson = new Gson();
		   
		  try {
		  
		   System.out.println("Reading JSON from a file");
		   System.out.println("----------------------------");
		   
		   BufferedReader br = new BufferedReader(
		     new FileReader("E:file.json"));
		   
		    //convert the json string back to object
		   Country countryObj = gson.fromJson(br, Country.class);
		   
		   System.out.println("Name Of Country: "+countryObj.getName());
		 
		   
		   System.out.println("Population: "+countryObj.getPopulation());
		 
		   System.out.println("States are :");
		   
		   List listOfStates = countryObj.getListOfStates();
		   for (int i = 0; i < listOfStates.size(); i++) {
		    System.out.println(listOfStates.get(i));
		   }
		  
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	}
}
