package com.example.admin.firebasestorage;

/**
 * Created by Admin on 10/20/2017.
 */

public class AssignmentInfoClass {
    String titleAssignment;
    float grade;
    String feedback;

    public AssignmentInfoClass() {
    }

    public AssignmentInfoClass(String titleAssignment, float grade, String feedback) {
        this.titleAssignment = titleAssignment;
        this.grade = grade;
        this.feedback = feedback;
    }

    public String getTitleAssignment() {
        return titleAssignment;
    }

    public void setTitleAssignment(String titleAssignment) {
        this.titleAssignment = titleAssignment;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return (titleAssignment + ": " + Float.toString(grade) + " - Feedback: " + feedback);
    }
}
