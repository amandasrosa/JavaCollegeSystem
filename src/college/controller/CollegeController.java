package college.controller;

import java.util.ArrayList;
import java.util.List;

import college.model.Classe;
import college.model.College;
import college.model.Country;
import college.model.Course;
import college.model.Employee;
import college.model.Program;
import college.model.Student;
import college.model.StudentClass;

public class CollegeController {

	
   //Instructors by classes and average student grades
    
   
   public static String instructorsByClasses() {
       String report = ""; //Util.pad("Instructor", 18) + " | " + Util.pad("Class Id",10) + " | " + Util.pad("Course", 40) + " | Average Grade\n"
       for (Classe c : College.getClasses()) {
           if (getAverageGradeOfClasse(c) != 0) {
               String instructor = c.getInstructor().getName();
               int classId = c.getClasseId();
               String course = c.getCourse().getName();
               int average = getAverageGradeOfClasse(c);
               //report += Util.pad(instructor, 18) + " | " + Util.pad(classId, 10) + " | " + Util.pad(course, 40) + " | \(average) \n"
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
       String report = "";//Util.pad("Country", 15) + "| Number of Students\n"
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
           //report += Util.pad(String(describing: c), 15) + "| \(count)\n"
       }
       return report;
   }
   
   
   //Top 3 courses with worst average grades
   
   public static String coursesByWorstAverage() {
       String report = ""; //Util.pad("Course", 40) + "| Grade\n"
       //var elements: [(Course, Int)] = [];
       for (Course c : College.getCourses()) {
           //elements.add((c, getAverageGradeOfClassesInCourse(c)));
       }
       //elements = elements.sorted(by:) {$0.1 < $1.1});
       //report += Util.pad(elements[0].0.getName(), 40) + "| \(elements[0].1)\n"
       //report += Util.pad(elements[1].0.getName(), 40) + "| \(elements[1].1)\n"
       //report += Util.pad(elements[2].0.getName(), 40) + "| \(elements[2].1)\n"
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
       String report = ""; //Util.pad("Instructor", 18) + " | " + Util.pad("Weekday",12) + " | Number of classes\n"
       for (Employee i : College.getEmployees()) {
           //for (e : schedulesPerInstructor(i)) {
               //report += Util.pad(i.getName(), 18) + " | " + Util.pad(e.0, 12) + " |  \(e.1)\n"
           //}
       }
       return report;
   }
   
   /*func schedulesPerInstructor(Employee instructor) -> [(String, Int)] {
       var elements: [(String, Int)] = [];
       for (Schedule s : College.getSchedules()) {
           if (s.getClasse().getInstructor().getEmployeeId() == instructor.getEmployeeId()) {
               int count = 1;
               if (let index = elements.index(where:) {$0.0 == s.getWeekday()})) {
                   let e = elements.remove(at: index);
                   count += e.1;
               }
               elements.add((s.getWeekday(), count));
               
           }
       }
       return elements;
   }*/
   
   
    //Top student with best average grade by program
   
   public static String studentsByBestAverage() {
       String report = ""; //Util.pad("Program", 20) + "| " + Util.pad("Student", 20) + "| Best Average Grade\n"
       for (Program p : College.getPrograms()) {
           //var elements = getAverageGradeOfEachSudentInProgram(p).sorted(by:) {$0.1 > $1.1});
           //report += Util.pad(p.getName(), 20) + "| " + Util.pad(elements[0].0.getName(), 20) + "| \(elements[0].1)\n"
       }
       return report;
   }

   /*func getAverageGradeOfEachSudentInProgram(Program program) -> [(Student, Int)] {
       var elements: [(Student, Int)] = [];
       for (Student s : College.getStudents()) {
           var student: Student?
           int sum = 0;
           int count = 0;
           for (StudentClass sc : College.getStudentClasses()) {
               if (sc.getClasse().getCourse().getProgram().getProgramId() == program.getProgramId()
                   && sc.getStudent().getStudentId() == s.getStudentId()) {
                   student = s;
                   if (sc.getGradeAssig() != null && sc.getGradeTest() != null && sc.getGradeProject() != null) {
                       sum += (sc.getGradeAssig()! + sc.getGradeTest()! + sc.getGradeProject()!) / 3;
                       count += 1;
                   }
                   
               }
           }
           if (student != null) {
               var element = (student!, 0);
               if (count != 0) {
                   element.1 = sum / count;
               }
               elements.add(element);
           }
       }
       return elements;
   }*/
}
