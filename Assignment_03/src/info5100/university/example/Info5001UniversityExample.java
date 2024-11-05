package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.Random;

public class Info5001UniversityExample {

    public static final int CREDIT_HOUR_TUITION_FEE = 500; // Tuition fee per credit hour

    public static void main(String[] args) {
        // Create one department
        Department department = new Department("Information Systems");
        Course course = department.newCourse("Advanced Engineering Design", "INFO 5100", 4);
        Course course1 = department.newCourse("Cybersecurity Fundamentals", "INFO 8705", 4);
        Course course2 = department.newCourse("Database Systems and Design", "DAMG 6210", 4);
        Course course3 = department.newCourse("Professional Career Development", "ENCP 6000", 1);
        Course course4 = department.newCourse("Applied Statistics", "MATH 5980", 4);
        Course course5 = department.newCourse("Responsive Web Development", "INFO 6150", 4);
        Course course6 = department.newCourse("Embedded Networked Computer Programming", "CSY 5500", 4);
        Course course7 = department.newCourse("Advanced Cybersecurity Concepts", "CYB 7520", 3);
        Course course8 = department.newCourse("Introduction to Health Informatics", "INFO 6020", 4);

        // Add core and elective courses using Department's methods
        department.addCoreCourse(course); // Core course

        // Add elective courses
        department.addElectiveCourse(course1);
        department.addElectiveCourse(course2);
        department.addElectiveCourse(course3);
        department.addElectiveCourse(course4);
        department.addElectiveCourse(course5);
        department.addElectiveCourse(course6);
        department.addElectiveCourse(course7);
        department.addElectiveCourse(course8);

       

        // Create course schedules and add course offers
        CourseSchedule spring2024 = department.newCourseSchedule("Spring 2024");
        CourseSchedule fall2024 = department.newCourseSchedule("Fall 2024");

        // Creating course offers for each semester
        CourseOffer offer1 = fall2024.newCourseOffer("INFO 5100"); // Core course
        CourseOffer offer2 = spring2024.newCourseOffer("INFO 8705");
        CourseOffer offer3 = fall2024.newCourseOffer("DAMG 6210");
        CourseOffer offer4 = fall2024.newCourseOffer("ENCP 6000");
        CourseOffer offer5 = spring2024.newCourseOffer("MATH 5980");
        CourseOffer offer6 = spring2024.newCourseOffer("INFO 6150");
        CourseOffer offer7 = fall2024.newCourseOffer("CSY 5500");
        CourseOffer offer8 = spring2024.newCourseOffer("CYB 7520");
        CourseOffer offer9 = fall2024.newCourseOffer("INFO 6020");
        CourseOffer offer10 = spring2024.newCourseOffer("INFO 5100");

        // Assign seats to each course offer to allow for student registrations
        offer1.generatSeats(30);
        offer2.generatSeats(30);
        offer3.generatSeats(40);
        offer4.generatSeats(30);
        offer5.generatSeats(40);
        offer6.generatSeats(30);
        offer7.generatSeats(30);
        offer8.generatSeats(40);
        offer9.generatSeats(30);
        offer10.generatSeats(30);

        // Create students and manage student registrations
        StudentDirectory studentDirectory = department.getStudentDirectory();
        for (int i = 1; i <= 10; i++) {
            Person person = department.getPersonDirectory().newPerson("011230" + i);
            studentDirectory.newStudentProfile(person);
        }

        Random random = new Random();

        // Register students for Spring 2024 and assign random grades
        int studentCount = 1;
        for (StudentProfile student : studentDirectory.getStudentlist()) {
            CourseLoad courseLoad = student.newCourseLoad("Spring 2024");
            SeatAssignment sa1 = courseLoad.registerStudentInClass(offer1); // Core course for all students
            sa1.setGrade(2.5f+ random.nextFloat() * 1.5f); // Assign random grade between 2.5 and 4.0

            if (studentCount <= 5) {
                SeatAssignment sa2 = courseLoad.registerStudentInClass(offer2);
                SeatAssignment sa3 = courseLoad.registerStudentInClass(offer5);
                sa2.setGrade(2.5f + random.nextFloat() * 1.5f);
                sa3.setGrade(2.5f + random.nextFloat() * 1.5f);
            } else {
                SeatAssignment sa4 = courseLoad.registerStudentInClass(offer6);
                SeatAssignment sa5 = courseLoad.registerStudentInClass(offer9);
                sa4.setGrade(2.5f + random.nextFloat() * 1.5f);
                sa5.setGrade(2.5f + random.nextFloat() * 1.5f);
            }
            studentCount++;
        }

        // Register students for the Fall 2024 semester and assign random grades
        studentCount = 1;
        for (StudentProfile student : studentDirectory.getStudentlist()) {
            CourseLoad courseLoad = student.newCourseLoad("Fall 2024");
            SeatAssignment sa6 = courseLoad.registerStudentInClass(offer3); // Elective course for all students
            sa6.setGrade(2.5f + random.nextFloat() * 1.5f);

            if (studentCount <= 5) {
                SeatAssignment sa7 = courseLoad.registerStudentInClass(offer4);
                SeatAssignment sa8 = courseLoad.registerStudentInClass(offer7);
                sa7.setGrade(2.5f + random.nextFloat() * 1.5f);
                sa8.setGrade(2.5f + random.nextFloat() * 1.5f);
            } else {
                SeatAssignment sa9 = courseLoad.registerStudentInClass(offer8);
                SeatAssignment sa10 = courseLoad.registerStudentInClass(offer10);
                sa9.setGrade(2.5f + random.nextFloat() * 1.5f);
                sa10.setGrade(2.5f + random.nextFloat() * 1.5f);
            }
            studentCount++;
        }

        // Assign professors to each course offer
        FacultyDirectory facultyDirectory = department.getFacultyDirectory();
        FacultyProfile prof1 = facultyDirectory.newFacultyProfile(department.getPersonDirectory().newPerson("001"));
        FacultyProfile prof2 = facultyDirectory.newFacultyProfile(department.getPersonDirectory().newPerson("002"));
        FacultyProfile prof3 = facultyDirectory.newFacultyProfile(department.getPersonDirectory().newPerson("003"));
        FacultyProfile prof4 = facultyDirectory.newFacultyProfile(department.getPersonDirectory().newPerson("004"));
        FacultyProfile prof5 = facultyDirectory.newFacultyProfile(department.getPersonDirectory().newPerson("005"));

        // Assign professors to each scheduled class
        offer1.AssignAsTeacher(prof1);
        offer2.AssignAsTeacher(prof2);
        offer3.AssignAsTeacher(prof3);
        offer4.AssignAsTeacher(prof4);
        offer5.AssignAsTeacher(prof5);
        offer6.AssignAsTeacher(prof1);
        offer7.AssignAsTeacher(prof2);
        offer8.AssignAsTeacher(prof3);
        offer9.AssignAsTeacher(prof4);
        offer10.AssignAsTeacher(prof5);

        // Calculate and print department revenue for Spring 2024
        int totalRevenue = department.calculateRevenuesBySemester("Spring 2024");
        System.out.println("Total Revenue for Spring 2024: $" + totalRevenue);

        // Print report for each semester
        printReportForSemester(studentDirectory, "Spring 2024");
        printReportForSemester(studentDirectory, "Fall 2024");
    }

    // Print report for the semester including GPA and tuition fees
    public static void printReportForSemester(StudentDirectory studentDirectory, String semester) {
        System.out.println("\n---- " + semester + " Student Report ----");
    
        for (StudentProfile studentProfile : studentDirectory.getStudentlist()) {
            CourseLoad semesterCourseLoad = studentProfile.getTranscript().getCourseLoadBySemester(semester);
            if (semesterCourseLoad != null) {
                System.out.println("Student ID: " + studentProfile.getPerson().getPersonId());
                float cumulativeGradePoints = 0;
                int totalSemesterCredits = 0;
                int totalTuitionFees = 0;
    
                for (SeatAssignment seatAssignment : semesterCourseLoad.getSeatAssignments()) {
                    Course enrolledCourse = seatAssignment.getAssociatedCourse();
                    FacultyProfile courseInstructor = seatAssignment.getCourseOffer().getFacultyProfile();
                    float courseGrade = seatAssignment.getGrade(); // Numeric grade
                    String letterGrade = seatAssignment.getLetterGrade(); // Letter grade
    
                    System.out.println("  Course: " + enrolledCourse.getCOurseNumber() + " - " + enrolledCourse.getName());
                    System.out.println("    Professor: " + courseInstructor.getPerson().getPersonId());
                    System.out.println("    Grade: " + courseGrade + " (" + letterGrade + ")"); // Display numeric and letter grade
    
                    cumulativeGradePoints += courseGrade * enrolledCourse.getCredits();
                    totalSemesterCredits += enrolledCourse.getCredits();
                    totalTuitionFees += enrolledCourse.getCredits() * CREDIT_HOUR_TUITION_FEE;
                }
    
                float averageGPA = (totalSemesterCredits > 0) ? Math.round((cumulativeGradePoints / totalSemesterCredits) * 10) / 10.0f : 0;
                System.out.println("  Average GPA: " + averageGPA);
                System.out.println("  Total Tuition Fees Paid: $" + totalTuitionFees);
                System.out.println(); // Line break between students
            }
        }
    }
}