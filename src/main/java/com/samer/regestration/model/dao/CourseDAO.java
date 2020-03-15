package com.samer.regestration.model.dao;

import com.samer.regestration.model.entity.Course;

import java.util.List;

public interface CourseDAO {
    Course findCourseById(String courseId);

    Course findCourseByName(String courseName);

    List<Course> findCourseByInstructor(String instructorName);

    int save(Course course);

    int delete(String courseId);
}
