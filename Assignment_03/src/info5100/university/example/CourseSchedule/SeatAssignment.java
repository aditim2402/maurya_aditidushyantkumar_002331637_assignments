/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {
    public String grade="F"; // Stores letter grade (e.g., A, A-, B+)
    
    // Returns the numeric grade based on letter grade mappings
    public float getGrade() {
        switch (this.grade) {
            case "A": return 4.0f;
            case "A-": return 3.7f;
            case "B+": return 3.3f;
            case "B": return 3.0f;
            case "C": return 2.0f;
            case "D": return 1.0f;
            case "F": return 0.0f;
            default: return 0.0f;
        }
    }

    Seat seat;
    boolean like; // true means like, false means dislike
    CourseLoad courseload;

    // Constructor to initialize SeatAssignment with CourseLoad and Seat
    public SeatAssignment(CourseLoad cl, Seat s) {
        seat = s;
        courseload = cl;
    }

    // Returns whether the student likes the seat assignment
    public boolean getLike() {
        return like;
    }

    // Assigns the seat to a student's course load
    public void assignSeatToStudent(CourseLoad cl) {
        courseload = cl;
    }

    // Returns the credit hours for the course associated with the seat
    public int getCreditHours() {
        return seat.getCourseCredits();
    }

    // Returns the assigned seat
    public Seat getSeat() {
        return seat;
    }

    // Returns the course offer associated with this seat assignment
    public CourseOffer getCourseOffer() {
        return seat.getCourseOffer();
    }

    // Returns the course associated with this seat assignment
    public Course getAssociatedCourse() {
        return getCourseOffer().getSubjectCourse();
    }

    // Calculates and returns the course student score based on the grade and credit hours
    public float getCourseStudentScore() {
        return getCreditHours() * getGrade();
    }
}
