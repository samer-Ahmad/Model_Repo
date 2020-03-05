package com.samer.regestration.model.entity;

public class Course {
    private String courseId;
    private String courseCode;
    private String courseName;
    private String instructorId;
    private String capacity;
    private String startingDate;
    private String duration;
    private String totalHours;

    public Course() {
    }

    public Course(String courseId, String courseCode, String courseName, String instructorId,
                  String capacity, String startingDate, String duration, String totalHours) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.capacity = capacity;
        this.startingDate = startingDate;
        this.duration = duration;
        this.totalHours = totalHours;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", instructorId='" + instructorId + '\'' +
                ", capacity='" + capacity + '\'' +
                ", startingDate='" + startingDate + '\'' +
                ", duration='" + duration + '\'' +
                ", totalHours='" + totalHours + '\'' +
                '}';
    }
}
