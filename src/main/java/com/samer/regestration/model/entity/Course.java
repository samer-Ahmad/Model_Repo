package com.samer.regestration.model.entity;

import java.util.Date;
import java.util.Objects;

public class Course {
    private String courseId;
    private String courseCode;
    private String courseName;
    private String instructorId;
    private int capacity;
    private Date startingDate;
    private String duration;
    private String totalHours;

    public Course() {
    }

    public Course(String courseId, String courseCode, String courseName, String instructorId,
                  int capacity, Date startingDate, String duration, String totalHours) {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getCourseId(), course.getCourseId()) &&
                Objects.equals(getCourseCode(), course.getCourseCode()) &&
                Objects.equals(getCourseName(), course.getCourseName()) &&
                Objects.equals(getInstructorId(), course.getInstructorId()) &&
                Objects.equals(getCapacity(), course.getCapacity()) &&
                Objects.equals(getStartingDate(), course.getStartingDate()) &&
                Objects.equals(getDuration(), course.getDuration()) &&
                Objects.equals(getTotalHours(), course.getTotalHours());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getCourseCode(), getCourseName(), getInstructorId(),
                getCapacity(), getStartingDate(), getDuration(), getTotalHours());
    }
}
