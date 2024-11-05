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

import java.util.ArrayList;

/**
 * Represents a course load for a specific semester.
 * Holds a list of SeatAssignments, where each SeatAssignment represents
 * a course registration for the student in this semester.
 * 
 */
public class CourseLoad {
    private String semester;
    private ArrayList<SeatAssignment> seatAssignments; // Each represents one course registration

    // Constructor to initialize CourseLoad for a specific semester
    public CourseLoad(String semester) {
        this.semester = semester;
        this.seatAssignments = new ArrayList<>(); // Using parameterized ArrayList
    }

    /**
     * Registers a student in a class by finding an empty seat in the course offer.
     * If an empty seat is found, it creates a new SeatAssignment and adds it to the student's course load.
     * 
     * @param courseOffer the course offer in which the student wants to register
     * @return the SeatAssignment created for the student, or null if no empty seat is available
     */
    public SeatAssignment registerStudentInClass(CourseOffer courseOffer) {
        Seat seat = courseOffer.getEmptySeat(); // Get an empty seat linked to courseOffer
        if (seat == null) return null;
        SeatAssignment seatAssignment = seat.newSeatAssignment(this);
        seatAssignments.add(seatAssignment); // Add to student's course load
        return seatAssignment;
    }

    /**
     * Adds an existing SeatAssignment to the course load for this semester.
     * 
     * @param seatAssignment the SeatAssignment to register for the student
     */
    public void registerStudent(SeatAssignment seatAssignment) {
        seatAssignment.assignSeatToStudent(this);
        seatAssignments.add(seatAssignment);
    }

    /**
     * Calculates the total score for the student's course load in the semester.
     * The score is the sum of the scores from each course the student is registered in.
     * 
     * @return the total semester score
     */
    public float getSemesterScore() {
        float sum = 0;
        for (SeatAssignment seatAssignment : seatAssignments) {
            sum += seatAssignment.getCourseStudentScore(); // Using the updated method name
        }
        return sum;
    }

    /**
     * Returns the list of SeatAssignments for the semester.
     * 
     * @return the list of SeatAssignments
     */
    public ArrayList<SeatAssignment> getSeatAssignments() {
        return seatAssignments;
    }
}
