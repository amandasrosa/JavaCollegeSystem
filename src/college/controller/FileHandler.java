package college.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import college.model.*;

public class FileHandler {

	public String readFile(String filename)
	{
		byte[] encoded = null;
		String path = "";
		if (getClass().getResource("/files/" + filename + ".json") == null) {
			System.out.println("File " + filename + ".json is missing. Aborting...");
			System.exit(0);
		} else {
			path = getClass().getResource("/files/" + filename + ".json").getPath();
		}
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
		JsonObject jo = new JsonObject();
		try {
			jo = (JsonObject)jsonParser.parse(content);
		} catch (JsonSyntaxException e) {
			System.out.println("File " + type + ".json is corrupted. Aborting...");
			System.exit(0);
		}
		return jo.getAsJsonArray(type);
	}

	//Json to Objects
	public List<Employee> parseEmployeeJson() {
		JsonArray jsonArr = getJsonArr("employee");

		List<Employee> list = new ArrayList<Employee>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Employee>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	public List<Department> parseDepartmentJson() {
		JsonArray jsonArr = getJsonArr("department");

		List<Department> list = new ArrayList<Department>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Department>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	public List<DepartmentEmployee> parseDepartmentEmployeeJson() {
		JsonArray jsonArr = getJsonArr("departmentEmployee");

		List<DepartmentEmployee> list = new ArrayList<DepartmentEmployee>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<DepartmentEmployee>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	public List<Program> parseProgramJson() {
		JsonArray jsonArr = getJsonArr("program");

		List<Program> list = new ArrayList<Program>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Program>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	public List<Course> parseCourseJson() {
		JsonArray jsonArr = getJsonArr("course");

		List<Course> list = new ArrayList<Course>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Course>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	public List<Classe> parseClasseJson() {
		JsonArray jsonArr = getJsonArr("classe");

		List<Classe> list = new ArrayList<Classe>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Classe>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	public List<Student> parseStudentJson() {
		JsonArray jsonArr = getJsonArr("student");

		List<Student> list = new ArrayList<Student>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Student>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	public List<StudentClass> parseStudentClassJson() {
		JsonArray jsonArr = getJsonArr("studentClass");

		List<StudentClass> list = new ArrayList<StudentClass>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<StudentClass>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	public List<Schedule> parseScheduleJson() {
		JsonArray jsonArr = getJsonArr("schedule");

		List<Schedule> list = new ArrayList<Schedule>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Schedule>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	public List<GradeAux> parseGradeAuxJson() {
		JsonArray jsonArr = getJsonArr("gradeAux");

		List<GradeAux> list = new ArrayList<GradeAux>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<GradeAux>>(){}.getType();
		list = gson.fromJson(jsonArr, listType);
		list.removeAll(Collections.singleton(null));
		return list;
	}

	//Object To Json
	public void saveEmployeeToJson(List<Employee> employees) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/employee.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"employee\": [\n\n");
			for (Employee e : employees) {
				gson.toJson(e, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveDepartmentToJson(List<Department> departments) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/department.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"department\": [\n\n");
			for (Department d : departments) {
				gson.toJson(d, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveDepartmentEmployeeToJson(List<DepartmentEmployee> departmentEmployees) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/departmentEmployee.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"departmentEmployee\": [\n\n");
			for (DepartmentEmployee de : departmentEmployees) {
				gson.toJson(de, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveProgramToJson(List<Program> programs) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/program.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"program\": [\n\n");
			for (Program p : programs) {
				gson.toJson(p, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveCourseToJson(List<Course> courses) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/course.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"course\": [\n\n");
			for (Course c : courses) {
				gson.toJson(c, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveClasseToJson(List<Classe> classes) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/classe.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"classe\": [\n\n");
			for (Classe c : classes) {
				gson.toJson(c, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveStudentToJson(List<Student> students) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/student.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"student\": [\n\n");
			for (Student s : students) {
				gson.toJson(s, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveStudentClassToJson(List<StudentClass> studentClasses) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/studentClass.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"studentClass\": [\n\n");
			for (StudentClass sc : studentClasses) {
				gson.toJson(sc, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveScheduleToJson(List<Schedule> schedules) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/schedule.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"schedule\": [\n\n");
			for (Schedule s : schedules) {
				gson.toJson(s, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public void saveGradeAuxToJson(List<GradeAux> gradeAuxs) {
		Gson gson = new Gson();
		String path = getClass().getResource("/files/gradeAux.json").getPath();
		String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter (osAppropriatePath)) {
			writer.write("{\"gradeAux\": [\n\n");
			for (GradeAux g : gradeAuxs) {
				gson.toJson(g, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
