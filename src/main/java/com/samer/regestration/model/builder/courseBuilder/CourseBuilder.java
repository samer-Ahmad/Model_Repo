package com.samer.regestration.model.builder.courseBuilder;

import com.samer.regestration.model.entity.Course;

import java.util.Date;

public class CourseBuilder {

    private Course course;

    public CourseBuilder() {
        this.course = new Course();
    }

    public CourseBuilder setCourseId(String courseId) {
        this.course.setCourseId(courseId);
        return this;
    }

    public CourseBuilder setCourseCode(String courseCode) {
        this.course.setCourseCode(courseCode);
        return this;
    }

    public CourseBuilder setCourseName(String courseName) {
        this.course.setCourseName(courseName);
        return this;
    }

    public CourseBuilder setInstructorId(String instructorId) {
        this.course.setInstructorId(instructorId);
        return this;
    }

    public CourseBuilder setCapacity(int capacity) {
        this.course.setCapacity(capacity);
        return this;
    }

    public CourseBuilder setStartingDate(Date startingDate) {
        this.course.setStartingDate(startingDate);
        return this;
    }

    public CourseBuilder setDuration(String duration) {
        this.course.setDuration(duration);
        return this;
    }

    public CourseBuilder setTotalHours(String totalHours) {
        this.course.setTotalHours(totalHours);
        return this;
    }

    public Course build() {
        return this.course;
    }
}
