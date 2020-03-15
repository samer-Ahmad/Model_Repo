package com.samer.regestration.model.dao.dao_Impl;

import com.samer.regestration.model.dao.CourseDAO;
import com.samer.regestration.model.entity.Course;
import com.samer.regestration.model.utils.DataSourcePool;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    private DataSourcePool pool = new DataSourcePool("jdbc:mysql://localhost/student_db",
            "root", "root@JEA");

    @Override
    public Course findCourseById(String courseId) {
        String statement = String.format("select * from course_table where courseId =%s", courseId);
        return selectCourse(statement);
    }

    @Override
    public Course findCourseByName(String courseName) {
        String statement1 = String.format("select * from course_table where courseName='%s'", courseName);
        return selectCourse(statement1);
    }

    @Override
    public List<Course> findCourseByInstructor(String instructorId) {
        String statement = String.format("select * from course_table where instructorId ='%s'", instructorId);
        ResultSet resultSet;
        List<Course> courseList = null;
        try {
            resultSet = getResultSet(statement);
            courseList = getCourseList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public int save(Course course) {
        String statement = "insert into course_table(courseId,courseCode,courseName,instructorId,capacity,startingDate" +
                ",duration,totalHours)" +
                "value(?,?,?,?,?,?,?,?)";
        int numberOfRowEffected = 0;
        try {
            numberOfRowEffected = insertExecute(statement, course);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return numberOfRowEffected;
    }

    @Override
    public int delete(String courseId) {
        String starement = String.format("delete from course_table where courseId =%s", courseId);
        int numberOfRowEffected = 0;
        try {
            numberOfRowEffected = updateExecute(starement);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return numberOfRowEffected;
    }

    private ResultSet getResultSet(String statement) throws SQLException {
        PreparedStatement statement1 = pool.getConnection().getConnection().prepareStatement(statement);
        ResultSet resultSet = statement1.executeQuery();

        return resultSet;
    }

    private Course selectCourse(String statement) {
        ResultSet resultSet;
        Course course;
        try {
            resultSet = getResultSet(statement);
            resultSet.next();
            course = buildCourse(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return course;

    }

    public Course buildCourse(ResultSet resultSet) throws SQLException {
        Course course = new Course();
        course.setCourseId(resultSet.getString("courseId"));
        course.setCourseCode(resultSet.getString("courseCode"));
        course.setCapacity(resultSet.getInt("capacity"));
        course.setCourseName(resultSet.getString("courseName"));
        course.setDuration(resultSet.getString("duration"));
        course.setInstructorId(resultSet.getString("instructorId"));
        course.setStartingDate(resultSet.getDate("startingDate"));
        course.setTotalHours(resultSet.getString("totalHours"));
        return course;
    }

    private int insertExecute(String query, Course course) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection().getConnection().prepareStatement(query);
        preparedStatement.setString(1, course.getCourseId());
        preparedStatement.setString(2, course.getCourseCode());
        preparedStatement.setString(3, course.getCourseName());
        preparedStatement.setString(4, course.getInstructorId());
        preparedStatement.setInt(5, course.getCapacity());
        preparedStatement.setDate(6, (Date) course.getStartingDate());
        preparedStatement.setString(7, course.getDuration());
        preparedStatement.setString(8, course.getTotalHours());
        return preparedStatement.executeUpdate();
    }

    private int updateExecute(String query) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection().getConnection().prepareStatement(query);
        return preparedStatement.executeUpdate();
    }

    private List<Course> getCourseList(ResultSet resultSet) throws SQLException {
        List<Course> courseList = new ArrayList<>();
        while (resultSet.next()) {
            courseList.add(buildCourse(resultSet));
        }
        return courseList;

    }
}
