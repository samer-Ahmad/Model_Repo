package com.samer.regestration.model.entity;

import java.util.Objects;

public class Schedule {
    private String studentId;
    private String courseId;

    public Schedule() {
    }

    public Schedule(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(getStudentId(), schedule.getStudentId()) &&
                Objects.equals(getCourseId(), schedule.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getCourseId());
    }
}
