package college.controller;

import java.io.FileWriter;
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

	//Json to Objects
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
	
	//Object To Json
	public static void getEmployeeToJson() {
		List<Employee> employees = College.getEmployees();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/employee.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/employee.json")) {
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
	public static void getDepartmentToJson() {
		List<Department> departments = College.getDepartments();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/department.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/department.json")) {
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
	public static void getDepartmentEmployeeToJson() {
		List<DepartmentEmployee> departmentEmployees = College.getDepartmentEmployees();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/departmentEmployee.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/departmentEmployee.json")) {
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
	public static void getProgramToJson() {
		List<Program> programs = College.getPrograms();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/program.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/program.json")) {
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
	public static void getCourseToJson() {
		List<Course> courses = College.getCourses();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/course.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/course.json")) {
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
	public static void getClasseToJson() {
		List<Classe> classes = College.getClasses();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/classe.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/classe.json")) {
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
	public static void getStudentToJson() {
		List<Student> students = College.getStudents();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/student.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/student.json")) {
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
	public static void getStudentClassToJson() {
		List<StudentClass> studentClasss = College.getStudentClasses();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/studentClass.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/studentClass.json")) {
			writer.write("{\"studentClass\": [\n\n");
			for (StudentClass sc : studentClasss) {
				gson.toJson(sc, writer);
				writer.write(",\n\n");
			}
			writer.write("]}");
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void getScheduleToJson() {
		List<Schedule> schedules = College.getSchedules();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/schedule.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/schedule.json")) {
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
	public static void getGradeAuxToJson() {
		List<GradeAux> gradeAuxs = College.getGrades();
		Gson gson = new Gson();
		//String path = getClass().getResource("/newFiles/gradeAux.json").getPath();
		//String osAppropriatePath = System.getProperty( "os.name" ).contains( "indow" ) ? path.substring(1) : path;
		try (FileWriter writer = new FileWriter ("/Users/araceliteixeira/eclipse-workspace/JavaCollegeSystem/bin/files/gradeAux.json")) {
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
	
	public static void objectsToJson () {
		getEmployeeToJson();
		getDepartmentToJson();
		getDepartmentEmployeeToJson();
		getProgramToJson();
		getCourseToJson();
		getClasseToJson();
		getStudentToJson();
		getStudentClassToJson();
		getScheduleToJson();
		getGradeAuxToJson();
	}
}
