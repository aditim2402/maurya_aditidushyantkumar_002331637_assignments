/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    
    /* 1) Create Department make sure to pass the name of the department
       2) Use the person directory to create persons some will play students role, some will play faculty role, etc
       3) Use the Course Catalog to creat some courses
       4) Create a course schedule for a semester (ex: spring 2025
       5) Use the course schedule to create some classes (course offer)
       6) Search for a person by ssn and assign as faculty (faculty profile)
       7) Search for person and assign as student (student profile)
       8) Register student for scheduled classes
    
    
    
    */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Department department = new Department("Information Systems");
        // we need the persondirectory to create persons for the different roles
        
        PersonDirectory persondirectory = department.getPersonDirectory();
        
//      Create course and keep it in the course catalog
        
        CourseCatalog coursecatalog = department.getCourseCatalog();        
        Course course = coursecatalog.newCourse("algorithms", "info 6205", 4);
        Course course2 = coursecatalog.newCourse("App Engineering", "info 5100", 4);
        Course course3 = coursecatalog.newCourse("Data Mgt and Database Design", "DAMG6210", 4);
        Course course4 = coursecatalog.newCourse("Career Management for Engineers", "ENCP6000", 1);
        Course course5 = coursecatalog.newCourse("Data Science Engineering Methods and Tools", "6105", 4);
        Course course6 = coursecatalog.newCourse("Web Design and User Experience Engineering", "6150", 4);
        Course course7 = coursecatalog.newCourse("Cybersecurity Basics", "CYBR5200", 3);



//      now lets schedule class to run for spring 2024        
        CourseSchedule courseschedule = department.newCourseSchedule("Spring 2024");
        CourseSchedule courseschedule2 = department.newCourseSchedule("Fall 2024");


        CourseOffer courseoffer = courseschedule.newCourseOffer("info 6205");
        CourseOffer courseoffer2 = courseschedule.newCourseOffer("info 5100");
        CourseOffer courseoffer3 = courseschedule2.newCourseOffer("DAMG6210");
        CourseOffer courseoffer4 = courseschedule2.newCourseOffer("6150");
        CourseOffer courseoffer5 = courseschedule2.newCourseOffer("6105");
        CourseOffer courseoffer6 = courseschedule2.newCourseOffer("CYBR5200");



        if (courseoffer==null)return; 
        
        courseoffer.generatSeats(30); // allow for 30 open seats in the class
        courseoffer2.generatSeats(50); // allow for 30 open seats in the class
        courseoffer3.generatSeats(20);
        courseoffer4.generatSeats(30);
        courseoffer5.generatSeats(60);
        courseoffer6.generatSeats(60);





//      Create teacher for class

        Person person1 = persondirectory.newPerson("01123022"); //person for teacher role                  
        Person person2 = persondirectory.newPerson("011230222"); 
        Person person3 = persondirectory.newPerson("01123024");
        Person person6 = persondirectory.newPerson("01123025");

        FacultyDirectory facultydirectory = department.getFacultyDirectory();
        FacultyProfile teacher = facultydirectory.newFacultyProfile(person1);
        FacultyProfile teacher2 = facultydirectory.newFacultyProfile(person2);   
        FacultyProfile teacher3 = facultydirectory.newFacultyProfile(person3);
        FacultyProfile teacher4 = facultydirectory.newFacultyProfile(person6);
    
       
        courseoffer.AssignAsTeacher(teacher);//  teacher.AssignAsTeacher(courseoffer); // OR  both work
        courseoffer.AssignAsTeacher(teacher2);//  teacher.AssignAsTeacher(courseoffer); // OR  both work
        courseoffer.AssignAsTeacher(teacher3);
        courseoffer.AssignAsTeacher(teacher4);
    //  Create student     
 
        Person person4 = persondirectory.newPerson("0112303");  
        Person person5 = persondirectory.newPerson("01123034");   
        
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person3); 
        StudentProfile student2 = sd.newStudentProfile(person4);
        
    //  Register student in class for the load of the spring semester     
        CourseLoad courseload = student.newCourseLoad("Spring 2024"); 
        CourseLoad courseload2 = student2.newCourseLoad("Spring 2024");        
        courseload.registerStudentInClass(courseoffer); //register student in class Info 6205
        courseload.registerStudentInClass(courseoffer2);//same student signed up for 2 classes
        courseload2.registerStudentInClass(courseoffer2);
        
        int total = department.calculateRevenuesBySemester("Spring 2024");
        System.out.print("Total:  " + total+"    ");

    }

}
