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

import college.model.*;

public class FileHandler {

	public String readFile(String filename)
	{
		byte[] encoded = null;
		String path = getClass().getResource("/files/" + filename + ".json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try {
			encoded = Files.readAllBytes(Paths.get(osAppropriatePath));
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

	public List<Department> parseDepartmentJson() {
		JsonArray jsonArr = getJsonArr("department");

		List<Department> list = new ArrayList<Department>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Department>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);

		return list;
	}

	public List<DepartmentEmployee> parseDepartmentEmployeeJson() {
		JsonArray jsonArr = getJsonArr("departmentEmployee");

		List<DepartmentEmployee> list = new ArrayList<DepartmentEmployee>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<DepartmentEmployee>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);

		return list;
	}

	public List<Program> parseProgramJson() {
		JsonArray jsonArr = getJsonArr("program");

		List<Program> list = new ArrayList<Program>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Program>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);

		return list;
	}

	public List<Course> parseCourseJson() {
		JsonArray jsonArr = getJsonArr("course");

		List<Course> list = new ArrayList<Course>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Course>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);

		return list;
	}

	public List<Classe> parseClasseJson() {
		JsonArray jsonArr = getJsonArr("classe");

		List<Classe> list = new ArrayList<Classe>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Classe>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);

		return list;
	}

	public List<Student> parseStudentJson() {
		JsonArray jsonArr = getJsonArr("student");

		List<Student> list = new ArrayList<Student>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Student>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);

		return list;
	}

	public List<StudentClass> parseStudentClassJson() {
		JsonArray jsonArr = getJsonArr("studentClass");

		List<StudentClass> list = new ArrayList<StudentClass>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<StudentClass>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);

		return list;
	}

	public List<Schedule> parseScheduleJson() {
		JsonArray jsonArr = getJsonArr("schedule");

		List<Schedule> list = new ArrayList<Schedule>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Schedule>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);

		return list;
	}

	public List<GradeAux> parseGradeAuxJson() {
		JsonArray jsonArr = getJsonArr("gradeAux");

		List<GradeAux> list = new ArrayList<GradeAux>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<GradeAux>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);

		return list;
	}
}
