package college.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import college.model.Classe;
import college.model.College;
import college.model.Country;
import college.model.Course;
import college.model.Employee;
import college.model.Program;
import college.model.Schedule;
import college.model.Student;
import college.model.StudentClass;
import college.model.Util;

public class CollegeController {

   //Instructors by classes and average student grades
   public static String instructorsByClasses() {
       String report = Util.padRight("Instructor", 18) + " | " + Util.padRight("Class Id",10) + " | " + Util.padRight("Course", 40) + " | Average Grade\n";
       for (Classe c : College.getClasses()) {
           if (getAverageGradeOfClasse(c) != 0) {
               String instructor = c.getInstructor().getName();
               int classId = c.getClasseId();
               String course = c.getCourse().getName();
               int average = getAverageGradeOfClasse(c);
               report += Util.padRight(instructor, 18) + " | " + Util.padRight(classId, 10) + " | " + Util.padRight(course, 40) + " | " + average + "\n";
           }
       }
       return report;
   }
   
   public static int getAverageGradeOfClasse(Classe classe) {
       int sum = 0;;
       int count = 0;;
       for (StudentClass sc : College.getStudentClasses()) {
           if (sc.getClasse().getClasseId() == classe.getClasseId()) {
               if ((sc.getGradeAssig() != 0) && (sc.getGradeTest() != 0) && (sc.getGradeProject() != 0)) {
                   sum += (sc.getGradeAssig() + sc.getGradeTest() + sc.getGradeProject()) / 3;
                   count += 1;
               }
           }
       }
       if (count == 0) {
           return 0;
       }
       return sum / count;
   }
   
   //Number of students by country
   public static String studentsByCountry() {
       String report = Util.padRight("Country", 15) + "| Number of Students\n";
       List<Country> countries = new ArrayList<Country>();
       for (Student s : College.getStudents()) {
           if (!countries.contains(s.getOriginCountry())) {
               countries.add(s.getOriginCountry());
           }
       }
       for (Country c : countries) {
           int count = 0;;
           for (Student s : College.getStudents()) {
               if (s.getOriginCountry() == c) {
                   count += 1;
               }
           }
           report += Util.padRight(c.toString(), 15) + "| " + count + "\n";
       }
       return report;
   }
   
   //Top 3 courses with worst average grades
   public static String coursesByWorstAverage() {
       String report = Util.padRight("Course", 40) + "| Grade\n";
       Map<Course, Integer> elements = new HashMap<Course, Integer>();
       for (Course c : College.getCourses()) {
           elements.put(c, getAverageGradeOfClassesInCourse(c));
       }
       //to sort
       Map<Course, Integer> treeMap = new TreeMap<Course, Integer>(elements);
       //for (int i : treeMap.values()) {
           //System.out.println(i);
       //}
       //elements = elements.sorted(by:) {$0.1 < $1.1});
       for (Map.Entry<Course, Integer> entry : treeMap.entrySet()) {
    	   report += Util.padRight(entry.getKey().getName(), 40) + "| " + entry.getValue() +"\n";
       }
       //report += Util.padRight(Iterables.get(treeMap.entrySet(),0).getName(), 40) + "| " + treeMap[0] +"\n";
       //report += Util.padRight(elements[1].0.getName(), 40) + "| \(elements[1].1)\n";
       //report += Util.padRight(elements[2].0.getName(), 40) + "| \(elements[2].1)\n";
       return report;
   }
   
   public static int getAverageGradeOfClassesInCourse(Course course) {
       int sum = 0;
       int count = 0;
       for (StudentClass sc : College.getStudentClasses()) {
           if (sc.getClasse().getCourse().getCourseId() == course.getCourseId()) {
               if (sc.getGradeAssig() != 0 && sc.getGradeTest() != 0 && sc.getGradeProject() != 0) {
                   sum += (sc.getGradeAssig() + sc.getGradeTest() + sc.getGradeProject()) / 3;
                   count += 1;
               }
           }
       }
       if (count == 0) {
           return 0;
       }
       return sum / count;
   }
   
   
   //Number of classes per instructor per weekday
   public static String classesByInscructorsPerWeek() {
       String report = Util.padRight("Instructor", 18) + " | " + Util.padRight("Weekday",12) + " | Number of classes\n";
       Map<String, Integer> elements = new HashMap<String, Integer>();
       
       for (Employee i : College.getEmployees()) {
    	   elements = schedulesPerInstructor(i);
    	   for (Map.Entry<String, Integer> entry : elements.entrySet()) {
               report += Util.padRight(i.getName(), 18) + " | " + Util.padRight(entry.getKey(), 12) + " | " + entry.getValue() + "\n";
           }
       }
       return report;
   }
   
   public static Map<String, Integer> schedulesPerInstructor(Employee instructor) {
	   Map<String, Integer> elements = new HashMap<String, Integer>();
       for (Schedule s : College.getSchedules()) {
           if (s.getClasse().getInstructor().getEmployeeId() == instructor.getEmployeeId()) {
               int count = 1;
               /*if (let index = elements.index(where:) {$0.0 == s.getWeekday()})) {
                   let e = elements.remove(at: index);
                   count += e.1;
               }*/
               elements.put(s.getWeekday(), count);
           }
       }
       return elements;
   }
   
   
   //Top student with best average grade by program
   public static String studentsByBestAverage() {
       String report = Util.padRight("Program", 20) + "| " + Util.padRight("Student", 20) + "| Best Average Grade\n";
       for (Program p : College.getPrograms()) {
    	   Map<Student, Integer> elements = new HashMap<Student, Integer>();
    	   elements = getAverageGradeOfEachSudentInProgram(p);
    	   //to sort
           Map<Student, Integer> treeMap = new TreeMap<Student, Integer>(elements);
    	   //var elements = getAverageGradeOfEachSudentInProgram(p).sorted(by:) {$0.1 > $1.1});
           for (Map.Entry<Student, Integer> entry : treeMap.entrySet()) {
        	   report += Util.padRight(p.getName(), 20) + "| " + Util.padRight(entry.getKey().getName(), 20) + "| " + entry.getValue() + "\n";
        	   //report += Util.padRight(p.getName(), 20) + "| " + Util.padRight(elements[0].0.getName(), 20) + "| " + elements[0].1 + "\n";
           }
       }
       return report;
   }

   public static Map<Student, Integer> getAverageGradeOfEachSudentInProgram(Program program) {
       Map<Student, Integer> elements = new HashMap<Student, Integer>();
       for (Student s : College.getStudents()) {
           Student student = new Student();
           int sum = 0;
           int count = 0;
           for (StudentClass sc : College.getStudentClasses()) {
               if (sc.getClasse().getCourse().getProgram().getProgramId() == program.getProgramId()
                   && sc.getStudent().getStudentId() == s.getStudentId()) {
                   student = s;
                   if (sc.getGradeAssig() != 0 && sc.getGradeTest() != 0 && sc.getGradeProject() != 0) {
                       sum += (sc.getGradeAssig() + sc.getGradeTest() + sc.getGradeProject()) / 3;
                       count += 1;
                   }
                   
               }
           }
           if (student != null) {
               int value = 0;
               if (count != 0) {
                   value = sum / count;
               }
               elements.put(student, value);
           }
       }
       return elements;
   }
   
   public static List<Classe> getClassesOfInstructor(Employee instructor) {
	   List<Classe> list = new ArrayList<>();
	   for (Classe c: College.getClasses()) {
		   if (c.getInstructor().getEmployeeId() == instructor.getEmployeeId()) {
			   list.add(c);
		   }
	   }
	   return list;
   }
   
   public static List<StudentClass> getStudentClassesOfClasse(Classe classe) {
	   List<StudentClass> list = new ArrayList<>();
	   for (StudentClass sc: College.getStudentClasses()) {
		   if (sc.getClasse().getClasseId() == classe.getClasseId()) {
			   list.add(sc);
		   }
	   }
	   return list;
   }
}
