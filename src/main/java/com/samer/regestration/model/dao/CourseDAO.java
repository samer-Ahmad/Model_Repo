package com.samer.regestration.model.dao;

import com.samer.regestration.model.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {
    Course findCourseById(String courseId) throws SQLException;

    Course findCourseByName(String courseName) throws SQLException;

    List<Course> findCourseByInstructor(String instructorName) throws SQLException;

    void save(Course course) throws SQLException;

    void delete(Course course);
}
