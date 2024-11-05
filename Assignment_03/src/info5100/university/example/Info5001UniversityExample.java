package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;

public class Info5001UniversityExample {

    public static final int CREDIT_HOUR_TUITION_FEE = 500;

    public static void main(String[] args) {
        Department department = new Department("Information Systems");

        // Person Directory
        PersonDirectory personDirectory = department.getPersonDirectory();
        StudentDirectory studentDirectory = department.getStudentDirectory();
        
        // Course Catalog Setup
        CourseCatalog courseCatalog = department.getCourseCatalog();
        Course coreCourse = courseCatalog.newCourse("Algorithms", "INFO6205", 4);
        Course elective1 = courseCatalog.newCourse("App Engineering", "INFO5100", 4);
        Course elective2 = courseCatalog.newCourse("Data Management and Database Design", "DAMG6210", 4);
        Course elective3 = courseCatalog.newCourse("Career Management for Engineers", "ENCP6000", 1);
        Course elective4 = courseCatalog.newCourse("Data Science Engineering Methods", "INFO6105", 4);
        Course elective5 = courseCatalog.newCourse("Business Analytics", "INFO6215", 4);

        // Course Schedule for Spring 2024
        CourseSchedule spring2024 = department.newCourseSchedule("Spring 2024");

        CourseOffer coreOffer = spring2024.newCourseOffer("INFO6205");
        CourseOffer electiveOffer1 = spring2024.newCourseOffer("INFO5100");
        CourseOffer electiveOffer2 = spring2024.newCourseOffer("DAMG6210");
        CourseOffer electiveOffer3 = spring2024.newCourseOffer("ENCP6000");
        CourseOffer electiveOffer4 = spring2024.newCourseOffer("INFO6105");
        CourseOffer electiveOffer5 = spring2024.newCourseOffer("INFO6215");

        coreOffer.generatSeats(30);
        electiveOffer1.generatSeats(30);
        electiveOffer2.generatSeats(30);
        electiveOffer3.generatSeats(30);
        electiveOffer4.generatSeats(30);
        electiveOffer5.generatSeats(30);

        // Create Faculty Members and Assign to Courses
        FacultyDirectory facultyDirectory = department.getFacultyDirectory();
        FacultyProfile professor1 = facultyDirectory.newFacultyProfile(personDirectory.newPerson("01123001"));
        FacultyProfile professor2 = facultyDirectory.newFacultyProfile(personDirectory.newPerson("01123002"));
        FacultyProfile professor3 = facultyDirectory.newFacultyProfile(personDirectory.newPerson("01123003"));
        FacultyProfile professor4 = facultyDirectory.newFacultyProfile(personDirectory.newPerson("01123004"));
        FacultyProfile professor5 = facultyDirectory.newFacultyProfile(personDirectory.newPerson("01123005"));

        coreOffer.AssignAsTeacher(professor1);
        electiveOffer1.AssignAsTeacher(professor2);
        electiveOffer2.AssignAsTeacher(professor3);
        electiveOffer3.AssignAsTeacher(professor4);
        electiveOffer4.AssignAsTeacher(professor5);
        electiveOffer5.AssignAsTeacher(professor1); // Repeat professor for elective

        // Create Students and Register in Classes
        for (int i = 1; i <= 10; i++) {
            String studentId = "01123" + String.format("%03d", i);
            Person studentPerson = personDirectory.newPerson(studentId);
            StudentProfile studentProfile = studentDirectory.newStudentProfile(studentPerson);

            // Register each student in multiple classes for course load
            CourseLoad courseLoad = studentProfile.newCourseLoad("Spring 2024");

            // Register the student in courses and assign grades
            SeatAssignment sa1 = courseLoad.registerStudentInClass(coreOffer);
            SeatAssignment sa2 = courseLoad.registerStudentInClass(electiveOffer1);
            SeatAssignment sa3 = courseLoad.registerStudentInClass(electiveOffer2);
            SeatAssignment sa4 = courseLoad.registerStudentInClass(electiveOffer3);

            // Manually assign grades for testing purposes
            if (sa1 != null) sa1.grade = "A";
            if (sa2 != null) sa2.grade = "B+";
            if (sa3 != null) sa3.grade = "A-";
            if (sa4 != null) sa4.grade = "B";
        }

        // Calculate revenue and print semester report
        int totalRevenue = department.calculateRevenuesBySemester("Spring 2024");
        System.out.println("Total Revenue for Spring 2024: $" + totalRevenue);
        printReportForSemester(studentDirectory, "Spring 2024");
    }

    // Method to print detailed student report for a specific semester
    public static void printReportForSemester(StudentDirectory studentDirectory, String semester) {
        for (StudentProfile studentProfile : studentDirectory.getStudentlist()) {
            CourseLoad semesterCourseLoad = studentProfile.getTranscript().getCourseLoadBySemester(semester);

            if (semesterCourseLoad != null) {
                float cumulativeGradePoints = 0;
                int totalSemesterCredits = 0;
                int totalTuitionFees = 0;

                System.out.println("Student ID: " + studentProfile.getPerson().getPersonId());

                for (SeatAssignment sa : semesterCourseLoad.getSeatAssignments()) {
                    // Ensure grade is assigned before calculating GPA
                    if (sa.grade == null) sa.grade = "B"; // Assign a default grade if null for testing

                    // Print course and grade details
                    System.out.println("Course: " + sa.getAssociatedCourse().getCOurseNumber() + " - " + sa.getAssociatedCourse().getName());
                    System.out.println("Grade: " + sa.grade);

                    // Calculate grade points and add to cumulative total
                    cumulativeGradePoints += sa.getGrade() * sa.getCreditHours();
                    totalSemesterCredits += sa.getCreditHours();

                    // Calculate tuition fees based on credit hours and add to the total
                    totalTuitionFees += sa.getCreditHours() * CREDIT_HOUR_TUITION_FEE;
                }

                float averageGPA = (totalSemesterCredits > 0) ? cumulativeGradePoints / totalSemesterCredits : 0;

                // Print student report with average GPA and total tuition fees
                System.out.println("Average GPA: " + averageGPA);
                System.out.println("Total Tuition Fees Paid: $" + totalTuitionFees);
                System.out.println("----------");
            }
        }
    }
}