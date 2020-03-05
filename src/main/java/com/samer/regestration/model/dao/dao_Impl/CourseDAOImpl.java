package com.samer.regestration.model.dao.dao_Impl;

import com.samer.regestration.model.dao.CourseDAO;
import com.samer.regestration.model.entity.Course;
import com.samer.regestration.model.utils.DataSourcePool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    DataSourcePool pool = new DataSourcePool();

    @Override
    public Course findCourseById(String courseId) throws SQLException {
        String statement = "select * from course_table where courseId ='" + courseId + "'";
        ResultSet resultSet = getResultSet(statement);
        Course course = new Course();
        return getCourse(course, resultSet);
    }

    @Override
    public Course findCourseByName(String courseName) throws SQLException {
        String statement = "select * from course_table where courseName ='" + courseName + "'";
        ResultSet resultSet = getResultSet(statement);
        Course course = new Course();
        return getCourse(course, resultSet);
    }

    @Override
    public List<Course> findCourseByInstructor(String instructorId) throws SQLException {
        String statement = "select * from course_table where instructorId ='" + instructorId + "';";
        ResultSet resultSet = getResultSet(statement);
        List<Course> courseList = getCourseList(resultSet);
        return courseList;
    }

    @Override
    public void save(Course course) throws SQLException {
        String statement = "insert into course_table(courseId,courseCode,courseName,instructorId,capacity,startingDate" +
                ",duration,totalHours)" +
                "value(?,?,?,?,?,?,?,?)";
        insertExecute(statement, course);
    }

    @Override
    public void delete(String courseId) throws SQLException {
        String starement = "delete from course_table where courseId ='" + courseId + "';";
        updateExecute(starement);

    }

    private ResultSet getResultSet(String statement) throws SQLException {
        PreparedStatement statement1 = pool.getConnection("jdbc:mysql://localhost/student_db",
                "root", "root@JEA").getConnection().prepareStatement(statement);
        ResultSet resultSet = statement1.executeQuery();

        return resultSet;
    }

    private Course getCourse(Course course, ResultSet resultSet) throws SQLException {
        resultSet.next();
        course.setCourseId(resultSet.getString("courseId"));
        course.setCourseCode(resultSet.getString("courseCode"));
        course.setCapacity(resultSet.getString("capacity"));
        course.setCourseName(resultSet.getString("courseName"));
        course.setDuration(resultSet.getString("duration"));
        course.setInstructorId(resultSet.getString("instructorId"));
        course.setStartingDate(resultSet.getString("startingDate"));
        course.setTotalHours(resultSet.getString("totalHours"));

        return course;

    }

    private void insertExecute(String query, Course course) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection("jdbc:mysql://localhost/student_db",
                "root", "root@JEA").getConnection().prepareStatement(query);
        preparedStatement.setString(1, course.getCourseId());
        preparedStatement.setString(2, course.getCourseCode());
        preparedStatement.setString(3, course.getCourseName());
        preparedStatement.setString(4, course.getInstructorId());
        preparedStatement.setString(5, course.getCapacity());
        preparedStatement.setString(6, course.getStartingDate());
        preparedStatement.setString(7, course.getDuration());
        preparedStatement.setString(8, course.getTotalHours());
        preparedStatement.executeUpdate();
    }

    private void updateExecute(String query) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection("jdbc:mysql://localhost/student_db",
                "root", "root@JEA").getConnection().prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    private List<Course> getCourseList(ResultSet resultSet) throws SQLException {
        List<Course> courseList = new ArrayList<>();
        Course course = new Course();
        System.out.println(resultSet.getMetaData());
        while (resultSet.next()) {
            courseList.add(getCourse(course, resultSet));

        }
        return courseList;

    }
}
