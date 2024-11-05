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
    public float grade; // Stores letter grade (e.g., A, A-, B+)

   

    // Returns the numeric grade based on letter grade mappings
    
    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    /**
     * @return
     */
    public String getLetterGrade() {
        if (grade >= 4.0) {
            return "A";
        } else if (grade >= 3.7) {
            return "A-";
        } else if (grade >= 3.3) {
            return "B+";
        } else if (grade >= 3.0) {
            return "B";
        } else if (grade >= 2.7) {
            return "B-";
        } else if (grade >= 2.3) {
            return "C+";
        } else if (grade >= 2.0) {
            return "C";
        } else if (grade >= 1.7) {
            return "C-";
        } else if (grade >= 1.0) {
            return "D";
        } else {
            return "F";
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
